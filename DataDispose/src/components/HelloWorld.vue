<script setup>
import {useRouter, useRoute} from 'vue-router'
const router=useRouter()
function to(url){
  router.push(url)
}
</script>

<template>
  <el-main>
    <el-button type="primary" @click="to('/layoutIndex')">科室布局图功能</el-button>
  </el-main>

</template>

<style scoped>

</style>
