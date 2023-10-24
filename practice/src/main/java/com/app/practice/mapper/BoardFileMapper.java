package com.app.practice.mapper;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.file.BoardFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardFileMapper {

    // 작성 완료 시 들어오는 파일
    public void insertFile(BoardFileVO boardFileVO);

    // 각 게시판의 파일 목록
    public List<BoardFileVO> findFiles(Long boardId);

}
