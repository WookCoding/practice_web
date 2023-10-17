package com.app.practice.dao;

import com.app.practice.domain.dao.BoardDAO;
import com.app.practice.domain.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAOTests {

    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void insertBoardTest(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardContent("테스트 내용 2");
        boardDTO.setBoardTitle("테스트 제목 2");
        boardDTO.setMemberId(1L);
        boardDAO.insertBoard(boardDTO);
    }
}
