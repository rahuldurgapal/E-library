
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">All Authors</h2>
            </div>
            <div class="offset-md-7 col-md-2">
                <a class="add-new" href="add-author">Add Author</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <c:if test="${done!=null}">
                    <div class="alert alert-success">${done}</div>
                </c:if>
                
                <!-- Display danger message if present -->
     
           <c:if test="${not empty sessionScope['danger-msg']}">
    <div class="alert alert-danger"><c:out value="${sessionScope['danger-msg']}" /></div>
</c:if>

 <!--Display success message if present -->
<c:if test="${not empty sessionScope['success-msg']}">
    <div class="alert alert-success"><c:out value="${sessionScope['success-msg']}" /></div>
</c:if>
<% session.removeAttribute("danger-msg");  session.removeAttribute("success-msg");  %>
    
                <div class="message"></div>
                            <table class="content-table">
                  <thead>
                    <th>S.No</th>
                    <th>Author Name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                  </thead>
                  <tbody>
                      <c:if test="${empty author}" >
                          <tr>
                              <td colspan="4">No Author Found</td>
                          </tr>
                      </c:if>
                          
                      <c:forEach items="${author}" var="auth"  >
                                      <tr>
                      <td>${auth.id}</td>
                      <td>${auth.name}</td>
                      <td class="edit">
                        <a href="update-author/${auth.id}" class="btn btn-success">Edit</a>
                      </td>
                      <td class="delete">
                        <a href="delete-author/${auth.id}" class="btn btn-danger" >Delete</a>
                      </td>
                    </tr>
                      </c:forEach>
                                    
                                      </tbody>
              </table>
              <ul class='pagination admin-pagination'><li class="active"><a href="author.php?page=1">1</a></li><li class=""><a href="author.php?page=2">2</a></li><li class=""><a href="author.php?page=2">Next</a></li></ul>            </div>
        </div>
    </div>
</div>
<!-- jquery -->
<script src="resources/js/jquery-3.6.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
//delete author script
$(".delete-author").on("click", function(){
  var author_id = $(this).data("aid");
  $.ajax({
    url : "delete-author",
    type : "POST",
    data : {author_id: author_id},
    success: function(data){
     
      setTimeout(function(){ window.location.reload(); }, 1000);
    }
  });
});
</script>

<%@include file="footer.jsp" %>
