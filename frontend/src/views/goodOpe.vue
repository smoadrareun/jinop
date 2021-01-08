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
        <MerchantNaviBar :index="index" />
      </div>

      <div style="grid-area: 1 / 2 / 2 / 11">
        <div style="margin-top: 16px; width: 480px; display: flex">
          <el-input
            v-model="searchCommodityName"
            placeholder="请输入商品名称..."
            size="normal"
            clearable
            class="input"
          >
          </el-input>
          <el-button
            type="primary"
            size="default"
            @click="searchCommodityByName"
            style="border-radius: 0 16px 16px 0"
            >搜索</el-button
          >
        </div>
      </div>

      <div style="grid-area: 2 / 2 / 10 / 11; display: flex; flex-wrap: wrap">
        <el-row :gutter="20" style="width: 100%" v-if="!noResult">
          <el-col
            :span="6"
            :offset="0"
            v-for="(item, index) in commodityList"
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
                </div>
                <div style="display: flex; justify-content: space-between">
                  <div style="line-height: 27px; color: rgba(0, 0, 0, 0.5)">
                    <span>剩余{{ item.num }}件,</span>
                    <span>已售{{ item.sales }}件</span>
                  </div>
                  <div>
                    <button
                      style="background-color: #11698e; margin-right: 4px"
                      @click="editMid(index)"
                    >
                      修改
                    </button>
                    <button
                      style="background-color: #ef4f4f"
                      @click="deleteMid(item.name, item.id)"
                    >
                      删除
                    </button>
                  </div>
                </div>
              </el-card>
            </div>
          </el-col>
        </el-row>

        <el-dialog title="商品信息" :visible.sync="dialogFormVisible">
          <el-form :model="mid" :rules="rules">
            <el-form-item label="商品名称" label-width="120px" prop="name">
              <el-input v-model="mid.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="商品库存" label-width="120px" prop="num">
              <el-input v-model.number="mid.num" autocomplete="off"> </el-input>
            </el-form-item>
            <el-form-item label="商品图片" label-width="120px" prop="pic">
              <el-input v-model="mid.pic" autocomplete="off"> </el-input>
            </el-form-item>
            <el-form-item label="商品种类" label-width="120px" prop="kind">
              <el-input v-model="mid.kind" autocomplete="off"> </el-input>
            </el-form-item>
            <el-form-item label="商品描述" label-width="120px" prop="info">
              <el-input v-model="mid.info" autocomplete="off"> </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="editCommodity()">确定</el-button>
          </div>
        </el-dialog>

        <el-dialog title="确认删除" :visible.sync="dialogFormVisible2">
          <div>
            <span>您确认要删除{{ midName }}吗？</span>
          </div>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible2 = false">取消</el-button>
            <el-button type="primary" @click="deleteCommodity()"
              >确定</el-button
            >
          </div>
        </el-dialog>

        <div v-if="noResult" style="margin-left: 16px">
          <span>{{ commodityList }}</span>
        </div>

        <div>
          <button
            @click="dialogFormVisible3 = true"
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
            <i class="fas fa-plus" style="font-size: 36px; color: #fff"></i>
          </button>
        </div>

        <el-dialog title="商品信息" :visible.sync="dialogFormVisible3">
          <el-form :model="addMid" :rules="rules">
            <el-form-item label="商品名称" label-width="120px" prop="name">
              <el-input v-model="addMid.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="商品库存" label-width="120px" prop="num">
              <el-input v-model.number="addMid.num" autocomplete="off">
              </el-input>
            </el-form-item>
            <el-form-item label="商品图片" label-width="120px" prop="pic">
              <el-input v-model="addMid.pic" autocomplete="off"> </el-input>
            </el-form-item>
            <el-form-item label="商品种类" label-width="120px" prop="kind">
              <el-input v-model="addMid.kind" autocomplete="off"> </el-input>
            </el-form-item>
            <el-form-item label="商品描述" label-width="120px" prop="info">
              <el-input v-model="addMid.info" autocomplete="off"> </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible3 = false">取消</el-button>
            <el-button type="primary" @click="addCommodity()">确定</el-button>
          </div>
        </el-dialog>
      </div>
    </div>
  </div>
</template>

<script>
import MerchantNaviBar from "@/components/merchantNaviBar";

export default {
  components: {
    MerchantNaviBar,
  },
  data() {
    let checkNum = (rule, value, callback) => {
      setTimeout(() => {
        if (!Number.isInteger(value)) {
          callback(new Error("请输入数字值"));
        } else {
          if (value < 1) {
            callback(new Error("请输入正确库存"));
          } else {
            callback();
          }
        }
      }, 100);
    };

    return {
      index: "1",
      searchCommodityName: "",
      commodityList: [],

      mid: {},
      midName: "",
      midId: "",

      addMid: {},

      // 修改Dialog
      dialogFormVisible: false,
      // 删除Dialog
      dialogFormVisible2: false,
      // 添加Dialog
      dialogFormVisible3: false,
      inputVisible: false,
      inputValue: "",

      noResult: false,

      rules: {
        name: [{ required: true, message: "请输入商品名称", trigger: "blur" }],
        num: [
          { required: true, message: "请输入商品库存", trigger: "blur" },
          { validator: checkNum, trigger: "blur" },
        ],
        pic: [{ required: true, message: "请输入商品图片", trigger: "blur" }],
        kind: [{ required: true, message: "请输入商品种类", trigger: "blur" }],
        info: [{ required: true, message: "请输入用户描述", trigger: "blur" }],
      },
    };
  },
  created() {
    this.getCommodity();
  },
  methods: {
    handleClose(tag, index) {
      this.commodityList[index].spec.splice(
        this.commodityList[index].spec.indexOf(tag),
        1
      );
    },
    showInput() {
      this.inputVisible = true;
      this.$nextTick(() => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },
    handleInputConfirm(index) {
      let inputValue = this.inputValue;
      if (inputValue) {
        this.commodityList[index].spec.push(inputValue);
      }
      this.inputVisible = false;
      this.inputValue = "";
    },
    getCommodity() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/showcommodity", {})
        .then((res) => {
          this.commodityList = res.data.data.rows;
          console.log(this.commodityList, "-----");
        })
        .catch((err) => {
          console.error(err);
        });
    },

    editCommodity() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/editcommodity", {
          id: this.mid.id,
          info: this.mid.info,
          kind: this.mid.kind,
          name: this.mid.name,
          num: this.mid.num,
          pic: this.mid.pic,
          spec: this.mid.spec,
        })
        .then((res) => {
          console.log(res, this.dialogFormVisible);
          this.dialogFormVisible = false;

          this.mid = {};
          this.getCommodity();
        })
        .catch((err) => {
          console.error(err);
        });
    },

    editMid(index) {
      this.mid = this.commodityList[index];
      this.dialogFormVisible = true;
    },

    deleteMid(name, id) {
      this.midName = name;
      this.midId = id;
      this.dialogFormVisible2 = true;
    },

    deleteCommodity() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/deletecommodity/" + this.midId)
        .then((res) => {
          console.log(res);
          this.midId = "";
          this.dialogFormVisible2 = false;
          this.getCommodity();
          this.$notify({
            title: "成功",
            message: "删除成功",
            type: "success",
            showClose: false,
          });
        })
        .catch((err) => {
          console.error(err);
        });
    },

    searchCommodityByName() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/showcommodity", {
          name: this.searchCommodityName,
        })
        .then((res) => {
          console.log(res);
          if (res.data.data.rows.length != 0) {
            this.commodityList = res.data.data.rows;
            this.noResult = false;
          } else {
            this.commodityList = "未查询到结果！";
            this.noResult = true;
          }
          this.searchCommodityName = "";
        })
        .catch((err) => {
          console.error(err);
        });
    },

    addCommodity() {
      console.log(this.addMid, "addMid");
      this.$axios
        .post("http://47.104.106.50:8888/jinop/addcommodity", {
          name: this.addMid.name,
          price: this.addMid.price,
          num: this.addMid.num,
          info: this.addMid.info,
          pic: this.addMid.pic,
        })
        .then((res) => {
          console.log(res);
          this.addMid = {};
          this.getCommodity();
          this.dialogFormVisible3 = false;
          this.$notify({
            title: "成功",
            message: "添加成功",
            type: "success",
            showClose: false,
          });
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
</script>

<style>
button {
  color: #f2f2f2;
  border: none;
  border-radius: 4px;
  padding: 4px 8px;
}
button:hover {
  cursor: pointer;
}
button:focus {
  outline: none;
}
</style>

<style scoped>
.input >>> .el-input__inner {
  border-radius: 16px 0 0 16px !important;
}
</style>