package com.app.practice.domain.dao;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardDAO {

    private final BoardMapper boardMapper;

    //글작성
    public void insertBoard(BoardVO boardVO){
        boardMapper.insertBoard(boardVO);
    }

    // 현재 시퀀스 가져오기
    public Long currentSequence(){
        return boardMapper.currentSequence();
    }

}
