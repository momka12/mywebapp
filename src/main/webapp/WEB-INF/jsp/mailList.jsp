<%@ page import="org.itstep.myWebApp.model.Mail" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mail list</title>
</head>
<body>
<table cellspacing="0" cellpadding="5" border="1">
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Text</td>
        <td>To</td>
        <td>Create</td>
        <td></td>
        <td></td>
    </tr>
    </thead>

    <%-- jstl realization - без костылей :)--%>
    <c:forEach items="${mailList}" var="mail">
        <tr>
            <jsp:useBean id="mail" class="org.itstep.myWebApp.model.Mail"/>
            <td>${mail.id}</td>
            <td>${mail.name}</td>
            <td>${mail.text}</td>
            <td>${mail.to}</td>
            <td>${mail.created}</td>
            <td><a href="users/update?id=${user.id}">UPDATE</a> </td>
            <td><a href="users/delete?id=${user.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
<a href="users/create">Create new one</a>
</body>
</html>
