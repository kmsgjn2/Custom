package com.custom.board;

import org.springframework.web.multipart.MultipartFile;

public class BoardDto {

	private int board_idx;
	private String board_title;
	private String board_text;
	private int board_writer_idx;
	private String board_reg_date;
	private String board_mod_date;
	private String board_img_path;
	private String board_del_yn;
	// 작성자
	private String board_writer;
	// 멀티파일 파일을 저장
	private MultipartFile file;

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_text() {
		return board_text;
	}

	public void setBoard_text(String board_text) {
		this.board_text = board_text;
	}

	public int getBoard_writer_idx() {
		return board_writer_idx;
	}

	public void setBoard_writer_idx(int board_writer_idx) {
		this.board_writer_idx = board_writer_idx;
	}

	public String getBoard_reg_date() {
		return board_reg_date;
	}

	public void setBoard_reg_date(String board_reg_date) {
		this.board_reg_date = board_reg_date;
	}

	public String getBoard_mod_date() {
		return board_mod_date;
	}

	public void setBoard_mod_date(String board_mod_date) {
		this.board_mod_date = board_mod_date;
	}

	public String getBoard_img_path() {
		return board_img_path;
	}

	public void setBoard_img_path(String board_img_path) {
		this.board_img_path = board_img_path;
	}

	public String getBoard_del_yn() {
		return board_del_yn;
	}

	public void setBoard_del_yn(String board_del_yn) {
		this.board_del_yn = board_del_yn;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

}
