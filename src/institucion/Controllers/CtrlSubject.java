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
    
    public boolean validateRegistration(Subject subject){
        boolean res = false;
        if(subject.getName().length() > 0 && 
                !subject.getSchedule().containsValue("--:--")){
            res = mod.register(subject);
        }
        return res;
    }
}
