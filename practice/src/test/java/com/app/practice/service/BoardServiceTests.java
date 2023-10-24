package com.app.practice.service;

import com.app.practice.domain.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;


    @Test
    public void writeTest(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardTitle("테스트 제목 3");
        boardDTO.setBoardContent("테스트 내용 3");
    }

    @Test
    public void boardListTest(){
        List<BoardDTO> boardDTOS = boardService.boardList();
    }

}
