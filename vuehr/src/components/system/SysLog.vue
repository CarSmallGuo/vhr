<template>
  <div>
    <el-container>
      <el-main>
        <div>
          <el-table
            :data="syslogs"
            stripe
            v-loading="tableLoading"
            size="mini">
            <el-table-column
              width="120"
              prop="id"
              label="序号">
            </el-table-column>
            <el-table-column
              width="120"
              prop="addDate"
              label="时间">
            </el-table-column>
            <el-table-column
              width="120"
              prop="operate"
              label="操作">
            </el-table-column>
            <el-table-column
              width="120"
              prop="hrId"
              label="用户id">
            </el-table-column>
          </el-table>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        syslogs: []
      };
    },
    methods: {
      loadSalaryCfg() {
        var _this = this;
        this.getRequest("/system/oplog/getLogs").then(resp=> {
          if (resp && resp.status == 200) {
            _this.syslogs = resp.data;
          }
        })
      }
    },
    mounted: function () {
      this.loadSalaryCfg();
    }
  }
</script>
