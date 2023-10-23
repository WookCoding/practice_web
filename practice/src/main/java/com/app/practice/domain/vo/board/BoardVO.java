package com.app.practice.domain.vo.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardVO {

    private Long boardId;
    private Long memberId;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime boardRegisterDate;
    private LocalDateTime boardUpdateDate;

}
