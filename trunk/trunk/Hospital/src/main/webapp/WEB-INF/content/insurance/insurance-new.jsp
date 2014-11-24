<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
              <i class="fa fa-plus"></i>
              <a href="/insurance/insuranceSet.action"> 医保类型列表</a>  /  新增医保类型
            </span>
          </div>
          <div class="box-body form">
            <form action="/insurance/saveInsurance.action" method="post">
              <label>医保类型名称</label>
              <input type="text" name="insurance.name">
              <div class="form-actions">
                <button class="button button-flat-action button-pill">保存</button>
              </div>
            </form>
          </div>
        </div>


      </div>
			
		</div>
	</div>


	<script src="/statics/js/jquery-1.9.1-min.js"></script>
	<script src="/statics/js/bootstrap.min.js"></script>
	
</body>
</html>