package com.app.practice.service;

import com.app.practice.domain.dao.BoardDAO;
import com.app.practice.domain.dao.BoardFileDAO;
import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.file.BoardFileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;
    private final BoardFileDAO boardFileDAO;

    // 작성 하기
    @Transactional
    public void write(BoardDTO boardDTO){
        List<BoardFileVO> boardFileVOS = boardDTO.getBoardFileVOS();
        boardDAO.insertBoard(boardDTO.toBoardVO());

        if(!boardFileVOS.isEmpty()){
            for (int i = 0; i < boardFileVOS.size(); i++) {
                boardFileVOS.get(i).setBoardId(currentSequence());
                boardFileDAO.insertFile(boardFileVOS.get(i));
            }
        }

        boardDTO.setBoardId(currentSequence());
    }

    // 현재 시퀀스
    private Long currentSequence(){
        return boardDAO.currentSequence();
    }

}
