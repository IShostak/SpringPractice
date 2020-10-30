<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<title>Customer Registration form</title>

<style>
    .error{color:red}
 </style>

 </head>
<body>

Fill out forms.
<form:form action = "processForm" modelAttribute = "customer">
     First name:       <form:input path = "firstName"/>
        <br><br>
     Last name:       <form:input path = "lastName"/>
     <form:errors path="lastName" ccsClass="error" />
    <br><br>
     <input type = "submit" value= "Submit"/>

</form:form>

</body>

</html>