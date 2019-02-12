<%@include file="/views/header.jsp" %>


<h3>Update Student</h3>
		
	<form method="GET" action="/webapp/college/updated">
		<%-- <input type="text" name = "regNo" value="${requestScope.item}" disabled />	
		<input type="text" name = "name" value="" />	
		<input type="text" name = "address" value="" />	
		<input type="submit" value="UPDATE"/>   --%>
		
			
		<input type="hidden" name = "rollNo" value="${requestScope.student.regNo}" />	
		<input type="text" name = "name" value="${requestScope.student.name} " />	
		<input type="text" name = "address" value="${requestScope.student.address} " />	
		<input type="submit" value="Update" />  
		
	</form>
<jsp:include page="/views/footer.jsp"></jsp:include>