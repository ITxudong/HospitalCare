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
		<jsp:param value="account" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
		  <div class="span12">

        <div class="box">
          <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/account/accountSet.action"> 系统账户列表</a>  /  修改账号
            </span>
          </div>
          <div class="box-body form">
            <form action="/account/updateAccount.action">
              <input type="hidden" name="account.id" value="${account.id }">
              <label>员工姓名</label>
              <input type="text" id="name" name="account.realName" value="${account.realName }">
              <label>账号 <span class="muted">(用于登录系统)</span></label>
              <input type="text" id="account" name="account.accountName" value="${account.accountName }">
              <label>密码 </label>
              <input type="password" name="account.pwd" value="${account.pwd }">
              <label>联系电话</label>
              <input type="text" name="account.tel" value="${account.tel }">
              <label>请选择角色</label>
              <select id="" name="account.type">
                <option value="管理员" ${account.type == '管理员' ? 'selected':'' }>管理员</option>
                <option value="普通员工" ${account.type == '普通员工' ? 'selected':'' }>普通员工</option>
              </select>
              
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