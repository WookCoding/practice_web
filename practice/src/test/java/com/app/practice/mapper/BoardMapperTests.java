package com.app.practice.mapper;

import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.criteria.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BoardMapperTests {

    @Autowired
    private BoardMapper boardMapper;

    // 작성하기 테스트
    @Test
    public void insertBoardTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardContent("테스트 내용 1");
        boardVO.setBoardTitle("테스트 제목 1");
        boardVO.setMemberId(1L);

        boardMapper.insertBoard(boardVO);
    }

    // 마지막 등록된 게시판 번호 가져오기
    @Test
    public void currentSequenceTest(){

        for (int i = 0; i < 100; i++) {
            BoardVO boardVO = new BoardVO();
            boardVO.setBoardContent("테스트 내용" + i);
            boardVO.setBoardTitle("테스트 제목 4" + i);
            boardVO.setMemberId(1L);
            boardMapper.insertBoard(boardVO);
        }

    }

    @Test
    public void findBoardDTOs(){
        Criteria criteria = new Criteria();
        List<BoardVO> boardVOS = boardMapper.findBoardVOS(criteria);

        log.info("사이즈 : " + boardVOS.size());
        boardVOS.stream().forEach(boardVO -> log.info(boardVO.getBoardContent()));
    }

}
