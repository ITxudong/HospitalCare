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
	
	
	<jsp:include page="../include/side.jsp">
		<jsp:param value="patient" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="patient-list.html"> 患者列表</a>  /  修改患者信息
            </span>
          </div>
          <div class="box-body form">
            <form action="/patient/updatePatient.action" method="post">
              <input type="hidden" name="patient.id" value="${patient.id }">
              <label>姓名</label>
              <input type="text" name="patient.name" value="${patient.name }">
              <label>性别</label>
              <select name="patient.sex" id="" value="${patient.sex }">
                <option value="男">男</option>
                <option value="女">女</option>
              </select>
              <label>身份证号</label>
              <input type="text" name="patient.peopleid" value="${patient.peopleid }">
              <label>年龄</label>
              <input type="text" name="patient.age" value="${patient.age }">
              <label>电话</label>
              <input type="text" name="patient.tel" value="${patient.tel }">
              <label>医保类型</label>
              <select name="patient.insurance.id" id="yb">
                <option value=""></option>
              	<c:forEach items="${insurances }" var="in">
                	<option value="${in.id }" ${patient.insurance.id == in.id ? 'selected' : '' }>${in.name }</option>
              	</c:forEach>
              </select>
              <label>住址</label>
              <input type="text" name="patient.address" value="${patient.address }">
              <label>过敏史</label>
              <textarea  class="editor1" style="height:50px" name="patient.allergic"></textarea>
              <label>备注</label>
              <textarea  class="editor2" name="patient.note"></textarea>
              <div class="form-actions">
                <button class="button button-flat-action button-pill">修改</button>
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
        textarea: $('.editor1')
      });
      var editor2 = new Simditor({
        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
        textarea: $('.editor2')
      });
      $("#yb").select2({
        placeholder: "请选择医保类型",
        width:'220px'
      });

    });
  </script>
	
	
</body>
</html>