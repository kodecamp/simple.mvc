<%@include file="/views/common/header.jsp"%>

<%--<c:if test="${ requestScope.error eq 'error'}"></c:if>--%>

<h3>ADD NEW COLLEGE V1</h3>

<form method="GET" action="${requestScope.defaultformaction}">

  <label for="" class="mandatory">Reg No</label>
  <input type="text" name = "regNo" value="${param.regNo}" />

  <label for="" class="mandatory">Name</label>	
  <input type="text" name = "name" value="${param.name}" />	

  <label for="" class="mandatory">Address</label>
  <input type="text" name = "address" value="${param.address}" />	

  <button name="addnew" value="addnew">Add New</button>
</form>

  <jsp:include page="/views/common/footer.jsp"></jsp:include>