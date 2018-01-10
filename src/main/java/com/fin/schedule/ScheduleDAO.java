package com.fin.schedule;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDAO {

	@Inject
	 private SqlSession sqlSession;
	 private static final String namespace ="scheduleMapper.";
	 
	 public int write(ScheduleDTO scheduleDTO)throws Exception{
		 return sqlSession.insert(namespace+"write",scheduleDTO);
	 }
	 public List<ScheduleDTO> jsonScheduleList(String id)throws Exception{
		 System.out.println(id);		 
		return sqlSession.selectList(namespace+"jsonScheduleList", id);		 
	 }
	 public List<ScheduleDTO> jsonScheduleDayList(ScheduleDTO scheduleDTO)throws Exception{
		List<ScheduleDTO> ar = sqlSession.selectList(namespace+"jsonScheduleDayList",scheduleDTO);
		for (ScheduleDTO scheduleDTO2 : ar) {
			scheduleDTO2.setStartday(scheduleDTO2.getStartday().substring(0,scheduleDTO2.getStartday().indexOf(" ")));
			scheduleDTO2.setLastday(scheduleDTO2.getLastday().substring(0, scheduleDTO2.getLastday().indexOf(" ")));
		}
		 return ar;
	 }
	 public int ScheduleDeleteOne(int num)throws Exception{

		 return sqlSession.delete(namespace+"ScheduleDeleteOne", num);
	 }
	 public ScheduleDTO ScheduleUpdateGET(int num)throws Exception{
		 ScheduleDTO scheduleDTO = sqlSession.selectOne(namespace+"ScheduleUpdateGET", num);
		 return sqlSession.selectOne(namespace+"ScheduleUpdateGET", num);
	 }
	 public int ScheduleUpdatePOST(ScheduleDTO scheduleDTO)throws Exception{
		 return sqlSession.update(namespace+"ScheduleUpdatePOST", scheduleDTO);
	 }
}
