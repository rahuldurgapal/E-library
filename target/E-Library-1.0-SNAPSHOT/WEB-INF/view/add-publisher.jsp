<%-- 
    Document   : add-publisher
    Created on : 03-May-2024, 8:20:25 PM
    Author     : rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">Add Publisher</h2>
            </div>
            <div class="offset-md-7 col-md-2">
              <a class="add-new" href="publisher">All Publishers</a>
            </div>
        </div>
        <div class="row">
            <div class="offset-md-3 col-md-6">
                <form class="yourform" action="save-publisher" method="post" autocomplete="off">
                    <div class="form-group">
                        <label>Publisher Name</label>
                        <input type="text" class="form-control" placeholder="publisher Name" name="name" value="" >
                    </div>
                    <input type="submit" name="save" class="btn btn-danger" value="save" >
                </form>
                            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
