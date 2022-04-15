<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<title>Register</title>
</head>
<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form class="user" id="register" action="${path }/user/register" method="post">
								<div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="name"
                                           name="custom_user_name" placeholder="Name">
                                        <div class="pl-2 pt-1" id="name_check"></div>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="birth"
                                           name="custom_user_birth" placeholder="Birth ex)20000101">
                                        <div class="pl-2 pt-1" id="birth_check"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="nick"
                                       name="custom_user_nick" placeholder="Nickname">
                                    <div class="pl-2 pt-1" id="nick_check"></div>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="email"
                                       name="custom_user_email" placeholder="Email Address">
                                    <div class="pl-2 pt-1" id="email_check"></div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="address"
                                       name="custom_user_address" placeholder="Address">
                                    <div class="pl-2 pt-1" id="address_check"></div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="phone"
                                       name="custom_user_phone" placeholder="Phone ex)010-0000-0000">
                                    <div class="pl-2 pt-1" id="phone_check"></div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="pswd"
                                           name="custom_user_pswd" placeholder="Password">
                                        <div class="pl-2 pt-1" id="pswd_check"></div>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" id="repeat_pswd"
                                            name="" placeholder="Repeat Password">
                                        <div class="pl-2 pt-1" id="repeat_pswd_check"></div>
                                    </div>
                                </div>
                                <a class="btn btn-primary btn-user btn-block" onclick="return join_check()">
                                    Register Account
                                </a>
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="${path }/user/forgetPswd">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="${path }/user/login">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  
	<script src="${path }/resources/js/register.js"></script>

    <!-- Bootstrap core JavaScript-->
    <script src="${path }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${path }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${path }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${path }/resources/js/sb-admin-2.min.js"></script>

</body>
</html>