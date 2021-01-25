package tera;

import java.io.Serializable;

public class UserBean implements Serializable {
	private String number;
	private String name;
	private String time;
	private String content;

	
	public UserBean(){}
	
	//number
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//time
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	//content
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
