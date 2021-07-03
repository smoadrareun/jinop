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
      <span>用户注册</span>
    </div>
    <el-card
      shadow="always"
      :body-style="bStyle"
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
        <input
          v-model="signupForm.username"
          name="username"
          style="margin-top: 24px"
          placeholder="请输入用户名"
        />
        <input
          type="password"
          v-model="signupForm.password"
          name="password"
          placeholder="请输入密码"
        />
        <input v-model="signupForm.name" name="name" placeholder="请输入姓名" />
        <input
          v-model="signupForm.num"
          name="num"
          placeholder="请输入电话号码"
        />
        <input
          type="password"
          v-model="signupForm.paypass"
          name="paypass"
          placeholder="请输入支付密码"
        />

        <button id="subBtn" @click="signup">注册</button>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      bStyle: {
        padding: "20px 110px",
      },
      signupForm: {
        username: "",
        password: "",
        name: "",
        num: "",
        paypass: "",
      },
    };
  },
  methods: {
    signup() {
      let mid = this.signupForm;
      this.$axios
        .post("http://47.104.106.50:8888/jinop/addclient", {
          username: mid.username,
          password: mid.password,
          name: mid.name,
          num: mid.num,
          paypass: mid.paypass,
        })
        .then((res) => {
          console.log(res, "merchant");
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