<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
              <i class="fa fa-plus"></i> 就诊记录信息
            </span>
          </div>
          <div class="box-body form">
            <form action="/visit/saveUpdate.action?id=${illintroid }" method="post">
              <input type="hidden" name="visit.id" value="${visit.id }" id="vid">
              <label>主要症状</label>
              <textarea  class="editor1 " name="visit.symptom">${visit.symptom }</textarea>
              <label>阳性体征</label>
              <textarea  class="editor3" name="visit.yxcharacter">${visit.yxcharacter }</textarea>
              <label>检查结果</label>
              <textarea  class="editor4" name="visit.finalresult">${visit.finalresult }</textarea>
              <label>治疗方案</label>
              <textarea  class="editor5" name="visit.curemethod">${visit.curemethod }</textarea>
              <label>影像资料</label>
              <div id="picker">选择资料</div>
					<ul id="fileList" class="thumbnails">
              			<c:forEach items="${visit.imgs }" var="i">
		                    <a href="/visit/download.action?fileFileName=${i.picname }"><img src="/visit/load.action?fileFileName=${i.picname }" alt="" width="190px"></a>
		                	<a class="btn btn-success" href="/visit/delImg.action?id=${visit.id }&illintroid=${illintro.id}&imgid=${i.id}">删除</a>
	                	</c:forEach>
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
  <script src="/statics/js/webupload/webuploader.min.js"></script>

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

      var uploader = WebUploader.create({
          swf: 'http://cdn.staticfile.org/webuploader/0.1.1/Uploader.swf',
          server: 'http://webuploader.duapp.com/server/fileupload.php',
          pick: '#picker',
          // 只允许选择图片文件。
          accept: {
              title: 'Images',
              extensions: 'gif,jpg,jpeg,bmp,png',
              mimeTypes: 'image/*'
          }
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
    
    
      
      
      
    });
  </script>
	
</body>
</html>