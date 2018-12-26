<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录 - 超市账单管理系统</title>
<!-- 
	标签定义文档与外部资源的关系。
	注意： link 元素是空元素，它仅包含属性。
	注意： 此元素只能存在于 head 部分，不过它可出现任何次数。 -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body class="blue-style">
	<div id="login">
		<div class="icon"></div>
		<div class="login-box">
			<form method="post" id="form1" action="index.do">
				<dl>
					<dt>用户名：</dt>

					<dd>
						<input type="text" name="username" id="username"
							class="input-text" /> <span id="sp1" style="color: red"></span>
					</dd>
					<dt>密 码：</dt>
					<dd>
						<input type="password" name="password" id="password"
							class="input-text" /> <span id="sp2"></span>
					</dd>
				</dl>
				<div class="buttons">
					<input type="submit" name="button" value="登   录"
						class="input-button" /> <input type="reset" name="reset"
						value="重   填" class="input-button" />
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js">
	
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
<script type="text/javascript">
	$("#form1").validate({
		rules : {
			username : {
				required : true
			},
			password : {
				remote : {
					url : "login.do", //后台处理程序
					data : { //要传递的数据
						username : function() {
							return $("#username").val();
						},
						password : function() {
							return $("#password").val();
						}
						
					}
					
				},required : true

			}

		},
		messages : {
			username : {
				required : "非空"
			},
			password : {
				required : "非空",remote:"用户名或者密码错误"
			}

		},
		submitHandler : function() {
			form1.submit();//手动提交
		}
	});
</script>
</html>