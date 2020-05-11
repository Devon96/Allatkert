<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="../WEB-INF/common/common-header.jsp"/>
    <title>Örökbefogadási adatok megadása</title>
</head>
<body>
<jsp:include page="/Orokbefogadas"/>
<jsp:useBean id="konyveles" class="hu.alkfejl.allatkert.model.bean.Konyveles" scope="request" />
<jsp:setProperty property="*" name="konyveles"/>
<div class="container">
    <form action="" method="post">
        <input type="hidden" name="konyvelesAzonosito" value="${konyveles.azonosito}" />
        <input type="hidden" name="konyvelesFelhasznalonev" value="${sessionScope.currentUser.felhasznalonev}" />
        <div class="form-group">
            <label for="leiras">Leírás</label>
            <input name="konyvelesLeiras" type="text" class="form-control" id="leiras"
                   value="${konyveles.leiras}"/>
        </div>
        <div class="form-group">
            <label for="tipus">Támogatás típusa</label>
            <select required name="konyvelesTamogatasTipusa" class="form-control" id="tipus">
                <option value="pénzösszeg">Pénzösszeg</option>
                <option value="állateledel">Állateledel</option>
            </select>
        </div>
        <div class="form-group">
            <label for="osszeg">Támogatás összege</label>
            <input name="konyvelesTamogatasOsszege" type="number" class="form-control" id="osszeg"
                  value="${konyveles.tamogatasOsszege}"/>
        </div>
        <div class="form-group">
            <label for="mennyiseg">Támogatás mennyisége</label>
            <input name="konyvelesTamogatasMennyisege" type="number" class="form-control" id="mennyiseg"
                   value="${konyveles.tamogatasMennyisege}"/>
        </div>
        <div class="form-group">
            <label for="gyakorisag">Támogatás gyakorisága</label>
            <select required name="konyvelesTamogatasGyakorisaga" class="form-control" id="gyakorisag">
                <option value="egyszeri">Egyszeri</option>
                <option value="ismétlődő">Ismétlődő</option>
            </select>
        </div>
        <button id="submit" type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
