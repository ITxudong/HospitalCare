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
              <a href="/account/accountSet.action"> 系统账户列表</a>  /  新增账号
            </span>
          </div>
          <div class="box-body form">
            <form action="/account/saveAccount.action" method="post" id="newAccount">
              <label>员工姓名</label>
              <input type="text" id="name" name="account.realName">
              <label>账号 <span class="muted">(用于登录系统)</span></label>
              <input type="text" id="account" name="account.accountName">
              <label>密码 <span class="muted">(默认123456)</span></label>
              <input type="password" value="123456" name="account.pwd">
              <label>联系电话</label>
              <input type="text" name="account.tel">
              <label>请选择角色</label>
              <select id="" name="account.type">
                <option value="管理员">管理员</option>
                <option value="普通员工">普通员工</option>
              </select>
              
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
			
			$("#name").blur(function(){
				
				var name = $("#name").val();
				
				$.ajax({
					url:"/pinyinJson.action",
					data:{"realName":name},
					dataType:"json",
					type:"get",
					success:function(json) {
						$("#account").val(json.pinyin);
					}
				});
				
			});
			
			$("#newAccount").validate({
				errorElement:"span",
				errorClass:"text-error",
				rules:{
					"account.realName":{
						required:true
					},
					"account.tel":{
						required:true
					}
				},
				messages:{
					"account.realName":{
						required:"请输入姓名"
					},
					"account.tel":{
						required:"请输入联系电话"
					}
				}
			});
			
		});
	
	</script>
	
</body>
</html>