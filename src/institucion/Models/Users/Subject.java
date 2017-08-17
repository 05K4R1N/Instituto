package institucion.Models.Users;

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
	private String[] schedule;
	
	public Subject(String name, String description, String[] schedule){
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

	public String[] getSchedule() {
		return schedule;
	}

	public void setSchedule(String[] schedule) {
		this.schedule = schedule;
	}
	
	
}
