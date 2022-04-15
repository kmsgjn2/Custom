package com.custom.board;

import java.util.List;

import com.custom.paging.BoardPagingVo;

public interface BoardService {

	// 총 게시물
	public int boardCount(String searchWord);
	
	// 게시물 목록
	public List<BoardDto> boardList(BoardPagingVo vo);
	
	// 게시물 작성
	public void boardInsert(BoardDto dto, int board_idx);
	
	// 게시물 본문 보기
	public BoardDto boardDetail(int board_idx);
	
	// 게시물 수정
	public void boardDetailModi(BoardDto dto);
	
	// 게시물 수정에서 파일 삭제
	public void fileDelete(int board_idx);	
	
	// 게시물 삭제
	public void boardDelete(int board_idx);
}
