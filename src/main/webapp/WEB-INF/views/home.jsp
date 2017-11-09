<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Home Page</title>
    </head>
    <body>
        Home!
        <a href="<c:url value="/addInfo" />">Add info</a>
        <a href="<c:url value="/showAll" />">Show all</a>
    </body>
</html>