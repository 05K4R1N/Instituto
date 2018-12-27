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

    public boolean assignTeacher(int teacherId, String subjects[], int year, 
                                String gestion, boolean available){
        boolean res = false;
        if( teacherId != 0 && 
                subjects.length > 0 && 
                year != 0 && 
                gestion.length()!= 0 ){
            res = true;
        }
        return res;
    }
    public Object[][] getSubjectsAssigned(int teacher_id, int year){
        Object[][] subjects = {};
        ArrayList<Integer> assigned = new ArrayList<Integer>();
        if( teacher_id > 0 && year > 0 ){
            assigned = mod.getSubjectsAssigned(teacher_id, year);
            subjects = mod.getTeachersSubject(assigned);
        }
        return subjects;
    }
    
    public boolean deleteById(int teacher_id){
        boolean res = false;
        if( teacher_id > 0 ){
            res = mod.deleteTeacherById(teacher_id);
        }
        return res;
    }
    
    public boolean action(String action, Teacher t){
        boolean processed = false;
        if( t.getFirst_name().length() > 0  && 
                t.getLast_name().length() > 0 && 
                t.getAddress().length() > 0 && 
                t.getPlace_birth().length() > 0 && 
                t.getBirthday() != null && 
                t.getCi() > 0 &&
                t.getUsername().length() > 0 && 
                t.getPassword().length() > 0){
            switch(action){
                case "add":
                    processed = mod.add(t);
                    break;
                case "update":
                    processed = mod.update(t);
                    break;
            }
        }
        return processed;
    }
    
    public Hashtable getTeacherData(int id){
        Hashtable teacher = new Hashtable();
        if( id > 0 ){
            Teacher data = mod.getTeacherByID(id);
            teacher.put("first_name", data.getFirst_name());
            teacher.put("last_name", data.getLast_name());
            teacher.put("address", data.getAddress());
            teacher.put("ci", data.getCi());
            teacher.put("birthday", data.getBirthday());
            teacher.put("place_birth", data.getPlace_birth());
            teacher.put("photo", data.getPhoto());
            teacher.put("username", data.getUsername());
        }
        return teacher;
    }
    
    public String getTeacherNameByID(int teacher_id){
        String teachers_name = "";
        if(teacher_id > 0){
                teachers_name = mod.getTeacherNameByID(teacher_id);
        }
        return teachers_name;
    }
    
    public Object[][] getTeacherAttendances(int id, int month){
        Object[][] attendances = null;
        if( id > 0 ){
            attendances = mod.getAttendances(id, month);
        }
        return attendances;
    }
    
    public Object[][] getAllTeachers(){
        Object[][] teachers = null;
        teachers = mod.getAllTeachers();
        return teachers;
    }
    
    public String getPhotoById(int teacherId){
        String photo = "";
        if( teacherId > 0 ){
            photo = mod.getPhotoName(teacherId);
        }
        return photo;
    }
    
    public Object[][] getTeachersByCI(String ci){
        Object[][] teachers = null;
        if(ci.length() > 0){
            teachers = mod.searchTeachersByCI(ci);
        }
        return teachers;
    }
    public HashMap getClassRooms(){
        HashMap classrooms = new HashMap();
        classrooms = mod.getClassRooms();
        return classrooms;
    }
	
    public Hashtable viewMessages(int classroom_id, int teacher_id){
        Hashtable messages = new Hashtable();
        if(teacher_id > 0){
                messages = mod.getMessages(classroom_id, teacher_id);
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
    public String getMessageByID(int message_id){
        String message = "";
        if( message_id > 0 ){
                message = mod.getMessageByID(message_id);
        }
        return message;
    }
    public void deleteMessageByMessageID(int message_id, int teacher_id){
        if(teacher_id > 0 && message_id > 0){
                mod.dropMessageByTeacherID(message_id, teacher_id);
        }
    }
    public ArrayList<String> getTeachersBySearching(String name){
        ArrayList<String> teachers = new ArrayList<String>();
        if(name.length()!=0){
                teachers = mod.getTeachersBySearch(name);
        }
        return teachers;
    }
    public int getTeacherID(String fn, String ln){
        int teacher_id = 0;
        if( fn.length() !=0 || ln.length() !=0 ){
                teacher_id = mod.getTeacherID(fn, ln);
        }
        return teacher_id;
    }
    public ArrayList<String> getTeacherByClassroom(int classroom_id){
        ArrayList<String> teachers = new ArrayList<String>();
        if(classroom_id != 0){
                teachers = mod.getTeachersByClassroom(classroom_id);
        }
        return teachers;
    }
}
