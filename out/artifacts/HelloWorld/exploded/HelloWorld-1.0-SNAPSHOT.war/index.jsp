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
    <br><br>

    <a href="springmvc/testRequestHeader">test Request Header</a>
    <br><br>

    <a href="springmvc/testCookieValue">test Cookie Value</a>
    <br><br>

    <form action="springmvc/testPojo" method="post">
      username: <input type="text" name="username">
      <br>
      password: <input type="password" name="password">
      <br>
      email: <input type="text" name="email">
      <br>
      age: <input type="text" name="age">
      <br>
      province: <input type="text" name="address.province">
      <br>
      city: <input type="text" name="address.city">
      <br>
      <input type="submit" value="submit">
    </form>
    <br><br>

    <a href="springmvc/testServletAPI">test ServletAPI</a>
    <br><br>

    <a href="springmvc/testModelAndView">test ModelAndView</a>
    <br><br>

    <a href="springmvc/testMap">test Map</a>
    <br><br>


  </body>
</html>
