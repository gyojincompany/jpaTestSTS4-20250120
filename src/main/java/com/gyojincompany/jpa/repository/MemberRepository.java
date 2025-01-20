package com.gyojincompany.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gyojincompany.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	@Transactional
	public void deleteAllByMid(String mid);//회원 아이디로 삭제
	
	public List<Member> findAllByOrderByMnumDesc();//모든 회원을 회원번호의 내림차순으로 정렬하여 반환
	public List<Member> findByMnameLikeOrderByMnumDesc(String mname);//이름에 포함된 특정 글자로 검색하여 가져오기
	public Member findByMidAndMpw(String mid, String mpw);//아이디와 비번이 모두 일치하는 회원 검색
	public List<Member> findByMname(String mname);
}
