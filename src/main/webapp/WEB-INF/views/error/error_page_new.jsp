<%--
  Created by IntelliJ IDEA.
  User: BS141
  Date: 7/17/2019
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>error</title>

    <c:url value="/resources/custom/errorpage/css/font-awesome.min.css" var="fontAwesomeCss"/>
    <c:url value="/resources/custom/errorpage/css/style.css" var="styleCss" />
    <c:url value="/resources/custom/errorpage/js/errorpage.js" var="errorJs" />

    <link type="text/css" rel="stylesheet" href="${fontAwesomeCss}" />
    <link type="text/css" rel="stylesheet" href="${styleCss}" />
    <script src="${errorJs}" ></script>
</head>


<%--<body>--%>
<%--<h1>${code}</h1>--%>
<%--<h2>${message}</h2>--%>
<%--</body>--%>

<body>
<div id="notfound">
    <div class="notfound">
        <div class="notfound-bg">
            <div></div>
            <div></div>
            <div></div>
        </div>
        <h1>oops!</h1>
        <h2>${message}</h2>
        <a href="/">go back</a>
    </div>
</div>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
