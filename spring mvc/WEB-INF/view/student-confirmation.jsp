<%@ taglib  uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %>

<!DOCTYPE html>
<html>

<head>
<title>Student confirmation form</title>
 </head>

<body>
    <br><br>

    Student name: ${student.firstName}  ${student.lastName}

    <br><br>
    Students country: ${student.country}

    <br><br>
    Favorite language: ${student.favLang}

    <br><br>
    OS:
    <ul>
      <c:forEach var = "temp" items="${student.opSys}" >
        <li> ${temp} </li>
      </c:forEach>
    </ul>

</body>

</html>