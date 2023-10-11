package com.app.practice.controller;

import com.app.practice.domain.vo.member.MemberVO;
import com.app.practice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("join")
    public void join(HttpSession session, MemberVO memberVO){
        session.invalidate();
    }

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberVO.setMemberPassword(new String(Base64.getEncoder().encode(memberVO.getMemberPassword().getBytes())));
        memberService.insertMember(memberVO);
        return new RedirectView("/member/login");
    }

    @GetMapping("login")
    public void login(){}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, HttpSession session){
        Long memberId = null;
        String url = "/member/login?check=false";

        memberVO.setMemberPassword(new String(Base64.getEncoder().encode(memberVO.getMemberPassword().getBytes())));
        memberId = memberService.login(memberVO);

        if(memberId != null){
            url = "/member/result";
            session.setAttribute("memberId", memberId);
        }

        return new RedirectView(url);
    }

    @GetMapping("result")
    public void result(Model model, HttpSession session){
        Long memberId = (Long) session.getAttribute("memberId");
        MemberVO memberVO = memberService.findMember(memberId);
        model.addAttribute("memberVO", memberVO);
    }
}
