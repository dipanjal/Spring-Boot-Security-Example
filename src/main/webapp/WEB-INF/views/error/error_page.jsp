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
    <title>error</title>
    <c:url value="/resources/custom/js/errorpage.js" var="errorJs" />
    <script src="${errorJs}" ></script>
</head>
<body>
<h1>${code}</h1>
<h2>${message}</h2>
</body>
</html>
