package com.app.practice.service;

import com.app.practice.domain.dao.MemberDAO;
import com.app.practice.domain.vo.member.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface MemberService {

    // 회원 가입
    public void insertMember(MemberVO memberVO);

    // 로그인
    public Long login(MemberVO memberVO);

    // 회원 정보 찾기
    public MemberVO findMember(Long memberId);

}
