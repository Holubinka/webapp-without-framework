<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: holyb
  Date: 04.04.2019
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
        <h1>Hello ${user.username}!</h1>
        <h3>You can visit this page <a href="<c:url value="/servlet/categories"/>">Categories</a></h3>
</body>
</html>
