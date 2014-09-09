<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.flyingbiz.user.entity.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

</head>
<body>
	<%-- 
	<form:form action="fileUpload" method="post" commandName="fileInfo">
		<table>

			<tr>
				<td>fileName:</td>
				<td><form:input path="fileName" /></td>
			</tr>
			<tr>
				<td>securityType:</td>
				<td><form:select path="securityType">
						<form:options items="${SecurityType.values()}"/>
					</form:select></td>
			</tr>
			<tr>
				<td>mediaType:</td>
				<td><form:select path="mediaType">
						<form:options items="${MediaType.values()}" />
					</form:select></td>
			</tr>
			<tr>
				<td>noticeType:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>fileType:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>issueDepartmentType:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>amountType:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>holdType:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>keyword:</td>
				<td><form:textarea path="keyword" cols="20" rows="10" /></td>
			</tr> 
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form:form>
	--%>

	<form:form action="fileUpload" method="post" commandName="fileInfo">
		<table>


			<tr>
				<td>securityType:</td>
				<td><form:select path="securityType">
						<form:options items="${SecurityType.values()}" />
					</form:select></td>
			</tr>
			<tr>
				<td>mediaType:</td>
				<td><form:select path="holdType">
						<c:forEach var="item" items="${HoldType.values()}">
							<form:option value="{item.getHoldType()}" >
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
