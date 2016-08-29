<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	<P>Hello World! </P>
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h1> Hello world!  </h1>
 
<P>  The time on the server is ${serverTime}. </P>
 
<!-- JSTL문법중 choose는 java의 if elseif else문과 비슷한 역할을 함  -->
<!-- 유저 정보 세션이 없으면  로그아웃 버튼 출력--> 
<!-- 유저 정보 세션이 존재하면  로그인 버튼 출력-->
<c:choose>
	<c:when test="${empty USER_SESSION}">
		<a href="${pageContext.request.contextPath}/login" target="_self">로그인 하기</a>
		<a href="${pageContext.request.contextPath}/register" target="_self">회원가입 하기</a>
	</c:when>

    <c:otherwise>
        <p>${USER_SESSION.username}님 환경합니다.</p>
        <h1> Hello world!  </h1>
        <form action="${pageContext.request.contextPath}/logout" method="post" target="_self">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button type="submit">로그아웃</button>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
