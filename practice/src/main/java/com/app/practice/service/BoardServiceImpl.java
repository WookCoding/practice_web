package com.app.practice.service;

import com.app.practice.domain.dao.BoardDAO;
import com.app.practice.domain.dao.BoardFileDAO;
import com.app.practice.domain.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;
    private final BoardFileDAO boardFileDAO;

    // 작성 하기
    public void write(BoardDTO boardDTO){
        boardDAO.insertBoard(boardDTO.toBoardVO());
        boardDTO.setBoardId(currentSequence());
    }

    // 현재 시퀀스
    private Long currentSequence(){
        return boardDAO.currentSequence();
    }

}
