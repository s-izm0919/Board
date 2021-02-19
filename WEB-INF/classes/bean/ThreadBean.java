package bean;

import java.io.Serializable;

public class ThreadBean implements Serializable {
	private String id;
	private String name;
	private String title;
	private String content;
	private String time;
	private String question;
	private String choice1;
	private String choice2;

	private int number;

	
	public ThreadBean(){}
	
	//id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	//title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	//question
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	//choice1
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	//choice2
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	//number
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}