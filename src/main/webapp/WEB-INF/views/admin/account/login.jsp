<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Đăng nhập hệ thống</title>
<!-- HTML5 Shim and Respond.js IE10 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 10]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
<!-- Meta -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="#">
<meta name="keywords" content="Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
<meta name="author" content="#">
<!-- Favicon icon -->
<link rel="icon" href="<c:url value='/statics/admin/assets/images/favicon.ico'/>" type="image/x-icon">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,800" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<c:url value='/statics/admin/bower_components/bootstrap/css/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css"	href="<c:url value='/statics/admin/assets/css/style.css'/>"></head>

<body class="fix-menu">
    <div></div>
    <!-- Pre-loader end -->
    <section class="login-block">
      <!-- Container-fluid starts -->
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-12">
            <c:url value="/admin/loginprocessing" var="action" />
            <!-- Authentication card start -->
            <form action="${ action }" method="post" class="md-float-material form-material">
              <div class="text-center">
                <img src="<c:url value='/statics/admin/assets/images/logo.png'/>" alt="logo">
              </div>
              <div class="auth-box card">
                <div class="card-block">
                  <div class="row m-b-20">
                    <div class="col-md-12">
                      <h3 class="text-center txt-primary">Đăng nhập</h3>
                    </div>
                  </div>
                  <div class="form-group form-primary">
                    <label for="">Email</label>
                    <input type="text" name="email" class="form-control">
                  </div>
                  <div class="form-group form-primary">
                    <label for="">Mật khẩu</label> 
                    <input type="password" name="password" class="form-control">
                  </div>
                  <div class="row m-t-30">
                    <div class="col-md-12">
                      <button type="submit" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">LOGIN</button>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <script type="text/javascript" src="<c:url value='/statics/admin/bower_components/jquery/js/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/statics/admin/bower_components/jquery-ui/js/jquery-ui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/statics/admin/bower_components/popper.js/js/popper.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/statics/admin/bower_components/bootstrap/js/bootstrap.min.js'/>"> </script>
</body>
</html>
