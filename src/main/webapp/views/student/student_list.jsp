
<%@include file="/views/header.jsp"%>

<div class="container">
	<h4>Student List</h4>
	<table>
		<thead>
			<tr>
				<th>Roll No</th>
				<th>Name</th>
				<th>Address</th>
				<th>Update Action</th>
				<th>Delete Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sessionScope.students}" var="student">
				<tr>
					<td>${student.rollNo}</td>
					<td>${student.name}</td>
					<td>${student.address}</td>
					<td><a href="/webapp/student?action=UPDATE&rollNo=${student.rollNo}">Edit</a></td>
					<td><a href="/webapp/college/delete?regNo=">Remove</a></td>
				</tr>
			</c:forEach>
			
			<%-- <c:forEach items="${sessionScope.collegesList" var="college">
				<tr>
					<td>${college.regNo}</td>
					<td>${college.name}</td>
					<td>${college.address}</td>
					<td><a href="/webapp/college/updateform?regNo=${college.regNo}&name=${college.name}&address=${college.address}">Edit</a></td>
					<td><a href="#">Remove</a></td>
				</tr>
				
			</c:forEach> --%>
		</tbody>
	</table>
</div>

<jsp:include page="/views/footer.jsp"></jsp:include>