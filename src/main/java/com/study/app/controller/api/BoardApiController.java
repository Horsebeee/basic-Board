package com.study.app.controller.api;

import com.study.app.dto.board.BoardDto;
import com.study.app.security.BoardPrincipal;
import com.study.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    // 게시글 생성
    @PostMapping("/api/board")
    public ResponseEntity<String> createBoard(@RequestBody BoardDto boardDto,
                                              @AuthenticationPrincipal BoardPrincipal boardPrincipal
                                              ) {
        System.out.println("===== 게시글 생성 POST =====");
        boardService.createBoard(boardDto,boardPrincipal.toDto());
        System.out.println("===== 게시글 생성 완료 =====");
        return ResponseEntity.ok().body("게시글 생성");
    }

    // 게시글 수정
    @PutMapping("/api/update/{board_no}")
    public ResponseEntity<String> updateBoard(@RequestBody BoardDto boardDto,
                                              @AuthenticationPrincipal BoardPrincipal boardPrincipal) {
        System.out.println("===== 게시글 수정 PUT =====");
        boardService.updateBoard(boardDto,boardPrincipal.toDto());
        System.out.println("===== 게시글 수정 완료 =====");
        return ResponseEntity.ok().body("게시글 수정");
    }

    // 게시글 삭제
    @DeleteMapping("/api/delete/{board_no}")
    public ResponseEntity<String> deleteBoard(@PathVariable ("board_no") Integer board_no) {
        System.out.println("===== 게시글 삭제 DELETE =====");
        boardService.deleteBoard(board_no);
        System.out.println("===== 게시글 삭제 완료 =====");
        return ResponseEntity.ok().body("게시글 삭제");
    }
}
