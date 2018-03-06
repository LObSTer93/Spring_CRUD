<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <title>Show all info</title>
</head>
<body>
    <a href="<c:url value="/add" />">Add info</a>

    <c:if test="${!empty infoList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${infoList}" var="info">
                <tr>
                    <td>${info.id}</td>
                    <td>${info.name}</td>
                    <td>${info.EMail}</td>
                    <td><a href="<c:url value='/edit/${info.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='/delete/${info.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <a href="<c:url value="/logout" />"> logout </a>
</body>
</html>