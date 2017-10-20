/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.Users;

import java.util.Date;
import java.util.Timer;

/**
 *
 * @author o5k4r1n
 */
public class Activity {
	private String name;
	private String description;
	private Date date_activity;
	private Date time_activity;

	public Activity(){}

	public Activity(String name, String description, Date date_activity, Date time_activity) {
		this.name = name;
		this.description = description;
		this.date_activity = date_activity;
		this.time_activity = time_activity;
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

	public Date getTime_activity() {
		return time_activity;
	}

	public void setTime_activity(Date time_activity) {
		this.time_activity = time_activity;
	}
	
}
