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
  <el-dialog custom-class="my-man-dialog"    v-model="dialogTableVisible" title=""  align-center="true" top="30px" width="760px"  @open="datachange(showinfo)">
    <el-tabs  v-if="showinfo?.type==='1'" model-value="first" class="demo-tabs"  >
      <el-tab-pane label="人员信息" name="first">
          <iframe :src="'http://192.9.200.50:99/imageSlideshow/peopleIndex/'+showinfo?.employeeNo" ></iframe>
      </el-tab-pane>
      <el-tab-pane label="人员技能" name="second">
        <iframe :src="'http://192.9.200.50:99/imageSlideshow/peopleskillIndex/'+showinfo?.employeeNo" ></iframe>
      </el-tab-pane>
      <el-tab-pane label="顶岗人" name="third">
        <iframe :src="'http://192.9.200.50:99/imageSlideshow/peopleIndex/'+showinfo?.onPostPerson" ></iframe>
      </el-tab-pane>
    </el-tabs >
    <el-tabs  style="min-height: 500px"  v-if="showinfo?.type==='2'" model-value="first" class="demo-tabs">
      <el-tab-pane label="安全事故信息" name="first">
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 发生时间 </el-card>
          </el-col>
         <el-col :span="18" :offset="1">
           <el-card :span="16" shadow="hover"> {{ dangerinfo?.occurDate }} </el-card>
         </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 发生地点 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.occurAddress }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 员工受伤情况 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.empInjuries }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 事故原因 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.accidentCause }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 事故具体情况 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.accidentDetails }} </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="安全事故图片" name="second">
        <el-image
            :src="'/static/'+dangerinfo?.photoPath"
            :preview-src-list="['/static/'+dangerinfo?.photoPath]"
            fit="fill"
        />
      </el-tab-pane>
    </el-tabs>
    <el-tabs  style="min-height: 500px"  v-if="showinfo?.type==='3'" model-value="first" class="demo-tabs">
      <el-tab-pane label="安全事故信息" name="first">
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 工序 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.process }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 变化点说明 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.changeState }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 潜在风险 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.potentialRisk }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 管控方案 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.controlScheme }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 责任人 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.personLiable }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 完成期限 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.compTime }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 品质确认及管控实施情况 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.implementation }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 确认人 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.confirmPerson }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 确认时间 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.compTime }} </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>

    </el-tabs>
    <el-tabs  style="min-height: 500px"  v-if="showinfo?.type==='4'" model-value="first" class="demo-tabs">
      <el-tab-pane label="历史事故示例信息一" name="first">
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 不良区分 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.badDist }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 不良项目 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.badProject }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 品名 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.proName }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 环别 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.ringCategory }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 工序 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.process }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 作业要领书NO </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.operationStandard }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 管理NO </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.manage }} </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="历史事故示例信息二" name="second">


        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 反馈日期 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.feedbackDate }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 反馈场所 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.feedbackAddress }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 不良内容 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.badContent }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 发生片数 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.sliceCount }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 不良状况 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.badStatus }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 要因解析 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.causeAnalysis }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 对策 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.countermeasure }} </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="历史事故图片" name="third">
        <el-image
            :src="'/static/'+dangerinfo?.photoPath"
            :preview-src-list="['/static/'+dangerinfo?.photoPath]"
            fit="fill"
        />
      </el-tab-pane>
    </el-tabs>

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
const showinfo=ref()

const dangerinfo=ref()

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
function datachange(item){

  if (item?.type==="2")
  axios.get(
      "/api/accidentInfo?id="+item.dangerousInformation
  ).then((re)=>{
    if (re.data.code===20000)
    dangerinfo.value=re.data.data
  })

  if (item?.type==="3"){
    axios.get("/api/changePoint?id="+item.changePointId ).then((re)=>{
      if (re.data.code===20000)
        dangerinfo.value=re.data.data
    })

  }

  if (item?.type==="4"){
    axios.get("/api/historyExample?id="+item.historicalPointId).then((re)=>{
      if (re.data.code===20000)
        dangerinfo.value=re.data.data
    })

  }





}
function onActivated(item, index) {
  gridData.value = item.points
  showUrl.value = item.show_image
  showinfo.value=item
  dialogTableVisible.value = true
}
</script>
<style>
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

.my-man-dialog{

}
.my-man-dialog iframe{
  display: block;
  border: 0;
  width: 700px;
  height: 720px;
  margin:  0 auto;
}
.my-man-dialog>.el-dialog__body{
  padding-top: 0;
  padding-bottom: 0;
}
.danger-info{
  margin-bottom: 10px;
}
</style>
