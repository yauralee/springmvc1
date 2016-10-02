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
    <br><br>
    <a href="springmvc/testPathVariable/1">Test Path Variable</a>
    <br><br>
    <a href="springmvc/testRest/1">Test Rest Get</a>
    <br><br>
    <form action="springmvc/testRest" method="post">
      <input type="submit" value="TestRest Post">
    </form>
    <br><br>
    <form action="springmvc/testRest/1" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="TestRest Put">
    </form>
    <br><br>
    <form action="springmvc/testRest/1" method="post">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="TestRest Delete">
    </form>


    <br><br>
    <a href="springmvc/testRequestParam?username=liyu&age=18">test Request Param</a>
  </body>
</html>
