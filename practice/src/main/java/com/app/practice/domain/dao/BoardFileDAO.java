package com.app.practice.domain.dao;

import com.app.practice.domain.vo.file.BoardFileVO;
import com.app.practice.mapper.BoardFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardFileDAO {

    private final BoardFileMapper boardFileMapper;

    // 게시판 작성 시 파일 등록
    public void insertFile(BoardFileVO boardFileVO) {
        boardFileMapper.insertFile(boardFileVO);
    }

    // 게시판 하나의 파일 목록
    public List<BoardFileVO> findFiles(Long boardId) {
        return boardFileMapper.findFiles(boardId);
    }

}
