package com.kh.mybatis.member.model.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.kh.mybatis.member.model.vo.Member;

@DisplayName("MemberService 테스트")
@TestMethodOrder(OrderAnnotation.class)
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
	@Disabled
	void create() {
		assertThat(service).isNotNull();
	}
	
	@Test
	@DisplayName("회원 수 조회 테스트")
	@Order(1)
	void getMemberCountTest() {
		int count = service.getMemberCount();
		
		assertThat(count).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("모든 회원 조회 테스트")
	@Order(2)
	void findAllTest() {
		List<Member> members = null;
		
		members = service.findAll();
		
		assertThat(members).isNotNull()
						   .isNotEmpty()
						   .extracting("id")
						   .isNotNull()
						   .contains("admin2");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"admin2"})
	@DisplayName("회원 조회 테스트(ID로 검색)")
	@Order(3)
	void findMemberByIdTest(String id) {
		Member member = null;
		
		member = service.findMemberById(id);
		
		System.out.println(member);
		
		assertThat(member).isNotNull()
						  .extracting("id")
						  .isEqualTo(id);
	}
	
	@ParameterizedTest
	@CsvSource({
		"test1, 1234, 홍길동",
		"test2, 4567, 임꺽정"
		
	})
	@DisplayName("회원 등록 테스트")
	@Order(4)
	void insertMemberTest(String id, String password, String name) {
		int result = 0;
		Member member = new Member(id, password, name);
		
		
		
		result = service.save(member);
		
		assertThat(result).isGreaterThan(0);
		assertThat(member.getNo()).isGreaterThan(0);
		assertThat(service.findMemberById(id)).isNotNull();
	}
	
	@ParameterizedTest
	@CsvSource({
		"test1, 0000, 이몽룡",
		"test2, 9999, 성춘향"
		
	})
	@DisplayName("회원 정보 수정 테스트")
	@Order(5)
	void updateMemberTest(String id, String password, String name) {
		int result = 0;
		Member member = null;
		
		member = service.findMemberById(id);
		
		member.setPassword(password);
		member.setName(name);
		
		result = service.save(member);
		
		// 실제로 DB에 Member가 수정되었는지 확인하기 위해서 다시 Member를 조회
		member = service.findMemberById(id);
		
		assertThat(result).isGreaterThan(0);
		
		assertThat(member.getName()).isNotNull().isEqualTo(name);
	}
	
	
	
	@ParameterizedTest
	@ValueSource(strings = {"test1", "test2"})
	@DisplayName("회원 삭제 테스트")
	@Order(6)
	void deleteTest(String id) {
		int result = 0;
		Member member = null;
		
		member = service.findMemberById(id);
		result = service.delete(member.getNo());
		
		assertThat(result).isGreaterThan(0);
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
