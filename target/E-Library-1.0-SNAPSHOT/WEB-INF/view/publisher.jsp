<%-- 
    Document   : publisher
    Created on : 03-May-2024, 8:20:18 PM
    Author     : rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">All Publishers</h2>
            </div>
            <div class="offset-md-7 col-md-2">
                <a class="add-new" href="add-publisher">Add Publisher</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                
                <c:if test="${done!=null}">
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
                    <th>Publisher Name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                  </thead>
                  <tbody>
                      <c:if test="${empty publisher}">
                          <tr>
                              <td colspan="4">No Publisher Found</td>
                          </tr>
                      </c:if>
                      <c:forEach items="${publisher}" var="p" >
                                        <tr>
                      <td>${p.id}</td>
                      <td>${p.name}</td>
                      <td class="edit">
                        <a href="update-publisher/${p.id}" class="btn btn-success">Edit</a>
                      </td>
                      <td class="delete">
                        <a href="delete-publisher/${p.id}" class="btn btn-danger" >Delete</a>
                      </td>
                    </tr>
                      </c:forEach>
                                 
                                    </tbody>
              </table>
              <ul class='pagination admin-pagination'><li class="active"><a href="publisher.php?page=1">1</a></li><li class=""><a href="publisher.php?page=2">2</a></li><li class=""><a href="publisher.php?page=2">Next</a></li></ul>            </div>
        </div>
    </div>
</div>
<script src="js/jquery-3.6.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
    //delete publisher script
  $(".delete-publisher").on("click", function(){
    var publisher_id = $(this).data("pid");
    $.ajax({
      url : "delete-publisher.php",
      type : "POST",
      data : {publisher_id: publisher_id},
      success: function(data){
        //alert(data);
        $(".message").html(data);
        setTimeout(function(){ window.location.reload(); }, 2000);
      }
    });
  });
</script>

<%@include file="footer.jsp" %>
