package com.app.practice.dao;

import com.app.practice.domain.dao.MemberDAO;
import com.app.practice.domain.vo.member.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@Slf4j
@SpringBootTest
public class MemberDAOTest {

    @Autowired
    private MemberDAO memberDAO;

    // 회원 가입
    @Test
    public void insertMemberTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberIdentification("hds12345");
        memberVO.setMemberName("홍길");
        memberVO.setMemberPassword("1324");
        memberDAO.insertMember(memberVO);
    }

    // 로그인
    @Test
    public void loginTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberIdentification("a123456");
        memberVO.setMemberPassword(new String(Base64.getEncoder().encode("a123456123".getBytes())));
        log.info("회원 번호 :::::::" + memberDAO.login(memberVO));
    }

    // 회원 찾기
    @Test
    public void findMemberTest(){
        log.info(memberDAO.findMember(1L).toString());
    }
}
