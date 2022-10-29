<template xmlns="">
  <div class="update" :style="backinfo">
    <VueDragResize class="drag" v-for="(item,index) in  info" :key="item.id" v-on:dragging="resize" @resizing="resize"
                   @clicked="onActivated(item,index)" :w="item.width / sf" :h="item.height/sf" :x="item.axis/sf"
                   :y="item.ayis/sf"
                   :parentLimitation="true" :minw="10" :minh="10" :isActive="item.isActive">
      <div class="bt" draggable="true" :style="{
        'background-image': `url(/static${item.icon_image})`,
        'border-radius': item.isRound?'50%':0,
        }">

      </div>
<!--      <el-avatar class="bt" :shape="item.isRound?'square':'circle'"  :src="'/static'+item.icon_image" />-->
    </VueDragResize>
  </div>
  <div class="info" v-if="formdata!=null">
    <el-form ref="formRef" :model="formdata" label-position="right" label-width="120px" class="demo-dynamic">

      <el-button type="primary" @click="submitForm(formRef)" plain>保存</el-button>
      <el-button type="primary" @click="addPoint">添加一个</el-button>
      <h3>基础信息</h3>
      <el-row>
        <el-col :span="6">
          <el-upload class="upload" :action="'/api/point/deptimage/'+route.params.id"
                     :limit="1"
                     :show-file-list="false"
                     :on-success="deptimageuploadsuccess"
                     accept=".jpg,.png,.gif"
          >
            <el-button type="primary">科室底图</el-button>
          </el-upload>
        </el-col>
        <el-col :span="6">
          <el-button type="danger" @click="deletePoint(formdata)">删除当前</el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="4" :push="1">
          <div class="block">
            <el-avatar :size="40" :src="'/static'+formdata.icon_image" fit="cover"/>
          </div>
        </el-col>
        <el-col :span="8">
          <el-upload ref="upload" class="upload" :limit="1" action="/api/upload"
                     :on-success="iconuploadsuccess"
                     :on-change="handleChange"
                     accept=".jpg,.png,.gif"
          >
            <el-button type="primary">更改图标</el-button>
          </el-upload>
        </el-col>
        <el-col :span="12">
          <el-switch v-model="formdata.isRound" inactive-text="圆形"/>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="10">
          <el-form-item hide-required-asterisk prop="height" label="高度" label-width="80px" required>
            <el-input v-model="formdata.height"/>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item hide-required-asterisk prop="width" label="宽度" label-width="80px" required>
            <el-input v-model="formdata.width"/>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="10">
          <el-form-item hide-required-asterisk prop="axis" label="纵坐标" label-width="80px" required>
            <el-input v-model="formdata.axis"/>
          </el-form-item>
        </el-col>
        <el-col :span="10">
          <el-form-item hide-required-asterisk prop="ayis" label="横坐标" label-width="80px" required>
            <el-input v-model="formdata.ayis"/>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-upload ref="up2" class="upload" action="/api/upload" :limit="1" :on-change="handleChange"
                     :on-success="showuploadsuccess"
                     accept=".jpg,.png,.gif">
            <el-button type="primary">上传展示图片</el-button>
          </el-upload>
        </el-col>
        <el-col :span="8">
          <el-form-item hide-required-asterisk required prop="type" label-width="15px">
            <el-select v-model="formdata.type" class="select" placeholder="选择类型" size="small" style="width:100%">
              <el-option label="人员" value="1"/>
              <el-option label="其他" value="2"></el-option>
            </el-select>
          </el-form-item>

        </el-col>

      </el-row>
      <el-space>
        <h3>
          自定义信息
        </h3>
        <el-row>
          <el-button @click="addDomain">添加信息</el-button>
        </el-row>
      </el-space>
      <el-scrollbar height="250px">
        <el-row v-for="(it,index) in formdata.points" :key="index">
          <el-col :span="10">
            <el-form-item hide-required-asterisk :prop="'points.'+index+'.key'" label="键" label-width="40px" :rules="{
                          required: true,
                          message: '不能为空',
                          trigger: 'blur',
                        }">
              <el-input autosize v-model="it.key"/>
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-form-item hide-required-asterisk :prop="'points.'+index+'.value'" label="值" label-width="40px" :rules="{
                          required: true,
                          message: '不能为空',
                          trigger: 'blur',
                        }">
              <el-input autosize v-model="it.value"/>
            </el-form-item>
          </el-col>
          <el-col :span="2" :push="1">
            <el-button type="danger" :icon="Delete" circle @click.prevent="removeDomain(index)"></el-button>
          </el-col>
        </el-row>
      </el-scrollbar>

    </el-form>
  </div>

</template>
<script setup async>
import {ElMessage, ElLoading} from 'element-plus';
import {nextTick, reactive, ref} from 'vue'
import {Delete} from '@element-plus/icons-vue'
import axios from "axios";
import VueDragResize from "vue-drag-resize/src/components/vue-drag-resize.vue";
import {useRouter, useRoute} from 'vue-router'

const formRef = ref(null)
const upload = ref(null)
const up2 = ref(null)
const sf = 1920 / 1280;
const route = useRoute()
const loadingInstance = ElLoading.service({fullscreen: true, text: "加载布局图中"})


const re = [

]
const info = reactive(re)
var formdata = ref(null)

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
      console.log(resp.data.data)
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
  if (formdata.value.points.length > 15) {
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
      width: 100,
      height: 100,
      isRound: true,
      show_image: "",
      icon_image: "/example/1661928324865.png",
      points: []
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
