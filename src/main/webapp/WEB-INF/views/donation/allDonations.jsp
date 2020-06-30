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
<section class="steps">
    <h2>Darowizny</h2>
</section>
<%--<section>--%>
<%--    <form action="add" method="get">--%>
<%--        <h1><input type="submit" value="Dodaj kategorię"></h1>--%>
<%--        <input type="hidden" name="toEditId" value=0>--%>
<%--    </form>--%>
<%--</section>--%>


<section class="steps">
    <table class="table" border="1">
        <thead>
        <tr>
            <th scope="col"><h1>Id</h1></th>
            <th scope="col"><h1>Miasto</h1></th>
            <th scope="col"><h1>Data odbioru</h1></th>
            <th scope="col"><h1>Godzina odbioru</h1></th>
            <th scope="col"><h1>Ilość worków</h1></th>
            <th scope="col"><h1>Adres</h1></th>
            <th scope="col"><h1>kod</h1></th>
            <th scope="col"><h1>Fundacja</h1></th>
            <th scope="col"><h1>Uwagi</h1></th>
            <th scope="col"><h1>Akcja</h1></th>
        </tr>
        <thead>
        <tbody>
        <c:forEach items="${donationList}" var="donation">

            <tr>
                <td>${donation.id}</td>
                <td>${donation.city}</td>
                <td>${donation.pickUpDate}</td>
                <td>${donation.pickUpTime}</td>
                <td>${donation.quantity}</td>
                <td>${donation.street}</td>
                <td>${donation.zipCode}</td>
                <td>${donation.institution.id}</td>
                <td>${donation.pickUpComment}</td>
                <td><form method="get"
                          action="add">
                    <input type="hidden" name="toEditId" value="${donation.id}">
                    <input type="submit" value="Edytuj">
                </form>
                    <form method="get"
                          action="remove">
                        <input type="hidden" name="toRemoveId" value="${donation.id}">
                        <input type="submit" value="Usun">
                    </form></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<%@ include file="/WEB-INF/views/footer.jsp" %>
<%--<script src="<c:url value="/resources/js/app.js"/>"></script>--%>

</body>
</html>