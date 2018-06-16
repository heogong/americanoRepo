<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" th:href="@{/css/login.css}" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/" method="get">
		<button class="btn btn-md btn-warning btn-block" type="Submit">Go To Login Page</button>
	</form>
	
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form autocomplete="off" action="/registration" method="post" class="form-horizontal" role="form">
					<h2>Registration Form</h2>
					
					<div class="form-group">
						<div class="col-sm-9">
							<input type="text" name="userId" id="userId" placeholder="ID" class="form-control" /> 
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-9">
						<input type="text" name="userNm" id="userNm" placeholder="name" class="form-control" /> 
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<input type="password" name="userPasswd" id="userPasswd" placeholder="Password" class="form-control" /> 
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<button type="submit" class="btn btn-primary btn-block">Register User</button>
						</div>
					</div>
					
					<span th:utext="${successMessage}"></span>
					
				</form>
			</div>
		</div>
	</div>


</body>
</html>