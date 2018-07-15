/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Controllers;

import institucion.Models.BD.ClassroomBD;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author o5k4r1n
 */
public class CtrlClassroom {
    private ClassroomBD mod;

    public CtrlClassroom(){
        mod = new ClassroomBD();
    }

    public ArrayList<String> obtainClassrooms(){
            return mod.getClassRooms();
    }
    public HashMap getStudents_of_classroom(String classroom){
        HashMap students = new HashMap();
        if(classroom.length() == 0 || 
                !classroom.equals("Seleccione un Aula")){
                students = mod.getClassroomStudents(classroom);
        }
        return students;
    }
    public int getClassroomID(String classroom){
        int classroom_id = 0;
        if(classroom.length()!=0){
                classroom_id = mod.getClassroomID(classroom);
        }
        return classroom_id;
    }
    public String getClassroomByID(int id){
        String classroom = "";
        if( id > 0 ){
                classroom = mod.getClassroomByID(id);
        }
        return classroom;
    }
    public HashMap<String, Integer> getClassroomNumbers(String classroom,
                                                        String sched,
                                                        String subject){
        HashMap<String, Integer> data = new HashMap();
        if((!classroom.isEmpty() || classroom.length() != 0) &&
                (sched.isEmpty() || sched.length() != 0) && 
                (subject.isEmpty() || sched.length() != 0)){
            data = mod.getClassroomNumbers(classroom, sched, subject);
        }
        return data;
    }
}
