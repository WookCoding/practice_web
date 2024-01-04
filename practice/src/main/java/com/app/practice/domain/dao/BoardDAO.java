package com.app.practice.domain.dao;

import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.criteria.Criteria;
import com.app.practice.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    // 게시글 목록 가져오기
    public List<BoardVO> findBoardVOS(Criteria criteria){ return boardMapper.findBoardVOS(criteria); }

    // 게시글 정보 가져오기
    public BoardVO findBoardVO(Long boardId){
        return boardMapper.findBoardVO(boardId);
    };
}
