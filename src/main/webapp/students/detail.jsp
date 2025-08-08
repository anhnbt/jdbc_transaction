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
    <title>Detail Student</title>
</head>
<body>
<h1>Detail Student</h1>
<table>
    <tr>
        <th>ID</th>
        <td>${student.id}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${student.name}</td>
    </tr>
    <tr>
        <th>Email</th>
        <td>${student.email}</td>
    </tr>
</table>
<a href="?action=list" class="btn btn-secondary">Back to List</a>
</body>
</html>
