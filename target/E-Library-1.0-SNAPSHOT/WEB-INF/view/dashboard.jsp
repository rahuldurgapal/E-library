<%-- 
    Document   : dashboard
    Created on : 02-May-2024, 9:06:40 PM
    Author     : rahul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div id="admin-content">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h2 class="admin-heading">Dashboard</h2>
            </div>
        </div>
        <div class="row">
          <div class="col-md-3 mb-4">
                      <div class="card" style="width: 14rem; margin: 0 auto;">
              <div class="card-body text-center">
                <p class="card-text">${auth}</p>
                <h5 class="card-title mb-0">Authors Listed</h5>
              </div>
            </div>
                    </div>
          <div class="col-md-3">
                          <div class="card" style="width: 14rem; margin: 0 auto;">
                <div class="card-body text-center">
                  <p class="card-text">${pub}</p>
                  <h5 class="card-title mb-0">Publishers Listed</h5>
                </div>
              </div>
                        </div>
            <div class="col-md-3">
                          <div class="card" style="width: 14rem; margin: 0 auto;">
                <div class="card-body text-center">
                  <p class="card-text">${cat}</p>
                  <h5 class="card-title mb-0">Categories Listed</h5>
                </div>
              </div>
                        </div>
            <div class="col-md-3">
                          <div class="card" style="width: 14rem; margin: 0 auto;">
                <div class="card-body text-center">
                  <p class="card-text">${book}</p>
                  <h5 class="card-title mb-0">Books Listed</h5>
                </div>
              </div>
                        </div>
            <div class="col-md-3">
                          <div class="card" style="width: 14rem; margin: 0 auto;">
                <div class="card-body text-center">
                  <p class="card-text">${std}</p>
                  <h5 class="card-title mb-0">Register Students</h5>
                </div>
              </div>
                        </div>
            <div class="col-md-3">
                          <div class="card" style="width: 14rem; margin: 0 auto;">
                <div class="card-body text-center">
                  <p class="card-text">${bi}</p>
                  <h5 class="card-title mb-0">Book Issued</h5>
                </div>
              </div>
                        </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>