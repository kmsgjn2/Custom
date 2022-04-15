<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
<title>Custom</title>
</head>
<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
   	    <!-- Sidebar -->
		<c:import url="/WEB-INF/views/include/sidebar.jsp"/>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
				<c:import url="/WEB-INF/views/include/topbar.jsp"/>
            </div>
            <!-- Footer -->
			<c:import url="/WEB-INF/views/include/footer.jsp"/>
        </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="${path }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${path }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${path }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${path }/resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${path }/resources/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${path }/resources/js/demo/chart-area-demo.js"></script>
    <script src="${path }/resources/js/demo/chart-pie-demo.js"></script>
</body>
</html>