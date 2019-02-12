<%@include file="/views/collegeV1/header.jsp"%>


<h3>Update</h3>
		
	<form method="GET" action="/webapp/college">
		<input type="hidden" value="delete" name="action">
		<input type="hidden" name = "regNo" value="${requestScope.college.regNo}" />	
		<input type="submit" value="Submit" />  
		
	</form>
<jsp:include page="/views/footer.jsp"></jsp:include>