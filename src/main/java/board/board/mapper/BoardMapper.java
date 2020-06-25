package board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	List<BoardDto> selectBoardList() throws Exception; // 게시판 조회
	void insertBoard(BoardDto board) throws Exception; // 게시판 작성
	void updateHitCount(int boardIdx) throws Exception; // 게시판 조회수 증가
	BoardDto selectBoardDetail(int board_idx) throws Exception; // 게시판 상세보기
	
}
