package com.app.practice.domain.vo.member;

import lombok.Data;

@Data
public class MemberFileVO {

    private Long memberFileId;
    private String memberFileOriginalName;
    private String memberFileUuid;
    private String memberFilePath;

}
