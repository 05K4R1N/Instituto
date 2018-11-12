package institucion.Controllers;

import config.Conexion;
import institucion.Models.BD.SubjectBD;
import institucion.Models.Users.Subject;
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
public class CtrlSubject {
    private SubjectBD mod;

    public CtrlSubject(){
        mod = new SubjectBD();
    }
    
    public Subject getSubjectById(int id){
        Subject subject = null;
        if( id > 0 ){
            subject = mod.getSubjectById(id);
        }
        return subject;
    }
    
    public boolean validateSubjectId(int subjectId){
        boolean res = false;
        if( subjectId > 0 ){
            res = mod.delete(subjectId);
        }
        return res;
    }

    public ArrayList<String> getNameSubjects(){
        return mod.getAllNameSubjects();
    }
    
    public ArrayList<String> getSubjectShifts(String name){
        ArrayList<String> shifts = new ArrayList<String>();
        if(!name.equals("Seleccione Materia")){
            shifts = mod.getShiftsByName(name);
        }
        return shifts;
    }
    
    public Object[][] getAllSubjects(){
        return mod.getAllSubjects();
    }
    
    public boolean validateSubjectData(Subject subject, String action){
        boolean res = false;
        switch(action){
            case "add":
                if(subject.getName().length() > 0 && 
                    !subject.getSchedule().containsValue("--:--")){
                    res = mod.processData(subject, action);
                }
                break;
            case "update":
                if( subject.getName().length() > 0 && 
                    !subject.getSchedule().containsValue("--:--") && 
                    subject.getSubjectId() > 0 ){
                    res = mod.processData(subject, action);
                }
        }
        return res;
    }
}
