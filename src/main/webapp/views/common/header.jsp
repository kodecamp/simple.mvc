<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>${requestScope.title}</title>
    <link href="/webapp/css/milligram/milligram.min.css" rel="stylesheet">
    <link href="/webapp/css/header.css" rel="stylesheet">
    <link href="/webapp/css/my_style.css" rel="stylesheet">
    <link href="/webapp/css/theme.css" rel="stylesheet">
  </head>
  <body>
    <header>
      <h3>LOGO</h3>

      <ul class="menu">
        <c:forEach items="${sessionScope.menus}" var="menu">
          <li class="menu-item"><a href="${menu.value}">${menu.key}</a></li>
          </c:forEach>
        <li class="menu-item">
          <a href="${pageContext.request.servletContext.contextPath}/auth/logout.xhtml">Logout ${sessionScope.userInfo.userName}</a>
        </li>
      </ul>
    </header>
    <!-- sets a variable in the defined scope -->
    <div class="main">
      <c:set var="messages" scope="request" value="${sessionScope.messages}"></c:set>

    <c:if test="${!empty messages}">
      <div class="message-panel " >
        <c:forEach items="${messages}" var="message">
          <p class="${message.severity}">${message.content}</p>
        </c:forEach>
      </div>
    </c:if>
