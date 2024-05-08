
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h2 class="admin-heading">All Students</h2>
            </div>
            <div class="offset-md-6 col-md-2">
                <a class="add-new" href="add-student">Add Student</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <c:if test="${done!=null}" >
        <div class="alert alert-success">${done}</div>
    </c:if>
                             <c:if test="${not empty sessionScope['danger-msg']}">
    <div class="alert alert-danger"><c:out value="${sessionScope['danger-msg']}" /></div>
</c:if>

 <!--Display success message if present -->
<c:if test="${not empty sessionScope['success-msg']}">
    <div class="alert alert-success"><c:out value="${sessionScope['success-msg']}" /></div>
</c:if>
<% session.removeAttribute("danger-msg");  session.removeAttribute("success-msg");  %>  
                <table class="content-table">
                    <thead>
                      <th>S.No</th>
                      <th>Student Name</th>
                      <th>Gender</th>
                      <th>Phone</th>
                      <th>Email</th>
                      <th>View</th>
                      <th>Edit</th>
                      <th>Delete</th>
                    </thead>
                    <tbody>
                        <c:if test="${empty student}">
                            <tr>
                                <td colspan="8">No Student Found</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${student}" var="s" >
                                            <tr>
                        <td class="id">${s.id}</td>
                        <td>${s.name}</td>
                        <td>${s.gender}</td>
                        <td>${s.phone}</td>
                        <td>${s.email}</td>
                        <td class="view">
                          <button data-sid='${s.id}'  class="btn btn-primary view-btn">View</button>
                        </td>
                        <td class="edit">
                          <a href="update-student/${s.id}" class="btn btn-success">Edit</a>
                        </td>
                        <td class="delete">
                          <a href="delete-student/${s.id}" class="btn btn-danger">Delete</a>
                        </td>
                      </tr>
                      
                    </c:forEach>
                                        </tbody>
                </table>
                <div id="modal">
                <div id="modal-form">
                  <table cellpadding="10px" width="100%"></table>
                  <div id="close-btn">X</div>
                </div>
              </div>
              <ul class='pagination admin-pagination'><li class="active"><a href="student.php?page=1">1</a></li><li class=""><a href="student.php?page=2">2</a></li><li class=""><a href="student.php?page=2">Next</a></li></ul>            </div>
        </div>
    </div>
</div>
<script src="resources/js/jquery-3.6.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
      //Show shudent detail
      $(".view-btn").on("click", function(){
        var student_id = $(this).data("sid");
        $.ajax({
          url : "view-student",
          type : "POST",
          data : {student_id: student_id},
          success: function(data){
            $("#modal-form table").html(data);
            $("#modal").show();
          }
        });
      });

      //Hide modal box
      $('#close-btn').on("click",function(){
        $("#modal").hide();
      });

      //delete student script
      $(".delete-student").on("click", function(){
        var s_id = $(this).data("sid");
        $.ajax({
          url : "delete-student.php",
          type : "POST",
          data : {sid: s_id},
          success: function(data){
            $(".message").html(data);
            setTimeout(function(){ window.location.reload(); }, 2000);
          }
        });
      });
</script>


<%@include file="footer.jsp" %>
