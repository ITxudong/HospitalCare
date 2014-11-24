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
            <span class="title"><i class="fa fa-search"></i> 搜索</span>
          </div>
          <div class="box-body search-box">
            <form action="/disease/diseaseSet.action" class="form-search">
              <input type="text" placeholder="疾病名称" name="q_S_LIKE_name" value="${param.q_S_LIKE_name }">
              <select id="ks" name="q_S_EQ_dept.id">
                <option></option>
                <c:forEach items="${list }" var="d">
                <option value="${d.id }" ${param['q_S_EQ_dept.id'] == d.id ? 'selected' : '' }>${d.name }</option>
                </c:forEach>
              </select>
              <button class="button button-pill button-flat-primary"><i class="fa fa-search"></i> 搜索</button>
            </form>

          </div>
        </div>


        <div class="box">
          <div class="box-header">
            <span class="title"><i class="fa fa-medkit"></i> 病种列表</span>
            <ul class="unstyled inline pull-right">
              <li><a href="/disease/newDisease.action"><i class="fa fa-plus"></i> 新建</a></li>
            </ul>
          </div>
          <div class="box-body">
            <table class="table">
              <thead>
                <tr>
                  <th width="200">疾病名称</th>
                  <th width="200">所属科室</th>
                  <th>#</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${diseases }" var="dis"> 
                	<tr>
	                <th>${dis.name }</th>
	                <th>${dis.dept.name }</th>
	                <th>
	                  <a href="/disease/update.action?id=${dis.id }">修改</a>
	                  <a href="/disease/del.action?id=${dis.id }">删除</a>
	                </th>
                </tr>
                </c:forEach>
              </tbody>
            </table>
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
        width:'200px'
      });
    });
  </script>
	
</body>
</html>