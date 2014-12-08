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
	
	<jsp:include page="../include/side.jsp">
		<jsp:param value="home" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/home.action?id=${param.id }"> 主页</a>  /  邮件
            </span>
          </div>
          <div class="box-body table">
            <table class="recieve">
				<c:if test="${param.type == 'recieve' }">
				<thead>
					<tr>
						<th><h1><strong>${email.title }</strong></h1></th>
					</tr>
				</thead>
					<tbody>
					    <tr>
					    	<td><h2><strong>发送者 : ${email.account.accountName }</strong></h2></td>
					    </tr>
					    <tr>
	                    <td><h2><strong>邮件内容</strong></h2></td>
	                  	</tr>
	                  	<tr>
	                    	<td>
	                    	<h3><strong>${email.content }</strong></h3>
	                    	</td>
	                  	</tr>
					</tbody>				
				</c:if>
				<c:if test="${param.type == 'send' }">
					<thead>
						<tr>
							<th><h1><strong>${email.title }</strong></h1></th>
						</tr>
					</thead>
					<tbody>
					    <tr>
					    	<td><h2><strong>接收者 : 
					    		<c:forEach items="${email.toAccounts }" var="ta">${ta.account.accountName } </c:forEach>
					    	</strong></h2></td>
					    </tr>
					    <tr>
	                    <td><h2><strong>邮件内容</strong></h2></td>
	                  	</tr>
	                  	<tr>
	                    	<td>
	                    	<h3><strong>${email.content }</strong></h3>
	                    	</td>
	                  	</tr>
					</tbody>
				</c:if>
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