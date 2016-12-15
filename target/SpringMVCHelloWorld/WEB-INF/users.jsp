<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 14/12/16
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Users</title>
</head>
<body>
<h2>List of Bootcamp Users:</h2>
<c:if test="${not empty userList}">
    <ul>
        <c:forEach var="user" items="${userList}">
            <li>${user.username} <strong>${user.email}</strong></li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
