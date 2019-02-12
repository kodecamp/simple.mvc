<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.servletContext.contextPath}"></c:set>
  <!doctype html>
  <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>${requestScope.title}</title>
    <link href="${contextPath}/css/milligram/milligram.min.css" rel="stylesheet">
    <link href="${contextPath}/css/header.css" rel="stylesheet">
    <link href="${contextPath}/css/my_style.css" rel="stylesheet">
    <link href="${contextPath}/css/theme.css" rel="stylesheet">
  </head>
  <body>
    <header>
      <h3>LOGO </h3>

      <ul class="menu">
        <li class="menu-item"><a href="${contextPath}/publicpages/courses.xhtml">Courses</a></li>
        <li class="menu-item"><a href="${contextPath}/publicpages/contact.xhtml">Contact</a></li>
          <c:if test="${empty param.isLogin}">
          <li class="menu-item"><a href="${contextPath}/publicpages/loginform.xhtml">Login</a></li>
          </c:if>
      </ul>
    </header>
        <c:set var="messages" scope="request" value="${sessionScope.messages}"></c:set>


          <div class="main">
          <c:if test="${!empty messages}">
            <div class="message-panel " >
              <c:forEach items="${messages}" var="message">
                <p class="${message.severity}">${message.content}</p>
              </c:forEach>
            </div>
          </c:if>


