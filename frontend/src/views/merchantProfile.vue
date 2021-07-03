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

      <div style="grid-area: 1 / 2 / 11 / 11">
        <el-card
          shadow="always"
          :body-style="{ padding: '20px' }"
          style="border-radius: 16px; width: 400px; margin-top: 16px"
        >
          <div style="display: flex; align-items: center">
            <img
              src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2126262052,3269603416&fm=26&gp=0.jpg"
              style="height: 128px; width: 128px; border-radius: 99px"
            />
            <div style="margin-left: 32px">
              <div>
                <span class="tagHead">用户昵称：</span>
                <span class="tagBody">{{ userInfo.username }}</span>
              </div>
              <div>
                <span class="tagHead">账户余额：</span>
                <span class="tagBody">{{ userInfo.money }}元</span>
              </div>
              <div>
                <span class="tagHead">联系方式：</span>
                <span class="tagBody">{{ userInfo.num }}</span>
              </div>
              <div>
                <span class="tagHead">账号等级：</span>
                <span class="tagBody">{{ userInfo.level }}</span>
              </div>
            </div>
          </div>
        </el-card>

        <div>
          <button
            @click="dialogFormVisible = true"
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
              class="fas fa-feather-alt"
              style="font-size: 36px; color: #fff"
            ></i>
          </button>
        </div>

        <el-dialog title="个人信息" :visible.sync="dialogFormVisible">
          <el-form :model="userInfo" :rules="rules">
            <el-form-item label="用户昵称" label-width="120px" prop="username">
              <el-input
                v-model="userInfo.username"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item label="账户余额" label-width="120px" prop="money">
              <el-input v-model="userInfo.money" autocomplete="off"> </el-input>
            </el-form-item>
            <el-form-item label="联系方式" label-width="120px" prop="num">
              <el-input v-model="userInfo.num" autocomplete="off"> </el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="changeMerchant()">确定</el-button>
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

    let checkPhone = (rule, value, callback) => {
      const phoneReg = /^1[3|4|5|7|8][0-9]{9}$/;
      setTimeout(() => {
        if (!Number.isInteger(+value)) {
          callback(new Error("请输入数字值"));
        } else {
          if (phoneReg.test(value)) {
            callback();
          } else {
            callback(new Error("电话号码格式不正确"));
          }
        }
      }, 100);
    };

    return {
      index: "5",
      userInfo: {},

      dialogFormVisible: false,

      rules: {
        username: [
          { required: true, message: "请输入用户昵称", trigger: "blur" },
        ],
        money: [
          { required: true, message: "请输入账户余额", trigger: "blur" },
          { validator: checkMoney, trigger: "blur" },
        ],
        num: [
          { required: true, message: "请输入联系方式", trigger: "blur" },
          { validator: checkPhone, trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.userInfo = this.$session.get("userInfo");
  },
  methods: {
    changeMerchant() {
      let mid = this.userInfo;
      this.$axios
        .post("http://47.104.106.50:8888/jinop/editmerchant", {
          id: mid.id,
          username: mid.username,
          password: mid.password,
          money: mid.money,
          name: mid.name,
          num: mid.num,
        })
        .then((res) => {
          console.log(res);
          this.dialogFormVisible = false;

          if (res.data.info.code == "200") {
            this.$notify({
              title: "成功",
              message: "修改成功！",
              type: "success",
              showClose: false,
            });

            this.$session.set("userInfo", res.data.data.rows[0]);
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
          this.dialogFormVisible = false;
        });
    },
  },
};
</script>

<style>
.tagHead {
  color: rgba(0, 0, 0, 0.5);
  font-size: 17px;
}
.tagBody {
  font-size: 17px;
}
</style>