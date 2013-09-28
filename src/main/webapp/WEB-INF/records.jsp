<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: nerff
  Date: 28.09.13
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>GuestBook</title>
</head>
<body>
<div style="text-align: center;">
    <h1>My Guestbook</h1></div>
<HR>
<table border="1">
    <c:forEach var="record" items="${requestScope.records}">
        <tr>
            <td><c:out value="${record.getId()}"/></td>
            <td><i><c:out value="${record.getDate()}"/></i></td>
            <td><c:out value="${record.getMessage()}"/></td>
        </tr>
    </c:forEach>
</table>
<div style="text-align: center;">

</div>
</body>
</html>