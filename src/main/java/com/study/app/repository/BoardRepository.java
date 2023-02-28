package com.study.app.repository;

import com.study.app.domain.Board;
import com.study.app.dto.board.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    // 조회수 1 증가
    @Modifying
    @Query(value = "UPDATE board as b set b.view_cnt = b.view_cnt + 1 where b.board_no = :board_no",nativeQuery = true)
    Integer updateViewCnt(Integer board_no);


}
