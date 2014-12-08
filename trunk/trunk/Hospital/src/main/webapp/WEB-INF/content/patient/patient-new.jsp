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
  	<link rel="stylesheet" href="/statics/js/simditor/styles/simditor.css">
  	<link rel="stylesheet" href="/statics/js/select2/select2.css">
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
              <a href="patient-list.html"> 患者列表</a>  /  新增患者
            </span>
          </div>
          <div class="box-body form">
            <form action="/patient/savePatient.action" method="post" id="patientForm">
              <label>姓名</label>
              <input type="text" name="patient.name">
              <label>身份证号</label>
              <input type="text" name="patient.peopleid" id="pid">
              <label>性别</label>
              <select name="patient.sex" id="sex" value="">
                <option id="men" value="男">男</option>
                <option value="女">女</option>
              </select>
              <label>年龄</label>
              <input type="text" name="patient.age" id="age">
              <label>电话</label>
              <input type="text" name="patient.tel">
              <label>医保类型</label>
              <select name="patient.insurance.id" id="yb">
                <option value=""></option>
              	<c:forEach items="${insurances }" var="in">
                	<option value="${in.id }">${in.name }</option>
              	</c:forEach>
              </select>
              <label>住址</label>
              <input type="text" name="patient.address">
              <label>过敏史</label>
              <textarea  class="editor1" style="height:50px" name="patient.allergic"></textarea>
              <label>备注</label>
              <textarea  class="editor2" name="patient.note"></textarea>
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
  <script src="/statics/js/simditor/scripts/js/simditor-all.min.js"></script>
  <script src="/statics/js/select2/select2.min.js"></script>
  <script src="/statics/js/jquery.validate.min.js"></script>
  
  <script>
    $(function(){

	      var editor = new Simditor({
	        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
	        textarea: $('.editor1')
	      });
	      var editor2 = new Simditor({
	        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
	        textarea: $('.editor2')
	      });
	      $("#yb").select2({
	        placeholder: "请选择医保类型",
	        width:'220px'
	      });

	      $("#pid").blur(function(){
	    	  var pid =  $("#pid").val();
	    	  //var sex = $("#sex").attr("value");
	    	  $.ajax({
	    		  url:"/autoJson.action",
	    		  data:{"pid":pid},
	    		  dataType:"json",
	    		  type:"get",
	    		  
	    		  success:function(json) {
	    			  //$("#sex").attr("value",json.sex);
	    			  //$("#men").replaceWith('<option value=""+json.sex+"">"+json.sex+"</option>');
	    			  $("#age").val(json.age);
	    		  }
	    	  });
	
	      });
	      
	      $("#patientForm").validate({
				errorElement:"span",
				errorClass:"text-error",
				rules:{
					"patient.name":{
						required:true
					},
					"patient.peopleid":{
						required:true,
						rangelength:[18,18]
					},
					"patient.tel":{
						required:true,
						rangelength:[11,11]
					},
					"patient.insurance.id":{
						required:true
					},
					"patient.address":{
						required:true
					}
				},
				messages:{
					"patient.name":{
						required:" 请输入患者姓名"
					},
					"patient.peopleid":{
						required:" 请输入身份证号",
						rangelength:"身份证为18位"
					},
					"patient.tel":{
						required:" 请输入联系电话",
						rangelength:"联系电话为11位"
					},
					"patient.insurance.id":{
						required:" 请选择医保类型"
					},
					"patient.address":{
						required:" 请输入患者住址"
					}
				}
			});
	      
	      
    });
  </script>
	
	
</body>
</html>