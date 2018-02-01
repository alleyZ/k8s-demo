<%--
  Created by IntelliJ IDEA.
  User: alleyz
  Date: 2017/12/15
  Time: 上午9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/login/signIn.al" method="post">
    username: <input type="text" name="userName" />
    <br/>
    password  <input type="password" name="password" />
    <br/>
    <button id="login" type="submit" value="SignIn">SignIn</button>
    </form>

    <h1><%=request.getParameter("msg")%></h1>
</body>
</html>
