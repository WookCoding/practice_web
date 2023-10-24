package com.app.practice.domain.dto;

import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.file.BoardFileVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
@Data
public class BoardDTO {

    private Long boardId;
    private Long memberId;
    private String boardTitle;
    private String boardContent;
    private String boardRegisterDate;
    private String boardUpdateDate;

    private List<BoardFileVO> boardFileVOS;

    public BoardVO toBoardVO(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle(boardTitle);
        boardVO.setBoardId(boardId);
        boardVO.setBoardContent(boardContent);
        boardVO.setMemberId(memberId);
        return boardVO;
    }

}
