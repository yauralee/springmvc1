<%--
  Created by IntelliJ IDEA.
  User: twcn
  Date: 10/2/16
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="helloworld">hello world</a>
    <br><br>
    <a href="springmvc/testRequestMapping">Test Request Mapping</a>
    <br><br>
    <!--
    <a href="springmvc/testMethod">Test Request Method</a>
    -->
    <form action="springmvc/testMethod" method="POST">
      <input type="submit" value="submit"/>
    </form>
    <br><br>
    <a href="springmvc/testParamsAndHeaders?username=liyu&age=10">Test Request Params</a>
    <br><br>
    <a href="springmvc/testAntPath/anychar/abc">Test Ant Path</a>
  </body>
</html>
