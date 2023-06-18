<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html>

<body>

<h2> Dear Employee, You are WELCOME!!! </h2>
<br>
<br>


Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department}
<br>

Language(s):
<ul>


    <c:forEach var="lang" items="${employee.languages}">
        <li>   ${lang}   </li>
    </c:forEach>



</ul>

Your car: ${employee.carBrand}
<br>

</body>

</html>
