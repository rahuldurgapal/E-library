
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">Add Student</h2>
            </div>
            <div class="offset-md-7 col-md-2">
                <a class="add-new" href="student">All Students</a>
            </div>
        </div>
        <div class="row">
            <div class="offset-md-3 col-md-6">
                                <form class="yourform" action="save-student" method="post" autocomplete="off">
                    <div class="form-group">
                        <label>Student Name</label>
                        <input type="text" class="form-control" placeholder="Student Name" name="name" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" placeholder="Address" name="address" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Gender</label>
                        <select name="gender" class="form-control">
                            <option value="male" selected>Male</option>
                            <option value="female">Female</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Class</label>
                        <input type="text" class="form-control" placeholder="Class" name="student_class" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Age</label>
                        <input type="number" class="form-control" placeholder="Age" name="age" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="number" class="form-control" placeholder="Phone" name="phone" value="" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" placeholder="Email" name="email" value="" required>
                    </div>
                    <input type="submit" name="save" class="btn btn-danger" value="save" required>
                </form>
            </div>
        </div>
    </div>
</div>



<%@include file="footer.jsp" %>
