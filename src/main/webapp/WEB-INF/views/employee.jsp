<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 4/18/2023
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Employee Salary Update</title>
</head>
<body>

<div class="container pt-6">
    <div class="card text-center">

        <%--        Body Part--%>
        <div class="card-body ">
            <form action="${pageContext.request.contextPath}/employeeSalaryUpdate" method="post" id="employeeSalaryUpdate">
                <h3 class="card-title">Employee Salary Update</h3>

                <c:if test="${not empty message}">
                    <div class="alert alert-success" role="alert">
                        ${message}
                    </div>
                </c:if>

                <div class="form">

                    <div class="card">
                        <h5 class="card-header control-label">Provide Details</h5>
                        <div class="card-body">
                            <div class="hold">
                                <div class="row g-3 mb-4">

                                    <div class="col-md-2 control-label">
                                        <label for="employeeId" class="form-label control-label">Select Employe</label>
                                        <select id="employeeId" class="form-control" name="employeeId" onchange="getEmployeeDetails(this.value)">

                                            <option value="0" selected hidden>Select</option>
                                            <c:forEach items="${employeeList}" var="employee" varStatus="count">
                                                <option value="${employee.employeeId}">${employee.employeeName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-md-2 control-label">
                                        <label for="phoneNumber" class="form-label control-label">Phone Number</label>
                                        <input type="text" name="phoneNumber" class="form-control" id="phoneNumber" required  disabled/>
                                    </div>
                                    <div class="col-md-2 control-label">
                                        <label for="phoneNumber" class="form-label control-label">Email</label>
                                        <input type="text" name="email" class="form-control" id="email" required disabled/>
                                    </div>
                                    <div class="col-md-2 control-label">
                                        <label for="phoneNumber" class="form-label control-label">Salary</label>
                                        <input type="text" name="salary" class="form-control" id="salary" required  disabled/>
                                    </div>
                                    <div class="col-md-2 control-label">
                                        <label for="phoneNumber" class="form-label control-label">PF Percentage</label>
                                        <input type="text" name="pf" class="form-control" id="pf" required disabled/>
                                    </div>
                                    <div class="col-md-2 control-label">
                                        <label for="phoneNumber" class="form-label control-label">HRA Percentage</label>
                                        <input type="text" name="hra" class="form-control" id="hra" required disabled/>
                                    </div>
                                </div>

                                <div class="btnhold mt-3">
                                    <button type="submit" class="btn btn-primary mr-3">Submit</button>
                                    <button type="reset" class="btn btn-secondary">Reset</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

    </div>
</div>
</div>
</body>
</html>

<script>
    function getEmployeeDetails(employeeId) {
        $.ajax({
            url: '/getEmployeeDetails',
            type: 'GET',
            data: {
                employeeId: employeeId
            },
            success: function (data) {
                console.log(data);
                $('#phoneNumber').val(data.employeePhone);
                $('#email').val(data.employeeEmail);
                $('#salary').val(data.employeeSalary);
                $('#pf').val(data.pfpercentage);
                $('#hra').val(data.hrapercentage);
            },
            error: function (data) {
                console.log(data);
            }
        });
    }
</script>

