package com.fin.member;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		return memberDAO.login(memberDTO);
	}
	public String nicknameCheck(String nickname)throws Exception{
		return memberDAO.nicknameCheck(nickname);
	}

}
