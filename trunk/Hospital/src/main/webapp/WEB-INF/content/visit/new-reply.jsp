<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="/statics/css/bootstrap.min.css">
	<link rel="stylesheet" href="/statics/js/simditor/styles/font-awesome.css">
	<link rel="stylesheet" href="/statics/js/simditor/styles/simditor.css">
	<link rel="stylesheet" href="/statics/js/select2/select2.css">
	<link rel="stylesheet" href="/statics/js/webupload/webuploader.css">
	<link rel="stylesheet" href="/statics/js/datepicker/datepicker.css">
	<link rel="stylesheet" href="/statics/css/style.css">
</head>
<body>
	
	<jsp:include page="../include/side.jsp">
		<jsp:param value="visit" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
      <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-info"></i>
              <a href="patient-list.html"> 患者列表</a>  /  患者基本信息
            </span>
          </div>
          <div class="box-body">
            <table class="table">
                <tbody>
                  <tr>
                    <td width="100"><strong>姓名</strong></td>
                    <td width="300">${illintro.patient.name }</td>
                    <td width="100"><strong>性别</strong></td>
                    <td width="300">${illintro.patient.sex }</td>
                    <td width="100"><strong>年龄</strong></td>
                    <td width="">${illintro.patient.age }</td>
                  </tr>
                  <tr>
                    <td><strong>身份证号</strong></td>
                    <td>${illintro.patient.peopleid }</td>
                    <td><strong>联系电话</strong></td>
                    <td>${illintro.patient.tel }</td>
                    <td><strong>医保类型</strong></td>
                    <td>${illintro.patient.insurance.name }</td>
                  </tr>
                  <tr>
                    <td><strong>地址</strong></td>
                    <td colspan="5">${illintro.patient.address }</td>
                  </tr>
                  <tr>
                    <td colspan="6"><strong>过敏史</strong></td>
                  </tr>
                  <tr>
                    <td colspan="6">
                     ${illintro.patient.allergic }
                    </td>
                  </tr>
                   <tr>
                    <td colspan="6"><strong>备注</strong></td>
                  </tr>
                   <tr>
                    <td colspan="6">${illintro.patient.note }</td>
                  </tr>
                </tbody>

            </table>
          </div>
        </div>
        <!-- box end -->

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i> 复诊信息
            </span>
          </div>
          <div class="box-body form">
            <form action="/visit/saveReply.action?id=${illintro.id }" method="post">
              <input type="hidden" name="illintro.id" value="${illintro.id }" id="vid">
              <label>主要症状</label>
              <textarea  class="editor1 " name="visit.symptom"></textarea>
              <label>阳性体征</label>
              <textarea  class="editor3" name="visit.yxcharacter"></textarea>
              <label>检查结果</label>
              <textarea  class="editor4" name="visit.finalresult"></textarea>
              <label>治疗方案</label>
              <textarea  class="editor5" name="visit.curemethod"></textarea>
              <label>下次复诊时间</label>
              <input type="text" id="nextTime" name="illintro.rechecktime">
              <label>影像资料</label>
              <div id="picker">选择资料</div>
					<ul id="fileList" class="thumbnails">
              
              		</ul>
              <div class="form-actions">
                <button class="button button-flat-action button-pill">保存</button>
              </div>
            </form>
          </div>
        </div>


      </div>  
		</div>
	</div>

		

  <script src="/statics/js/jquery-1.9.1-min.js"></script>
  <script src="/statics/js/bootstrap.min.js"></script>
  <script src="/statics/js/simditor/scripts/js/simditor-all.min.js"></script>
  <script src="/statics/js/select2/select2.min.js"></script>
  <script src="/statics/js/autocomplete/jquery.autocomplete.min.js"></script>
  <script src="/statics/js/webupload/webuploader.min.js"></script>
  <script src="/statics/js/datepicker/bootstrap-datepicker.js"></script>
  <script src="/statics/js/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>

  <script>
    $(function(){

      var editor = new Simditor({
        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
        textarea: $('.editor1')
      });
      var editor3 = new Simditor({
        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
        textarea: $('.editor3')
      });
      var editor4 = new Simditor({
        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
        textarea: $('.editor4')
      });
      var editor5 = new Simditor({
        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
        textarea: $('.editor5')
      });

      //插件地址 http://www.devbridge.com/sourcery/components/jquery-autocomplete/
      $("#name").autocomplete({
        lookup:['java','javascript','alex','jsp']
      });

      
    //web uploader 
      var uploader = WebUploader.create({
          swf: '/statics/js/webupload/Uploader.swf',
          server: '/visit/upload.action',
          pick: '#picker',
          auto:true,
          // 只允许选择图片文件。
          accept: {
              title: 'Images',
              extensions: 'gif,jpg,jpeg,bmp,png',
              mimeTypes: 'image/*'
          }
      });
      
      uploader.on( 'fileQueued', function( file ) {
  	    var $li = $(
  	            '<div id="' + file.id + '" class="span2 upload-state-done uploadfile">' + "<li class='img'>正在上传...</li>" + 
  	                '<img>' +
  	                '<div class="info">' + file.name + '</div>' +
  	            '</div>'
  	            ),
  	        $img = $li.find('img');


  	    // $list为容器jQuery实例
  	   $("#fileList").append( $li );

  	    // 创建缩略图
  	    // 如果为非图片文件，可以不用调用此方法。
  	    // thumbnailWidth x thumbnailHeight 为 100 x 100
  	    uploader.makeThumb( file, function( error, src ) {
  	        if ( error ) {
  	            $img.replaceWith('<span>不能预览</span>');
  	            return ;
  	        }

  	        $img.attr( 'src', src );
  	    }, 192, 192 );
  	  });
    
      uploader.on( 'uploadSuccess', function( file ) {
  	    $(".img").text("上传完成√");
  	 
  	    $('<input type="hidden" name="imgs.picname" value="'+ file.name +'"/>').insertBefore($("#vid"));
  	  });
    
    
      
      $("#nextTime").datepicker({
        format: "yyyy-mm-dd",
        language: "zh-CN",
        autoclose: true
      });


    });
  </script>
	
</body>
</html>