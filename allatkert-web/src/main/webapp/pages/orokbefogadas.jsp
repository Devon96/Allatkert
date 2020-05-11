<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<html>
<head>
    <jsp:include page="../WEB-INF/common/common-header.jsp"/>
    <title>Állatok örökbefogadása</title>
</head>
<body>
<jsp:include page="../WEB-INF/common/menu.jsp"/>
<jsp:include page="/OrokbefogadasWebController"/>
<div>
    <h1>Az örökbefogadható állatok listája</h1>
</div>
<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Azonosító</th>
            <th scope="col">Név</th>
            <th scope="col">Faj</th>
            <th scope="col">Fénykép</th>
            <th scope="col">Bemutatkozás</th>
            <th scope="col">Születési év</th>
            <th scope="col">Örökbefogadás</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="item" items="${requestScope.orokbefogadhatokList}">
            <tr>
                <td>${item.azonosito}</td>
                <td>${item.nev}</td>
                <td>${item.faj}</td>
                <td>
                    <img src="data:image/jpeg;base64,${item.kep}"/>
                </td>
                <td>${item.bemutatkozas}</td>
                <td>${item.szuletesiEv}</td>
                <td>
                    <a href="../pages/add_konyveles.jsp?azonosito=${item.azonosito}">Örökbefogadom</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>