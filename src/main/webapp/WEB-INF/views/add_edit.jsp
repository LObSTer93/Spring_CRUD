<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
    <head>
        <title>
            <c:choose>
                <c:when test="${isEdit}">
                    Edit
                </c:when>
                <c:otherwise>
                    Add
                </c:otherwise>
            </c:choose>
        </title>
    </head>
    <body>
        <h1>Add new info</h1>

        <form method="POST">
            <label for="name">Name:</label>
            <input type="text" name="name" id="name"/><br/>

            <label for="eMail">Email: </label>
            <input type="email" name="eMail" id="eMail"/><br/>

            <input type="submit" value="add" />
        </form>
    </body>
</html>
