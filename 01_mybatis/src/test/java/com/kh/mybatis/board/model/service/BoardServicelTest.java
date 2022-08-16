package com.kh.mybatis.board.model.service;


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

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

@TestMethodOrder(OrderAnnotation.class)
class BoardServicelTest {
	private BoardService service = null;

	@BeforeEach
	void setUp() {
		service = new BoardServiceImpl();
	}
	
	@Test
	@Disabled
	void nothing() {
	}
	
	@Test
	@Disabled
	void create() {
		assertThat(service).isNotNull();
	}
	
	@Test
	@Order(1)
	@DisplayName("게시글 수 조회(전체 목록) 테스트")
	void getBoardCountTest() {
		int count = 0;
		
		count = service.getBoardCount();
		
		
		assertThat(count).isGreaterThan(0); 
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 10",
		"4, 10"
	})
	@Order(2)
	@DisplayName("게시글 목록 조회(전체 목록) 테스트")
	void findAllTest(int currentPage, int expected) {
		List<Board> list = null;
		PageInfo pageInfo = null;
		int listCount = 0;
		
		listCount = service.getBoardCount();
		pageInfo = new PageInfo(currentPage, 10, listCount, 10);
		
		list = service.findAll(pageInfo);
		
		assertThat(list).isNotNull().isNotEmpty();
		assertThat(list.size()).isEqualTo(expected);
	}

	
	@ParameterizedTest
	@CsvSource(
			value = {
					"null, null, null, 53",
					"ad, null, null, 53",
					"null, 50, null, 1",
					"null, null, 13, 1",
			},
			nullValues = "null"
	)
	@Order(3)
	@DisplayName("게시글 목록 조회(검색 기능 적용) 테스트")
	void findAllTest(String writer, String title, String content, int expected) {
		List<Board> list = null;
		
		list = service.findAll(writer, title, content);	
		
		System.out.println(list);
		System.out.println(list.size());
		
		assertThat(list).isNotNull().isNotEmpty();
		assertThat(list.size()).isEqualTo(expected);
	}
	

}
