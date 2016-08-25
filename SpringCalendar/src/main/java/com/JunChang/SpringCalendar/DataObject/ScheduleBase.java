package com.JunChang.SpringCalendar.DataObject;

import java.util.Date;

/**
 * 
 * @class ScheduleBase
 * @author Lemoness
 * @version 1.0 (new)
 * @CreateDate 2016. 08. 25
 * @UpdateDate 2016. 08. 25
 * @Desc This class store data of schedule infomation like meeting, promise or holiday
 *
 */

class UserBase{
	
}

public class ScheduleBase {
	/*
	 * Private Variables
	 */
//	private UserBase UserInfo;
	private String UnqID;
	private Date StartTime;
	private Date EndTime;
	private String Title;
	
	/*
	 * Initializer
	 */
	public ScheduleBase() {
		super();
	}
	public ScheduleBase(/*UserBase userInfo, */Date startTime, Date endTime,
			String title) {
		super();
//		UserInfo = userInfo;
		StartTime = startTime;
		EndTime = endTime;
		Title = title;
	}
	public ScheduleBase(/*UserBase userInfo, */String unqID, Date startTime,
			Date endTime, String title) {
		super();
//		UserInfo = userInfo;
		UnqID = unqID;
		StartTime = startTime;
		EndTime = endTime;
		Title = title;
	}


	/*
	 * Default Getter & Setter
	 */
	public String getUnqID() {
		return UnqID;
	}
	public void setUnqID(String unqID) {
		UnqID = unqID;
	}
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
}
