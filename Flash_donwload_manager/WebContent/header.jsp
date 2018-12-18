<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="models.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flash Download Manager</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<body>
	<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #e3f2fd;">
			<a class="navbar-brand active" href="index.jsp">Flash Download Manager</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto justify-content-end w-100">
			    <li class="nav-item support"><a class="nav-link" href="support">Support</a></li>
				<li class="nav-item Downloads"><a class="nav-link" href="downloads">Downloads</a></li>
				<li class="nav-item BugReport"><a class="nav-link" href="BugReport">Bug Report</a></li>
				<%
					if ( session.getAttribute("User") == null) {
				%>
				<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
				<%
					} else {
						User user = (User)session.getAttribute("User");
				%>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="index.jsp" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Hi <%= user.getUsername()%> </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="logout">Logout</a>
					</div>
				</li>
				<%
					}
				%>
			</ul>
		</div>
	</nav>