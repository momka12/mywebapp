<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.itstep.myWebApp.model.Mail" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail List</title>
</head>
<body>
<table cellspacing="0" cellpadding="5" border="1">

    <form action="mail" method="post" >
        <label>UserId</label>
        <input type="number" name="userId">
        <input type="submit">
    </form>

    <thead>
    <tr>
        <td>Name</td>
        <td>Text</td>
        <td>To</td>
        <td>Created</td>
        <td></td>
    </tr>
    </thead>

    <c:forEach items="${mailList}" var="mail">
        <tr>
            <jsp:useBean id="mail" class="org.itstep.myWebApp.model.Mail"/>
            <td>${mail.name}</td>
            <td>${mail.text}</td>
            <td>${mail.to}</td>
            <td>${mail.created}</td>
            <td><a href="users?action=delete&id=${mail.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
