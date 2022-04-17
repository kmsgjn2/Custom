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
<link rel="stylesheet" type="text/css" media="screen" href="http://trirand.com/blog/jqgrid/themes/redmond/jquery-ui-1.8.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="http://trirand.com/blog/jqgrid/themes/ui.multiselect.css" />
<script src="http://trirand.com/blog/jqgrid/js/jquery.js" type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery-ui-1.8.1.custom.min.js" type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.layout.js" type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/ui.multiselect.js" type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.tablednd.js" type="text/javascript"></script>
<script src="http://trirand.com/blog/jqgrid/js/jquery.contextmenu.js" type="text/javascript"></script>  
<title>UserInfo</title>
</head>
<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
   	    <!-- Sidebar -->
		<c:import url="/WEB-INF/views/include/sidebar.jsp"/>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
		<c:import url="/WEB-INF/views/include/topbar.jsp"/>
            <!-- Main Content -->
            <div id="content">
            	  <table id="list"></table> 
				  <div id="pager"></div> 
				  <script>
				  	let userArr = new Array();
				 	<c:forEach var="list" items="${list}">
				    	userArr.push({
				    		name: "${list.custom_user_name}",
				    		nick: "${list.custom_user_nick}",
				    		email: "${list.custom_user_email}",
				    		phone: "${list.custom_user_phone}",
				    		address: "${list.custom_user_address}",
				    		auth: "${list.custom_user_auth}",
				    		del_yn: "${list.custom_user_del_yn}"
			    		});
				    </c:forEach>
		 
			    	$(document).ready(function() {
			      		$("#list").jqGrid({
			    			datatype: 'local',
				        	data: userArr,
			        		styleUI: 'Foundation',
			        		colNames: ['이름', '닉네임', '메일', '휴대폰번호', '주소', '유저권한', '탈퇴여부'],
			        		colModel: [
			          			{name: 'name', label : 'name'},
			          			{name: 'nick', label : 'nick'},
			          			{name: 'email', label : 'email'},
			          			{name: 'phone', label : 'phone'},
			          			{name: 'address', label : 'address'},
			          			{name: 'auth', label : 'auth'},
			          			{name: 'del_yn', label : 'del_yn'},
				        	],
			        		caption : '회원목록',
			        		autowidth: true,
			        		height: 'auto',
			        		rowNum: 1,
			        		pager: '#pager'
			      		});
			    	});
				  </script>
            </div>
            <!-- Footer -->
			<c:import url="/WEB-INF/views/include/footer.jsp"/>
        </div>
    </div>
    
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