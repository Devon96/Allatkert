<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String redirectURL = "${pageContext.request.contextPath}/pages/login.jsp";
    response.sendRedirect(redirectURL);
%>
