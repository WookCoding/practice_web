package com.app.practice.service;

import com.app.practice.domain.dao.BoardDAO;
import com.app.practice.domain.dao.BoardFileDAO;
import com.app.practice.domain.dao.MemberDAO;
import com.app.practice.domain.dto.BoardDTO;
import com.app.practice.domain.vo.board.BoardVO;
import com.app.practice.domain.vo.criteria.Criteria;
import com.app.practice.domain.vo.file.BoardFileVO;
import com.app.practice.domain.vo.member.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;
    private final BoardFileDAO boardFileDAO;
    private final MemberDAO memberDAO;


    // 작성 하기
    @Override @Transactional
    public void write(BoardDTO boardDTO) {
        List<BoardFileVO> boardFileVOS = boardDTO.getBoardFileVOS();
        boardDAO.insertBoard(boardDTO.toBoardVO());
        Long sequence = currentSequence();

        if(boardFileVOS != null){
            for (int i = 0; i < boardFileVOS.size(); i++) {
                boardFileVOS.get(i).setBoardId(sequence);
                boardFileDAO.insertFile(boardFileVOS.get(i));
            }
        }
    }

    @Override
    public List<BoardDTO> boardList(Criteria criteria) {
        List<BoardVO> boardVOS =  boardDAO.findBoardVOS(criteria);
        List<BoardDTO> boardDTOS = new ArrayList<>();

        boardVOS.forEach(boardVO -> {
            MemberVO memberVO = memberDAO.findMember(boardVO.getMemberId());
            List<BoardFileVO> boardFileVOS = boardFileDAO.findFiles(boardVO.getBoardId());
            boardDTOS.add(toBoardDTO(boardVO, boardFileVOS, memberVO));
        });

        return boardDTOS;
    }

    @Override
    public BoardDTO board(Long boardId) {
        List<BoardFileVO> boardFileVOS = boardFileDAO.findFiles(boardId);
        BoardVO boardVO = boardDAO.findBoardVO(boardId);
        MemberVO memberVO = memberDAO.findMember(boardVO.getMemberId());
        return toBoardDTO(boardVO, boardFileVOS, memberVO);
    }

    // 현재 시퀀스
    private Long currentSequence(){
        return boardDAO.currentSequence();
    }


}
