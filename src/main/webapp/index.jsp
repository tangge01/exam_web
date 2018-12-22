<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>千锋教育分析平台</title>
</head>
<body background="https://goss.veer.com/creative/vcg/veer/800water/veer-303623271.jpg">

<%--<form action="/queryContact"> id:<input type="text" name="id"/>
    telephone:<input type="text" name="telephone"/>
    <input type="submit" value="查询联系人"/>
</form>
<form action="/queryContactList">
    <input type="submit" value="查询所有"/>
</form>
<br/>--%>

<div style="text-align:center;margin-top: 120px">
    <font color="yellow" size="5">班级考试情况统计
<form action="${pageContext.request.contextPath}/queryCallLogList" method="post">
    班级 <input type="text", name="class_name">
    <input type="submit" value="查询">
</form>
    <div style="text-align:center;margin-top: 40px"></div>
        题目错误率统计
    <form action="${pageContext.request.contextPath}/queryCallLogList0" method="post">
        难度 <input type="text", name="question_diffculty">
        <input type="submit" value="查询">
    </form>
        <br/> <br/>  <br/>
        <marquee direction="right" scrolldelay="90"
         scrollamount="6" behavior="scroll" loop="0"
         style="position:absolute;" id="Marquee1">
 <span style="color:#000000;
 font-family:Arial;font-size:40px;color: #ffee35">
        技术支持：<br/>
     大数据开发工程师陈鑫<br/>
     大数据开发工程师张文豪<br/>
     大数据开发工程师陈凯<br/>
     大数据开发工程师余建堂
</span></marquee></font></div>
</body>
</html>
