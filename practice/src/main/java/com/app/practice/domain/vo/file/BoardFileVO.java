package com.app.practice.domain.vo.file;

import lombok.Data;

@Data
public class BoardFileVO {
    private Long boardFileId;
    private Long boardId;
    private String boardFileOriginalName;
    private String boardFileUuid;
    private String boardFilePath;
}
