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
     Free passes name:       <form:input path = "freePasses"/>
     <form:errors path="freePasses" ccsClass="error" />

     <br><br>
     Postal Code:   <form:input path = "postalCode"/>
     <form:errors path="postalCode" ccsClass="error" />

     <br><br>
     Course Code:   <form:input path = "courseCode"/>
     <form:errors path="courseCode" ccsClass="error" />

    <br><br>
     <input type = "submit" value= "Submit"/>

</form:form>

</body>

</html>