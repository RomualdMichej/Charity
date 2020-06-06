<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/views/header.jsp" %>
</header>

<table class="table" border="1">
    <thead>
    <tr>
        <th scope="col"><h1>Email</h1></th>
        <th scope="col"><h1>Hasło</h1></th>
        <th scope="col"><h1>Akcja</h1></th>
    </tr>
    <thead>
    <tbody>
    <c:forEach items="${userList}" var="user">

        <tr>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td><form method="get"
                      action="edit">
                <input type="hidden" name="toEditId" value="${user.id}">
                <input type="submit" value="Edytuj">
            </form>
                <form method="get"
                      action="remove">
                    <input type="hidden" name="toRemoveId" value="${user.id}">
                    <input type="submit" value="Usun">
                </form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>