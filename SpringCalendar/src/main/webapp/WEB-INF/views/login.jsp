<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<!-- JSTL의 if 문법 사용-->
<!-- 로그인 오류메시지 세션이 존재하면  메시지 출력-->
<c:if test="${!empty LOGIN_EXCEPTION}">
    <p>${LOGIN_EXCEPTION}</p>
</c:if>
 
 <!-- 이번에 추가된 부분 -->
<div>
    <a href="${pageContext.request.contextPath}/register" target="_self">회원가입 하기</a>
</div>
 
<form action="${pageContext.request.contextPath}/login-request" method="post" target="_self">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="login_email">Email</label>
    <input type="email" name="login_email" id="login_email" autofocus maxlength="128">
    <label for="login_password">Password</label>
    <input type="password" name="login_password" id="login_password" maxlength="64">
    
    <label>
        <input type="checkbox" name="login_rememberme" id="login_rememberme">
         Remember Me
    </label>
    
    <button type="submit">로그인</button>    
</form>
</body>
</html>