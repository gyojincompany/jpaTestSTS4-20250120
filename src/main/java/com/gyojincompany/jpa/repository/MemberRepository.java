package com.gyojincompany.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
