package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		System.out.println("Autowiring sqlSessionTemplate: " + sqlSessionTemplate);
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int selectBoardAllCount() {
		return this.getSqlSession()
				.selectOne("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectBoardAllCount");
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		return this.getSqlSession()
				.selectList("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectAllBoard");
	}

}
