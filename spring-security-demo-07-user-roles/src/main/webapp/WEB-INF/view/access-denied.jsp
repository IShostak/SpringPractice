<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<head>
	<title>Access Denied</title>
</head>

<body>
      <h2>You're not allowed to see this page</h2>

       <hr>
        <a href = "${pageContext.request.contextPath}/">Back to home page</a>
</body>

</html>