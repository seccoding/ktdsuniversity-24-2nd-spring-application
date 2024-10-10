package com.ktdsuniversity.edu.hello_spring.member.dao;

import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

public interface MemberDao {

	public int selectEmailCount(String email);
	
	public int insertNewMember(RegistMemberVO registMemberVO);
	
}
