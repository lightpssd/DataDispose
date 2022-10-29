<template xmlns="">
  <div class="update" :style="backinfo">
    <VueDragResize class="drag" v-for="(item,index) in  info" :key="item.id"
                   @clicked="onActivated(item,index)" :w="item.width" :h="item.height" :x="item.axis"
                   :y="item.ayis" :isActive="false" :isDraggable="false" :isResizable="false"
                   :minw="10" :minh="10">
      <div class="bt" :style="{
        'background-image': `url(/static${item.icon_image})`,
        'border-radius': item.isRound?'50%':0,
        }">
      </div>
      <!--      <el-popover placement="top-start" title="Title" :width="200" trigger="hover">-->
      <!--        <template #reference>-->
      <!--          <div class="bt" :style="item.style" draggable="true">-->
      <!--            {{ item.axis }}-->
      <!--          </div>-->
      <!--        </template>-->
      <!--      </el-popover>-->
    </VueDragResize>
  </div>
  <el-dialog  v-model="dialogTableVisible" title="详细信息展示" :width="showUrl!==''?'60%':'30%'" align-center="true">
    <el-row >
      <el-col :span="showUrl!==''?9:24">
        <el-table :data="gridData" stripe max-height="350" table-layout="fixed">
          <el-table-column property="key" label="" min-width="100px"/>
          <el-table-column property="value" label="" min-width="100px"/>
        </el-table>
      </el-col>
      <el-col :span="15" v-if="showUrl!==''">
        <div class="imagec">
          <el-image :src="'static'+showUrl" :fit="'contain'"
                    :preview-src-list="['static'+showUrl]"
                    :initial-index="0"/>
        </div>
      </el-col>
    </el-row>
  </el-dialog>
</template>
<script setup async>
import {ElMessage, ElLoading} from 'element-plus';
import {nextTick, reactive, ref} from 'vue'
import {Delete} from '@element-plus/icons-vue'
import axios from "axios";
import VueDragResize from "vue-drag-resize/src/components/vue-drag-resize.vue";
import {useRouter, useRoute} from 'vue-router'

const route = useRoute()
const loadingInstance = ElLoading.service({fullscreen: true, text: "加载布局图中"})
const dialogTableVisible = ref(false)

const re = []
const info = reactive(re)
const gridData = ref()
const showUrl = ref()
const backinfo = reactive({
  "background-image": "linear-gradient(red, yellow, blue)",
  "background-repeat": "no-repeat",
  "background-size": "100% 100%"
})
axios.get("/api/point/deptimage/" + route.params.id).then((resp) => {
  if (resp.data.code === 20000)
    backinfo["background-image"] = `url(/static${resp.data.data})`
})
axios.get("/api/point/" + route.params.id).then(
    (resp) => {
      console.log(resp.data.data)
      if (resp.data.data.length > 0) {

        info.pop()
        resp.data.data.forEach((a) => {
          a.icon_image = a.icon_image.replaceAll("\\", "/")
          a.show_image = a.show_image.replaceAll("\\", "/")
          info.push(a)
        })
      } else {

      }

      loadingInstance.close()
    }
)

function onActivated(item, index) {
  gridData.value = item.points
  showUrl.value = item.show_image
  dialogTableVisible.value = true
}


</script>
<style scoped>
.bt {
  /*border-radius: 50%;*/
  width: 100%;
  height: 100%;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  border: 1px #00ff00 solid;
}

.update {

  background-color: aqua;
  float: left;
  width: 1920px;
  height: 1080px;
  margin: 0;
  padding: 0;
}

.imagec {
  text-align: center;
  max-height: 450px;
  overflow: clip;
}
el-image{

}
</style>
