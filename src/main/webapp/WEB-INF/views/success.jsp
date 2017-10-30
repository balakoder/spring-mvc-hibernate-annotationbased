<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
 <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
 <html>
<head>
	<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

<div class="container">
  <h5>Welcome !!!</h5>
  <c:if test="${message != '' }">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>Success!</strong> ${message}
		</div>
		<a class="nav-link" href="logout">Click Here to logout</a>
	</c:if>
   
 
</div>
 

 
 <jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>
