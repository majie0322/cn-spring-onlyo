<%--
  Created by IntelliJ IDEA.
  User: majie
  Date: 2018/1/28
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
            <form action="student_insert_do.jsp" method="post">
                姓名<input type="text" name="name"><br/>
                年龄<input type="text" name="age"><br/>
                成绩<input type="text" name="score"><br/>
                <input type="submit" value="输入"><br/>
                <input type="reset" value="重置">
            </form>
</body>
</html>
