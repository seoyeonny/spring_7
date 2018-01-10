package com.fin.s6;




import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fin.schedule.ScheduelService;
import com.fin.schedule.ScheduleDTO;

@Controller
@RequestMapping(value="/schedule/**")
public class ScheduleController {
	
	@Inject
	ScheduelService ScheduelService;
	
	@RequestMapping(value="scheduleUpdatePOST",method =RequestMethod.POST)
	public String ScheduleUpdate(ScheduleDTO scheduleDTO,RedirectAttributes rd,HttpServletRequest request){
		int result = 0;
		try {			
			result = ScheduelService.ScheduleUpdatePOST(scheduleDTO);
			System.out.println("num : "+scheduleDTO.getNum());
			System.out.println("result : "+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "일정수정이 실패하였습니다.";
		if(result>0){
			message = "수정이 완료되었습니다.";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./mainSchedule";
		
	}
		
	@RequestMapping(value="ScheduleUpdate",method=RequestMethod.GET)
	public ModelAndView ScheduleUpdate(int num,HttpServletRequest request){		
		ModelAndView mv = ScheduelService.ScheduleUpdateGET(num, request);
		mv.setViewName("/schedule/ScheduleUpdate");
		return mv;
	}
	
	//삭제 버튼 누르면 삭제되게 
	@RequestMapping(value="scheduleDeleteOne",method=RequestMethod.GET)
	public String scheduleDeleteOne(int num, RedirectAttributes rd){
		int result = 0;
	try {
		result = ScheduelService.ScheduleDeleteOne(num);
		System.out.println("삭제갯수 :" + result);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String message = "삭제 실패";
	if(result>0){
		message = "삭제 성공";
	}
	rd.addFlashAttribute("message", message);	
	return "redirect:./mainSchedule";
	}
	
	
	//날짜 클릭시 그 날짜의 일정 홛인하는 것 
	@RequestMapping(value="ScheduleDayJson")
	@ResponseBody
	public ModelAndView ScheduleDayJson(ScheduleDTO scheduleDTO,HttpServletRequest request
			,HttpServletResponse response){		
		ModelAndView mv = ScheduelService.getScheduleDayArticles(scheduleDTO, request, response);
		return mv;	
	}
	
	@RequestMapping(value="ScheduleJson")
	@ResponseBody
	public ModelAndView ScheduleJson(String id){		
		ModelAndView mv = ScheduelService.getScheduleArticles(id);
		return mv;	
	}
	
	@RequestMapping(value="ScheduleWrite", method =RequestMethod.POST)
	public String ScheduleWrite(ScheduleDTO scheduleDTO,RedirectAttributes rd, HttpSession session){
		int result = 0;
		try {
			result = ScheduelService.write(scheduleDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "일정등록을 재실행해주세요.";
		if(result>0){
			message = "일정이 등록되었습니다.";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:./mainSchedule";
		
	}
	
	@RequestMapping(value="mainSchedule")
	public void mainSchedule(){
		
	}
	
}
