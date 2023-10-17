package com.app.practice.domain.dto;

import com.app.practice.domain.vo.board.BoardFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Data
public class BoardDTO {

    private Long boardId;
    private Long memberId;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime boardRegisterDate;
    private LocalDateTime boardUpdateDate;
    private BoardFileVO boardFileVO;

}
