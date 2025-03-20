<template>
  <div class="editor">
    <div id="editor" ></div>
  </div>
</template>

<script>
  import E from "wangeditor"

  export default {
    name: 'Wangeditor',
    data(){
      return{
        uploadImgUrl: process.env.VUE_APP_BASE_API + "/uploadImgFile",
        content:"",
        editor: null,
        info_:null
      }
    },
    model: {
      prop: 'desc',
      event:'change'
    },
    watch:{
      isClear(val){
        if (val){
          this.editor.txt.clear()
        }
      },
      desc(value) {
        if (value != this.editor.txt.html()) {
          this.editor.txt.html(this.desc)
        }
      }
    },
    props:{
      desc:{
        type:String,
        default:""
      },
      // 清除缓存
      isClear:{
        type:Boolean,
        default:false
      }
    },
    methods:{
      initE(){
        this.editor = new E('#editor')
        this.editor.config.onchangeTimeout = 1000 // 单位 ms
        this.editor.config.uploadFileName = 'file'
        this.editor.config.uploadImgServer = this.uploadImgUrl  // 你的服务器地址
        this.editor.config.uploadImgHooks = {
          fail: (xhr, editor, result) => {
            // 插入图片失败回调
          },
          success: (xhr, editor, result) => {
            // 图片上传成功回调
          },
          timeout: (xhr, editor) => {
            // 网络超时的回调
          },
          error: (xhr, editor) => {
            // 图片上传错误的回调
          },
          timeout: function (xhr, editor) {
            // 图片上传超时时触发
          },
          customInsert: function (insertImg, result, editor) {
            // 图片上传成功，插入图片的回调
            insertImg(process.env.VUE_APP_BASE_API + result.data)
          }
        }

        // 监听事项
        this.editor.config.onchange = (html) => {
          this.info_ = html // 绑定当前逐渐地值
          this.$emit('change', this.info_) // 将内容同步到父组件中
        }

        // 基础配置
        this. editor.config.menus = [
          'head',  // 标题
          'bold',  // 粗体
          'fontSize',  // 字号
          'fontName',  // 字体
          'italic',  // 斜体
          'underline',  // 下划线
          'strikeThrough',  // 删除线
          'foreColor',  // 文字颜色
          'backColor',  // 背景颜色
          'link',  // 插入链接
          'list',  // 列表
          'justify',  // 对齐方式
          'quote',  // 引用
          'image',  // 插入图片
          'code',  // 插入代码
          'undo',  // 撤销
          'redo'  // 重复
        ]

        // 创建编辑器
        this.editor.create()
        // this.editor.txt.html(this.desc)
      }
    },
    mounted () {
      this.initE();
    }
  }
</script>

<style scoped>

</style>
