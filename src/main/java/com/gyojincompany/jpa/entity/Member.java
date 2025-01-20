package com.gyojincompany.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//annotaion으로 JPA 설정
@Entity
@Table(name = "jpamembertbl")//실제로 데이터베이스에 생성될 테이블의 이름(엔티티 클래스와 해당 테이블이 매핑)
@SequenceGenerator(
		name = "JPAMEMBER_SEQ_GENERATOR",//시퀀스 제너레이터 이름
		sequenceName = "jpamember_seq",//시퀀스 객체 이름
		initialValue = 1,//시작값
		allocationSize = 1//증가치
		)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	
	@Id //매핑될 테이블의 해당 필드를 기본키로 설정
	@Column(name = "mnum") //실제로 DB 테이블의 만들어질 필드 이름을 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JPAMEMBER_SEQ_GENERATOR")
	private Long mnum;//회원번호(1부터 1씩 증가->시퀀스로 자동으로 입력)->기본키
	
	@Column(name = "mid", length = 20, unique = true, nullable = false)
	private String mid;//회원 아이디
	
	@Column(name = "mpw", length = 20, nullable = false)
	private String mpw;//회원 비밀번호
	
	@Column(name = "mname", length = 20, nullable = false)
	private String mname;//회원 이름
	
	@Column(name = "mage")
	private int mage;//회원나이
	
}
