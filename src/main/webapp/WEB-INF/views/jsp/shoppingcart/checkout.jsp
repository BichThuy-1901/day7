<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
<link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
<script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
</head>
<body>
    <h2>Checkout</h2>
     <form action="${pageContext.request.contextPath}/placeOrder" method="post">
                <!-- Truyền thông tin người dùng -->
                Name: <input type="text" name="customerName" required class="form-control"/><br/>
                Address: <input type="text" name="customerAddress" required class="form-control"/><br/>

                <!-- Nếu cần truyền orderId -->
                <input type="hidden" name="orderId" value="${order.id}"/>

                <!-- Nút để tiếp tục (place order) -->
                <button type="submit" class="btn btn-success">Continue</button>
     </form>
</body>
</html>