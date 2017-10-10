/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.Users;

/**
 *
 * @author o5k4r1n
 */
public class Message {
	private int id;
	private int teacher_id;
	private int classroom_id;
	private String title;
	private String content;
	private String moment;
	private int resend;

	public Message(int teacher_id, int classroom_id, String title, String content, String moment, int resend) {
		this.teacher_id = teacher_id;
		this.classroom_id = classroom_id;
		this.title = title;
		this.content = content;
		this.moment = moment;
		this.resend = resend;
	}

	public Message(int id, int teacher_id, int classroom_id, String title, String content, int resend) {
		this.id = id;
		this.teacher_id = teacher_id;
		this.classroom_id = classroom_id;
		this.title = title;
		this.content = content;
		this.resend = resend;
	}
	
	public Message(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(int classroom_id) {
		this.classroom_id = classroom_id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public int getResend() {
		return resend;
	}

	public void setResend(int resend) {
		this.resend = resend;
	
	}
}
