<template>
  <div>
    <el-container>
      <el-main style="padding-left: 0px;padding-top: 0px;margin-top: 10px">
        <div>
          <el-table
            :data="syslogs"
            border
            stripe
            v-loading="tableLoading"
            size="mini"
            style="width: 100%">
            <el-table-column
              align="center"
              width="120"
              prop="id"
              label="序号">
            </el-table-column>
            <el-table-column
              align="center"
              width="120"
              prop="addDate"
              label="时间">
              <template slot-scope="scope">{{ scope.row.addDate | formatDate}}</template>
            </el-table-column>
            <el-table-column
              align="center"
              width="300"
              prop="operate"
              label="操作">
            </el-table-column>
            <el-table-column
              align="center"
              width="120"
              prop="hrId"
              label="用户id">
            </el-table-column>
          </el-table>
        </div>
        <div style="display: flex;justify-content: space-between;margin: 2px">
          <el-pagination
            background
            :page-size="10"
            :current-page="currentPage"
            @current-change="currentChange"
            layout="prev, pager, next"
            :total="totalCount">
          </el-pagination>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        syslogs: [],
        currentPage: 1,
        totalCount: -1,
        tableLoading:false,
      };
    },
    methods: {
      loadSalaryCfg() {
        this.tableLoading = true;
        this.getRequest("/system/oplog/getLogs?page="+ this.currentPage + "&size=10").then(resp=> {
          if (resp && resp.status == 200) {
            this.syslogs = resp.data.logs;
            this.totalCount = resp.data.count;
            console.log(resp.data)
          }
          this.tableLoading = false;
        })
      },
      currentChange(currentChange){
        this.currentPage = currentChange;
        this.loadSalaryCfg();
      },
    },
    mounted: function () {
      this.loadSalaryCfg();
    }
  }
</script>
