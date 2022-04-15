<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<title>Board</title>
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
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end mb-3">
                                    <button class="btn btn-primary me-md-2 mr-3" type="button" onclick="location.href='${path}/board/boardInsert'">글쓰기</button>
                                    <c:if test="${sessionScope.userAuth == 1 }">
	                                    <button class="btn btn-primary" type="button" onclick="boardDelete()">글삭제</button>
                                    </c:if>
                                </div>
                                <form class="row g-3" action="${path }/board/board">
                                <div class="col-auto">
                                    <input type="text" name="searchWord" class="form-control" id="inputPassword2" placeholder="Search" value="${page.searchWord }">
                                </div>
                                <div class="col-auto">
                                    <button type="submit" class="btn btn-primary mb-3">검색</button>
                                </div>
                                </form>
                                <table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead>
                                        <tr style="background-color: whitesmoke;">
                                        	<c:if test="${sessionScope.userAuth == 1 }">
                                            	<th width="5%"></th>
                                            </c:if>
                                            <th width="5%">No</th>
                                            <th width="10%">작성자</th>
                                            <th width="30%">제목</th>
                                            <th width="40%">내용</th>
                                            <th width="20%">수정일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                   		<c:if test="${fn:length(boardList) == 0 }">
                                    		<tr>
                                    			<td colspan="6" class="text-center">글이 없습니다!</td>
                                    		</tr>
                                   		</c:if>
                                    	<c:forEach var="list" items="${boardList }">
	                                        <tr>
	                                        	<c:if test="${sessionScope.userAuth == 1 }">
		                                            <td><input type="checkbox" name="board_idx" value="${list.board_idx }"></td>
	                                        	</c:if>    
	                                            <td>${list.board_idx }</td>
	                                            <td>${list.board_writer }</td>
	                                            <td><a href="${path }/board/boardDetail?board_idx=${list.board_idx}">${list.board_title }</a></td>
	                                            <td>${list.board_text }</td>
	                                            <td>${list.board_mod_date}</td>
	                                        </tr>
                                    	</c:forEach>
                                    </tbody>
                                    <tfoot>
                                        
                                    </tfoot>
                                </table>
                                
                            </div>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center mt-3">
                                <c:choose>
                                	<c:when test="${page.prevPage <= 0 }">
                                	</c:when>
                                	<c:otherwise>
	                                  <li class="page-item">
	                                  	<a class="page-link" href="${path }/board/board?currentPage=${page.prevPage}<c:if test="${page.searchWord != null }">&searchWord=${page.searchWord }</c:if>">Previous</a>
	                                  </li>
                                	</c:otherwise>
                                </c:choose>
                                <c:forEach var="idx" begin="${page.paginationStart}" end="${page.paginationEnd }">
                                	<c:choose>
									  <c:when test="${idx == page.currentPage }">
		                                  <li class="page-item active">
		                                  	<span class="page-link">${idx }</span>
		                                  </li>
									  </c:when>	  
									  <c:otherwise>
                                  		  <li class="page-item">
                                  		  	<a class="page-link" href="${path }/board/board?currentPage=${idx}<c:if test="${page.searchWord != null }">&searchWord=${page.searchWord }</c:if>">${idx }</a>
                                  		  </li>									  	
									  </c:otherwise>                              		
                                	</c:choose>
                                </c:forEach>
                                <c:choose>
                                	<c:when test="${page.paginationEnd >= page.totalPage }">
                                	</c:when>
                                	<c:otherwise>
                                	 	<li class="page-item">
                                	 		<a class="page-link" href="${path }/board/board?currentPage=${page.nextPage}<c:if test="${page.searchWord != null }">&searchWord=${page.searchWord }</c:if>">Next</a>
                                	 	</li>
                                	</c:otherwise>
                                </c:choose>
                                </ul>
                             </nav>
                        </div>
                    </div>

                </div>
            </div>
            <!-- Footer -->
			<c:import url="/WEB-INF/views/include/footer.jsp"/>
        </div>
    </div>

   <script src="${path }/resources/js/board.js"></script>

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