package com.custom.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.custom.paging.BoardPagingVo;

@Repository("board")
public class BoardDaoImple implements BoardDao {

	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int boardCount(String searchWord) {
		return sqlSessionTemplate.selectOne("boardCount", searchWord);
	}
	
	@Override
	public List<BoardDto> boardList(BoardPagingVo vo) {
		return sqlSessionTemplate.selectList("boardList", vo);
	}
	
	@Override
	public void boardInsert(BoardDto dto) {
		sqlSessionTemplate.insert("boardInsert", dto);
	}
	
	@Override
	public BoardDto boardDetail(int board_idx) {
		return sqlSessionTemplate.selectOne("boardDetail", board_idx);
	}
	
	@Override
	public void boardDetailModi(BoardDto dto) {
		sqlSessionTemplate.update("boardDetailModi", dto);
	}
	
	@Override
	public void fileDelete(int board_idx) {
		sqlSessionTemplate.update("fileDelete", board_idx);
	}
	
	@Override
	public void boardDelete(int board_idx) {
		sqlSessionTemplate.delete("boardDelete", board_idx);
	}
}
