package com.app.practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
public class MemberControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){ mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();}


    // 회원가입 테스트
    @Test
    public void joinTest() throws Exception {
        mockMvc.perform(post("/member/join")
                .param("memberName", "이순신")
                .param("memberIdentification", "test1")
                .param("memberPassword", "a123124141")
        ).andExpect(status().is3xxRedirection());
    }


    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(post("/member/login")
                .param("memberIdentification","a123456")
                .param("memberPassword","a123456123")
        ).andExpect(status().is3xxRedirection());
    }

}
