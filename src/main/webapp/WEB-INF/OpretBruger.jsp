<%--
  Created by IntelliJ IDEA.
  User: lforlasse
  Date: 04-03-2020
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opret bruger</title>
</head>
<body>

Her skal du registrere dig, og derefter lave indkøb i webshoppen.
<br>
<br>

${requestScope.besked}
<br>
<br>

<form action="OpretServlet" method ="post">
    <label for="fname">Username:</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Password:</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="Opret">
</form>


</body>
</html>
