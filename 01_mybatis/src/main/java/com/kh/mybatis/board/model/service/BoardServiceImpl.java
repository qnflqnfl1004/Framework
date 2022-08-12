package com.kh.mybatis.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.dao.BoardDaoImpl;
import com.kh.mybatis.board.model.vo.Board;
import static com.kh.mybatis.common.template.SqlSessionTemplate.*;

public class BoardServiceImpl implements BoardService {
	private BoardDao dao = new BoardDaoImpl();
	
	@Override
	public List<Board> findAll() {
		List<Board> list = null;
		SqlSession session = getSession();
		
		list = dao.findAll(session);
		
		session.close();
		
		return list;
	}

}
