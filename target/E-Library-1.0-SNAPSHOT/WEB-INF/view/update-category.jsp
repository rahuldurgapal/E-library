<%-- 
    Document   : update-category
    Created on : 03-May-2024, 11:17:26 PM
    Author     : rahul
--%>

<%@page import="model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

    Admin admin = (Admin) session.getAttribute("admin");
    if (admin == null) {
        session.setAttribute("error", "Please Login First");
        response.sendRedirect(request.getContextPath());
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../resources/css/style.css"/>
        <link rel="stylesheet" href="../resources/css/bootstrap.css"/>
        <title>JSP Page</title>
        <%     response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.setHeader("Pragma", "no-cache");%>
    </head>
    <body>
        <div id="header"> <!-- HEADER -->
            <div class="container">
                <div class="row">
                    <div class="offset-md-4 col-md-4">
                        <div class="logo">
                            <a href="#"><img src="../resources/images/library.png"></a>
                        </div>
                    </div>
                    <div class="offset-md-2 col-md-2">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Hi Admin
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="#">Change Password</a>
                                <a class="dropdown-item" href="logout">Log Out</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- /HEADER -->
        <div id="menubar"> <!-- Menu Bar -->
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="menu">
                            <li><a href="dashboard">Dashboard</a></li>
                            <li><a href="author">Authors</a></li>
                            <li><a href="publisher">Publishers</a></li>
                            <li><a href="category">Categories</a></li>
                            <li><a href="book">Books</a></li>
                            <li><a href="student">Reg Students</a></li>
                            <li><a href="book-issue">Book Issue</a></li>
                            <li><a href="#">Reports</a></li>
                            <li><a href="setting">Settings</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div> <!-- /Menu Bar -->
        
<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">UpdateCategory</h2>
            </div>
        </div>
        <div class="row">
            <div class="offset-md-3 col-md-6">
                <form class="yourform" action="${pageContext.request.contextPath}/save-category" method="post" autocomplete="off">
                    <div class="form-group">
                        <input type="hidden" class="form-control" name="id" value="${cat.id}" required>
                    </div>
                    <div class="form-group">
                        <label>Category Name</label>
                        <input type="text" class="form-control"  name="name" value="${cat.name}" required>
                    </div>
                    <input type="submit" name="submit" class="btn btn-danger" value="save" required>
                </form>
                            </div>
        </div>
    </div>
</div>

    <div id="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <span>© Copyright 2024 <a href="#">Rahul Durgapal</a></span>
            </div>
        </div>
    </div>
  </div>
  <!-- /FOOTER -->
  <script src="../resources/js/jquery-3.6.0.min.js"></script>
  <script src="../resources/js/popper.min.js"></script>
  <script src="../resources/js/bootstrap.min.js"></script>
</body>
</html>