package com.app.practice.controller;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.criteria.Criteria;
import com.app.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 작성 페이지
    @GetMapping("write")
    public void write(){;}

    @PostMapping("write")
    public RedirectView write(BoardDTO boardDTO, HttpSession session){
        Long memberId = (Long) session.getAttribute("memberId");
        boardDTO.setMemberId(memberId);
        boardService.write(boardDTO);
        return new RedirectView("/board/boardList");
    }

    @GetMapping("boardList")
    public void boardList(HttpSession session, Model model){
        Long memberId = (Long) session.getAttribute("memberId");
        model.addAttribute("memberId", memberId);
    }

    // 목록
    @GetMapping("list/{page}")
    @ResponseBody
    public List<BoardDTO> boardList(@PathVariable int page){
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        List<BoardDTO> boardDTOS = boardService.boardList(criteria);
        return boardDTOS;
    }

    @GetMapping("board")
    public void board(@RequestParam("boardId") Long boardId,  Model model, HttpSession session){
        Long memberId = (Long) session.getAttribute("memberId");
        model.addAttribute("memberId", memberId);
        BoardDTO boardDTO = boardService.board(boardId);

        model.addAttribute("boardDTO", boardDTO);
        model.addAttribute("memberId", memberId);
    }

}
