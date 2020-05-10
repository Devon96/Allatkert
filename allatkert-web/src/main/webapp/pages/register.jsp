<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../WEB-INF/common/common-header.jsp"/>
    <title>Regisztráció</title>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/RegisterController" method="post">
        <div class="form-group">
            <label for="felhasznalonev">Felhasználónév</label>
            <input required name="felhasznalonev" type="text" class="form-control" id="felhasznalonev"
                   placeholder="Felhasznalonev"/>
        </div>
        <div class="form-group">
            <label for="jelszo">Jelszó</label>
            <input required name="jelszo" type="password" class="form-control" id="jelszo"
                   placeholder="Jelszo"/>
        </div>
        <div class="form-group">
            <label for="nev">Név</label>
            <input required name="nev" type="text" class="form-control" id="nev"
                   placeholder="Nev"/>
        </div>
        <div class="form-group">
            <label for="telefon">Telefonszám</label>
            <input name="telefon" type="number" class="form-control" id="telefon"
                   placeholder="Telefonszam"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input name="email" type="email" class="form-control" id="email"
                   placeholder="Email"/>
        </div>
        <button id="submit" type="submit" class="btn btn-primary">Küldés</button>
    </form>
</div>

</body>
</html>
