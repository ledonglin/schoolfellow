<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script>
	function mycheck() {
		if (document.all("user.password").value != document.all("again").value) {
			alert("两次输入的密码不正确，请更正。");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	用户注册信息：
	<form action="<c:url value="/registerDetail" />" method="post">
		<input type="hidden" name="userId" value="${user.userId}" /> 
		<input type="hidden" name="userName" value="${user.userName}" />
		<table border="1px" width="60%">
			<tr>
				<td width="20%">邮箱</td>
				<td width="80%"><input type="text" name="email" /></td>
			</tr>

			<tr>
				<td width="20%">手机号码</td>
				<td width="80%"><input type="text" name="mobilePhone" maxlength='11'/></td>
			</tr>
			<tr>
				<td width="20%">座机号码</td>
				<td width="80%"><input type="text" name="phone" maxlength='12'></td>
			</tr>
			<tr>
				<td width="20%">职务</td>
				<td width="80%"><input type="text" name="title"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>
