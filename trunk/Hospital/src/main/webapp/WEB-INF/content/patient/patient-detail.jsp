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
            <span class="title">
              <i class="fa fa-info"></i>
              <a href="/patient/patientlist.action"> 患者列表</a>  /  患者基本信息
            </span>
            <ul class="unstyled inline pull-right">
              <li><a href="/patient/update.action?id=${param.id }"><i class="fa fa-edit"></i> 修改</a></li>
              <li><a href="/patient/del.action?id=${param.id }"><i class="fa fa-times"></i> 删除</a></li>
            </ul>
          </div>
          <div class="box-body">
            <table class="table">
                <tbody>
                  <tr>
                    <td width="100"><strong>姓名</strong></td>
                    <td width="300">${patient.name }</td>
                    <td width="100"><strong>性别</strong></td>
                    <td width="300">${patient.sex }</td>
                    <td width="100"><strong>年龄</strong></td>
                    <td width="">${patient.age }</td>
                  </tr>
                  <tr>
                    <td><strong>身份证号</strong></td>
                    <td>${patient.peopleid }</td>
                    <td><strong>联系电话</strong></td>
                    <td>${patient.tel }</td>
                    <td><strong>医保类型</strong></td>
                    <td>${patient.insurance.name }</td>
                  </tr>
                  <tr>
                    <td><strong>地址</strong></td>
                    <td colspan="5">${patient.address }</td>
                  </tr>
                  <tr>
                    <td colspan="6"><strong>过敏史</strong></td>
                  </tr>
                  <tr>
                    <td colspan="6">
                    ${patient.allergic }
                    </td>
                  </tr>
                   <tr>
                    <td colspan="6"><strong>备注</strong></td>
                  </tr>
                   <tr>
                    <td colspan="6">${patient.note }</td>
                  </tr>
                </tbody>

            </table>
          </div>
        </div>
        <!-- box end -->
        <div class="box">
          <div class="box-header">
            <span class="title"><i class="fa fa-stethoscope"></i> 就诊记录</span>
          </div>
          <div class="box-body">
            <table class="table">
              <thead>
                <tr>
                  <th width="100">日期</th>
                  <th width="150">科室</th>
                  <th width="200">病种</th>
                  <th>初步诊断</th>
                  <th width="50"></th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${illintros }" var="ill">
                <tr>
                  <td>${ill.createtime }</td>
                  <td>${ill.dept.name }</td>
                  <td>${ill.disease.name }</td>
                  <td>${ill.preresult }</td>
                  <td>
                    <a href="/visit/visitDetail.action?id=${ill.id }">详情</a>
                  </td>
                </tr>
                </c:forEach>
              </tbody>
            </table>

          </div>
        </div>
        <!-- box end -->
      </div>
			
		</div>
	</div>

		

	<script src="/statics/js/jquery-1.9.1-min.js"></script>
	<script src="/statics/js/bootstrap.min.js"></script>
	
	
</body>
</html>