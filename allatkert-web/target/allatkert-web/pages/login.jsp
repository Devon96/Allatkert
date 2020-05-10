<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="../WEB-INF/common/common-header.jsp"/>
    <title>Bejelentkezés</title>
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/LoginController" method="post">
        <div class="form-group">
            <label for="username">Felhasználónév</label>
            <input required name="username" type="text" class="form-control" id="username"
                   placeholder="Username"/>
        </div>
        <div class="form-group">
            <label for="password">Jelszó</label>
            <input required name="password" type="password" class="form-control" id="password"
                   placeholder="Password"/>
        </div>
        <button id="submit" type="submit" class="btn btn-primary">Bejelentkezés</button>
        <span><a href="register.jsp">Regisztráció</a></span>
    </form>
</div>
</body>
</html>