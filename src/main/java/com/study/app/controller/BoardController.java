package com.study.app.controller;

import com.study.app.dto.board.BoardDto;
import com.study.app.repository.UserRepository;
import com.study.app.security.BoardPrincipal;
import com.study.app.service.BoardService;
import com.study.app.service.PageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService boardService;
    private final PageHandler pageHandler;


    // 게시판 리스트 보여주기
    /* TODO : 게시글 전체 조회 해서 리스트로 받아와서 모델로 넘겨 주기, 페이징처리 */
    @GetMapping("list")
    public String boardList(@AuthenticationPrincipal BoardPrincipal principal,
                            @PageableDefault(size = 10,sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable,
                            Model model

    ) {
        System.out.println(" ======= 보드 페이지 GET ======= ");
        Page<BoardDto> dto = boardService.BoardList(pageable);
        List<Integer> pageNums = pageHandler.PageHandler(pageable.getPageNumber(),dto.getTotalPages());

        model.addAttribute("dto",dto);
        model.addAttribute("pageNum",pageNums);
        model.addAttribute("principal",principal);

        return "board/list";
    }

    // 게시글 보여주기
    @GetMapping("{board_no}")
    public String boardDetail(@AuthenticationPrincipal BoardPrincipal principal,
                              @PathVariable ("board_no") Integer board_no,
                              Model model
    ) {
         boardService.updateViewCnt(board_no); // 조회수 1 증가
         BoardDto boardDetail = boardService.boardDetail(board_no);

         model.addAttribute("principal",principal);
         model.addAttribute("detail",boardDetail);
    return "board/detail";
    }

    // 게시글 등록 페이지로 이동
    @GetMapping("/form")
    public String boardForm(BoardDto boardDto,
                            @AuthenticationPrincipal BoardPrincipal boardPrincipal,
                              Model model
    ) {
         model.addAttribute("dto",boardDto);
         model.addAttribute("principal",boardPrincipal);
         return "board/form";
    }

    // 게시글 수정 페이지로 이동
    @GetMapping("update/{board_no}")
    public String boardModifiy(@PathVariable ("board_no") Integer board_no,
                               @AuthenticationPrincipal BoardPrincipal boardPrincipal,
                               Model model
    ) {
        System.out.println(" ======= 수정 페이지 GET ======= ");
        BoardDto boardDto = boardService.boardDetail(board_no); //findById

        model.addAttribute("principal",boardPrincipal);
        model.addAttribute("dto",boardDto);
        // 로그인 정보와 게시글 작성자 정보가 같은지 확인 보류 url 접근 막기
        if (false == boardDto.writer().username().equals(boardPrincipal.getUsername())) {
            return "error";
        }

        return "board/update";
    }

}
