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
    <link rel="stylesheet" href="/statics/js/datepicker/datepicker.css">
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
            <span class="title">
              <i class="fa fa-plus"></i> 病历信息
            </span>
          </div>
          <div class="box-body form">
            <form action="/visit/saveIllintro.action?id=${illintro.id }" method="post">
              <input type="hidden" name="illintro.id" value="${illintro.id }">
              <label>科室</label>
              <select name="illintro.dept.id" id="">
              	<option></option>
              	<c:forEach items="${depts }" var="de">
              		<option value="${de.id }" ${illintro.dept.id == de.id ? 'selected' :'' }>${de.name }</option>
              	</c:forEach>
              </select>
              <label>病种</label>
              <select name="illintro.disease.id" id="">
              	<option></option>
              	<c:forEach items="${diseases }" var="d">
              		<option value="${d.id }" ${illintro.disease.id == d.id ?'selected':'' }>${d.name }</option>
              	</c:forEach>
              </select>
              <label>管床医生</label>
              <input type="text" name="illintro.doctor" value="${illintro.doctor }">
              <label>初步诊断</label>
              <input type="text" class="span12" name="illintro.preresult" value="${illintro.preresult }">
              <label>相关病史</label>
              <textarea  class="editor" name="illintro.allergic">${illintro.allergic }</textarea>
              <label>下次复诊时间</label>
              <input type="text" id="nextTime" name="illintro.rechecktime" value="${illintro.rechecktime }">
             
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
  <script src="/statics/js/datepicker/bootstrap-datepicker.js"></script>
  <script src="/statics/js/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>

  <script>
    $(function(){

      var editor = new Simditor({
        toolbar:['title','bold','italic','underline','strikethrough','ol','ul','blockquote','table','link','hr','indent','outdent'],
        textarea: $('.editor')
      });
     
      $("#nextTime").datepicker({
        format: "yyyy-mm-dd",
        language: "zh-CN",
        autoclose: true
      });

    });
  </script>
	
</body>
</html>