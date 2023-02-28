package com.study.app.service;

import com.study.app.domain.Board;
import com.study.app.dto.board.BoardDto;
import com.study.app.dto.user.UserDto;
import com.study.app.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    //게시판 리스트
    @Transactional(readOnly = true)
    public Page<BoardDto> BoardList(Pageable pageable) {
       return boardRepository.findAll(pageable).map(BoardDto::from);
    }

    // 게시물 클릭하면 조회수 1 증가
    @Transactional
    public Integer updateViewCnt(Integer board_no) {
       return boardRepository.updateViewCnt(board_no);
    }

    // 게시글 하나 보여주기
    @Transactional
    public BoardDto boardDetail(Integer board_no) {
        return boardRepository.findById(board_no)
                .map(BoardDto::from)
                .orElseThrow(()-> new EntityNotFoundException("게시글이 없습니다. " + board_no)); // 예외 처리
    }

    // 게시글 생성
    @Transactional
    public void createBoard(BoardDto boardDto , UserDto user) {
        boardRepository.save(boardDto.toCreateBoardEntity(user.toCreateEntity()));
    }

    // 게시글 수정
    @Transactional
    public void updateBoard(BoardDto boardDto,UserDto user) {
        boardRepository.save(boardDto.toUpdateBoardEntity(user.toCreateEntity()));
    }

    // 게시글 삭제
    @Transactional
    public void deleteBoard(Integer board_no) {
        Board board = boardRepository.findById(board_no)
                                     .orElseThrow(()-> new EntityNotFoundException("게시글이 없습니다. " + board_no));
        boardRepository.delete(board);
    }
}
