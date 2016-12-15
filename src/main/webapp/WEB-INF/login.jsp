<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <p>Name: <form:input path="username"/></p>
    <%--<form:errors path="username"/>--%>
    <p>Password: <form:password path="password"/></p>
    <%--<form:errors path="password"/>--%>
    <input type="submit" value="Login"/>
</form:form>
<div style="color:red">${error}</div>
</body>
</html>