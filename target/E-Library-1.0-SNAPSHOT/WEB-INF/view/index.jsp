<%-- 
    Document   : index
    Created on : 01-May-2024, 8:54:00 PM
    Author     : rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/style.css"/>
        <link rel="stylesheet" href="resources/css/bootstrap.css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <div id="wrapper-admin">
            <div class="container">
                <div class="row">
                    <div class="offset-md-4 col-md-4">
                        <div class="logo border border-danger">
                            <img src="resources/images/library.png" alt="">
                        </div>
                        <form class="yourform" action="login-process" method="post">
                            <h3 class="heading">Admin Login</h3>
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" name="username" class="form-control" value="" required>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" name="password" class="form-control" value="" required>
                            </div>
                            <input type="submit" name="login" class="btn btn-danger" value="login" />
                        </form>
                        <c:if test="${error!=null}" >
                            <div class='alert alert-danger'>${error}</div>
                            <%  session.removeAttribute("error"); %>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>