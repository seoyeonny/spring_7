package com.fin.schedule;

import java.util.List;

import com.fin.member.MemberDTO;

public class ScheduleDTO {
	private int num;
	private String id; 
	private String title;
	private String pro_contents;
	private String startday;
	private String lastday;
	private String start_time;
	private String last_time;
	private String color;
	private List<MemberDTO> part;
	
	public ScheduleDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<MemberDTO> getPart() {
		return part;
	}
	public void setPart(List<MemberDTO> part) {
		this.part = part;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPro_contents() {
		return pro_contents;
	}
	public void setPro_contents(String pro_contents) {
		this.pro_contents = pro_contents;
	}
	public String getStartday() {
		return startday;
	}
	public void setStartday(String startday) {
		this.startday = startday;
	}
	public String getLastday() {
		return lastday;
	}
	public void setLastday(String lastday) {
		this.lastday = lastday;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getLast_time() {
		return last_time;
	}
	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}
	
	
}
