<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        <c:choose>
            <c:when test="${isEdit}">
                Edit
            </c:when>
            <c:otherwise>
                Delete
            </c:otherwise>
        </c:choose>
    </title>
</head>
<body>

</body>
</html>
