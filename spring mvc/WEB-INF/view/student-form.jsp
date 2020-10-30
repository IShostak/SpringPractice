<%@ taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<title>Student Registration form</title>
 </head>
<body>

<form:form action = "processForm" modelAttribute = "student">
     First name:       <form:input path = "firstName"/>
        <br><br>
     Last name:       <form:input path = "lastName"/>
      <br><br>
              <form:select path = "country" >
                  <form:options items = "${student.countryOptions}"/>

                  <!-- <form:option value = "France" label = "France"/>-->
              </form:select>
              <br><br>
      Java <form:radiobutton path = "favLang" value = "Java" />
      C# <form:radiobutton path = "favLang" value = "C# " />
      PHP <form:radiobutton path = "favLang" value = "PHP" />


      <br><br>
      What OS do you know?
      <br>
            MacOs <form:checkbox path = "opSys" value = "MacOs" />
            Linux <form:checkbox path = "opSys" value = "Linux" />
            Windows <form:checkbox path = "opSys" value = "Windows" />
       <br><br>
     <input type = "submit" value= "Submit"/>
</form:form>

</body>

</html>