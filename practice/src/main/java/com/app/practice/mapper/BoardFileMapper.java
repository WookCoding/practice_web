package com.app.practice.mapper;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.file.BoardFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardFileMapper {

    // 작성 완료 시 들어오는 파일
    public void insertFile(BoardFileVO boardFileVO);

}
