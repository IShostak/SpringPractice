<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<head>
	<title>Leaders Home Page</title>
</head>

<body>
      <h2>Leaders home page</h2>

      <hr>
      Welcome

       <hr>
         <p>
            See you in Brazil
            <br>
            Keep this is secret.
         <p>

       <hr>

        <a href = "${pageContext.request.contextPath}/">Back to home page</a>
</body>

</html>