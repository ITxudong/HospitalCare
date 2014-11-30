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
	<style type="text/css">
		.email{
			margin:20px ;
			position:absolute;
		}
		.left{
			float:left;
			border-right:1px dashed grey;
			padding-left:200px;
			padding-top:50px;
			display:block;
			hight:500px;
			width:400px;
		}
		.right{
		    float:left;
			display:block;
			hight:200px;
			width:200px;
			padding-left:200px;
			padding-top:50px;
		}
	</style>
</head>
<body>
	
	<jsp:include page="include/side.jsp">
		<jsp:param value="home" name="menu"/>
	</jsp:include>
	
	<div class="email">	
		<div class="left">
			<table>
				<thead>
					<tr>
						<th><h1><strong>公告</strong></h1></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${announces }" var="an">
						<tr>
							<td><h2><strong>
							<a href="/announce/detail.action?id=${an.id }">${an.title }</a>	
							</strong></h2></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${isa == 'true' }">
			<div class="btn btn-success"><a href="/announce/newAnnounce.action?id=${sessionScope.currAccount.id }">发布新公告</a></div>	
			</c:if>
		</div>
		<div class="right">
			<table>
				<thead>
					<tr>
						<th><h1><strong>内部邮件</strong></h1></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><h2><strong>
						<a href="/email/newEmail.action?id=${param.id }">写邮件</a>
						</strong></h2></td>
					</tr>
					<tr>
						<td><h2><strong>
						<a href="/email/recieveEmail.action?id=${param.id }">收件箱</a>
						</strong></h2></td>
					</tr>
					<tr>
						<td><h2><strong>
						<a href="/email/sendEmail.action?id=${param.id }">发件箱</a>
						</strong></h2></td>
					</tr>
				</tbody>
			</table>	
		</div>
	</div>
	<script src="/statics/js/jquery-1.9.1-min.js"></script>
	<script src="/statics/js/bootstrap.min.js"></script>

</body>
</html>