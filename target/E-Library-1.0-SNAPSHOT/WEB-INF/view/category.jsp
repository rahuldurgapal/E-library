<%-- 
    Document   : category
    Created on : 03-May-2024, 7:12:34 PM
    Author     : rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"   %>

<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">All categories</h2>
            </div>
            <div class="offset-md-7 col-md-2">
                <a class="add-new" href="add-category">Add category</a>
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
                      <th>Category Name</th>
                      <th>Edit</th>
                      <th>Delete</th>
                    </thead>
                    <tbody>
                        <c:if test="${empty category}">
                            <tr>
                                <td colspan="4">No Category Found</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${category}" var="cat" >
                                          <tr>
                        <td>${cat.id}</td>
                        <td>${cat.name}</td>
                        <td class="edit">
                          <a href="update-category/${cat.id}" class="btn btn-success">Edit</a>
                        </td>
                        <td class="delete">
                          <a href="delete-category/${cat.id}" class="btn btn-danger" >Delete</a>
                        </td>
                      </tr>
                    </c:forEach>
                                        </tbody>
                </table>
                            </div>
        </div>
    </div>
</div>
<!-- jquery -->
<script src="js/jquery-3.6.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
  //delete category script
  $(".delete-category").on("click", function(){
    var category_id = $(this).data("cid");
    $.ajax({
      url : "delete-category.php",
      type : "POST",
      data : {category_id: category_id},
      success: function(data){
        $(".message").html(data);
        setTimeout(function(){ window.location.reload(); }, 2000);
      }
    });
  });
</script>




<%@include file="footer.jsp" %>