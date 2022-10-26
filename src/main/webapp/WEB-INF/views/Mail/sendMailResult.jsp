<%--
  Created by IntelliJ IDEA.
  User: data-21
  Date: 2022-09-21
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%
    String jspRes = CmmUtil.nvl((String)request.getAttribute("res"),"0");


    String toMail = CmmUtil.nvl(request.getParameter("toMail"));
    String title = CmmUtil.nvl(request.getParameter("title"));
    String contents = CmmUtil.nvl(request.getParameter("contents"));
%>
<!DOCUTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>메일발송결과보기</title>
</head>
<body>
<%
    if (jspRes.equals("1")) {

        out.println(toMail + "로 메일 전송이 성공하였습니다. ");
        out.println("메일 제목 : " + title);
        out.println("메일 내용 : " + contents);
    }else {
        out.println(toMail + "로 메일 전송이 실패하였습니다.");
    }
%>

</body>
</html>
