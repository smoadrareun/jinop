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
            v-model="searchNameinSCart"
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
            class="input"
            >搜索</el-button
          >
        </div>
      </div>

      <div style="grid-area: 2 / 2 / 10 / 11; display: flex; flex-wrap: wrap">
        <el-row :gutter="20" style="width: 100%">
          <el-col
            :span="6"
            :offset="0"
            v-for="(item, index) in sCartList"
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
                    >{{ item.price }}元
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
                    * {{ item.num }}件
                  </span>
                </div>
                <div style="display: flex; justify-content: space-between">
                  <div style="line-height: 27px">
                    <span>共 {{ (item.price * item.num).toFixed(2) }}元</span>
                  </div>
                  <div>
                    <button
                      style="background-color: #ef4f4f"
                      @click="remove(index)"
                    >
                      移除
                    </button>
                  </div>
                </div>
              </el-card>
            </div>
          </el-col>
        </el-row>

        <div>
          <button
            @click="balance"
            style="
              position: absolute;
              bottom: 32px;
              right: 32px;
              background-color: #11698e;
              height: 64px;
              width: 64px;
              border-radius: 32px;
            "
          >
            <i
              class="fas fa-credit-card"
              style="font-size: 36px; color: #fff"
            ></i>
          </button>
        </div>
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
      index: "2",
      sCartList: {},
      searchNameinSCart: "",
    };
  },
  created() {
    this.sCartList = this.$session.get("shoppingCart");
  },
  methods: {
    remove(index) {
      this.sCartList.splice(index, 1);
      this.$session.set("shoppingCart", this.sCartList);
    },
    balance() {
      if (this.sCartList.length == 0) {
        this.$notify.error({
          title: "错误",
          message: "购物车为空！",
          showClose: false,
        });
      } else {
        let userInfo = this.$session.get("userInfo");
        let money = 0;
        this.sCartList.forEach((element) => {
          money += element.num * element.price;
        });

        this.$axios
          .post("http://47.104.106.50:8888/jinop/addtransaction", {
            cliid: userInfo.id,
            merid: 1,
            money: money.toFixed(2),
            info: JSON.stringify(this.sCartList),
            status: 1,
          })
          .then((res) => {
            if (res.data.info.code == 200) {
              console.log(res);
              this.sCartList = [];
              this.$session.remove("userInfo");

              this.$notify({
                title: "成功",
                message: "下单成功",
                type: "success",
                showClose: false,
              });
            } else {
              this.$notify.error({
                title: "错误",
                message: res.data.info.message,
                showClose: false,
              });
            }
          })
          .catch((err) => {
            console.error(err);
          });
      }
    },
  },
};
</script>

<style scoped>
.input >>> .el-input__inner {
  border-radius: 16px 0 0 16px;
}
</style>