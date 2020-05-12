<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<html>
<head>
    <jsp:include page="../WEB-INF/common/common-header.jsp"/>
    <title>Könyvelések listázása</title>
</head>
<body>
<jsp:include page="../WEB-INF/common/menu.jsp"/>
<jsp:include page="/KonyvelesWebController"/>
<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Felhasználónév</th>
            <th scope="col">Azonosító</th>
            <th scope="col">Időpont</th>
            <th scope="col">Leírás</th>
            <th scope="col">Összeg</th>
            <th scope="col">Típus</th>
            <th scope="col">Mennyiség</th>
            <th scope="col">Gyakoriság</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${requestScope.konyvelesList}">
            <tr>
                <td>${item.konyvelesID}</td>
                <td>${item.felhasznalonev}</td>
                <td>${item.azonosito}</td>
                <td>${item.orokbefogadasIdeje}</td>
                <td>${item.leiras}</td>
                <td>${item.tamogatasTipusa}</td>
                <td>${item.tamogatasOsszege}</td>
                <td>${item.tamogatasMennyisege}</td>
                <td>${item.gyakorisag}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<div>
    <form action="" method="post">
        <label>Szűrés örökbefogadó alapján</label>
        <label>
            <select name="konyvelesOrokbefogadoFelhasznalonev">
                    <option value="frissites">Tábla frissítése</option>
                <c:forEach items="${requestScope.orokbefogadoFelhasznalonevekList}" var="orokbefogadoFelhasznalonev">
                    <option value="${orokbefogadoFelhasznalonev}">${orokbefogadoFelhasznalonev}</option>
                </c:forEach>
            </select>
        </label>
        <input type="submit" value="Küldés" />
    </form>
</div>
<div>
    <form action="" method="post">
        <label>Szűrés örökbefogadott alapján</label>
        <label>
            <select name="konyvelesOrokbefogadottAzonosito">
                    <option value="frissites">Tábla frissítése</option>
                <c:forEach items="${requestScope.orokbefogadottAzonositokList}" var="orokbefogadottAzonosito">
                    <option value="${orokbefogadottAzonosito}">${orokbefogadottAzonosito}</option>
                </c:forEach>
            </select>
        </label>
        <input type="submit" value="Küldés" />
    </form>
</div>
<div>
    <form action="" method="post">
        <label>Szűrés időpont alapján</label>
        <label>
            <input type="number" maxlength="4" name="konyvelesIdopont">
        </label>
        <input type="submit" value="Küldés" />
    </form>
</div>
<div>
    <form action="" method="post">
        <label>Szűrés támogatás típusa alapján</label>
        <label>
            <select name="konyvelesTamogatasTipusa">
                    <option value="frissites">Tábla frissítése</option>
                <c:forEach items="${requestScope.tamogatasTipusaList}" var="tamogatasTipusa">
                    <option value="${tamogatasTipusa}">${tamogatasTipusa}</option>
                </c:forEach>
            </select>
        </label>
        <input type="submit" value="Küldés" />
    </form>
</div>
</body>
</html>

