<template>
  <div style="height: 100%">
    <el-menu
      :default-active="index"
      class="el-menu-vertical-demo"
      style="height: 100%"
    >
      <el-menu-item index="1" @click="goToBuy">
        <template slot="title">
          <i class="el-icon-goods"></i>
          <span slot="title">首页</span>
        </template>
      </el-menu-item>
      <el-menu-item index="2" @click="goToShoppingCart">
        <template slot="title">
          <i class="el-icon-shopping-cart-1"></i>
          <span slot="title">购物车</span>
        </template>
      </el-menu-item>
      <el-menu-item index="3" @click="goToClientProfile">
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
  methods: {
    goToBuy() {
      this.$router.push("/buy");
    },
    goToShoppingCart() {
      this.$router.push("/shoppingCart");
    },
    goToClientProfile() {
      this.$router.push("/clientProfile");
    },
    quit() {
      this.$router.push("/");
    },
  },
};
</script>

<style>
</style>