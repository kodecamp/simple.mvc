
<%@include file="/views/common/header.jsp"%>
<%--<jsp:include page="/views/header.jsp"></jsp:include>--%>
<div class="container">
  <h4>All Colleges</h4>
  <h4>V1</h4>
  <table>
    <thead>
      <tr>
        <th>Reg #</th>
        <th>Name</th>
        <th>Address</th>
        <th>Update Action</th>
        <th>Delete Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${sessionScope.college.collegeList}" var="uicollege">
        <tr>
          <td>${uicollege.college.regNo}</td>
          <td>${uicollege.college.name}</td>
          <td>${uicollege.college.address}</td>
          <td><a href="${ uicollege.updateUrl}">Edit</a></td>
          <td><a href="${ uicollege.deleteUrl}">Remove</a></td>
        </tr>
      </c:forEach>
        ${sessionScope.college.value1}
        ${sessionScope.college.value2}
        ${sessionScope.college.value3}
    </tbody>
  </table>
</div>

        <jsp:include page="/views/common/footer.jsp"></jsp:include>