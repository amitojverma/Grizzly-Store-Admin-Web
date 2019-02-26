<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="styles\main.css">
    <script src="scripts\main.js"></script>
</head>
<body>
<form action="LoginServlet" method = "post">
	<div class="loginwindow">
        <center><img src="images/logingrizzly.jpg" height=280px width=550px></center><br>
        <center><input class="logininput" type="text"  name="userId"><br></center>
        <center><input class="logininput" type="password"  name="password"><br></center>
        <center><button class="loginbtn">Login</button></center>
    </div></form>
</body>
</html>