<%--
  Created by IntelliJ IDEA.
  User: wanbi
  Date: 08/08/2025
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h1>List Student</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${students}">
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.email}</td>
        <td>
            <a href="?action=detail&id=${student.id}">Detail</a>
            <a href="?action=update&id=${student.id}">Update</a>
            <a href="?action=delete&id=${student.id}">Delete</a>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
