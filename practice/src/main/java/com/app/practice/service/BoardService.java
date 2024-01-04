package com.app.practice.service;


import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.criteria.Criteria;
import com.app.practice.domain.vo.file.BoardFileVO;
import com.app.practice.domain.vo.member.MemberVO;

import java.util.List;

public interface BoardService {

    // 작성하기
    public void write(BoardDTO boardDTO);
    // 게시글 목록
    public List<BoardDTO> boardList(Criteria criteria);
    // 게시글 정보 가져오기
    public BoardDTO board(Long boardId);

    default BoardDTO toBoardDTO(BoardVO boardVO, List<BoardFileVO> boardFileVOS, MemberVO memberVO){
        BoardDTO boardDTO = new BoardDTO();

        boardDTO.setMemberVO(memberVO);
        boardDTO.setBoardContent(boardVO.getBoardContent());
        boardDTO.setBoardTitle(boardVO.getBoardTitle());
        boardDTO.setBoardRegisterDate(boardVO.getBoardRegisterDate());
        boardDTO.setBoardUpdateDate(boardVO.getBoardUpdateDate());
        boardDTO.setMemberId(boardVO.getMemberId());
        boardDTO.setBoardId(boardVO.getBoardId());
        boardDTO.setBoardFileVOS(boardFileVOS);

        return boardDTO;
    }
}
