<%-- 
    Document   : test_form
    Created on : Feb 9, 2019, 1:46:39 PM
    Author     : kcamp
--%>

<jsp:include page="/views/header.jsp"></jsp:include>

  <h1>Hello World!</h1>
  <form action="${requestScope.defaultformaction}">
  <button name="list" value="list"> Show List</button>
  <button name="addform" value="addform">Add Form</button>
</form>


<jsp:include page="/views/footer.jsp"></jsp:include>