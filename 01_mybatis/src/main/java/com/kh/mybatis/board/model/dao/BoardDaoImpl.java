package com.kh.mybatis.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

public class BoardDaoImpl implements BoardDao {
	@Override
	public int getBoardCount(SqlSession session) {
		
		
		return session.selectOne("boardMapper.selectBoardCount");
	}

	@Override
	public List<Board> findAll(SqlSession session, PageInfo pageInfo) {
		/*
		 * mybatis에서 페이징 처리
		 * 
		 * mybatis에서는 페이징 처리를 위해 RowBounds라는 클래스를 제공해 준다.
		 * RowBounds의 객체를 생성할 때 offset과 limit 값을 전달해서 페이징 처리를 쉽게 구현한다.
		 * (offset 만큼 건너뛰고 limit 만큼 가져온다.)
		 * 
		 * offset = 0, limit = 10
		 * 	- 0개를 건너뛰고 10개를 가져온다. (1 ~ 10)
		 * 
		 * offset = 10, limit = 10
		 * 	- 10개를 건너뛰고 10개를 가져온다. (11 ~ 20)
		 * 
		 * offset - 20, limit = 10
		 * 	- 20개를 건너뛰고 10개를 가져온다. (21 ~ 30)
		 */
		int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getListLimit();
		int limit = pageInfo.getListLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList("boardMapper.selectAll", null, rowBounds);
	}

	@Override
	public List<Board> findAll(SqlSession session, String writer, String title, String content) {
		Map<String, String> map = new HashMap<>();
		
		map.put("writer", writer);
		map.put("title", title);
		map.put("content", content);
		
		return session.selectList("boardMapper.selectBoardListByKeyWord", map);
	}


}
