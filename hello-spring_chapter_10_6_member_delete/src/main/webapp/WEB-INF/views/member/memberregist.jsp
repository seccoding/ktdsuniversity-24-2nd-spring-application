<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c"
uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <script type="text/javascript" src="/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript" src="/js/member/memberregist.js"></script>
  </head>
  <body>
    <h1>회원가입</h1>
    <form:form modelAttribute="registMemberVO" method="post">
      <div class="grid grid-member-regist">
        <label for="email">이메일</label>
        <div>
          <input
            id="email"
            type="email"
            name="email"
            value="${registMemberVO.email}"
          />
          <form:errors path="email" element="div" cssClass="error" />
        </div>

        <label for="name">이름</label>
        <div>
          <input
            id="name"
            type="text"
            name="name"
            value="${registMemberVO.name}"
          />
          <form:errors path="name" element="div" cssClass="error" />
        </div>

        <label for="password">비밀번호</label>
        <div>
          <input
            id="password"
            type="password"
            name="password"
            value="${registMemberVO.password}"
          />
          <form:errors path="password" element="div" cssClass="error" />
        </div>

        <label for="confirmPassword">비밀번호 확인</label>
        <div>
          <input id="confirmPassword" type="password" name="confirmPassword" />
          <form:errors path="confirmPassword" element="div" cssClass="error" />
          <c:if test="${not empty error_password}">
            <div class="error">${error_password}</div>
          </c:if>
        </div>

        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="등록" />
          </div>
        </div>
      </div>
    </form:form>
  </body>
</html>
