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
  	<link rel="stylesheet" href="/statics/js/select2/select2.css">
  	<link rel="stylesheet" href="/statics/js/select2/select2-bootstrap.css">
	<link rel="stylesheet" href="/statics/css/style.css">
</head>
<body>
	
	<jsp:include page="../include/side.jsp">
		<jsp:param value="disease" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/disease/diseaseSet.action"> 病种列表</a>  /  修改疾病
            </span>
          </div>
          <div class="box-body form">
            <form action="/disease/updateDisease.action" method="post">
              <input type="hidden" name="disease.id" value="${disease.id }">
              <label>疾病名称</label>
              <input type="text" name="disease.name" value="${disease.name }">
              <label>所属科室</label>
              <select id="ks" name="disease.deptid">
                <option ></option>
                <c:forEach items="${list }" var="d">
                	<option value="${d.id }" ${disease.deptid == d.id ? 'selected' : ''}>${d.name }</option>
                </c:forEach>
              </select>
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
  <script src="/statics/js/select2/select2.min.js"></script>
  <script>
    $(function(){
      $("#ks").select2({
        placeholder: "请选择科室",
        width:'220px'
      });
    });
  </script>
	
</body>
</html>