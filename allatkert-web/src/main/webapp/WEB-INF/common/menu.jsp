<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav w-100">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/pages/list_allat.jsp">Állatok listázása</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/pages/orokbefogadas.jsp">Állat örökbefogadása</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/pages/list_orokbefogado.jsp">Örökbefogadók listázása</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/pages/list_konyveles.jsp">Könyvelések listázása</a></li>
<!--

                <li class="nav-item dropdown ml-auto">
                    <a class='nav-link dropdown-toggle' href='#' id='navbarDropdownMenuLink' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>

                    </a>
                    <div class='dropdown-menu dropdown-menu-right' aria-labelledby='navbarDropdownMenuLink'>
                        <a class='dropdown-item' href='/pages/profile.jsp'>Profil</a>
                        <a class='dropdown-item' href='/LogoutController'>Kijelentkezés</a>
                    </div>
                </li>

            -->
        </ul>
    </div>
</nav>
