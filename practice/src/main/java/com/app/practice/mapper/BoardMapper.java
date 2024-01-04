package com.app.practice.mapper;

import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.criteria.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 작성 하기
    public void insertBoard(BoardVO boardVO);

    // 현재 시퀀스 가져 오기
    public Long currentSequence();

    // 게시판 목록
    public List<BoardVO> findBoardVOS(@Param("cri") Criteria criteria);

    //게시판 정보
    public BoardVO findBoardVO(Long boardId);
}
