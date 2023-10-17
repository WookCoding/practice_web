package com.app.practice.mapper;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.member.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void insertBoardTest(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardContent("테스트 내용 1");
        boardDTO.setBoardTitle("테스트 제목 1");
        boardDTO.setMemberId(1L);

        boardMapper.insertBoard(boardDTO);

    }

}
