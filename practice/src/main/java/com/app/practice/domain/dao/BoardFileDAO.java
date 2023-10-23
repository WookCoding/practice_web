package com.app.practice.domain.dao;

import com.app.practice.domain.vo.file.BoardFileVO;
import com.app.practice.mapper.BoardFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardFileDAO {

    private final BoardFileMapper boardFileMapper;

    public void insertFile(BoardFileVO boardFileVO){
        boardFileMapper.insertFile(boardFileVO);
    }

}
