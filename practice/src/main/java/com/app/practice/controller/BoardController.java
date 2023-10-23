package com.app.practice.controller;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    // 작성 페이지
    @GetMapping("write")
    public void write(){;}

    @PostMapping("write")
    public RedirectView write(BoardDTO boardDTO, HttpSession session){
        Long memberId = (Long) session.getAttribute("memberId");
        boardDTO.setMemberId(memberId);
        log.info(boardDTO.getBoardFileVOS().get(0).getBoardFilePath());
        boardService.write(boardDTO);

        return new RedirectView("/board/boardList");
    }

    // 목록
    @GetMapping("boardList")
    public void boardList(Model model, HttpSession session){
        Long memberId = (Long)session.getAttribute("memberId");
        model.addAttribute("memberId", memberId);
    }

}
