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
		<jsp:param value="dept" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/dept/deptSet.action"> 科室列表</a>  /  新增科室
            </span>
          </div>
          <div class="box-body form">
            <form action="/dept/saveDept.action" method="post" id="deptForm">
              <label>科室名称</label>
              <input type="text" name="dept.name">
              <label>负责人</label>
              <input type="text" name="dept.principal">
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
	<script src="/statics/js/jquery.validate.min.js"></script>
	
	<script>
	
	$(function(){
		
		$("#deptForm").validate({
			errorElement:"span",
			errorClass:"text-error",
			rules:{
				"dept.name":{
					required:true
				},
				"dept.principal":{
					required:true
				}
			},
			messages:{
				"dept.name":{
					required:"请输入科室名称"
				},
				"dept.principal":{
					required:"请输入科室负责人"
				}
			}
		});
		
	});

	
	</script>
	
</body>
</html>