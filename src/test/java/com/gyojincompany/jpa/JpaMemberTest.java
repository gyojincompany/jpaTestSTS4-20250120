package com.gyojincompany.jpa;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gyojincompany.jpa.entity.Member;
import com.gyojincompany.jpa.repository.MemberRepository;

@SpringBootTest
public class JpaMemberTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@DisplayName("로그인 테스트(아이디 비번 확인)")
	public void loginTest() {
		Member member = memberRepository.findByMidAndMpw("tiger", "12345");
		System.out.println(member.getMname());//홍길동
	}
	
	@Test
	@DisplayName("회원 이름으로 검색")
	public void nameTest() {
		List<Member> members = memberRepository.findByMname("이사자");
		for(Member member:members) {
			System.out.println(member.getMid());//회원이름이 이사자인 모든 회원의 아이디 출력
		}
		
	}
}
