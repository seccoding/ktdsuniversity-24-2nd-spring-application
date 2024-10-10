package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void testSelectBoardAllCount() {
		int count = this.boardDao.selectBoardAllCount();
		System.out.println("boardCount: " + count);
	}
	
	@Test
	public void testSelectAllBoard() {
		List<BoardVO> boardList = this.boardDao.selectAllBoard();
		System.out.println("boardList: " + boardList);
	}
	
}







