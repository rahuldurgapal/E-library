<%-- 
    Document   : add-book
    Created on : 04-May-2024, 11:03:11 AM
    Author     : rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">Add Book</h2>
            </div>
            <div class="offset-md-7 col-md-2">
                <a class="add-new" href="book.php">All Books</a>
            </div>
        </div>
        <div class="row">
            <div class="offset-md-3 col-md-6">
                <form class="yourform" action="save-book" method="post" autocomplete="off">
                    <div class="form-group">
                        <label>Book Name</label>
                        <input type="text" class="form-control" placeholder="Book Name" name="name" value="" required>
                    </div>

                    <div class="form-group">
                        <label>Book Quanity</label>
                        <input type="number" class="form-control" placeholder="Book Quantity" name="quantity" value="" required>
                    </div>

                    <div class="form-group">
                        <label>Category</label>
                        <select class="form-control" name="category.id" required>

                            <option value="">Select Category</option>
                            <c:forEach items="${category}" var="cat" >
                                <option value="${cat.id}">${cat.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Author</label>
                        <select class="form-control" name="author.id" required >
                            <option value="">Select Author</option>
                            <c:forEach items="${author}" var="auth" >
                                <option value="${auth.id}">${auth.name}</option>
                            </c:forEach>          </select>
                    </div>
                    <div class="form-group">
                        <label>Publisher</label>
                        <select class="form-control" name="publisher.id" required>
                            <option value="">Select Publisher</option>
                            <c:forEach items="${publisher}" var="pub" >
                                <option value="${pub.id}">${pub.name}</option>
                            </c:forEach>          </select>
                    </div>
                    <input type="submit" name="save" class="btn btn-danger" value="save" required>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
