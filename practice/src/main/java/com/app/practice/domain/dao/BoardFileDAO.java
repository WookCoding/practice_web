package com.app.practice.domain.dao;

import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.mapper.BoardFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardFileDAO {

    private final BoardFileMapper boardFileMapper;

    public void insertFile(BoardDTO boardDTO){
        boardFileMapper.insertFile(boardDTO);
    }

}
