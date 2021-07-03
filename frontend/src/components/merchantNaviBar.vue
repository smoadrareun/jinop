<template>
  <div style="height: 100%">
    <el-menu
      :default-active="index"
      class="el-menu-vertical-demo"
      style="height: 100%"
      unique-opened="true"
    >
      <el-menu-item index="1" @click="goToGoodOpe">
        <template slot="title">
          <i class="el-icon-user-solid"></i>
          <span slot="title">商品操作</span>
        </template>
      </el-menu-item>
      <el-menu-item index="2" @click="goToMerchantOpe" :disabled="level == 1">
        <template slot="title">
          <i class="el-icon-user"></i>
          <span slot="title">商户操作</span>
        </template>
      </el-menu-item>
      <el-menu-item index="3" @click="goToTradingRecordOpe">
        <template slot="title">
          <i class="el-icon-s-order"></i>
          <span slot="title">交易记录</span>
        </template>
      </el-menu-item>
      <el-menu-item index="4" @click="goToClientSearch">
        <template slot="title">
          <i class="el-icon-search"></i>
          <span slot="title">客户查询</span>
        </template>
      </el-menu-item>
      <el-menu-item index="5" @click="goToMerchantProfile">
        <template slot="title">
          <i class="el-icon-more"></i>
          <span slot="title">个人信息</span>
        </template>
      </el-menu-item>
      <el-button
        type="danger"
        size="default"
        style="
          width: 100%;
          position: absolute;
          bottom: 0;
          border-radius: 0;
          background-color: #ef4f4f;
        "
        @click="quit"
        >注销</el-button
      >
    </el-menu>
  </div>
</template>

<script>
export default {
  props: {
    index: String,
  },
  data() {
    return {
      level: 1,
    };
  },
  created() {
    let userInfo = this.$session.get("userInfo");
    console.log(userInfo);

    this.level = userInfo.level;
  },
  methods: {
    goToGoodOpe() {
      this.$router.push("/goodOpe");
    },
    goToMerchantOpe() {
      this.$router.push("/merchantOpe");
    },
    goToTradingRecordOpe() {
      this.$router.push("/tradingRecordOpe");
    },
    goToClientSearch() {
      this.$router.push("/clientSearch");
    },
    goToMerchantProfile() {
      this.$router.push("/merchantProfile");
    },
    quit() {
      this.$router.push("/");
    },
  },
};
</script>

<style>
</style>