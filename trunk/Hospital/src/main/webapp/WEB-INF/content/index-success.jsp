<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="/statics/css/bootstrap.min.css">
	<link rel="stylesheet" href="/statics/css/style.css">
</head>
<body>
	<div class="container">
		
		<div class="login_warper">
			<form action="/login.action" method="post">
				<legend>KaiShengIT</legend>
				<label>账号</label>
				<input type="text" name="account.accountName">
				<label>密码</label>
				<input type="password" name="account.pwd">
				<div class="form-actions">
					<button class="button button-flat-action">进入系统</button>
				</div>
			</form>
		</div>

	</div>
	

	<script src="/statics/js/jquery-1.9.1-min.js"></script>
	<script src="/statics/js/bootstrap.min.js"></script>


</body>
</html>