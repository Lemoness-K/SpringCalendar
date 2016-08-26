package com.JunChang.SpringCalendar.DataObject;

/**
 * 
 * @class UserBase
 * @author Lemoness
 * @version 1.0 (new)
 * @CreateDate 2016. 08. 26
 * @UpdateDate 2016. 08. 26
 * @Desc This class store data of user data like Email, Locale Data..
 *
 */
public class UserBase {
	
	/*
	 * Private Variables
	 */
	private int UnqID;
	private String Email;
	private String Location;	// likes ko-KR / en-US ...
	
	/*
	 * Initalizer
	 */
	public UserBase() {
		super();
	}
	public UserBase(String email, String location) {
		super();
		Email = email;
		Location = location;
	}
	public UserBase(int unqID, String email, String location) {
		super();
		UnqID = unqID;
		Email = email;
		Location = location;
	}
	
	/*
	 * Default Getter & Setter
	 */
	public int getUnqID() {
		return UnqID;
	}
	public void setUnqID(int unqID) {
		UnqID = unqID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
}
