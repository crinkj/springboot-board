package board.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.dto.BoardDto;
import board.board.dto.BoardFileDto;

public interface BoardService  {

	List<BoardDto> selectBoardList() throws Exception;	// 게시판 리스트 조회

	void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception; // 게시판 작성
	
	BoardDto selectBoardDetail(int board_idx) throws Exception;  // 리턴 받을값만 받고 조회수증가처리나 매퍼연결은 서비스 임플에서 처리한다.
	
	void updateBoard(BoardDto board) throws Exception; // 게시판 수정 
	
	void deleteBoard(int boardIdx) throws Exception; // 게시판 삭제

	BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception; // 파일 다운로드


}
