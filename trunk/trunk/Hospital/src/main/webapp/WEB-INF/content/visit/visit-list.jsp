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
	<link rel="stylesheet" href="/statics/js/select2/select2.css">
	<link rel="stylesheet" href="/statics/js/select2/select2-bootstrap.css">
	<link rel="stylesheet" href="/statics/css/style.css">
</head>
<body>
	
	
	<jsp:include page="../include/side.jsp">
		<jsp:param value="visit" name="menu"/>
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
              <input type="text" placeholder="姓名">
              <input type="text" placeholder="电话">
              <input type="text" id="rangepicker" placeholder="就诊时间">
              <select name="" id="state">
                <option value=""></option>
                <option value="">就诊</option>
                <option value="">已出院</option>
              </select>
              <button class="button button-flat-primary button-pill"><i class="fa fa-search"></i> 搜索</button>
            </form>
          </div>
        </div>




        <div class="box">
          <div class="box-header">
            <span class="title"><i class="fa fa-stethoscope"></i> 就诊列表</span>
            <ul class="unstyled inline pull-right">
              <li><a href="/visit/newVisit.action"><i class="fa fa-plus"></i> 新建</a></li>
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
                  <th width="150">科室</th>
                  <th width="200">病种</th>
                  <th>初步诊断</th>
                  <th width="50">状态</th>
                  <th width="100">创建日期</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${visits }" var="v">
	             <tr>
                  <td>
                    <input type="checkbox" name="" id="">
                  </td>
                  <td><a href="/visit/visitDetail.action?pid=${v.patient.id }&vid=${v.id}">${v.patient.name }</a></td>
                  <td>${v.patient.sex }</td>
                  <td>${v.dept.name }</td>
                  <td>${v.disease.name }</td>
                  <td>${v.preresult }</td>
                  <td>${v.state }</td>
                  <td id="nicetime">${v.createtime }</td>
                </tr>
                </c:forEach>
                <tr>
                  <td>
                    <input type="checkbox" name="" id="">
                  </td>
                  <td><a href="/visit/visitDetail.action">张晓明</a></td>
                  <td>男</td>
                  <td>内科</td>
                  <td>流感</td>
                  <td>流行性感冒</td>
                  <td>在诊</td>
                  <td>2014-07-09</td>
                </tr>
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
  <script src="/statics/js/select2/select2.min.js"></script>
  <script>
    $(function(){
		
        $("#rangepicker").daterangepicker(
          {
            ranges: {
             '今天': [new Date(), new Date()],
             '昨天': [moment().subtract('days', 1), moment().subtract('days', 1)],
             '最近7天': [moment().subtract('days', 6), new Date()],
             '最近30天': [moment().subtract('days', 29), new Date()],
             '本月': [moment().startOf('month'), moment().endOf('month')],
             '上一月': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
            },
            opens: 'left',
            format:'YYYY/MM/DD'
          },
          function(start,end,label){
            console.log("start:" + start.format('YYYY-MM-DD'));
            console.log("end:" + end.format('YYYY-MM-DD'));
          }

        );

        $("#state").select2({
          placeholder: "患者状态",
          width:'220px'
        });
		
        
        //更改日期形式 YYYY-MM-DD
		function nicedate() {
			var date = $("#nicetime").text();
			var nicedate = moment(date).format("YYYY-MM-DD");
			$("#nicetime").text(nicedate)
        }
        
        nicedate()();
        
    });
  </script>
	
</body>
</html>