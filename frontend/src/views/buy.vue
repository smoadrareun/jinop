<template>
  <div style="height: 100vh">
    <div
      style="
        display: grid;
        grid-template-columns: repeat(10, 1fr);
        grid-template-rows: repeat(10, 1fr);
        grid-column-gap: 12px;
        grid-row-gap: 12px;
        height: 100%;
      "
    >
      <div style="grid-area: 1 / 1 / 11 / 2; height: 100%">
        <ClientNaviBar :index="index" />
      </div>

      <div style="grid-area: 1 / 2 / 2 / 11">
        <div style="margin-top: 16px; width: 480px; display: flex">
          <el-input
            v-model="searchName"
            placeholder="请输入商品名称..."
            size="normal"
            clearable
            class="input"
          >
          </el-input>
          <el-button
            type="primary"
            size="default"
            @click="search"
            style="border-radius: 0 16px 16px 0"
            >搜索</el-button
          >
        </div>
      </div>

      <div style="grid-area: 2 / 2 / 10 / 11; display: flex; flex-wrap: wrap">
        <el-row :gutter="20" style="width: 100%">
          <el-col
            :span="6"
            :offset="0"
            v-for="(item, index) in goodsList"
            :key="item.name"
          >
            <div style="width: 420px; margin-bottom: 12px">
              <el-card
                shadow="hover"
                :body-style="{ padding: '20px' }"
                style="border-radius: 16px"
              >
                <div
                  slot="header"
                  style="
                    display: flex;
                    align-content: center;
                    position: relative;
                  "
                >
                  <span style="display: flex; align-items: center">
                    <img
                      :src="item.pic"
                      style="height: 64px; width: 64px; border-radius: 99px"
                    />
                  </span>
                  <span
                    style="
                      font-weight: bold;
                      font-size: 18px;
                      line-height: 69px;
                      margin-left: 12px;
                    "
                    >{{ item.name }}</span
                  >
                  <span
                    style="
                      font-weight: bold;
                      font-size: 18px;
                      line-height: 69px;
                      position: absolute;
                      right: 16px;
                    "
                    >{{ item.price }}元起
                  </span>
                  <span
                    style="
                      font-weight: bold;
                      font-size: 16px;
                      line-height: 69px;
                      position: absolute;
                      right: 16px;
                      top: 28px;
                      color: rgba(0, 0, 0, 0.5);
                    "
                  >
                    剩余{{ item.num }}件
                  </span>
                </div>
                <div style="display: flex; justify-content: space-between">
                  <div style="line-height: 27px">
                    <span>{{ item.info }}</span>
                  </div>
                  <div>
                    <button
                      style="background-color: #11698e"
                      @click="setMidSc(index)"
                    >
                      购买
                    </button>
                  </div>
                </div>
              </el-card>
            </div>
          </el-col>
        </el-row>

        <el-dialog
          title="商品信息"
          :visible.sync="dialogFormVisible"
          style="border-radius: 16px"
          @closed="clear"
        >
          <el-form :model="midSc">
            <el-form-item label="商品名称" label-width="120px">
              {{ midSc.name }}
            </el-form-item>
            <el-form-item label="商品价格" label-width="120px">
              {{ midSc.price }}
            </el-form-item>
            <el-form-item label="商品种类" label-width="120px">
              {{ midSc.kind }}
            </el-form-item>
            <el-form-item label="商品规格" label-width="120px">
              <!-- <el-radio-group v-model="selectSpec">
                            <el-radio
                              :label="spec"
                              v-for="spec in item.spec"
                              :key="spec"
                              >{{ spec }}</el-radio
                            >
                          </el-radio-group> -->
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <span
              style="
                position: absolute;
                bottom: 70px;
                width: 112px;
                text-align: center;
              "
              >{{ totalPrice(midSc.price) }}元</span
            >
            <div
              style="
                display: flex;
                position: absolute;
                right: 164px;
                width: 128px;
                justify-content: space-around;
              "
            >
              <el-button
                type="primary"
                icon="el-icon-minus"
                circle
                @click="minus"
                :disabled="num < 2"
              ></el-button>
              <span
                style="line-height: 40px; width: 16px; text-align: center"
                >{{ num }}</span
              >
              <el-button
                type="primary"
                icon="el-icon-plus"
                circle
                @click="plus"
              ></el-button>
            </div>
            <el-button type="primary" @click="addToShoppingCart()"
              >加入购物车</el-button
            >
            <span></span>
          </div>
        </el-dialog>
      </div>
    </div>
  </div>
</template>

<script>
import ClientNaviBar from "@/components/clientNaviBar";

export default {
  components: {
    ClientNaviBar,
  },
  data() {
    return {
      index: "1",
      searchName: "",
      goodsList: [],
      dialogFormVisible: false,
      selectSpec: "",
      num: 1,

      midSc: {},
    };
  },
  created() {
    this.$axios
      .post("http://47.104.106.50:8888/jinop/showcommodity", {})
      .then((res) => {
        this.goodsList = res.data.data.rows;
        console.log(this.goodsList, "-----");
        this.$session.set("shoppingCart", []);
      })
      .catch((err) => {
        console.error(err);
      });
  },
  methods: {
    addToShoppingCart() {
      let mid = {
        name: this.midSc.name,
        price: this.midSc.price,
        num: this.num,
        totalPrice: (this.midSc.price * this.num).toFixed(2),
      };
      let sC = this.$session.get("shoppingCart");
      console.log(sC, "------------------------");
      // for (let i = 0; i <= sC.length; i++) {
      //   if (item.name == mid.name) {
      //     item.num = item.num + mid.num;
      //   } else if (i == sC.length) {
      //     sC.push(mid);
      //   }
      // }
      sC.push(mid);
      this.$session.set("shoppingCart", sC);
      this.$notify({
        title: "成功",
        message: "添加成功！",
        type: "success",
        showClose: false,
      });
      this.dialogFormVisible = false;
    },
    plus() {
      this.num++;
    },
    minus() {
      this.num--;
    },
    totalPrice(price) {
      return (price * this.num).toFixed(2);
    },
    clear() {
      this.num = 1;
    },

    setMidSc(index) {
      this.midSc = this.goodsList[index];
      this.dialogFormVisible = true;
    },
  },
};
</script>

<style scoped>
.input >>> .el-input__inner {
  border-radius: 16px 0 0 16px !important;
}
</style>