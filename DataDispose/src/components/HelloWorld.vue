<script setup>
import {useRouter, useRoute} from 'vue-router'
import {ref} from "vue";
import pdf from 'pdfobject'
import { onMounted } from 'vue'

const dialogTableVisible = ref(false)
const router = useRouter()

function to(url) {
  router.push(url)
}


function asd(){
  dialogTableVisible.value=true
  setTimeout(()=>{
    pdf.embed("https://pdfobject.com/pdf/sample-3pp.pdf", "#example1",options);
    pdf.embed("https://pdfobject.com/pdf/sample-3pp.pdf", "#example2",options);
  },1)

}
</script>

<template>
  <el-main>
    <el-button type="primary" @click="to('/layoutIndex')">科室布局图功能</el-button>
  </el-main>

  <el-dialog :draggable="true" :top="'32px'" custom-class="my-dialog"  title="ATGL工厂危险源" v-model="dialogTableVisible" width="1300px">

    <el-tabs type="border-card" :stretch="true">
      <el-tab-pane label="危险因素分析" name="first">
        <template #label>
        <span class="custom-tabs-label">
          危险因素分析
        </span>
        </template>
        <el-header>

          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">${占位符}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">${占位符}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main class="tab-main">
          <el-row class="tab-row" justify="center">
            <el-col :span="11">
              <el-image style="width: 100%; height: 600px" :src="'/src/assets/image/1668671870047.png'" :fit="fit" />
            </el-col>
            <el-col :span="1"></el-col>
            <el-col :span="11" >
              <el-image style="width: 100%; height: 600px" :src="'/src/assets/image/1668671870047.png'" :fit="fit" />
            </el-col>
          </el-row>

        </el-main>

      </el-tab-pane>
      <el-tab-pane label="应急预案及演练" name="second">
        <template #label>
        <span class="custom-tabs-label">
          应急预案及演练
        </span>
        </template>
        <el-header>

          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">${占位符}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">${占位符}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main class="tab-main">
          <el-row class="tab-row" justify="center">
            <el-col :span="11">
              <div class="pdfview" id="example1" >sasd</div>
            </el-col>
            <el-col :span="1"></el-col>
            <el-col :span="11" >
              <div class="pdfview" id="example2" >sasd</div>
            </el-col>
          </el-row>

        </el-main>
      </el-tab-pane>
      <el-tab-pane label="安全操作规程" name="third">
        <template #label>
        <span class="custom-tabs-label">
          安全操作规程
        </span>
        </template>
        <el-header>

          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">${占位符}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">${占位符}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main>

        </el-main>
      </el-tab-pane>
      <el-tab-pane label="日常点检" name="fourth">
        <template #label>
        <span class="custom-tabs-label">
         日常点检
        </span>
        </template>
        <el-header>

          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">${占位符}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">${占位符}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main>

        </el-main>
      </el-tab-pane>
      <el-tab-pane label="视频监控" name="six">
        <template #label>
        <span class="custom-tabs-label">
         视频监控
        </span>
        </template>
        <el-header>

          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">${占位符}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">${占位符}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main>

        </el-main>
      </el-tab-pane>
    </el-tabs>
  </el-dialog>
  <el-button @click="asd"></el-button>
</template>

<style>


</style>
