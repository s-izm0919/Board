package bean;

import java.io.Serializable;

public class ResThreadBean implements Serializable {
    private String th_id;
    private String re_id;
	private String name;
	private String content;
	private String time;
	private String voting ;

	private int number;

	
	public ResThreadBean(){}
	
	//th_id
	public String getTh_id() {
		return th_id;
	}
	public void setTh_id(String th_id) {
		this.th_id = th_id;
    }
    
    //re_id
    public String getRe_id() {
		return re_id;
	}
	public void setRe_id(String re_id) {
		this.re_id = re_id;
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

	//voting
	public String getVoting() {
		return voting;
	}
	public void setVoting(String voting) {
		this.voting = voting;
    }
    
	//number
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
