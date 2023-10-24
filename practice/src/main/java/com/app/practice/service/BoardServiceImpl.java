package com.app.practice.service;

import com.app.practice.domain.dao.BoardDAO;
import com.app.practice.domain.dao.BoardFileDAO;
import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.file.BoardFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;
    private final BoardFileDAO boardFileDAO;


    // 작성 하기
    @Override @Transactional
    public void write(BoardDTO boardDTO) {
        List<BoardFileVO> boardFileVOS = boardDTO.getBoardFileVOS();
        boardDAO.insertBoard(boardDTO.toBoardVO());
        Long sequence = currentSequence();

        if(boardFileVOS != null){
            for (int i = 0; i < boardFileVOS.size(); i++) {
                boardFileVOS.get(i).setBoardId(sequence);
                boardFileDAO.insertFile(boardFileVOS.get(i));
            }
        }
    }

    @Override
    public List<BoardDTO> boardList() {
        List<BoardVO> boardVOS =  boardDAO.findBoardVO();
        List<BoardDTO> boardDTOS = new ArrayList<>();

        boardVOS.forEach(boardVO -> {
            List<BoardFileVO> boardFileVOS = boardFileDAO.findFiles(boardVO.getBoardId());
            boardDTOS.add(toBoardDTO(boardVO, boardFileVOS));
        });

        return boardDTOS;
    }

    // 현재 시퀀스
    private Long currentSequence(){
        return boardDAO.currentSequence();
    }

}
