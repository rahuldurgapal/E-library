
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">All Book Issue</h2>
            </div>
            <div class="offset-md-6 col-md-3">
                <a class="add-new" href="add-book-issue">Add Book Issue</a>
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
                    <th>Student Name</th>
                    <th>Book Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Issue Date</th>
                    <th>Return Date</th>
                    <th>Status</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>
                    <tbody>
                        <c:if test="${empty bookIssue}">
                            <tr>
                                <td colspan="10">No book-issue found</td>
                            </tr>
                        </c:if>
                         
                        <c:forEach items="${bookIssue}" var="bi" >
                            <tr >

                                <td>${bi.id}</td>
                                <td>${bi.student.name}</td>
                                <td>${bi.book.name} </td>
                                <td>${bi.student.phone}</td>
                                <td>${bi.student.email}</td>
                                <td>
                                    <!-- Format curr_date -->
                                    <fmt:parseDate value="${bi.curr_date}" var="date" pattern="yyyy-MM-dd" />
                                    <fmt:formatDate value="${date}" var="curr_date" pattern="dd MMMM, yyyy" />
                                    ${curr_date}

                                </td>
                                <td>
                                    <!-- Format return_date (assuming you have a 'return_date' attribute) -->
                                    <fmt:parseDate value="${bi.return_date}" var="date" pattern="yyyy-MM-dd" />
                                    <fmt:formatDate value="${date}" var="return_date" pattern="dd MMMM, yyyy" />
                                    ${return_date}
                                </td>
                                <td>
                                    <c:if test="${bi.status==false}">
                                        <span class='badge badge-danger'>Issued</span> 
                                    </c:if>

                                    <c:if test="${bi.status==true}">
                                        <span class='badge badge-success'>Returned</span> 
                                    </c:if>
                                </td>
                                <td class="edit">
                                    <a href="update-book-issue/${bi.id}"  class="btn btn-success">Edit</a>
                                </td>
                                <td class="delete">
                                    <a href="delete-book-issue/${bi.id}" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                         

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
