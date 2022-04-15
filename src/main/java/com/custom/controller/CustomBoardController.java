package com.custom.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.custom.board.BoardDto;
import com.custom.board.BoardService;
import com.custom.paging.BoardPagingVo;

@Controller
@RequestMapping("/board")
public class CustomBoardController {

	@Autowired private BoardService boardService;
	
	// 게시판 페이지 이동
	@GetMapping("/board")
	public ModelAndView board(@RequestParam(required = false) String searchWord,
							  @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		ModelAndView mav = new ModelAndView("board/board");
		
		int boardCount = boardService.boardCount(searchWord);
		
		BoardPagingVo vo = new BoardPagingVo(currentPage, boardCount, searchWord);
		
		mav.addObject("page", vo);
		mav.addObject("boardList", boardService.boardList(vo));
		
		return mav;
	}
	
	// 게시물 작성 페이지 이동
	@GetMapping("/boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}	
	
	// 게시물 작성
	@PostMapping("/boardInsert")
	public ModelAndView boardInsertAction(BoardDto dto, HttpSession session) {
		ModelAndView mav = new ModelAndView("msg/msg");
			
		boardService.boardInsert(dto, (int) session.getAttribute("userIdx"));
		
		mav.addObject("msg", "게시글 저장 성공!");
		mav.addObject("url", "/board/boardDetail?board_idx=" + dto.getBoard_idx());
		
		return mav;
	}
	
	// 임시 파일 저장
	@ResponseBody
	@PostMapping("/boardFile")
	public void boardFile(MultipartFile file) {
		
		String file_path = "C:/Project/Custom/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/temp/";
		
		if (file.getSize() > 0) {
			String file_name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			
			try {
				File fileSave = new File(file_path + file_name);
				
				file.transferTo(fileSave);	
				
				fileSave.deleteOnExit();
				
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}
	
	// 게시판 본문 보기
	@GetMapping("/boardDetail")
	public ModelAndView boardDetail(@RequestParam int board_idx) {
		ModelAndView mav = new ModelAndView("board/boardDetail");
		
		mav.addObject("dto", boardService.boardDetail(board_idx));
		
		return mav;
	}	
	
	// 게시판 수정 페이지 이동
	@GetMapping("/boardDetailModi")
	public ModelAndView boardDetailModi(@RequestParam int board_idx) {
		ModelAndView mav = new ModelAndView("board/boardDetailModi");
		
		mav.addObject("dto", boardService.boardDetail(board_idx));
		
		return mav;
	}	
	
	// 게시판 수정
	@PostMapping("/boardDetailModi")
	public ModelAndView boardDetailModiAction(BoardDto dto) {
		ModelAndView mav = new ModelAndView("msg/msg");
		
		boardService.boardDetailModi(dto);
		
		mav.addObject("msg", "게시글 수정 성공!");
		mav.addObject("url", "/board/boardDetail?board_idx=" + dto.getBoard_idx());
		
		return mav;
	}
	
	// 파일 삭제
	@ResponseBody
	@RequestMapping("/fileDelete")
	public void fileDelete(@RequestParam String img_path, @RequestParam int board_idx) {
		
		String path = "C:/Project/Custom/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Custom/resources/board img/";
		
		File file = new File(path + img_path);
		
		System.out.println(file.exists());
		
		if (file.exists()) {
			file.delete();
			boardService.fileDelete(board_idx);
		}
	}	
	
	// 게시물 삭제
	@RequestMapping("/boardDelete")
	public ModelAndView boardDelete(@RequestParam int board_idx) {
		ModelAndView mav = new ModelAndView("msg/msg");
		
		boardService.boardDelete(board_idx);
		
		mav.addObject("msg", "게시글 삭제 성공!");
		mav.addObject("url", "/board/board");
		
		return mav;
	}
	
	// 관리자가 게시물 삭제
	@ResponseBody
	@PostMapping("/adminboardDelete")
	public void adminBoardDelte(@RequestParam(value = "checkBoxArr[]") int [] checkBoxArr) {

		for (int str : checkBoxArr) {
			// 반복문으로 게시물 삭제
			int idx = str;
			boardService.boardDelete(idx);
		}
	}
}
