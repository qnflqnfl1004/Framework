package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSession() {
		SqlSession session = null;
		SqlSessionFactoryBuilder builder = null;
		SqlSessionFactory factory = null;
		InputStream is = null;
		
		try {
			// SqlSession 객체 생성하기
			// 1. SqlSessionFactoryBuilder 객체 생성
			builder = new SqlSessionFactoryBuilder();
			// 마이바티스에서 자원을 좀 더 쉽게 로드할 수 있는 Resources 클래스를 제공한다.
			is = Resources.getResourceAsStream("mybatis-config.xml");
			
			// 2. SqlSessionFactory 객체 생성하기
			factory = builder.build(is);
//			factory = builder.build(is, "kh");
			
			// 3. SqlSession 객체 생성 (true: 오토 커밋, false: 수동 커밋)
			session = factory.openSession(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return session;
	}
}
