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
		<jsp:param value="account" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title"><i class="fa fa-user-md"></i> 系统账号列表</span>
            <ul class="unstyled inline pull-right">
              <li><a href="/account/newAccount.action"><i class="fa fa-plus"></i> 新建</a></li>
            </ul>
          </div>
          <div class="box-body">
            <table class="table">
              <thead>
                <tr>
                  <th width="200">账户名称</th>
                  <th width="200">员工姓名</th>
                  <th>电话</th>
                  <th>最后登录时间</th>
                  <th>最后登录IP</th>
                  <th>#</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${accounts }" var="a">
                  <tr>
	                 <td>${a.accountName }</td>
	                 <td>${a.realName }</td>
	                 <td>${a.tel }</td>
	                 <td>${a.lastTime }</td>
	                 <td>${a.lastIp }</td>
	                 <td>
	                   <a href="/account/update.action?id=${a.id }">修改</a>
					   <c:choose>
					   		<c:when test="${a.enable == true }">
					  			<a href="/account/enable.action?id=${a.id }">禁用</a>
					   		</c:when>
					   		<c:otherwise>
					  			<a href="/account/enable.action?id=${a.id }">启用</a>
					   		</c:otherwise>
					   </c:choose>
	                   <a href="/account/del.action?id=${a.id }">删除</a>
	                 </td>
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