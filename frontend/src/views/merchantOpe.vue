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
            v-model="searchMerchantUsername"
            placeholder="请输入商品名称..."
            size="normal"
            clearable
            class="input"
          >
          </el-input>
          <el-button
            type="primary"
            size="default"
            @click="searchMerchantByUsername"
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
            v-for="(item, index) in merchantList"
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
                    >{{ item.username }}</span
                  >
                  <span
                    style="
                      font-weight: bold;
                      font-size: 18px;
                      line-height: 69px;
                      position: absolute;
                      right: 16px;
                    "
                    >余额：{{ item.money }}元
                  </span>
                </div>
                <div style="display: flex; justify-content: space-between">
                  <div></div>
                  <div>
                    <button
                      style="background-color: #11698e; margin-right: 4px"
                      @click="editMerchantMid(index)"
                    >
                      修改
                    </button>
                    <button
                      style="background-color: #ef4f4f"
                      @click="deleteMid(item.username, item.id)"
                    >
                      删除
                    </button>
                  </div>
                </div>
              </el-card>
            </div>
          </el-col>
        </el-row>

        <el-dialog title="员工信息" :visible.sync="dialogFormVisible">
          <el-form :model="mid" :rules="rules">
            <el-form-item label="账号" label-width="120px" prop="username">
              <el-input v-model="mid.username" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" label-width="120px" prop="password">
              <el-input v-model="mid.password" autocomplete="off"> </el-input>
            </el-form-item>
            <el-form-item label="余额" label-width="120px" prop="money">
              <el-input v-model="mid.money" autocomplete="off"> </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="editMerchant()">确定</el-button>
          </div>
        </el-dialog>

        <el-dialog title="确认删除" :visible.sync="dialogFormVisible2">
          <div>
            <span>您确认要删除{{ midUsername }}吗？</span>
          </div>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible2 = false">取消</el-button>
            <el-button type="primary" @click="deleteMerchant()">确定</el-button>
          </div>
        </el-dialog>

        <div v-if="noResult" style="margin-left: 16px">
          <span>{{ merchantList }}</span>
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

        <el-dialog title="员工信息" :visible.sync="dialogFormVisible3">
          <el-form :model="addMid" :rules="rules">
            <el-form-item label="账号" label-width="120px" prop="username">
              <el-input v-model="addMid.username" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" label-width="120px" prop="password">
              <el-input v-model="addMid.password" autocomplete="off">
              </el-input>
            </el-form-item>
            <el-form-item label="余额" label-width="120px" prop="money">
              <el-input v-model="addMid.money" autocomplete="off"> </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible3 = false">取消</el-button>
            <el-button type="primary" @click="addMerchant()">确定</el-button>
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
    let checkMoney = (rule, value, callback) => {
      setTimeout(() => {
        if (!Number.isInteger(value)) {
          callback(new Error("请输入数字值"));
        } else {
          if (value < 1) {
            callback(new Error("请输入正确余额"));
          } else {
            callback();
          }
        }
      }, 100);
    };

    return {
      index: "2",
      searchMerchantUsername: "",
      merchantList: [],

      mid: {},
      midUsername: "",
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
        username: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        money: [
          { required: true, message: "请输入余额", trigger: "blur" },
          { validator: checkMoney, trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getMerchant();
  },
  methods: {
    getMerchant() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/showmerchant", {
          level: 1,
        })
        .then((res) => {
          console.log(res);
          this.merchantList = res.data.data.rows;
        })
        .catch((err) => {
          console.error(err);
        });
    },

    editMerchantMid(index) {
      this.mid = this.merchantList[index];
      this.dialogFormVisible = true;
    },

    deleteMid(username, id) {
      this.midUsername = username;
      this.midId = id;
      this.dialogFormVisible2 = true;
    },

    deleteMerchant() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/deletemerchant/" + this.midId)
        .then((res) => {
          console.log(res);
          this.midId = "";
          this.dialogFormVisible2 = false;
          this.getMerchant();
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

    searchMerchantByUsername() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/showcommodity", {
          name: this.searchMerchantUsername,
        })
        .then((res) => {
          console.log(res);
          if (res.data.data.rows.length != 0) {
            this.merchantList = res.data.data.rows;
            this.noResult = false;
          } else {
            this.merchantList = "未查询到结果！";
            this.noResult = true;
          }
          this.searchMerchantUsername = "";
        })
        .catch((err) => {
          console.error(err);
        });
    },

    addMerchant() {
      console.log(this.addMid, "addMid");
      this.$axios
        .post("http://47.104.106.50:8888/jinop/addmerchant", {
          username: this.addMid.username,
          password: this.addMid.password,
          money: this.addMid.money,
          level: 1,
        })
        .then((res) => {
          console.log(res);
          this.addMid = {};
          this.getMerchant();
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

<style scoped>
.input >>> .el-input__inner {
  border-radius: 16px 0 0 16px !important;
}
</style>