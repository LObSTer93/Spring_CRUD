<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
    <head>
        <title>
            ${isEdit ? "Edit" : "Add"}
        </title>
    </head>
    <body>
        <h1>
            ${isEdit ? "Edit info with id ".concat(info.id) : "Add new info"}
        </h1>

        <form method="POST">
            <input type="hidden" name="id" value="${isEdit ? info.id : ''}">
            <table>
                <tr>
                    <td>
                        <label for="name">Name:</label>
                    </td>
                    <td>
                        <input type="text" name="name" id="name" value="${isEdit ? info.name : ''}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="eMail">Email: </label>
                    </td>
                    <td>
                        <input type="email" name="eMail" id="eMail" value="${isEdit ? info.EMail : ''}" />
                    </td>
                </tr>
            </table>
            <input type="submit" value="${isEdit ? 'edit' : 'add'}" />
        </form>
    </body>
</html>
