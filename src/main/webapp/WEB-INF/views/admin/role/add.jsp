<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-body">
  <div class="row">
    <div class="col-md-12 mb-2">
      <div class="page-header-breadcrumb">
        <ul class="breadcrumb-title">
          <li class="breadcrumb-item"><a href="/admin"> <i
              class="feather icon-home"></i> Trang chủ </a></li>
          <li class="breadcrumb-item"><a href="#!">Thêm mới Role</a></li>
        </ul>
      </div>
    </div>
    <div class="col-sm-12">
      <div class="card">
        <div class="card-header">
          <h2 class="text-uppercase text-center">Thêm mới Role</h2>
        </div>
        <div class="card-block">
          <c:url value="/admin/role/add" var="action" />
          <mvc:form action="${ action }" method="post" modelAttribute="role">
            <div class="row">
              <div class="col-md-6">
<!--                 <div class="form-group"> -->
<!--                   <label>Role ID</label> -->
<%--                   <mvc:input type="text" path="roleId"    cssClass="form-control" /> --%>
<%--                   <mvc:errors path="roleId" cssClass="text-danger" /> --%>
<!--                 </div> -->
                <div class="form-group">
                  <label>Role Name</label>
                  <mvc:input type="text" path="name"    cssClass="form-control" />
                  <mvc:errors path="name" cssClass="text-danger" />
                </div>
                <div class="form-group">
                  <label>Description</label>
                  <mvc:input  type="text" path="description"  cssClass="form-control" />
                  <mvc:errors path="description" cssClass="text-danger" />
                </div>
            </div>
            </div>
            <div class="col-12 mt-3">
              <div class="form-group">
                <button type="submit" class="btn btn-primary m-b-0">Lưu  lại</button>
                <a href="#" class="btn btn-secondary text-white">Quay lại</a>
              </div>
            </div>
        </mvc:form>
        </div>
      </div>
    </div>
  </div>
</div>