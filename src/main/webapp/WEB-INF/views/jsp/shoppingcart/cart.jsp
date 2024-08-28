<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
    <jsp:include page="header.jsp" />
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Your Shopping Cart</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                      <th>Id</th>
                      <th>Product Name</th>
                      <th>Description</th>
                      <th>Unit Price</th>
                      <th>Quantity</th>
                    </tr>
                </thead>
                <c:forEach var = "item" items = "${sessionScope.cartList}" varStatus = "index">

                    <tr>
                         <td>${item.product.id}</td>
                         <td>${item.product.name}</td>
                         <td>${item.product.description}</td>
                         <td>${item.product.unitPrice}</td>
                         <td>${item.quantity}</td>
                         <td>
                         <button class = "btn btn-sm btn-danger" onclick = "location.href = '/removeItem/${item.product.id}'">Remove from cart</button>
                         </td>
                    </tr>
                         </c:forEach>
            </table>
            <div class="d-flex justify-content-between">
                <a href="/checkout" class="btn btn-success">Checkout</a>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>