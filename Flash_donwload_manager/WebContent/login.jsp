<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<body
	class="d-flex flex-column justify-content-center align-items-center"
	style="width: 100vw; height: 100vh;">
	<div class="p-4">
		<a href="index"><h4 class="text-info text-justify">
				<u>Flash Download Manager</u>
			</h4></a>
	</div>
	<div class="w-50 p-5 shadow-lg bg-light rounded">
		<form method="post" action="login">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" id="username" aria-describedby="emailHelp"
					placeholder="Enter username" required name="usr" pattern="[\D@#$%&?]\w*">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" id="exampleInputPassword1"
					placeholder="Password" required name="pwd">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<span class="pl-3">Don't have an account? <a
				href="register">Sign Up</a></span>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>