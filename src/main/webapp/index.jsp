<%--
  Created by IntelliJ IDEA.
  User: lforlasse
  Date: 04-03-2020
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop</title>
</head>
<body>

<h1>Velkommmen til din Webshop</h1>
<br>
<br>

${sessionScope.besked}
<<br>
<<br>

${requestScope.besked}
<br>
<br>

<form action="LogInServlet" method ="post">
    <label for="fname">Username:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Password:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
