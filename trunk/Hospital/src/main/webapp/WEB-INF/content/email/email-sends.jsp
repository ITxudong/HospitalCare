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
	<style type="text/css">
		.recieve{
			padding-left:100px;
			padding-top:50px;
			display:block;
		}
		
	</style>
</head>
<body>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/home.action?id=${param.id }"> 主页</a>  /  发件箱
            </span>
          </div>
          <div class="box-body table">
            <table class="recieve">
				<thead>
					<tr>
						<th><h1><strong>发件箱</strong></h1></th>
					</tr>
				</thead>
				<tbody>
				    <c:forEach items="${emails }" var="e">
				    	<tr>
							<td><h2><strong><a href="/email/detail.action?id=${e.id }&type=send">${e.title }</a>
							</strong></h2></td>
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