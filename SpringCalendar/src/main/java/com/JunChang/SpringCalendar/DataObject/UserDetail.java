package com.JunChang.SpringCalendar.DataObject;

/**
 * 
 * @class UserDetail
 * @author Lemoness
 * @version 1.0 (new)
 * @CreateDate 2016. 08. 26
 * @UpdateDate 2016. 08. 26
 * @Desc This class store extra data of UserBase. It'll be provide external API infomations.
 * 
 */
public class UserDetail extends UserBase{
	/*
	 * Private Variables
	 */
	private String Password;

	/*
	 * Initializer
	 */
	public UserDetail() {
		super();
	}
	public UserDetail(String email, String location, String password) {
		super(email, location);
		// TODO Auto-generated constructor stub
		Password = password;
	}
	public UserDetail(int unqID, String email, String location, String password) {
		super(unqID, email, location);
		// TODO Auto-generated constructor stub
		Password = password;
	}

	/*
	 * Default Getter & Setter
	 */
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
