<%@include file="/views/header.jsp" %>

<h3>Add New Student</h3>
<form method="GET" action="${requestScope.defaultformaction}">
  <label for="">Roll No</label>
                <input type="text" name = "rollNo" value="${sessionScope.student.rollNo}" />

		<label for="">Name</label>	
                <input type="text" name = "name" value="${sessionScope.student.name}" />

		<label for="">Address</label>
                <input type="text" name = "address" value="${sessionScope.student.address}" />

                <button name="addnew" value="addnew">Add New</button>
</form>

<jsp:include page="/views/footer.jsp"></jsp:include>