package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDaoImpl;

import static com.kh.mybatis.common.template.SqlSessionTemplate.*;

public class MemberServiceImpl implements MemberService {

	@Override
	public int getMemberCount() {
		int count = 0;
		SqlSession session = getSession();
		
		count = new MemberDaoImpl().getMemberCount(session);
		
		session.close();
		
		return count;
	}

}
