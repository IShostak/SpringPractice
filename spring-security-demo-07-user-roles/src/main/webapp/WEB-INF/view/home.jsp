<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<head>

	<title>Login Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
      <h2>Company home page</h2>

      <hr>
      Welcome

       <hr>

         <p>
            User: <sec:authentication property ="principal.username" />
            <br><br>
            Role(s): <sec:authentication property ="principal.authorities"/>
         <p>

       <hr>


       <sec:authorize access = "hasRole('MANAGER')">
            <p>
                <a href = "${pageContext.request.contextPath}/leaders"> Leadership Meeting</a>
           (Only for manager peeps)
           </p>
       </sec:authorize>

       <sec:authorize access = "hasRole('ADMIN')">
            <a href = "${pageContext.request.contextPath}/systems"> Admins Meeting</a>
                         (Only for Admins)
       </sec:authorize>

        <form:form action="${pageContext.request.contextPath}/logout"
                                 		method="POST" class="form-horizontal">
                 <div style="margin-top: 10px" class="form-group">
                     <div class="col-sm-6 controls">
                          <button type="submit" class="btn btn-success">Logout</button>
                     </div>
                 </div>
        </form:form>
</body>

</html>