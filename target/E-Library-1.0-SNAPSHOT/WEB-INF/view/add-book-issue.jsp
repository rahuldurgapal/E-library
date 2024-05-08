<%-- 
    Document   : add-book-issue
    Created on : 04-May-2024, 5:32:31 PM
    Author     : rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<div id="admin-content">
  <div class="container">
    <div class="row">
      <div class="col-md-3">
          <h2 class="admin-heading">Add Book Issue</h2>
      </div>
      <div class="offset-md-7 col-md-2">
        <a class="add-new" href="book-issue">All Issue List</a>
      </div>
    </div>
    <div class="row">
      <div class="offset-md-3 col-md-6">
                <form class="yourform" action="save-book-issue" method="post" autocomplete="off">
          <div class="form-group">
              <label>Student Name</label>
              <select class="form-control" name="student.id" required>
                <option value="">Select Name</option>
                <c:forEach items="${student}" var="s" >
                <option value="${s.id}">${s.name}</option>     
                </c:forEach>
              </select>
          </div>
          <div class="form-group">
              <label>Book Name</label>
              <select class="form-control" name="book.id" required>
                <option value="">Select Name</option>
                <c:forEach items="${book}" var="b" >
                <option value="${b.id}">${b.name}</option>     
                </c:forEach>
              </select>
          </div>
          <input type="submit" name="save" class="btn btn-danger" value="save" required>
        </form>
      </div>
    </div>
  </div>
</div>

<%@include file="footer.jsp" %>