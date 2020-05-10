<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<html>
<head>
    <jsp:include page="../WEB-INF/common/common-header.jsp"/>
    <title>Örökbefogadók listázása</title>
</head>
<body>
<jsp:include page="../WEB-INF/common/menu.jsp"/>
<jsp:include page="/OrokbefogadoWebController"/>

<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Felhasználónév</th>
            <th scope="col">Név</th>
            <th scope="col">Telefonszám</th>
            <th scope="col">Email</th>
            <th scope="col">Felvétel ideje</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="item" items="${requestScope.orokbefogadoList}">
            <tr>
                <td>${item.felhasznalonev}</td>
                <td>${item.nev}</td>
                <td>${item.telefonszam}</td>
                <td>${item.email}</td>
                <td>${item.felvetelIdeje}</td>
                <!--
                 <td>
                     <a href="../UpdatePerson?personId="><i class="fas fa-edit"></i></a>
                     <a href="../DeletePerson?personId="><i class="fas fa-trash"></i></a>
                 </td>
                 -->
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>
