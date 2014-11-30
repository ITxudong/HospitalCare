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
		.re{
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
              <a href="/home.action?id=${param.id }"> 主页</a>  /  公告详情
            </span>
          </div>
          <div class="box-body table">
            <table class="re">
				<thead>
					<tr>
						<th><h1><strong>${announce.title }</strong></h1></th>
					</tr>
				</thead>
				<tbody>
				    <tr>
				        <td><h3><strong>发布者 : ${announce.account.accountName }</strong></h3></td>
				    </tr>
				    <tr>
	                    <td><h2><strong>公告详情 : </strong></h2>
	                    <h3>${announce.content }</h3>
	                    </td>
	                </tr>
                	<tr>
	                  	<td>
	                  	<h4><strong>创建时间 ：&nbsp;${announce.createtime }</strong></h4>
	                  	</td>
                	</tr>
                	<tr>
                		<td>
		                  	<h4><strong>已浏览成员 ：
		                  	<c:forEach items="${announce.counts }" var="co">${co.account.accountName }&nbsp;&nbsp;</c:forEach>
		                  	</strong></h4>
	                  	</td>
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
	
</body>
</html>