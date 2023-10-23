package com.app.practice.mapper;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.file.BoardFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@Slf4j
public class BoardFileMapperTest {

    @Autowired
    private BoardFileMapper boardFileMapper;


    // 작성완료시 들어가는 파일테스트
    @Test
    public void insertFileTest(){
    }


}
