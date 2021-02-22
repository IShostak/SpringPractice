<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Login form</title>
    </head>

    <style>
        .failed {
            color: red;
        }
    </style>

<body>
      <h2>Custom login form</h2>

      <form:form action = "${pageContext.request.contextPath}/authenticateUser"
                 method = "POST">

                 <c:if test = "${param.error != null}" >
                    <i class = "failed">Invalid credentials</i>
                 </c:if>
                 <p>
                    User name : <input type = "text" name = "username"/>
                 </p>
                 <p>
                    Password  : <input type = "password" name = "password"/>
                 </p>

                 <input type=  "submit" value = "Login" />
      </form:form>
</body>

</html>