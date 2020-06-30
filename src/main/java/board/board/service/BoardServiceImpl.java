package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.dto.BoardDto;
import board.board.dto.BoardFileDto;
import board.board.mapper.BoardMapper;
import board.common.FileUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUtils fileUtils;
	
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
	public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardMapper.insertBoard(board);
		List<BoardFileDto> list = fileUtils.parseFileInfo(board.getBoardIdx(), multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false) {
			boardMapper.insertBoardFileList(list);
		}
	}
	/*
	 * 게시판 상세보기 밎 조회수 증가
	 */
	@Override
	public BoardDto selectBoardDetail(int board_idx) throws Exception {
		BoardDto board = boardMapper.selectBoardDetail(board_idx); // 게시글 내용조회
		
		List<BoardFileDto> fileList = boardMapper.selectBoardFileList(board_idx); // 첨부파일 조회
		board.setFileList(fileList); // 첨부파일목록 저장
		
		boardMapper.updateHitCount(board_idx);	// 게시글 조회수 증가

		return board; 
	}

	/*
	 * 게시판 수정
	 */
	@Override
	public void updateBoard(BoardDto board) throws Exception {
		
		boardMapper.updateBoard(board);
		
	}

	/*
	 * 게시판 삭제
	 */
	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		
		boardMapper.deleteBoard(boardIdx);
	}
	
}
