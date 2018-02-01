<%@ page import="com.alleyz.k8s.web.util.Const" %>
<%@ page import="com.alleyz.k8s.bean.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>i am test</title>
</head>
<body>

${msg}
 <h1>
     hi, i am <%=(session.getAttribute(Const.SIGN_IN_USER)) == null ? "??": ((User) session.getAttribute(Const.SIGN_IN_USER)).getNickName()%>
 </h1>
<button id="out" value="LoginOut">LoginOut</button>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    $(function(){

        $("#out").bind('click', function(){
            $.ajax({
                url: "<%=request.getContextPath()%>/login/loginOut.al",
                type: "post",
                dataType: "json",
                success: function(){
                    window.location.href = "<%=request.getContextPath()%>/login.jsp";
                }, error: function(){
                    alert("签出错误!")
                }
            });

        })

    });

</script>
</body>
</html>
