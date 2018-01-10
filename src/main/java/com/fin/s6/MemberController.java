package com.fin.s6;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fin.member.MemberDTO;
import com.fin.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void membrLogin(){}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session){
		try {
			memberDTO=memberService.login(memberDTO);
		} catch (Exception e) {
			memberDTO=null;
			e.printStackTrace();
		}
		if(memberDTO != null){
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect:/";	
	}
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session){
		session.removeAttribute("member");
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="memberNickCheck",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> nicknameCheck(HttpServletRequest request)throws Exception{
	    String nickname = request.getParameter("nickname");
	    String result =memberService.nicknameCheck(nickname);
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("result", result);
		return map;
	}
	


	
	

}
