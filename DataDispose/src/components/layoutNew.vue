<template xmlns="">
  <div class="update" :style="backinfo">
    <VueDragResize class="drag" v-for="(item,index) in  info" :key="item.id"
                   @clicked="onActivated(item,index)"
                   :preventActiveBehavior="true"
                   :w="item.width" :h="item.height" :x="item.axis"
                   :y="item.ayis" :isActive="false" :isDraggable="false" :isResizable="false"
                   :minw="10" :minh="10" :style="{
                     'z-index':item.type==='7'?1:10,
                     'border':'none'
                   }">
      <el-tooltip  effect="light" :content="item.tipText" placement="right-end"  :disabled="!item.tipActive">
      <div class="bt" :class="{
             upload_bt_light:item.lightStyle
           }" :style="{
        'background-image': `url(/static${item.icon_image})`,
        'border-radius': item.isRound?'50%':0,
         'border': item.outerBorder?`1px ${item.outerBorderColor} solid`:'0',
        }"  v-if="item.type!=='8'" >
      </div>
        <div style="text-align: center;" :style="{
          'line-height':item.height+'px',
          'font-size':item.fontSize+'pt',
          'color':item.fontColor,
'font-family':item.fontFamily
        }"
             v-if="item.type==='8'">
          {{item.text}}
        </div>
      </el-tooltip>
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
      <el-tab-pane label="历史安全事故信息" name="first">
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
      <el-tab-pane label="变化点信息信息" name="first">
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
    <el-tabs  style="min-height: 500px"  v-if="showinfo?.type==='5'" model-value="first" class="demo-tabs">
      <el-tab-pane label="设备信息一" name="first">
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 设备编号 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.eqCode }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 设备名称 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.eqName }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 规格型号 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.model }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 现状 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.presentSituation }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 厂家 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.manufactor }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 日期 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.date }} </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="设备信息二" name="second">

        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 存放地点 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.address }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 盘点结果 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.invRes }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 是否处理 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.handle }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 处理结果 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.hanRes }} </el-card>
          </el-col>
        </el-row>



      </el-tab-pane>

    </el-tabs>
    <el-tabs  style="min-height: 500px"  v-if="showinfo?.type==='6'" model-value="first" class="demo-tabs">
      <el-tab-pane label="危险源信息一" name="first">
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 工序名称 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.process }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 序号 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.serialNo }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 危险源 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.hazard }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 风险 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.risk }} </el-card>
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
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 可能性 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.possibility }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后预计可能性 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.impPoss }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后可能性确认 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.cfmPoss }} </el-card>
          </el-col>
        </el-row>

      </el-tab-pane>
      <el-tab-pane label="危险源信息二" name="second">
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 频率 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.frequency }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后预计频率 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.impFre }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后频率确认 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.cfmFre }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 严重性 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.seriousness }} </el-card>
          </el-col>
        </el-row>

        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后预计严重性 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.impSerious }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后严重性确认 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.cfmSerious }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 评价分 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.score }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后预计评价分 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.impScore }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后评价分确认 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.cfmScore }} </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="危险源信息三" name="three">


        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 风险等级 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.riskLevel }} </el-card>
          </el-col>
        </el-row>

        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后预计风险等级 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.impRiskLevel }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 改善后风险等级确认 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.cfmRiskLevel }} </el-card>
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
            <el-card class=""  shadow="never"> 实施部门 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.impDept }} </el-card>
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
            <el-card class=""  shadow="never"> 确认人 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.confirm }} </el-card>
          </el-col>
        </el-row>
        <el-row class="danger-info">
          <el-col :span="5">
            <el-card class=""  shadow="never"> 备注 </el-card>
          </el-col>
          <el-col :span="18" :offset="1">
            <el-card :span="16" shadow="hover"> {{ dangerinfo?.bz }} </el-card>
          </el-col>
        </el-row>


      </el-tab-pane>

    </el-tabs>

  </el-dialog>
  <el-dialog :draggable="true" :top="'32px'" custom-class="my-dialog"  title="ATGL工厂危险源" v-model="atgdialogTableVisible" width="1300px" @open="datachange(showinfo)" @opened="opendDialogEvent(dangerinfo)">

    <el-tabs type="border-card" :stretch="true">
      <el-tab-pane label="危险因素分析" name="first">
        <template #label>
        <span class="custom-tabs-label">
          危险因素分析
        </span>
        </template>
        <el-header class="dialog-header">

          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">{{ dangerinfo?.hazardName }}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">{{ dangerinfo?.manResDept }}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main class="tab-main">
          <el-row class="tab-row" justify="center">
            <el-col :span="11">
              <div class="pdfview" id="pdf1" >加载中</div>
            </el-col>
            <el-col :span="1"></el-col>
            <el-col :span="11" >
              <el-image style="width: 100%; height: 600px" :src="`/static/${dangerinfo?.realPhoto}`" :fit="fit" />
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
        <el-header class="dialog-header">


          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">{{ dangerinfo?.hazardName }}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">{{ dangerinfo?.manResDept }}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main class="tab-main">
          <el-row class="tab-row" justify="center">
            <el-col :span="11">
              <div class="pdfview" id="pdf2" >加载中</div>
            </el-col>
            <el-col :span="1"></el-col>
            <el-col :span="11" >
              <div class="pdfview" id="pdf3" >加载中</div>
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
        <el-header class="dialog-header">
          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">{{ dangerinfo?.hazardName }}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">{{ dangerinfo?.manResDept }}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main class="tab-main">

        </el-main>
      </el-tab-pane>
      <el-tab-pane label="日常点检" name="fourth">
        <template #label>
        <span class="custom-tabs-label">
         日常点检
        </span>
        </template>
        <el-header class="dialog-header">


          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">{{ dangerinfo?.hazardName }}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">{{ dangerinfo?.manResDept }}</label>
              </el-space>
            </el-col>
          </el-row>

        </el-header>
        <el-main class="tab-main">
          <el-row class="tab-row" justify="center">
            <div class="pdfview" id="pdf4" >加载中</div>
          </el-row>
        </el-main>
      </el-tab-pane>
      <el-tab-pane label="视频监控" name="six">
        <template #label>
        <span class="custom-tabs-label">
         视频监控
        </span>
        </template>
        <el-header class="dialog-header">
          <el-row>
            <el-col :span="7">
              <el-space :size="30">
                <label class="content-title">危险源名称:</label>
                <label class="content-info">{{ dangerinfo?.hazardName }}</label>
              </el-space>

            </el-col>
            <el-col :span="12">
              <el-space :size="30">
                <label class="content-title">管理责任部门:</label>
                <label class="content-info">{{ dangerinfo?.manResDept }}</label>
              </el-space>
            </el-col>
          </el-row>
        </el-header>
        <el-main>

        </el-main>
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
import pdf from "pdfobject";

const route = useRoute()
const loadingInstance = ElLoading.service({fullscreen: true, text: "加载布局图中"})
const dialogTableVisible = ref(false)
const atgdialogTableVisible = ref(false)

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
var options = {
  pdfOpenParams: { scrollbar: '0', messages: '0', navpanes: '0',toolbar:'0' },
};
const opendDialogEvent=(item)=>{
  console.log(item)
  pdf.embed(`/static/${item.riskFactorPdf}`, "#pdf1",options);
  pdf.embed(`/static/${item.contPlanPdf}`, "#pdf2",options);
  pdf.embed(`/static/${item.drillReportPdf}`, "#pdf3",options);
  pdf.embed(`/static/${item.spotCheckPdf}`, "#pdf4",options);

}
//对话框打开事件
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

  if (item?.type==="5"){
    axios.get("/api/eqInfo?id="+item.deviceInformationId).then((re)=>{
      if (re.data.code===20000)
        dangerinfo.value=re.data.data
    })

  }
  if (item?.type==="6"){
    axios.get("/api/hazardSource?id="+item.hazardSourceId).then((re)=>{
      if (re.data.code===20000)
        dangerinfo.value=re.data.data
    })

  }
  if (item?.type==="6"){
    axios.get("/api/hazardSource?id="+item.hazardSourceId).then((re)=>{
      if (re.data.code===20000)
        dangerinfo.value=re.data.data
    })

  }
  if (item?.type==="9"){
    axios.get("/api/secEnv?id="+item.atgSecEnvId).then((re)=>{
      if (re.data.code===20000)
        dangerinfo.value=re.data.data
    })

  }
}
function onActivated(item, index) {
  if(['7','8'].includes(item.type))return
  gridData.value = item.points
  showUrl.value = item.show_image
  showinfo.value=item
  if (item.type==='9'){

    atgdialogTableVisible.value=true
  }else {
    dialogTableVisible.value = true
  }

}
</script>
<style>
.bt {
  /*border-radius: 50%;*/
  width: 100%;
  height: 100%;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  /*border: 1px #00ff00 solid;*/
}
.upload_bt_light:hover{
  box-shadow:  0 0 60px #39c5bb inset;
  transition: box-shadow 0.3s ease;
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
.danger-info .el-card__body{
  height: 18px
}
.content-title {
  font-size: 17pt;
}

.content-info {
  font-size: 17pt;
}

.custom-tabs-label {
  font-size: 14pt;
  font-family: 黑体, serif;
}
.tab-main{
  padding: 0;
  overflow-y: hidden;
}
.tab-row{
  padding: 0;
}
.my-dialog>.el-dialog__body{

  padding: 0;
}
.pdfview{
  height: 610px;
  width: 100%;
}
.dialog-header{

  height: 50px;
  vertical-align: top;
}
</style>
