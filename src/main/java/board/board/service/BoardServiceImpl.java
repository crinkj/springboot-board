package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	/*
	 * 게시판 리스트 조회
	 */
	@Override
	public List<BoardDto> selectBoardList() throws Exception{
		
		return boardMapper.selectBoardList();
	}

	/*
	 * 게시판 작성
	 */
	@Override
	public void insertBoard(BoardDto board) throws Exception {
		
		boardMapper.insertBoard(board);
		
	}
	/*
	 * 게시판 상세보기 밎 조회수 증가
	 */
	@Override
	public BoardDto selectBoardDetail(int board_idx) throws Exception {
		boardMapper.updateHitCount(board_idx);	// 게시글 조회수 증가
		
		BoardDto board = boardMapper.selectBoardDetail(board_idx); // 게시글 내용조회
		
		return board; 
	}
}
