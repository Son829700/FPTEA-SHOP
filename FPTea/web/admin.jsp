<%-- 
    Document   : admin
    Created on : May 27, 2024, 9:05:56 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        
       
   
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID != 'AD'}">
            <c:redirect url="login.html"></c:redirect>
        </c:if>
        <h1>Welcome: ${sessionScope.LOGIN_USER.fullName}</h1>
        <c:url var="logoutLink" value="MainController">
            <c:param name="action" value="Logout"></c:param>
        </c:url>
        <a href="${logoutLink}" class="btn btn-warning">LogoutJSTL</a>
        <form action="MainController" method="POST" class="from">
            <label class="form-label">Search</label>
            <input name="search" value="${param.search}"  class="form-control w-50 m-2"/>
            <input type="submit" name="action" value="Search" class="btn btn-primary form-inline m-2"/>
            <h4 style="color: red">${requestScope.ERROR_DELETE}</h4>
            <c:if test="${requestScope.LIST_USER != null}">
                <c:if test="${not empty requestScope.LIST_USER}">
                    <table border="1" class="table table-hover">
                        <thead>
                            <tr class="table-primary">
                                <th>No</th>
                                <th>User ID</th>
                                <th>Full Name</th>
                                <th>Role ID</th>
                                <th>Password</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">   
                            <form action="MainController" method="POST" class="form">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        <input type="text" name="userID" value="${user.userID}" readonly="" class="form-control"/>
                                    </td>
                                    <td>
                                        <input type="text" name="fullName" value="${user.fullName}"  class="form-control"/>
                                    </td>
                                    <td>
                                        <input type="text" name="roleID" value="${user.roleID}"  class="form-control"/>
                                    </td>
                                    <td>
                                        <input type="text" readonly value=" ${user.password}" class="form-control"/>
                                    </td>
                                    <td>
                                        <input type="submit" name="action" value="Update" class="btn btn-outline-primary"/>
                                        <input type="hidden" name="search" value="${param.search}" />
                                    </td>
                                    <td>
                                        <c:url var="deleteLink" value="MainController">
                                            <c:param name="action" value="Delete"></c:param>
                                            <c:param name="userID" value="${user.userID}"></c:param>                                          
                                            <c:param name="search" value="${param.search}"></c:param>
                                        </c:url>
                                        <a href="${deleteLink}" class="btn btn-outline-danger">Delete</a>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>              
                </c:if>
            </c:if>
        </form>
       
</body>
</html>
