/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Controllers;

import institucion.Models.BD.TeacherBD;
import institucion.Models.Users.Teacher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author master
 */
public class CtrlTeacher {

    private TeacherBD mod;
    public CtrlTeacher(){
        mod = new TeacherBD();
    }

    public boolean add(Teacher t){
        boolean added = false;
        if(( t.getFirst_name().length() != 0 || !t.getFirst_name().equals(" ") ) || 
                (t.getLast_name().length() != 0 || !t.getLast_name().equals(" ")) || 
                (t.getBirthday().toString().isEmpty() || !t.getBirthday().toString().equals(" ")) || 
                (t.getPlace_birth().length() != 0 || !t.getPlace_birth().equals(" ")) || 
                (t.getAddress().length() != 0 || !t.getAddress().equals(" ")) ){
            mod.add(t);
            added = true;
        }
        return added;
    }
    public Hashtable getTeacherData(int id){
        Hashtable teacher = new Hashtable();
        if( id > 0 ){
            Teacher data = mod.getTeacherByID(id);
            teacher.put("first_name", data.getFirst_name());
            teacher.put("last_name", data.getLast_name());
            teacher.put("birthday", data.getBirthday());
            teacher.put("place_birth", data.getPlace_birth());
            teacher.put("address", data.getAddress());
			teacher.put("photo", data.getPhoto());
        }
        return teacher;
    }
    public Object[][] getTeacherAttendances(int id){
        Object[][] attendances= null;
        if( id > 0 ){
            attendances = mod.getAttendances(id);
        }
        return attendances;
    }
    public HashMap getClassRooms(){
        HashMap classrooms = new HashMap();
        classrooms = mod.getClassRooms();
        return classrooms;
    }
	public ArrayList<String> viewMessages(int classroom_id, int teacher_id){
		ArrayList<String> messages = null;
		if( classroom_id > 0 || teacher_id > 0 ){
			messages = mod.getMessages(classroom_id, teacher_id);
		}
		return messages;
	}
	public Hashtable viewMessages2(int classroom_id, int teacher_id){
		Hashtable messages = new Hashtable();
		if(teacher_id > 0){
			messages = mod.getMessages2(classroom_id, teacher_id);
		}
		return messages;
	}
	public HashMap getSubjectsTeacher(int id){
		HashMap subjects = new HashMap();
		if(id > 0){
			subjects = mod.getSubjectsbyTeacherId(id);
		}
		return subjects;
	}
	public String getMessageByID(int teacher_id){
		String message = "";
		if( teacher_id > 0 ){
			message = mod.getMessageByID(teacher_id);
		}
		return message;
	}
}
