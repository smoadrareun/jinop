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
            v-model="searchClientName"
            placeholder="请输入用户名..."
            size="normal"
            clearable
            class="input"
          >
          </el-input>
          <el-button
            type="primary"
            size="default"
            @click="searchClient()"
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
            v-for="(item, index) in clientList"
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
                  <span
                    style="
                      font-weight: bold;
                      font-size: 18px;
                      line-height: 69px;
                      position: absolute;
                      right: 16px;
                      top: 28px;
                    "
                    >会员等级：{{ item.viplevel }}</span
                  >
                </div>
                <div style="display: flex; justify-content: space-between">
                  <div style="line-height: 27px; color: rgba(0, 0, 0, 0.5)">
                    <span>Phone：{{ item.num }}</span>
                  </div>
                  <div>
                    <button
                      style="background-color: #11698e; margin-right: 4px"
                      @click="showDetailedClient(index)"
                    >
                      详情
                    </button>
                  </div>
                </div>
              </el-card>
            </div>
          </el-col>
        </el-row>

        <div v-if="noResult" style="margin-left: 16px">
          <span>{{ clientList }}</span>
        </div>

        <el-dialog
          title="详细信息"
          :visible.sync="dialogFormVisible"
          style="border-radius: 16px"
        >
          <el-form :model="detailedClientFrom">
            <el-form-item label="真实姓名" label-width="120px">
              {{ enName(detailedClientFrom.name) }}
            </el-form-item>
            <el-form-item label="收货地址" label-width="120px">
              {{ detailedClientFrom.address }}
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="dialogFormVisible = false"
              >确定</el-button
            >
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
    return {
      index: "4",
      searchClientName: "",
      clientList: [],
      detailedClientFrom: {},

      noResult: false,

      dialogFormVisible: false,
    };
  },
  methods: {
    searchClient() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/showclient", {
          username: this.searchClientName,
        })
        .then((res) => {
          console.log(res);
          if (res.data.data.rows.length != 0) {
            this.clientList = res.data.data.rows;
            this.noResult = false;
          } else {
            this.clientList = "未查询到结果！";
            this.noResult = true;
          }
          this.searchClientName = "";
        })
        .catch((err) => {
          console.error(err);
        });
    },

    showDetailedClient(index) {
      this.detailedClientFrom = this.clientList[index];
      this.dialogFormVisible = true;
    },

    enName(name) {
      if (name) {
        name = name.split("");
        let res = [];

        let mid = name[name.length - 1];
        for (let index = 0; index < name.length - 1; index++) {
          res.push("*");
        }
        res.push(mid);

        return res.join("");
      } else {
        return "";
      }
    },
  },
};
</script>

<style scoped>
.input >>> .el-input__inner {
  border-radius: 16px 0 0 16px !important;
}
</style>