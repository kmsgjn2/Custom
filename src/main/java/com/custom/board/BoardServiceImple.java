package com.custom.board;

import java.io.File;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.custom.paging.BoardPagingVo;

@Service
public class BoardServiceImple implements BoardService {

	@Autowired private BoardDao boardDao;
	
	private static final String file_path = "C:/Project/Custom/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Custom/resources/board img/";
	
	@Override
	public int boardCount(String searchWord) {
		return boardDao.boardCount(searchWord);
	}
	
	@Override
	public List<BoardDto> boardList(BoardPagingVo vo) {
		return boardDao.boardList(vo);
	}
	
	@Override
	public void boardInsert(BoardDto dto, int board_idx) {
		
		// 파일을 받아와 객체 생성
		MultipartFile file = dto.getFile();
		
		if (file.getSize() > 0) {
			
			String file_name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			
			try {
				file.transferTo(new File(file_path + file_name));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setBoard_img_path(file_name);
		}
		
		dto.setBoard_writer_idx(board_idx);
		
		boardDao.boardInsert(dto);
		
	}
	
	@Override
	public BoardDto boardDetail(int board_idx) {
		return boardDao.boardDetail(board_idx);
	}
	
	@Override
	public void boardDetailModi(BoardDto dto) {

		// 파일을 받아와 객체 생성
		MultipartFile file = dto.getFile();
		
		if (file.getSize() > 0) {
			
			String file_name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
			
			try {
				file.transferTo(new File(file_path + file_name));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setBoard_img_path(file_name);
			
		} 
		
		boardDao.boardDetailModi(dto);
		
	}
	
	@Override
	public void fileDelete(int board_idx) {
		boardDao.fileDelete(board_idx);
	}
	
	@Override
	public void boardDelete(int board_idx) {
		boardDao.boardDelete(board_idx);
	}
}
