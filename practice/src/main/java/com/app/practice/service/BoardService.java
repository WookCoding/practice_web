package com.app.practice.service;


import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.file.BoardFileVO;

import java.util.List;

public interface BoardService {

    // 작성하기
    public void write(BoardDTO boardDTO);
    // 게시글 목록
    public List<BoardDTO> boardList();


    default BoardDTO toBoardDTO(BoardVO boardVO, List<BoardFileVO> boardFileVOS){
        BoardDTO boardDTO = new BoardDTO();

        boardDTO.setBoardContent(boardVO.getBoardContent());
        boardDTO.setBoardTitle(boardVO.getBoardTitle());
        boardDTO.setBoardRegisterDate(boardVO.getBoardRegisterDate());
        boardDTO.setBoardUpdateDate(boardVO.getBoardUpdateDate());
        boardDTO.setMemberId(boardVO.getMemberId());
        boardDTO.setBoardId(boardVO.getBoardId());
        boardDTO.setBoardFileVOS(boardFileVOS);

        return boardDTO;
    }
}
