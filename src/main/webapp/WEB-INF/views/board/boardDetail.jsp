<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="${path }/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
<title>BoardDetail</title>
</head>
<body id="page-top">
   <div id="wrapper">
		<c:import url="/WEB-INF/views/include/sidebar.jsp"/>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
				<c:import url="/WEB-INF/views/include/topbar.jsp"/>
                <div class="container-fluid">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <tbody>
                                        <tr>
                                            <th width="100px" style="background-color: whitesmoke;">게시판 타입</th>
                                            <td colspan="2">자유게시판</td>
                                        </tr>
                                        <tr>
                                          <th style="background-color: whitesmoke;">작성자</th>
                                          <td colspan="2">${dto.board_writer }</td>
                                        </tr>
                                        <tr>
                                          <th style="background-color: whitesmoke;">제목</th>
                                          <td colspan="2">${dto.board_title }</td>
                                        </tr>
                                        <tr>
                                          <th style="background-color: whitesmoke;">내용</th>
                                          <td colspan="2">${dto.board_text }</td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
	                                    <c:if test="${dto.board_img_path != null}">
	                                      <tr>
	                                        <th style="background-color: whitesmoke;">파일</th>
	                                        <td colspan="2"><img src="${path }/resources/board img/${dto.board_img_path}"></td>
	                                      </tr>
	                                    </c:if>
                                    </tfoot>
                                </table>
                                <div class="d-grid gap-2 d-md-block">
                                  <button class="btn btn-primary" type="button" onclick="location.href='${path}/board/board'">목록으로</button>
                                  <c:if test="${sessionScope.userIdx == dto.board_writer_idx }">
	                                  <button class="btn btn-success" type="button" onclick="location.href='${path}/board/boardDetailModi?board_idx=${dto.board_idx }'">수정</button>
	                                  <button class="btn btn-danger" type="button" onclick="location.href='${path}/board/boardDelete?board_idx=${dto.board_idx }'">삭제</button>
                                  </c:if>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- Footer -->
			<c:import url="/WEB-INF/views/include/footer.jsp"/>
        </div>
    </div>
   <!-- Begin Page Content -->
   <!-- Bootstrap core JavaScript-->
   <script src="${path }/resources/vendor/jquery/jquery.min.js"></script>
   <script src="${path }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

   <!-- Core plugin JavaScript-->
   <script src="${path }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

   <!-- Custom scripts for all pages-->
   <script src="${path }/resources/js/sb-admin-2.min.js"></script>

   <!-- Page level plugins -->
   <script src="${path }/resources/vendor/datatables/jquery.dataTables.min.js"></script>
   <script src="${path }/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

   <!-- Page level custom scripts -->
   <script src="${path }/resources/js/demo/datatables-demo.js"></script>
</body>
</html>