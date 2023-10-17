package com.app.practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
public class BoardControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){ mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();}

    // 세션용
    public MockHttpSession session(){
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("memberId", 1L);
        return session;
    }

    // 게시판 작성 하기 이미지 x
    @Test
    public void writeTest() throws Exception {
        mockMvc.perform(post("/board/write")
                .param("boardTitle", "테스트 제목 4")
                .param("boardContent", "테스트 내용 4")
                .session(session())
        ).andExpect(status().is3xxRedirection());
    }

}
