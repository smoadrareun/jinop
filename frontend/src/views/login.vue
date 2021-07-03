<template>
  <div style="height: 100%">
    <img
      src="https://s3.ax1x.com/2020/12/29/r7ri0x.jpg"
      style="height: 100vh; width: 100vw; display: block"
    />
    <div
      style="
        position: absolute;
        top: 88px;
        color: #fff;
        font-size: 64px;
        left: 50%;
        transform: translateX(-50%);
        display: flex;
        flex-direction: column;
        align-items: center;
      "
    >
      <span>劲的小店</span>
      <span style="font-size: 24px; color: rgba(255, 255, 255, 0.75)">{{
        loginMode
      }}</span>
    </div>
    <el-card
      shadow="always"
      :body-style="{ padding: '80px' }"
      style="
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: rgba(0, 0, 0, 0.5);
        border-radius: 16px;
        backdrop-filter: blur(16px);
        border: none;
      "
    >
      <div style="display: flex; flex-direction: column">
        <input v-model="loginForm.username" name="username" />
        <input type="password" v-model="loginForm.password" name="password" />
        <button id="subBtn" @click="submit(1)">登录</button>
        <button id="subBtn" @click="submit(2)" v-if="loginModeNum !== 0">
          管理员登录
        </button>
        <button id="subBtn" @click="goToSignup" v-if="loginModeNum == 0">
          注册
        </button>

        <div
          style="
            display: flex;
            justify-content: center;
            color: rgba(255, 255, 255, 0.3);
          "
        >
          <span>想要登录{{ unLoginMode }}？</span>
          <span class="click" @click="changeLoginMode">点击这里</span>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "",
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
      },
      loginMode: "用户版",
      unLoginMode: "商户版",
      loginModeNum: 0,
    };
  },
  methods: {
    submit(level) {
      if (this.loginModeNum == 1) {
        this.$axios
          .post("http://47.104.106.50:8888/jinop/querymerchant", {
            username: this.loginForm.username,
            password: this.loginForm.password,
            level: level,
          })
          .then((res) => {
            console.log(res, "merchant");
            if (res.data.info.code == "200") {
              this.$session.set("userInfo", res.data.data.rows[0]);
              this.$router.push("/goodOpe");
              this.$notify({
                title: "成功",
                message: "欢迎" + res.data.data.rows[0].username + "！",
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
      } else {
        this.$axios
          .post("http://47.104.106.50:8888/jinop/queryclient", {
            username: this.loginForm.username,
            password: this.loginForm.password,
          })
          .then((res) => {
            console.log(res, "client");
            if (res.data.info.code == "200") {
              this.$session.set("userInfo", res.data.data.rows[0]);
              this.$router.push("/buy");
              this.$notify({
                title: "成功",
                message: "欢迎" + res.data.data.rows[0].username + "！",
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

    changeLoginMode() {
      if (this.loginMode == "用户版") {
        this.loginMode = "商户版";
        this.unLoginMode = "用户版";
        this.loginModeNum = 1;
      } else if (this.loginMode == "商户版") {
        this.loginMode = "用户版";
        this.unLoginMode = "商户版";
        this.loginModeNum = 0;
      }
    },

    goToSignup() {
      this.$router.push("/signup");
    },
  },
};
</script>

<style scoped>
input {
  height: 56px;
  width: 240px;
  border-radius: 16px;
  border: 1px solid #f2f2f2;
  background-color: rgba(0, 0, 0, 0);
  text-align: center;
  font-size: 24px;
  color: #f2f2f2;
  margin-bottom: 24px;
}
input:focus {
  outline: none;
}

#subBtn {
  height: 56px;
  background-color: rgba(0, 0, 0, 0);
  border-radius: 16px;
  border: none;
  transition: 0.75s;
  transition: all 0.2s ease-in-out;
  cursor: pointer;
  font-size: 22px;
  font-weight: bold;
  color: #f2f2f2;
  margin-bottom: 24px;
}
#subBtn:hover {
  transition: 0.75s;
  background-color: #f2f2f2;
  color: #000;
  border: none;
}
#subBtn:focus {
  outline: 0;
}

.click {
  transition: 0.5s;
}
.click:hover {
  color: #fff;
  transition: 0.5s;
}
</style>