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
	<style type="text/css">
		#theme{
			width:393px;
		}
		ul.select2-choices{
			width:400px;
			border-radius: 4px;
		}
	</style>
</head>
<body>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/home.action?id=${param.id }"> 主页</a>  /  写邮件
            </span>
          </div>
          <div class="box-body form">
            <form action="/email/saveEmail.action" method="post">
              <input type="hidden" name="email.account.id" value="${param.id }">
              <label>收件人</label>
              <select name="persons" multiple id="yb">
                <option value=""></option>
              	<c:forEach items="${accounts }" var="acc">
              		<c:if test="${sessionScope.currAccount.id != acc.id }">
                		<option value="${acc.id }">${acc.accountName }</option>
              		</c:if>
              	</c:forEach>
              </select>
              <label>主题</label>
              <input type="text" name="email.title" id="theme">
              <label>邮件内容</label>
              <textarea  class="editor" style="height:50px" name="email.content"></textarea>
              <div class="form-actions">
                <button class="button button-flat-action button-pill">发送</button>
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
	      
	      $("#yb").select2({
	        placeholder: "请选择收件人",
	        width:'220px'
	      });

	      
    });
  </script>
	
	
</body>
</html>