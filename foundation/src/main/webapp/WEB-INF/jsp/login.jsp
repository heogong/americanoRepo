<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/registration" method="get">
		<button class="btn btn-md btn-warning btn-block" type="Submit">Go To Registration Page</button>
	</form>	
	
	<div class="container">
		<form action="/login" method="POST" class="form-signin">
			<h3 class="form-signin-heading" th:text="Welcome"></h3>
			<br/>
			 
			<input type="text" id="userId" name="userId"  th:placeholder="ID" class="form-control" /> <br/> 
			<input type="password"  th:placeholder="Password" id="userPasswd" name="userPasswd" class="form-control" /> <br />
			 
			<div align="center" th:if="${param.error}">
				<p style="font-size: 20; color: #FF1C19;">ID or Password invalid, please verify</p>
			</div>
			<button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit" th:text="Login"></button>
		</form>
	</div>
</body>
</html>