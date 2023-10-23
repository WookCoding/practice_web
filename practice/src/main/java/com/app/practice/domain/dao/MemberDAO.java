package com.app.practice.domain.dao;

import com.app.practice.domain.vo.member.MemberVO;
import com.app.practice.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private MemberMapper memberMapper;

    // 회원 가입
    public void insertMember(MemberVO memberVO){
        memberMapper.insertMember(memberVO);
    }

    // 로그인
    public Long login(MemberVO memberVO){
        return memberMapper.login(memberVO);
    }


    //회원 정보 찾기
    public MemberVO findMember(Long memberId) {
        return memberMapper.findMember(memberId);
    }


}
