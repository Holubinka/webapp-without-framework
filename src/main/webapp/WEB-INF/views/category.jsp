<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: holyb
  Date: 07.04.2019
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
    <h3>Category name: <c:out value="${category.categoryName}"/></h3>
    <p>Description: <c:out value="${category.categoryDescription}"/></p>
    <c:forEach items="${category.products}" var="p">
        <p>Products: <a href="<c:url value="/servlet/product?p_id=${p.id}"/>"><c:out value="${p.productName}"/></a></p>
    </c:forEach>

</body>
</html>
