package com.app.practice.service;

import com.app.practice.domain.dao.MemberDAO;
import com.app.practice.domain.vo.member.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("member") @Primary
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    // 회원 가입
    public void insertMember(MemberVO memberVO) {
        memberDAO.insertMember(memberVO);
    }

    // 로그인
    public Long login(MemberVO memberVO){
        return memberDAO.login(memberVO);
    }

    // 회원 정보 찾기
    public MemberVO findMember(Long memberId) {
        return memberDAO.findMember(memberId);
    };
}
