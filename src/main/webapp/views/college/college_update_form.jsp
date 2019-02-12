<%@include file="/views/common/header.jsp"%>


<h3>Update</h3>

<form id="webform" name="webform" method="post" action="${requestScope.defaultformaction}" accept-charset="UTF-8">
  <input type="hidden" value="update" name="action">
  <input type="hidden" name = "regNo" value="${requestScope.uicollege.college.regNo}" />
  <input type="text" name = "name" value="${requestScope.uicollege.college.name}" />
  <input type="text" name = "address" value="${requestScope.uicollege.college.address}" />
  <button name="update" value="update" class="action"> Update </button>

</form>
  <%@include file="/views/common/footer.jsp"%>