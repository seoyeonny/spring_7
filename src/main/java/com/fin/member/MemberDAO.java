package com.fin.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.fin.member.MemberDTO;

@Repository
public class MemberDAO {

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="memberMapper.";
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
	}
	
	public boolean nicknameCheck(String nickname){
		return sqlSession.selectOne(nickname+"nicknameCheck", nickname);
	}
	
}
