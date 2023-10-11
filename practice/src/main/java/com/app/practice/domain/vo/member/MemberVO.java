package com.app.practice.domain.vo.member;

import lombok.Data;

@Data
public class MemberVO {
    private Long memberId;
    private String memberIdentification;
    private String memberPassword;
    private String memberName;
}
