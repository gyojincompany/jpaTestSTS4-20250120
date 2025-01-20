package com.gyojincompany.jpa.controller;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gyojincompany.jpa.repository.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JpaController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@PostMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		int mage = Integer.parseInt(request.getParameter("mage"));//int로 변환
		
		com.gyojincompany.jpa.entity.Member member = new com.gyojincompany.jpa.entity.Member();
		member.setMid(mid);
		member.setMpw(mpw);
		member.setMname(mname);
		member.setMage(mage);
		
		memberRepository.save(member);//save->insert 쿼리를 실행함 
		
		return "joinOk";
		
	}

}
