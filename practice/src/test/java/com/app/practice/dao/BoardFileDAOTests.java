package com.app.practice.dao;

import com.app.practice.domain.dao.BoardFileDAO;
import com.app.practice.domain.vo.file.BoardFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@Slf4j
public class BoardFileDAOTests {

    @Autowired
    private BoardFileDAO boardFileDAO;


    // 작성완료시 들어가는 파일테스트
    @Test
    public void insertFileTest(){
        BoardFileVO boardFileVO = new BoardFileVO();

        boardFileVO.setBoardFileUuid(UUID.randomUUID().toString());
        boardFileVO.setBoardId(6L);
        boardFileVO.setBoardFileOriginalName("테스트1.png");
        boardFileVO.setBoardFilePath("2023/10/23");

        boardFileDAO.insertFile(boardFileVO);
    }

    // 게시판 하나당 가지고 있는 파일 리스트
    @Test
    public void findFilesTest(){
        List<BoardFileVO> boardFileVOS = boardFileDAO.findFiles(14L);
        boardFileVOS.forEach(boardFileVO -> log.info(boardFileVO.getBoardFileOriginalName()));
    }
}
