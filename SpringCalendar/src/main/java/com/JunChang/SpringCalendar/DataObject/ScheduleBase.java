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
public class ScheduleBase {
	/*
	 * Private Variables
	 */
	private UserBase UserInfo;
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
	public ScheduleBase(UserBase data, Date startTime, Date endTime,
			String title) {
		super();
		UserInfo = data;
		StartTime = startTime;
		EndTime = endTime;
		Title = title;
	}
	public ScheduleBase(UserBase data, String unqID, Date startTime,
			Date endTime, String title) {
		super();
		UserInfo = data;
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
	public UserBase getUserInfo() {
		return UserInfo;
	}
	public void setUserInfo(String email, String location) {
		UserInfo = new UserBase(email, location);
	}
	public void setUserInfo(int uid, String email, String location) {
		UserInfo = new UserBase(uid, email, location);
	}
	public void setUserInfo(UserBase userInfo) {
		UserInfo = userInfo;
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
