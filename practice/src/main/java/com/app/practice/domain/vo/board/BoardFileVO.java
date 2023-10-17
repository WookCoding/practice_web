package com.app.practice.domain.vo.board;

import lombok.Data;

@Data
public class BoardFileVO {

   private Long boardFileId;
   private String boardFileOriginalName;
   private String boardFileUuid;
   private String boardFilePath;

}

