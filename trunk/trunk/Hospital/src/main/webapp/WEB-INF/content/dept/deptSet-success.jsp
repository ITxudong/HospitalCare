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
	<link rel="stylesheet" href="/statics/css/style.css">
</head>
<body>
	
	<jsp:include page="../include/side.jsp">
		<jsp:param value="dept" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title"><i class="fa fa-sitemap"></i> 科室列表</span>
            <ul class="unstyled inline pull-right">
              <li><a href="/dept/newDept.action"><i class="fa fa-plus"></i> 新建</a></li>
            </ul>
          </div>
          <div class="box-body">
            <table class="table">
              <thead>
                <tr>
                  <th width="200">科室名称</th>
                  <th width="200">负责人</th>
                  <th>#</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${list }" var="d">
                <tr>
	               	 <th>${d.name }</th>
	                 <th>${d.principal }</th>
	                 <th>
	                   <a href="/dept/update.action?id=${d.id }">修改</a>
	                   <a href="/dept/delDept.action?id=${d.id }">删除</a>
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
</body>
</html>