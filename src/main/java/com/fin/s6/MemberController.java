package com.fin.s6;

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
	@RequestMapping("memberNickCheck")
	@ResponseBody
	public ModelAndView nicknameCheck(HttpServletRequest request){
		ModelAndView mv= new ModelAndView();
		boolean result = true;
		String nickname = request.getParameter("partner");
		System.out.println(nickname);
		if(nickname=="")
		{
			result=false;
		}
		else{
			try {
				result= memberService.nicknameCheck(nickname);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		mv.addObject("nickname", nickname);
		mv.addObject("result",result);
		mv.setViewName("common/nicknameCheck");
		return mv;
	}
	


	
	

}
