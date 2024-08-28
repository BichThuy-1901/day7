<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Shopping Cart | Cart List</title>
    <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.3.0/css/bootstrap.min.css' />
    <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
    <jsp:include page="header.jsp" />
</head>

<body>
    <h2>My Order Detail List</h2>
    <c:if test="${empty orderDetail}">
        <p>Your order detail is empty.</p>
    </c:if>
    <c:if test="${not empty orderDetail}">
        <table class="table">
            <thead>
                <h2>Order Id: ${orderId}</h2>
                    <tr>
                        <th>Order Detail Id</th>
                        <th>Product Name</th>
                        <th>Description</th>
                        <th>Unit Price</th>
                        <th>Quantity</th>
                    </tr>
            </thead>
            <tbody>
                <c:forEach var="detail" items="${orderDetail}">
                    <tr>
                        <th>${detail.id}</th>
                        <td>${detail.product.name}</td>
                        <td>${detail.product.description}</td>
                        <td>${detail.product.unitPrice}</td>
                        <td>${detail.quantity}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>
