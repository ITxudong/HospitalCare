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
    <link rel="stylesheet" href="/statics/js/rangepicker/style.css">
	<link rel="stylesheet" href="/statics/css/style.css">
</head>
<body>
	
	<jsp:include page="../include/side.jsp">
		<jsp:param value="notify" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title"><i class="fa fa-search"></i> 搜索</span>
          </div>
          <div class="box-body search-box">
            <form action="" class="form-search">
              <input type="text" id="rangepicker" placeholder="就诊时间" name="q_S_BT_rechecktime">
              <button class="button button-flat-primary button-pill"><i class="fa fa-search"></i> 搜索</button>
            </form>
          </div>
        </div>




        <div class="box">
          <div class="box-header">
            <span class="title"><i class="fa fa-bell-o"></i> 提醒列表</span>
            
          </div>
          <div class="box-body">
            <table class="table">
              <thead>
                <tr>                 
                  <th width="100">复诊时间</th>
                  <th width="100">姓名</th>
                  <th width="100">联系电话</th>
                  <th width="50">性别</th>
                  <th width="150">科室</th>
                  <th width="200">病种</th>
                  <th>初步诊断</th>
                  <th width="50">状态</th>
                  <th width="100">创建日期</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${illintros }" var="i">
                <tr>
                  <td>${i.rechecktime }</td>
                  <td><a href="/patient/detail.action?id=${i.patient.id }">${i.patient.name }</a></td>
                  <td>${i.patient.tel }</td>
                  <td>${i.patient.sex }</td>
                  <td>${i.dept.name }</td>
                  <td>${i.disease.name }</td>
                  <td>${i.preresult }</td>
                  <td>${i.state }</td>
                  <td>${i.createtime }</td>
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
  <script src="/statics/js/moment.min.js"></script>
  <script src="/statics/js/rangepicker/rangepicker.js"></script>
  <script>
    $(function(){

        $("#rangepicker").daterangepicker(
          {
            ranges: {
             '3天内': [new Date(),moment().subtract('days', -3)],
             '7天内': [new Date(),moment().subtract('days', -6)]
            },
            opens: 'right',
            format:'YYYY/MM/DD'
          },
          function(start,end,label){
            console.log("start:" + start.format('YYYY-MM-DD'));
            console.log("end:" + end.format('YYYY-MM-DD'));
          }

        );




    });
  </script>
	
	
</body>
</html>