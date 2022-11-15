<template xmlns="">
  <div class="master">

  <div class="update" :style="backinfo">
    <VueDragResize class="drag" v-for="(item,index) in  info" :key="item.id" v-on:dragging="resize" @resizing="resize"
                   @clicked="onActivated(item,index)" :w="item.width/sf" :h="item.height/sf" :x="item.axis/sf"
                   :y="item.ayis/sf"
                   :parentLimitation="true" :minw="10" :minh="10" :isActive="item.isActive"
                   :style="{
                     'z-index':item.type==='7'?1:10
                   }">
      <el-tooltip  effect="light" :content="item.tipText" placement="right-end"  :disabled="!item.tipActive">
      <div class="upload_bt"
           :class="{
             upload_bt_light:item.lightStyle
           }" draggable="true" :style="{
        'background-image': `url(/static${item.icon_image})`,
        'border-radius': item.isRound?'50%':0,
        'border': item.outerBorder?`1px ${item.outerBorderColor} solid`:'0',
        }" v-if="item.type!=='8'" >

      </div>
        <div style="text-align: center;" :style="{
          'line-height':item.height/sf+'px',
          'font-size':item.fontSize+'pt',
          'color':item.fontColor,
'font-family':item.fontFamily
        }"
             v-if="item.type==='8'">
          {{item.text}}
        </div>
      </el-tooltip>
<!--      <el-avatar class="bt" :shape="item.isRound?'square':'circle'"  :src="'/static'+item.icon_image" />-->
    </VueDragResize>
  </div>
  <div class="info" v-if="formdata!=null" >
    <el-form ref="formRef" :model="formdata" label-position="right" label-width="120px" class="demo-dynamic">
      <el-row>

        <el-col :span="4">
          <el-button type="primary" @click="addPoint">添加一个</el-button>
        </el-col>
        <el-col :span="3">
          <el-upload class="upload" :action="'/api/point/deptimage/'+route.params.id"
                     :limit="1"
                     :show-file-list="false"
                     :on-success="deptimageuploadsuccess"
                     accept=".jpg,.png,.gif"
          >
            <el-button type="primary">科室底图</el-button>
          </el-upload>
        </el-col>
      </el-row>



      <h3>基础信息</h3>
      <el-row>
        <el-col :span="3">
          <el-button type="primary" @click="submitForm(formRef)" plain>保存</el-button>
        </el-col>
        <el-col :span="6">
          <el-button type="danger" @click="deletePoint(formdata)">删除当前</el-button>
        </el-col>
      </el-row>
      <el-row style="margin-top: 10px">
        <el-col :span="3" :push="1">
          <div class="block">
            <el-avatar :size="40" :src="'/static'+formdata.icon_image" fit="cover"/>
          </div>
        </el-col>
        <el-col :span="3">
          <el-upload ref="upload" class="upload" :limit="1" action="/api/upload"
                     :on-success="iconuploadsuccess"
                     :on-change="handleChange"
                     accept=".jpg,.png,.gif"
          >
            <el-button type="primary" size="small">更改图标</el-button>
          </el-upload>
        </el-col>
        <el-col :span="7" >

            <el-form-item  label="默认图标" label-width="80px">
            <el-cascader
                placeholder="选择类型"
                size="small"
                :options="options"
                @change="(val)=>{formdata.icon_image=val.pop()}"></el-cascader>
            </el-form-item>


        </el-col>
        <el-col :span="3" :offset="1">
          <el-switch v-model="formdata.isRound" inactive-text="圆形"/>
        </el-col>
        <el-col :span="3" >
          <el-switch v-model="formdata.outerBorder" inactive-text="外框线"/>
        </el-col>
        <el-col :span="2">
          <el-color-picker v-model="formdata.outerBorderColor"  show-alpha></el-color-picker>
        </el-col>
      </el-row>
      <el-row style="height: 40px">
        <el-col :span="4" :offset="4">
          <el-switch v-model="formdata.lightStyle"  inactive-text="移入发光"/>
        </el-col>
        <el-col :span="4" >
          <el-switch v-model="formdata.tipActive"  inactive-text="文字提示"/>
        </el-col>
        <el-col :span="10" v-if="formdata.tipActive">
          <el-form-item prop="tipText" label="提示文字" label-width="80px" >
            <el-input v-model="formdata.tipText"/>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="10" style="margin-top: 5px">
          <el-form-item hide-required-asterisk prop="height" label="高度" label-width="80px" required>
            <el-input-number  type="number" :step="2" v-model="xy.height" @blur="rexy(xy)" @change="rexy(xy)"/>
          </el-form-item>
        </el-col>
        <el-col :span="10" style="margin-top: 5px">
          <el-form-item hide-required-asterisk prop="width" label="宽度" label-width="80px" type="number " required>
            <el-input-number  type="number" :step="2" v-model="xy.width" @blur="rexy(xy)" @change="rexy(xy)"/>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="10" style="margin-top: 5px">
          <el-form-item hide-required-asterisk prop="axis" label="横坐标" label-width="80px" required>
            <el-input-number  type="number" :step="2" v-model="xy.axis" @blur="rexy(xy)" @change="rexy(xy)"/>
          </el-form-item>
        </el-col>
        <el-col :span="10" style="margin-top: 5px">
          <el-form-item hide-required-asterisk  prop="ayis" label="纵坐标" label-width="80px" required>
            <el-input-number  type="number" :step="2" v-model="xy.ayis" @blur="rexy(xy)" @change="rexy(xy)"/>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
<!--        <el-col :span="8">-->
<!--          <el-upload ref="up2" class="upload" action="/api/upload" :limit="1" :on-change="handleChange"-->
<!--                     :on-success="showuploadsuccess"-->
<!--                     accept=".jpg,.png,.gif">-->
<!--            <el-button type="primary">上传展示图片</el-button>-->
<!--          </el-upload>-->
<!--        </el-col>-->

        <el-col :span="24">
          <el-form-item hide-required-asterisk required prop="type" label="点位类型" label-width="80px">
            <el-select v-model="formdata.type" class="select" placeholder="选择类型" size="small" @change="componentTypeSelectHandle">
              <el-option label="人员" value="1"/>
              <el-option label="历史安全事故发生点" value="2"></el-option>
              <el-option label="变化点" value="3"></el-option>
              <el-option label="历史生产问题发生点" value="4"></el-option>
              <el-option label="加工设备" value="5"></el-option>
              <el-option label="危险源" value="6"></el-option>
              <el-option label="文字" value="8"></el-option>
              <el-option label="仅图标" value="7"></el-option>
            </el-select>
          </el-form-item>

        </el-col>

      </el-row>
      <el-row>
        <el-form-item v-if="formdata.type==='1'" hide-required-asterisk prop="employeeNo" label="员工编号" label-width="80px" required>
          <el-input v-model="formdata.employeeNo"/>
        </el-form-item>
        <el-form-item v-if="formdata.type==='1'" hide-required-asterisk prop="onPostPerson" label="顶岗人编号" label-width="110px" required>
          <el-input v-model="formdata.onPostPerson"/>
        </el-form-item>
      </el-row>
      <el-row>
        <el-form-item v-if="formdata.type==='2'" hide-required-asterisk prop="dangerousInformation" label="发生点ID" label-width="80px" required>
          <el-input v-model="formdata.dangerousInformation"/>
        </el-form-item>
      </el-row>
      <el-row>
        <el-form-item v-if="formdata.type==='3'" hide-required-asterisk prop="changePointId" label="变化点ID" label-width="80px" required>
          <el-input v-model="formdata.changePointId"/>
        </el-form-item>
      </el-row>
      <el-row>
        <el-form-item v-if="formdata.type==='4'" hide-required-asterisk prop="historicalPointId" label="发生点ID" label-width="80px" required>
          <el-input v-model="formdata.historicalPointId"/>
        </el-form-item>
      </el-row>
      <el-row>
        <el-form-item v-if="formdata.type==='5'" hide-required-asterisk prop="deviceInformationId" label="设备信息ID" label-width="80px" required>
          <el-input v-model="formdata.deviceInformationId"/>
        </el-form-item>
      </el-row>
      <el-row>
        <el-form-item v-if="formdata.type==='6'" hide-required-asterisk prop="hazardSourceId" label="危险源ID" label-width="80px" required>
          <el-input v-model="formdata.hazardSourceId"/>
        </el-form-item>
      </el-row>
      <el-row v-if="formdata.type==='8'">
        <el-form-item  hide-required-asterisk prop="text" label="文字" label-width="80px" required>
          <el-input v-model="formdata.text" style="width: 350px" />
        </el-form-item>
        <el-form-item  hide-required-asterisk prop="fontFamily" label="字体" label-width="80px" required>
          <el-select  v-model="formdata.fontFamily" class="select" placeholder="选择类型" size="small" >
            <el-option label="宋体" value="宋体"/>
            <el-option label="微软雅黑" value="微软雅黑"></el-option>
            <el-option label="楷体" value="楷体"></el-option>
            <el-option label="隶书" value="隶书"></el-option>
            <el-option label="华文琥珀" value="华文琥珀"></el-option>
            <el-option label="华文彩云" value="华文彩云"></el-option>
            <el-option label="卡通" value="星辰温柔浪漫体"></el-option>
            <el-option label="粗毛笔" value="平方飞扬体"></el-option>
            <el-option label="细毛笔" value="汉仪瑞鹤"></el-option>
            <el-option label="TimesNew Roman" value="TimesNew Roman"></el-option>
            <el-option label="Arial Black" value="Arial Black"></el-option>
            <el-option label="Calibri" value="Calibri"></el-option>
            <el-option label="Meiryo UI" value="Meiryo UI"></el-option>
            <el-option label="Algerian" value="Algerian"></el-option>
            <el-option label="Blackadder ITC" value="Blackadder ITC"></el-option>
            <el-option label="Edwardian Script ITC" value="Edwardian Script ITC"></el-option>
            <el-option label="Jokerman" value="Jokerman"></el-option>
            <el-option label="Wide Latin" value="Wide Latin"></el-option>
          </el-select>
        </el-form-item>
      </el-row>
      <el-row v-if="formdata.type==='8'">
        <el-form-item  hide-required-asterisk prop="fontSize" label="字体大小" label-width="80px" required>
          <el-slider v-model="formdata.fontSize" :step="2" :max="100" show-stops style="width: 350px" />
        </el-form-item>
        <el-form-item  hide-required-asterisk prop="fontColor" label="字体颜色" label-width="80px" required>
          <el-color-picker v-model="formdata.fontColor" show-alpha />
        </el-form-item>
      </el-row>

      <el-space v-if="formdata.type==='512'">
        <h3>
          自定义信息
        </h3>
        <el-row>
          <el-button @click="addDomain">添加信息</el-button>
        </el-row>
        <el-button size="small" @click="addTab(editableTabsValue)">
          添加一个标签页
        </el-button>
      </el-space>

      <el-scrollbar height="250px">

      </el-scrollbar>

    </el-form>
  </div>
  </div>
</template>
<script setup async>


import {ElMessage, ElLoading} from 'element-plus';
import {nextTick, reactive, ref} from 'vue'
import {Delete} from '@element-plus/icons-vue'
import axios from "axios";
import VueDragResize from "vue-drag-resize/src/components/vue-drag-resize.vue";
import {useRouter, useRoute} from 'vue-router'
import { computed} from 'vue'

console.log(import.meta.env.VITE_MainMain_ADRESS)
const formRef = ref(null)
const upload = ref(null)
const up2 = ref(null)
const sf = 1920 / 1280;
const route = useRoute()
const loadingInstance = ElLoading.service({fullscreen: true, text: "加载布局图中"})
const xy=reactive({
  ayis:0

})

const options=[
  {
    value:"警示",
    label:"警示",
    children:[
      {
        label:"警示红",
        value:"/example/警示红.png"
      },
      {
        label:"警示橙",
        value:"/example/警示橙.png"
      },
    ]
  },
  {
    value:"危险",
    label:"危险",
    children:[
      {
        label:"危险红",
        value:"/example/危险红.png"
      },
      {
        label:"危险橙",
        value:"/example/危险橙.png"
      },
      {
        label:"危险黄",
        value:"/example/危险黄.png"
      },
    ]
  },
  {
    value:"火灾",
    label:"火灾",
    children:[

      {
        label:"火灾橙",
        value:"/example/火灾橙.png"
      },
      {
        label:"火灾红",
        value:"/example/火灾红.png"
      },
    ]
  },
]
axios.get("/api/defimagelist").then((re)=>{
  if (re.data.code===20000){
    options.push(...re.data.data)
  }
})
const re = [

]
const info = reactive(re)
var formdata = ref(null)


function rexy(val){

  formdata.value.axis=val.axis
  formdata.value.ayis=val.ayis
  formdata.value.width=val.width
  formdata.value.height=val.height

  // Object.assign(formdata.value,val)
}
const backinfo=reactive({
  "background-image":"linear-gradient(red, yellow, blue)",
  "background-repeat": "no-repeat",

})

axios.get("/api/point/deptimage/"+route.params.id).then((resp)=>{
  if (resp.data.code===20000)
    backinfo["background-image"]=`url(/static${resp.data.data})`
}).catch(()=>{
  ElMessage.success("服务器忙!")
})

axios.get("/api/point/" + route.params.id).then(
    (resp) => {

      if (resp.data.data.length > 0) {

        info.pop()
        resp.data.data.forEach((a) => {
          a.icon_image = a.icon_image.replaceAll("\\", "/")
          a.show_image = a.show_image.replaceAll("\\", "/")
          info.push(a)
        })

        // formdata.value = info[0]
      }
      else {
        formdata.value = {}
      }

      loadingInstance.close()
    }
).catch(()=>{
  ElMessage.success("服务器忙!")
  loadingInstance.close()

})

function resize(rec) {
  formdata.value.axis = rec.left * 1.5;
  formdata.value.ayis = rec.top * 1.5;
  formdata.value.width = rec.width * 1.5;
  formdata.value.height = rec.height * 1.5;
  xy.axis = rec.left * 1.5;
  xy.ayis = rec.top * 1.5;
  xy.width = rec.width * 1.5;
  xy.height = rec.height * 1.5;

}
//选择点位类型时的类型回调
const componentTypeSelectHandle= (val)=>{
  if(val==='8' && formdata.value.text==="世界，never been so gentle"){

    xy.height=60

    formdata.value.height=60
    setTimeout(()=>{
      xy.width=900
      formdata.value.width=900
    },100)


  }
}
function onActivated(item, index) {

  info.forEach(a => {
    a.isActive = false
  })
  info[index].isActive = true
  formdata.value = info[index]
  upload.value?.clearFiles()
  up2.value?.clearFiles()
}
//科室图片上传成功
function deptimageuploadsuccess(resp){

  backinfo["background-image"]=`url(/static${resp.data})`
}
function deletePoint(fd) {
  let index = info.indexOf(fd)
  if (fd.isNew===true){
    info.splice(index, 1)
    ElMessage.success("删除成功!")
    formdata.value = {
      icon_image: "/example/1661928324865.png",
    }
  }

  axios.delete('/api/point/'+info[index].id).then((resp)=>{
    if (resp.data.code===20000){
      ElMessage.success("删除成功!")
      info.splice(index, 1)
      formdata.value = {
        icon_image: "/example/1661928324865.png",
      }
    }
    else {
      ElMessage.success("删除失败")
    }
  })

}

//添加一个信息
function addDomain() {
  if (formdata.value.points?.length > 15) {
    ElMessage.error("最多添加15条信息")
    return
  }
  formdata.value.points.push({
    key: "",
    value: ""
  })
}

//删除一条信息
function removeDomain(index) {
  if (formdata.value.points[index].id){
    axios.delete("/api/point/pointinfoid/"+formdata.value.points[index].id).then((resp)=>{
      if (resp.data.code!==20000){
        ElMessage.error("删除失败!")
      }
      else
        formdata.value.points.splice(index, 1)
    })
  }
  else {
    formdata.value.points.splice(index, 1)
  }
  ElMessage.success("删除成功")
}

//提交验证
const submitForm = (formEl) => {
  if (!formEl) return
  formEl.validate().then(() => {
        axios.post("/api/point/" + route.params.id, formdata.value).then((resp) => {
          if (resp.data.code===20000){
            formdata.value.points = resp.data.data
            ElMessage.success("保存成功！")
            formdata.value.isNew=false
          }
          else {
            ElMessage.error(resp.data.msg)
          }
        }).catch(()=>{
          ElMessage.error("保存失败！")
        })
      },
      () => {

      })
}

//添加一个元素
function addPoint() {
  axios.get("/api/uuid").then((resp) => {
    info.push({
      id: resp.data,
      isNew:true,
      axis: 900,
      ayis: 500,
      width:72,
      height: 72,
      employeeNo:"000000",
      isRound: true,
      show_image: "",
      onPostPerson:"",
      type:"1",
      historicalPointId:"",
      dangerousInformation:"",
      deviceInformationId:"",
      hazardSourceId:"",
      outerBorder:true,
      outerBorderColor:'#6cf',
      lightStyle:false,
      tipActive:false,
      tipText:"",
      fontSize:23,
      fontColor:"#66ccff",
      text:"世界，never been so gentle",
      fontFamily:"宋体",
      changePointId:"",
      icon_image: "/example/1661928324865.png",
      points: [],
    })
  })
}

//icon上传
function iconuploadsuccess(resp, file) {
  if (resp.code === 20000) {
    formdata.value.icon_image = resp.data
  } else {
    ElMessage.error("上传失败！请重试")
  }
}

//展示图片上传
function showuploadsuccess(resp, file) {
  if (resp.code === 20000) {
    formdata.value.show_image = resp.data
  } else {
    ElMessage.error("上传失败！请重试")
  }
}

function handleChange(file, fileList) {
  if (fileList.length > 1) {
    fileList.splice(0, 1);//这一步，是 展示最后一次选择文件
  }
}
</script>
<style scoped >

.upload_bt {
  /*border-radius: 50%;*/
  width: 100%;
  height: 100%;

  background-repeat: no-repeat;
  background-size: 100% 100%;

}
.upload_bt_light:hover{
  box-shadow:  0 0 60px #39c5bb inset;
  transition: box-shadow 0.3s ease;
}
.master{
  width: 1920px;
  height: 720px;
}
.update {
  background-size: 100% 100%;
  background-color: aqua;
  float: left;
  width: 1280px;
  height: 720px;
  margin: 0;
  padding: 0;

}

.info {

  border: 1px solid wheat;
  margin: 0;
  padding: 0;
  width: 100%;
  height: 720px;
  background-color: rgb(121, 229, 244);

}

</style>
