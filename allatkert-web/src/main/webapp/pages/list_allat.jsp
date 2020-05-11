<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<html>
<head>
    <jsp:include page="../WEB-INF/common/common-header.jsp"/>
    <title>Állatok listázása</title>
</head>
<body>
<jsp:include page="../WEB-INF/common/menu.jsp"/>
<jsp:include page="/AllatWebController"/>
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
        </tr>
        </thead>
        <tbody>

        <c:forEach var="item" items="${requestScope.allatList}">
            <tr>
                <td>${item.azonosito}</td>
                <td>${item.nev}</td>
                <td>${item.faj}</td>
                <td>
                    <img src="data:image/jpeg;base64,${item.kep}"/>
                </td>
                <td>${item.bemutatkozas}</td>
                <td>${item.szuletesiEv}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <form action="" method="post">
        <label>Szűrés örökbefogadottság szerint</label>
        <label>
            <select name="orokbefogadottsagiStatusz">
                <option value="frissites">Tábla frissítése</option>
                <option value="orokbefogadottak">Örökbefogadottak</option>
                <option value="orokbefogadatlanok">Örökbefogadatlanok</option>
            </select>
        </label>
        <input type="submit" value="Küldés" />
    </form>
</div>
</body>
</html>
