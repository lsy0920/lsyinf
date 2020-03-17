<template>
  <div>
    <el-cascader v-model="myDepartment" class="linkWidth" :options="options" @change="handleChange"></el-cascader>

    <div class="selectDepartment">
      <span class="departmentWidth">部门：</span>
      <el-select
        v-model="department"
        filterable
        size="small"
        @change="departmentChanged"
        placeholder="请选择部门"
        prop="status"
        style="width: 10%"
      >
        <el-option
          :value="item.value"
          :label="item.label"
          v-for="item in departments"
          :key="item.value"
        ></el-option>
      </el-select>
      <span class="officeWidth">科室：</span>
      <el-select
        v-model="office"
        :loading="loadingOffice"
        filterable
        size="small"
        @change="officeChanged"
        placeholder="请选择科室"
        prop="status"
        style="width: 10%"
      >
        <el-option
          :value="item.value"
          :label="item.label"
          v-for="item in offices"
          :key="item.value"
        ></el-option>
      </el-select>
    </div>

    <div class="test">
      <el-select
        v-model="departmentTest"
        multiple
        filterable
        remote
        reserve-keyword
        value-key ="id"
        placeholder="请选择部门"
        :remote-method="remoteDepartment"
        :loading="loading"
      >
        <el-option
          v-for="item in departmentList"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        ></el-option>
      </el-select>
      <el-select
        v-model="officeTest"
        multiple
        filterable
        remote
        reserve-keyword
        value-key ="id" 
        placeholder="请选择科室"
        :remote-method="remoteOffice"
        :loading="loadOffice"
      >
        <el-option
          v-for="item in officeList"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        ></el-option>
      </el-select>
    </div>
  </div>
</template>
<script>
import information from "@/assets/json/information.json"

export default {
  name: "Link",
  props: {
    departmentCode: {
      type: String,
      default: ""
    },
    officeCode: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      options: [
        {
          value: "informationEngineer",
          label: "信息工程部",
          children: [
            {
              value: "softDeparnmentCenter",
              label: "软件开发中心"
            },
            {
              value: "softDeparnmentCenter",
              label: "软件开发中心"
            },
            {
              value: "softDeparnmentCenter",
              label: "软件开发中心"
            }
          ]
        },
        {
          value: "financeDepartment",
          label: "财务部",
          children: [
            {
              value: "financeCenter",
              label: "财务中心"
            }
          ]
        }
      ],
      department: "",
      departments: [],
      offices: [],
      myDepartment: "",
      office: "",
      loadingOffice: false,
      departmentTest: "",
      officeTest: "",
      loadingOfficeTest: false,
      departmentList: [],
      list: [],
      allDepartments: [],
      loading: false,
      loadOffice: false,
      officeList: [],
      allOffices: [],
      lists: []
    };
  },
  created() {
    this.departments = information.departments;
    this.offices = information.offices;
  },
  mounted() {
    this.department = this.departmentCode;
    this.departmentChanged(this.departmentCode);
    this.office = this.officeCode;
    this.officeChanged(this.officeCode);
    this.getDepartmentData();
    this.getOfficeData();
  },
  methods: {
    departmentChanged(value) {
      if (value !== "") {
        this.loadingOffice = true;
        for (var item of this.departments) {
          if (item.value === value) {
            this.offices = item.offices;
            this.office = "";
            this.loadingOffice = false;
            this.department = item.label;
            break;
          } else {
            continue;
          }
        }
      } else {
        this.offices = [];
        this.office = "";
      }
    },

    officeChanged(value) {
      if (value !== "") {
        for (var item of this.offices) {
          if (item.value === value) {
            this.office = item.label;
          }
        }
      }
    },
    handleChange() {},

    getDepartmentData() {
      this.$http({
        method: "post",
        url: "/api/getDepartment"
      })
        .then(response => {
          console.log(response.data);
          this.allDepartments = response.data;
          this.list = this.allDepartments.map(item => {
            return { value: item.id, label: item.department };
          });
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    getOfficeData() {
      this.$http({
        method: "post",
        url: "/api/getOffice"
      })
        .then(response => {
          console.log(response.data);
          this.allOffices = response.data;
          this.lists = this.allOffices.map(item => {
            return { value: item.id, label: item.office };
          });
        })
        .catch(function(error) {
          console.log(error);
        });
    }, 
    remoteDepartment(query) {
      if (query !== "") {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.departmentList = this.list.filter(item => {
            return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1;
          });
        }, 200);
      } else {
        this.departmentList = [];
      }
    },
    remoteOffice(query) {
        if (query !== "") {
        this.loadOffice = true;
        setTimeout(() => {
          this.loadOffice = false;
          this.officeList = this.lists.filter(item => {
            return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1;
          });
        }, 200);
      } else {
        this.officeList = [];
      }
    }
  }
};
</script>
<style scoped>
.selectDepartment {
  margin-top: 50px;
}
.test {
  margin-top: 50px;
}
</style>
