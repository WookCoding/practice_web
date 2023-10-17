package com.app.practice.service;

import com.app.practice.domain.dao.BoardDAO;
import com.app.practice.domain.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDAO boardDAO;

    // 작성하기
    public void write(Long memberId, BoardDTO boardDTO){
        boardDTO.setMemberId(memberId);
        boardDAO.insertBoard(boardDTO);
    }

}
