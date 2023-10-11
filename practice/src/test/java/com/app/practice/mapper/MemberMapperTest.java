package com.app.practice.mapper;

import com.app.practice.domain.vo.member.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@Slf4j
@SpringBootTest
public class MemberMapperTest {

    @Autowired
    private MemberMapper memberMapper;

    // 회원 가입
    @Test
    public void insertMemberTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberName("홍길동");
        memberVO.setMemberIdentification("hds1234");
        memberVO.setMemberPassword("1234");
        memberMapper.insertMember(memberVO);
    }

    // 로그인
    @Test
    public void loginTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberIdentification("a123456");
        memberVO.setMemberPassword(new String(Base64.getEncoder().encode("a123456123".getBytes())));
        log.info("회원 번호 :::::::" + memberMapper.login(memberVO));
    }


    // 회원 정보 찾기
    @Test
    public void findMemberTest() {
        log.info(memberMapper.findMember(1L).toString());
    }

}
