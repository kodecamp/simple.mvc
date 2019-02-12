
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- public header -->

<jsp:include page="/views/header.jsp" flush="true">
  <jsp:param name="isLogin" value="isLogin"></jsp:param>
</jsp:include>


<h3>Login</h3>

<form method="POST" action="${defaultformaction}">

  <label for="" class="mandatory">User Name</label>
  <input type="text" name = "userName" value="${param.userName}" />

  <label for="" class="mandatory">Password</label>
  <input type="password" name = "password" value="${param.password}" />

  <button name="login" value="login">Login</button>
</form>

  <jsp:include page="/views/footer.jsp"></jsp:include>
  <script>

<!-- disables the back button -->
    function clearHistory() {
      history.pushState(null, null, document.title);
      window.addEventListener('popstate', function () {
        history.pushState(null, null, document.title);
      });
    }

    clearHistory();
  </script>