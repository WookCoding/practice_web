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
    }
}
