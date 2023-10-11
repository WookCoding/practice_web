package com.app.practice.mapper;

import com.app.practice.domain.vo.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    // 회원 가입
    public void insertMember(MemberVO memberVO);

    // 로그인
    public Long login(MemberVO memberVO);

    // 회원 정보 찾기
    public MemberVO findMember(Long memberId);
}
