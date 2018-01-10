package com.fin.s6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fin.schedule.ScheduleDTO;

@RestController
public class JsonController {

	
	
	@RequestMapping(value="/json01")
	public String json01(){
		return "{\"num\":999}";
	}
	
	@RequestMapping(value="/json02")
	public Map<String, Object> json02(){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("num", 1);
		map.put("name","김구라");
		return map;
	}
	@RequestMapping(value="/json03")	
	public ScheduleDTO json03(){
		return null;
		
	}
}
