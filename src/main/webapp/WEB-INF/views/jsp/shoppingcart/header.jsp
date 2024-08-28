<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
    <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <div class="btn btn-info d-flex align-items-center" style="padding: 10px;">
        <a  href="/" class="btn btn-light ml-auto" style="margin-right: 5px">Home </a>
        <a href="/cart" class="btn btn-light ml-auto" style="margin-right: 5px">My Cart</a>
        <a href="/order" class="btn btn-light ml-auto">My Order</a>
    </div>

</body>
</html>
