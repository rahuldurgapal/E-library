

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">All Books</h2>
            </div>
            <div class="offset-md-7 col-md-2">
                <a class="add-new" href="add-book">Add Book</a>
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
                    <th>Book Name</th>
                    <th>Category</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>Status</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                        <c:if test="${empty book}" >
                            <tr>
                                <td colspan="8">No Book Found</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${book}" var="b" >
                            <tr>
                                <td class="id">${b.id}</td>
                                <td>${b.name}</td>
                                <td>${b.category.name}</td>
                                <td>${b.author.name}</td>
                                <td>${b.publisher.name}</td>
                                <td>
                                    <c:if test="${b.status==false}">
                                        <span class='badge badge-danger'>Not Available</span>
                                    </c:if>
                                    <c:if test="${b.status == true}">
                                        <span class='badge badge-success'>Available</span> 
                                    </c:if>
                                </td>
                                <td class="edit">
                                    <a href="update-book/${b.id}" class="btn btn-success">Edit</a>
                                </td>
                                <td class="delete">
                                    <a href="delete-book/${b.id}" class="btn btn-danger" >Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <ul class='pagination admin-pagination'><li class="active"><a href="book.php?page=1">1</a></li><li class=""><a href="book.php?page=2">2</a></li><li class=""><a href="book.php?page=2">Next</a></li></ul>          </div>
        </div>
    </div>
</div>
<!-- jquery -->
<script src="resources/js/jquery-3.6.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
//delete book script
    $(".delete-book").on("click", function () {
        var book_id = $(this).data("bid");
        $.ajax({
            url: "delete-book.php",
            type: "POST",
            data: {book_id: book_id},
            success: function (data) {
                $(".message").html(data);
                setTimeout(function () {
                    window.location.reload();
                }, 2000);
            }
        });
    });
</script>

<%@include file="footer.jsp" %>
