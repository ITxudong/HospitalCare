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
		<jsp:param value="patient" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">搜索</span>
          </div>
          <div class="box-body search-box">
            <form action="" class="form-search">
              <input type="text" placeholder="姓名" name="q_S_LIKE_name" value="${param.q_S_LIKE_name }">
              <input type="text" placeholder="身份证号" name="q_S_LIKE_peopleid" value="${param.q_S_LIKE_peopleid }">
              <input type="text" placeholder="电话" name="q_S_LIKE_tel" value="${param.q_S_LIKE_tel }">
              <button class="button button-flat-primary button-pill"><i class="fa fa-search"></i> 搜索</button>
            </form>
          </div>
        </div>




        <div class="box">
          <div class="box-header">
            <span class="title"><i class="fa fa-building"></i> 患者列表</span>
            <ul class="unstyled inline pull-right">
              <li><a href="/patient/newPatient.action"><i class="fa fa-plus"></i> 新建</a></li>
            </ul>
          </div>
          <div class="box-body">
            <table class="table">
              <thead>
                <tr>
                  <th width="20">
                    <input type="checkbox" name="" id="">
                  </th>
                  <th width="100">姓名</th>
                  <th width="50">性别</th>
                  <th width="150">电话</th>
                  <th width="200">医保类型</th>
                  <th>地址</th>
                  <th width="50">状态</th>
                  <th width="100">创建日期</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${list }" var="li">
                <tr>
                  <td>
                    <input type="checkbox" name="" id="">
                  </td>
                  <td><a href="/patient/detail.action?id=${li.id }">${li.name }</a></td>
                  <td>${li.sex }</td>
                  <td>${li.tel }</td>
                  <td>${li.insurance.name }</td>
                  <td>${li.address }</td>
                  <td>${li.state }</td>
                  <td>${li.createtime }</td>
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