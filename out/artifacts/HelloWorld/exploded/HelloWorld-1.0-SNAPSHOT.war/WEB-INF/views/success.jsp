<%--
  Created by IntelliJ IDEA.
  User: twcn
  Date: 10/2/16
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h4>success page</h4>
    time: ${requestScope.time}
    <br><br>
    names: ${requestScope.names}
    <br><br>
    request user: ${requestScope.user}
    <br><br>
    session user: ${sessionScope.user}
    <br><br>
    request school: ${requestScope.school}
    <br><br>
    session school: ${sessionScope.school}
</head>
<body>

</body>
</html>
