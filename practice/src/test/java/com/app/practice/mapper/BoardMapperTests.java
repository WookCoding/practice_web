package com.app.practice.mapper;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.member.MemberVO;
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

        BoardVO boardVO = new BoardVO();
        boardVO.setBoardContent("테스트 내용 4");
        boardVO.setBoardTitle("테스트 제목 4");
        boardVO.setMemberId(1L);
        boardMapper.insertBoard(boardVO);
        
        log.info("등록된 게시판 번호 : " + boardMapper.currentSequence());
    }

    @Test
    public void findBoardDTOs(){
        List<BoardVO> boardVOS = boardMapper.findBoardVO();

        log.info("사이즈 : " + boardVOS.size());
        boardVOS.stream().forEach(boardVO -> log.info(boardVO.getBoardContent()));
    }

}
