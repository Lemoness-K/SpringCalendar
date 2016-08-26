package com.JunChang.SpringCalendar.DataObject;

import java.util.Date;

/**
 * 
 * @class Latlng
 * @author Lemoness
 * @version 1.0 (new)
 * @CreateDate 2016. 08. 25
 * @UpdateDate 2016. 08. 25
 * @Desc This class store Lat/Lng data. like Android SDK's Latlng
 *
 */
class Latlng{
	public double latitude = 0.0;
	public double longitude = 0.0;
	public Latlng() {
		super();
	}
	public Latlng(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}

/**
 * 
 * @class ScheduleDetail
 * @author Lemoness
 * @version 1.0 (new)
 * @CreateDate 2016. 08. 25
 * @UpdateDate 2016. 08. 25
 * @Desc This class store detail data of each ScheduleBase
 *
 */
public class ScheduleDetail extends ScheduleBase{
	
	/*
	 * Private Variables
	 */
	private String Location;
	private Latlng LocaleLatlng;
	private String Content;
	private boolean isHoliday;
	private boolean isRepeat;
	private boolean isAlarm;
	private boolean AlarmCheck;
	private int AlarmMin;
	private int Color;
	private String Status;
	
	/*
	 * Initializer
	 */
	public ScheduleDetail() {
		super();
	}
	public ScheduleDetail(ScheduleBase data) {
		super(data.getUserInfo(), data.getUnqID(), data.getStartTime(), data.getEndTime(), data.getTitle());
	}
	public ScheduleDetail(UserBase userdata, Date StartTime, Date EndTime, String Title,
			String location, Latlng localeLatlng, String content,
			boolean isHoliday, boolean isRepeat, boolean isAlarm,
			boolean alarmCheck, int alarmMin, int color, String status) {
		super(userdata, StartTime, EndTime, Title);
		Location = location;
		LocaleLatlng = localeLatlng;
		Content = content;
		this.isHoliday = isHoliday;
		this.isRepeat = isRepeat;
		this.isAlarm = isAlarm;
		AlarmCheck = alarmCheck;
		AlarmMin = alarmMin;
		Color = color;
		Status = status;
	}
	public ScheduleDetail(UserBase userdata, String UnqID, Date StartTime, Date EndTime, String Title,
			String location, Latlng localeLatlng, String content,
			boolean isHoliday, boolean isRepeat, boolean isAlarm,
			boolean alarmCheck, int alarmMin, int color, String status) {
		super(userdata, UnqID, StartTime, EndTime, Title);
		Location = location;
		LocaleLatlng = localeLatlng;
		Content = content;
		this.isHoliday = isHoliday;
		this.isRepeat = isRepeat;
		this.isAlarm = isAlarm;
		AlarmCheck = alarmCheck;
		AlarmMin = alarmMin;
		Color = color;
		Status = status;
	}
	
	/*
	 * Default Getter & Setter
	 */
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Latlng getLocaleLatlng() {
		return LocaleLatlng;
	}
	public void setLocaleLatlng(Latlng localeLatlng) {
		LocaleLatlng = localeLatlng;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public boolean isHoliday() {
		return isHoliday;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	public boolean isRepeat() {
		return isRepeat;
	}
	public void setRepeat(boolean isRepeat) {
		this.isRepeat = isRepeat;
	}
	public boolean isAlarm() {
		return isAlarm;
	}
	public void setAlarm(boolean isAlarm) {
		this.isAlarm = isAlarm;
	}
	public boolean isAlarmCheck() {
		return AlarmCheck;
	}
	public void setAlarmCheck(boolean alarmCheck) {
		AlarmCheck = alarmCheck;
	}
	public int getAlarmMin() {
		return AlarmMin;
	}
	public void setAlarmMin(int alarmMin) {
		AlarmMin = alarmMin;
	}
	public int getColor() {
		return Color;
	}
	public void setColor(int color) {
		Color = color;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
}
