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
            v-model="searchRecordId"
            placeholder="请输入订单号..."
            size="normal"
            clearable
            class="input"
          >
          </el-input>
          <el-button
            type="primary"
            size="default"
            @click="searchRecord"
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
            v-for="item in recordList"
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
                    justify-content: space-around;
                    position: relative;
                  "
                >
                  <span
                    style="
                      position: absolute;
                      color: rgba(0, 0, 0, 0.5);
                      font-size: 14px;
                      left: 0px;
                      z-index: 999;
                    "
                    >CNY20210107180930</span
                  >
                  <div
                    style="
                      position: relative;
                      top: 4px;
                      display: flex;
                      width: 100%;
                      justify-content: space-around;
                    "
                  >
                    <span
                      style="
                        font-weight: bold;
                        font-size: 18px;
                        line-height: 69px;
                      "
                      >{{ item.cliname }}</span
                    >

                    <span
                      style="
                        font-weight: bold;
                        font-size: 18px;
                        line-height: 69px;
                      "
                    >
                      >> {{ item.money }}元 >>
                    </span>

                    <span
                      style="
                        font-weight: bold;
                        font-size: 18px;
                        line-height: 69px;
                      "
                      >{{ item.mername }}
                    </span>
                  </div>
                </div>
                <div style="display: flex; justify-content: space-between">
                  <div style="line-height: 27px">
                    <span>{{ item.date }}</span>
                  </div>
                  <div>
                    <button
                      style="background-color: #11698e; margin-right: 4px"
                      @click="showDetailedInfo(item)"
                    >
                      详情
                    </button>
                    <button style="background-color: #ef4f4f">删除</button>
                  </div>
                </div>
              </el-card>
            </div>
          </el-col>
        </el-row>

        <div v-if="noResult" style="margin-left: 16px">
          <span>{{ recordList }}</span>
        </div>

        <el-dialog
          title="商品信息"
          :visible.sync="dialogFormVisible"
          style="border-radius: 16px"
        >
          <el-table :data="infoTable" stripe style="width: 100%">
            <el-table-column prop="name" label="名称" width="180">
            </el-table-column>
            <el-table-column prop="num" label="数量" width="180">
            </el-table-column>
            <el-table-column prop="price" label="单价"> </el-table-column>
            <el-table-column prop="totalPrice" label="总价"> </el-table-column>
          </el-table>
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="dialogFormVisible = false"
              >确认</el-button
            >
            <span></span>
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
      index: "3",
      searchRecordId: "",
      recordList: [],
      infoTable: [],

      dialogFormVisible: false,
      noResult: false,
    };
  },
  created() {
    this.$axios
      .post("http://47.104.106.50:8888/jinop/showtransaction", {})
      .then((res) => {
        this.recordList = res.data.data.rows;
      })
      .catch((err) => {
        console.error(err);
      });
  },
  methods: {
    searchRecord() {
      this.$axios
        .post("http://47.104.106.50:8888/jinop/showtransaction", {
          id: this.searchRecordId,
        })
        .then((res) => {
          console.log(res);
          if (res.data.data.rows.length != 0) {
            this.recordList = res.data.data.rows;
            this.noResult = false;
          } else {
            this.recordList = "未查询到结果！";
            this.noResult = true;
          }
          this.searchRecordId = "";
        })
        .catch((err) => {
          console.error(err);
        });
    },

    showDetailedInfo(item) {
      this.infoTable = item.info;
      console.log(this.infoTable);
      this.dialogFormVisible = true;
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