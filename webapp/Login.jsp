<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
/* Optional: Style the error message to stand out */
.error-message {
    color: red;
    font-weight: bold;
    margin-top: 10px;
}
</style>
</head>
<body>
<h1>Login Page</h1>

<%
    // Using Scriptlet (less common now, but works well)
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
        <p class="error-message"><%= errorMessage %></p>
<%
    }
%>

<%-- 
    <p class="error-message">${errorMessage}</p>
--%>

<form action="LoginServlet" method="post">
Email: <input type="email" placeholder="enter your email" name="email">
Password: <input type="password" placeholder="enter your password" name="password">
<br>
<input type="submit" value="Login">
</form>
<p> New User ?</p>
<a href="Register.jsp">Register here</a>

</body>
</html>