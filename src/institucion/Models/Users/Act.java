/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.Users;

import java.util.Date;

/**
 *
 * @author o5k4r1n
 */
public class Act {
	private String name;
	private int classroom_id;
	private String description;
	private Date date_activity;
	private String time_activity;

	public Act(){}

	public Act(int classroom_id,String name, String description, Date date_activity, String time_activity) {
		this.classroom_id = classroom_id;
		this.name = name;
		this.description = description;
		this.date_activity = date_activity;
		this.time_activity = time_activity;
	}

	public int getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(int classroom_id) {
		this.classroom_id = classroom_id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_activity() {
		return date_activity;
	}

	public void setDate_activity(Date date_activity) {
		this.date_activity = date_activity;
	}

	public String getTime_activity() {
		return time_activity;
	}

	public void setTime_activity(String time_activity) {
		this.time_activity = time_activity;
	}
	
}
