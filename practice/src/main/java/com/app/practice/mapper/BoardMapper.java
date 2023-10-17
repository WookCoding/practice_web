package com.app.practice.mapper;

import com.app.practice.domain.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardDTO boardDTO);
}
