<%--
  Created by IntelliJ IDEA.
  User: data-21
  Date: 2022-09-21
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>메일</title>
</head>
<body>
<form name="f" method="post" action="/Mail/sendMailResult">
    <table border="1" style="width:500px">
        <tr>
            <td style="width:100px">받는사람</td>
            <td style="width:400px"><input type="text" name="toMail" style="width:380px"/> </td>
        </tr>
        <tr>
            <td style="width:100px">메일제목</td>
            <td><input type="text" name="title" style="width:380px"/> </td>
        </tr>
        <tr>
            <td style="width:100px">메일내용</td>
            <td><textarea name="contents" rows="5" style="width:380px"></textarea></td>

        </tr>

    </table>
    <input type="submit" value="[메일전송]"/>
    <input type="reset" value="[내용초기화]"/>
</form>

</body>
</html>
