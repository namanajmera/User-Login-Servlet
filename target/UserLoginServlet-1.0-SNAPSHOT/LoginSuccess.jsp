<%--
  Created by IntelliJ IDEA.
  User: naman
  Date: 15-06-2021
  Time: 01:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>

<h3> Hi <%= request.getAttribute("user")%>, Login Successful.</h3>
<a href="login.html">Login Page</a>

</body>
</html>
