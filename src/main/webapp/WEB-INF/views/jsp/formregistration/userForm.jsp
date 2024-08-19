<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Spring MVC Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
    <div class="container mt-5">
            <h2 class="mb-4">User Registration Form</h2>
            <mvc:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/result" cssClass="needs-validation" novalidate="true">
                <div class="form-group row">
                    <label for="name" class="col-sm-3 col-form-label">First name (*)</label>
                    <div class="col-sm-9">
                        <mvc:input path="name" cssClass="form-control" required="true" placeholder="FirstName"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lastname" class="col-sm-3 col-form-label">Last name (*)</label>
                    <div class="col-sm-9">
                        <mvc:input path="lastname" cssClass="form-control" required="true" placeholder="LastName"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-sm-3 col-form-label">Password (*)</label>
                    <div class="col-sm-9">
                        <mvc:password path="password" cssClass="form-control" required="true" placeholder="Password"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="detail" class="col-sm-3 col-form-label">Detail</label>
                    <div class="col-sm-9">
                        <mvc:textarea path="detail" cssClass="form-control" placeholder="Detail information"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="birthDate" class="col-sm-3 col-form-label">Birth Date</label>
                    <div class="col-sm-9">
                        <mvc:input path="birthDate" type="Date" cssClass="form-control"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-3 col-form-label">Gender</label>
                    <div class="col-sm-9 d-flex align-items-center">
                        <mvc:radiobuttons path="gender" items="${genders}" element="div class='form-check form-check-inline'"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="country" class="col-sm-3 col-form-label">Country</label>
                    <div class="col-sm-9">
                        <mvc:select path="country" items="${countries}" cssClass="form-control"/>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-3">Non Smoking</div>
                    <div class="col-sm-9 form-check">
                        <mvc:checkbox path="nonSmoking" cssClass="form-check-input"/>
                        <label class="form-check-label" for="nonSmoking"></label>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-9 offset-sm-3">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="button" class="btn btn-primary">Click me</button>
                    </div>
            </mvc:form>
        </div>
</body>
</html>