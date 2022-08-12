package com.kh.mybatis.board.model.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kh.mybatis.board.model.vo.Board;

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
	@DisplayName("게시글 목록 조회(전체 목록) 테스트")
	void findAllTest() {
		List<Board> list = null;
		
		list = service.findAll();
		System.out.println(list.get(0));
		
		assertThat(list).isNotNull().isNotEmpty();
	}
	

}
