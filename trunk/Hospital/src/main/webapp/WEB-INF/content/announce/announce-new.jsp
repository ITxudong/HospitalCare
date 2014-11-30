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
	<link rel="stylesheet" href="/statics/css/style.css">
</head>
<body>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/home.action?id=${param.id }"> 主页</a>  /  发布公告
            </span>
          </div>
          <div class="box-body form">
            <form action="/announce/pubAnnounce.action?id=${param.id }" method="post">
              <label>公告标题</label>
              <input type="text" name="announce.title" id="">
              <label>公告内容</label>
              <textarea  class="editor" style="height:50px" name="announce.content"></textarea>
              <div class="form-actions">
                <button class="button button-flat-action button-pill">发布</button>
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
  <script>
    $(function(){

	      var editor = new Simditor({
	        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
	        textarea: $('.editor')
	      });
	      
    });
  </script>
	
	
</body>
</html>