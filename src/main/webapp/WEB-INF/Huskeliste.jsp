<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lforlasse
  Date: 04-03-2020
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Huskeliste</title>
</head>
<body>

${sessionScope.besked}
<br>
<br>

<h1>Tilføj emner til din indkøbskurv</h1>
<br>
<br>

<form action="AddItemServlet" method ="post">
    <label for="fname">Angiv vare:</label><br>
    <input type="text" id="fname" name="vareNavn"><br>
    <input type="submit" value="Tilføj">
</form>
<br>
<br>

${requestScope.besked}
<br>
<br>

<c:forEach var="element" items="${sessionScope.basket}">

    ${element}
    <br>

</c:forEach>


</body>
</html>
