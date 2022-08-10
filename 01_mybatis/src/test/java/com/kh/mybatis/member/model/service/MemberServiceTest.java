package com.kh.mybatis.member.model.service;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MemberService 테스트")
class MemberServiceTest {
	private MemberService service;

	// 각각의 테스트 메소드들이 실행되기 전에 실행되는 메소드
	@BeforeEach
	void setUp() {
		service = new MemberServiceImpl();
	}
	
	@Test
	@Disabled
	void nothing() {
	}
	
	@Test
	@DisplayName("MemberService 객체 생성 테스트")
	void create() {
		assertThat(service).isNotNull();
	}
	
	@Test
	@DisplayName("회원 수 조회 테스트")
	void getMemberCountTest() {
		int count = service.getMemberCount();
		
		assertThat(count).isGreaterThan(0);
		
		
	}

}
