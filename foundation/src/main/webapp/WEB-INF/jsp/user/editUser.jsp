<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>사용자 리스트</title>
</head>

<script>
$(document).ready(function() {
});
</script>
<body>
<form action="/editUser"  method="post">
	<input type="text" name="userNm" value="${user.getUserNm()}">
	<input type="text" name="userId" value="${user.getUserId()}">
	<input type="text" name="userAge" value="${user.getUserAge()}">
	<input type="text" name="userTel" value="${user.getUserTel()}">
	<input type="hidden" name="seq" value="${user.getSeq()}">
	
	<c:forEach var="role" items="${role}">
		<div>
			<c:forEach var="userRole" items="${user.getRoles()}">
				<c:choose>
					<c:when test="${role.getRoleSeq() eq userRole.getRoleSeq()}">
						<input type="checkbox" name="roles" value="${role.getRoleSeq()}" checked="checked">${role.getRole()}
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="roles" value="${role.getRoleSeq()}">${role.getRole()}
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</c:forEach>
	
	<input type="submit">
</form>
</body>
</html>
