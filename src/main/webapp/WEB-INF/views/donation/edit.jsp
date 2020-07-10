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
    <h2>Darowizna</h2>
</section>

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
<%--        <c:forEach items="${donationList}" var="donation">--%>

            <tr>
                <form method="post"
                      action="add">
                <td>${donation.id}</td>
                <td><input type="text" name="city" placeholder="${donation.city}"></td>
                <td><input type="date" name="data" placeholder="${donation.pickUpDate}"></td>
                <td><input type="time" name="time" placeholder="${donation.pickUpTime}"></td>
                <td><input type="text" name="bags" placeholder="${donation.quantity}"></td>
                <td><input type="text" name="address" placeholder="${donation.street}"></td>
                <td><input type="text" name="postcode" placeholder="${donation.zipCode}"></td>
                <td><input type="text" name="organizationId" placeholder="${donation.institution.id}"></td>
                <td><input type="text" name="more_info" placeholder="${donation.pickUpComment}"></td>
                <td>
                    <input type="hidden" name="toEditId" value="${donation.id}">
                    <input type="hidden" name="phone" value="">
                    <input type="hidden" name="categoriesId" value="">
                    <input type="submit" value="Zapisz">
                </form>
<%--                    <form method="get"--%>
<%--                          action="remove">--%>
<%--                        <input type="hidden" name="toRemoveId" value="${donation.id}">--%>
<%--                        <input type="submit" value="Usun">--%>
<%--                    </form></td>--%>
            </tr>
<%--        </c:forEach>--%>
        </tbody>
    </table>
</section>

<%@ include file="/WEB-INF/views/footer.jsp" %>
<%--<script src="<c:url value="/resources/js/app.js"/>"></script>--%>

</body>
</html>