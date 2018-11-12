package institucion.Models.Users;

import java.util.HashMap;

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
        private int subjectId;
	private String name;
	private String description;
	private HashMap<String,String> schedule;
	
	public Subject(String name, String description, HashMap schedule){
            this.name = name;
            this.description = description;
            this.schedule = schedule;
	}
	public Subject(){
            this.name = "";
            this.description = "";
	}
        
        public int getSubjectId(){
            return subjectId;
        }
        
        public void setSubjectId(int subjectId){
            this.subjectId = subjectId;
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

	public HashMap<String, String> getSchedule() {
            return schedule;
	}

	public void setSchedule(HashMap<String, String> schedule) {
            this.schedule = schedule;
	}
        
}
