<template>
  <el-form-item label="科室导航">
    <el-input v-model="deptid" ></el-input>
  </el-form-item>

  <div v-if="deptid>0">
    <p>
        <router-link :to="'/layout/'+deptid">去往科室id为{{deptid}}的科室布局图修改页面</router-link>
    </p>
   <p>
    <router-link :to="'/layout/show/'+deptid">去往科室id为{{deptid}}的科室布局图页面</router-link>
  </p>
  </div>
</template>
<script setup>
import {ref} from 'vue'
const deptid=ref(0)
</script>
<script>

</script>
