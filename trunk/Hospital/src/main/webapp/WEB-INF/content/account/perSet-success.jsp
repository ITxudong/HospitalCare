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
		<jsp:param value="perSet" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i> 个人设置
            </span>
          </div>
          <div class="box-body form">
            <form action="/account/savePerset.action?id=${account.id }" method="post">
              <input type="hidden" name="account.id" value="${account.id }"/>
              <input type="hidden" name="account.realName" value="${account.realName }"/>
              <input type="hidden" name="account.type" value="${account.type }"/>
              <label>姓名</label>
              <input type="text" id="name" value="${account.realName }" name="account.realName" disabled/>
              <label>账号 <span class="muted">(用于登录系统)</span></label>
              <input type="text" id="account" value="${account.accountName }" name="account.accountName"/>
              <label>密码 <span class="muted"></span></label>
              <input type="password" value="${account.pwd }" name="account.pwd"/>
              <label>联系电话</label>
              <input type="text" name="account.tel" value="${account.tel }"/>
              
              <div class="form-actions">
                <button class="button button-flat-action button-pill">修改</button>
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