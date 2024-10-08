<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
<link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
<script type="text/javascript" src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<jsp:include page="header.jsp" />
<body>
    <div class="container" style="margin-top: 60px;">
        <div class="col-md-4">
            <form:form action="${action}" method="post" modelAttribute="book">
                <fieldset class="scheduler-border">
                    <legend class="scheduler-border"><c:out value="${msg}"/></legend>
                        <c:if test="${type.equals ('update')}">
                            <div class="form-group">
                                <label class="control-label">ID</label>
                                    <form:input path="id" type="text" class="form-control" id="id" placeholder="ID" disabled="true"/>
                                    <form:hidden path="id" />
                                    <form:hidden path="bookDetails.id" />
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label class="control-label">Name (*)</label>
                                <form:input path="name" type="text" class="form-control" placeholder="Name" />
                                <form:errors path="name" class="text-danger"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Author (*)</label>
                                <form:input path="author" type="text" class="form-control" placeholder="Author" />
                        </div>
                        <div class="form-group">
                            <label class="control-label">ISBN (*)</label>
                                <form:input path="bookDetails.isbn" type="text" class="form-control" placeholder="ISBN" />
                        </div>
                        <div class="form-group">
                            <label class="control-label">Price (*)</label>
                                <form:input path="bookDetails.price" type="number" step="any" class="form-control" placeholder="Price"  min="1"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Number of pages (*)</label>
                                <form:input path="bookDetails.numberOfPage" type="number" class="form-control" placeholder="Number of pages"  min="1"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Publish Date (*)</label>
                                <form:input path="bookDetails.publishDate" type="date" class="form-control" placeholder="Publish Date"  />
                        </div>
                        <div class="form-group">
                            <label class="control-label">Category (*) </label>
                                <form:select path="category.id" class="form-control">
                                    <form:option value="0" label="--- Select ---" />
                                    <form:options items="${categoryList}" />
                                </form:select>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-info">Save</button>
                </fieldset>
            </form:form>
        </div>
    </div>
</body>
</html>