package institucion.Models.Users;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author o5k4r1n
 */
public class Subject {
	private String name;
	private String description;
	private ArrayList<String> schedule;
	
	public Subject(String name, String description, ArrayList schedule){
		this.name = name;
		this.description = description;
		this.schedule = schedule;
	}
	public Subject(){
		this.name = "";
		this.description = "";
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

	public ArrayList<String> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<String> schedule) {
		this.schedule = schedule;
	}
	
	
}
