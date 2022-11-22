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

  <div id="example1" ></div>
</template>
<script setup>
// import  PDFObject  from '../assets/js/pdfobject'
import pdf from 'pdfobject'
import {ref} from 'vue'
import { onMounted } from 'vue'
var options = {
  width: "40rem",
  height: "40rem"
};
onMounted(() => {
  pdf.embed("https://pdfobject.com/pdf/sample-3pp.pdf", "#example1",options);
})

// import jsPdf from "./Javascript.pdf"
const deptid=ref(0)
</script>
<style>

</style>
