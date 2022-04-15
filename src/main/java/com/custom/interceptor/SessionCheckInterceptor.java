package com.custom.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.custom.board.BoardDto;
import com.custom.board.BoardService;

public class SessionCheckInterceptor implements HandlerInterceptor {

	@Autowired BoardService boardService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		// 게시글 회원 인덱스 dto에 저장
		BoardDto dto = boardService.boardDetail(Integer.parseInt(request.getParameter("board_idx")));
		
		if (session.getAttribute("userIdx") == null || (int) session.getAttribute("userIdx") != dto.getBoard_writer_idx()) {
			// 유저 세션이 없고 글 작성자와 세션이 맞지 않으면 에러 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/msg/error");
			return false;
		}
		
		return true;
	}
}
