/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Controllers;

import institucion.Models.BD.PrincipalBD;
import institucion.Models.Users.Message;
import institucion.Models.Users.Principal;
import java.util.HashMap;

/**
 *
 * @author o5k4r1n
 */
public class CtrlPrincipal {
    private PrincipalBD mod;

    public CtrlPrincipal(){
        mod = new PrincipalBD();
    }
    public Principal getPrincipalDataByID(int director_id){
        Principal p = new Principal();
        if(director_id > 0){
                p = mod.getPrincipalByID(director_id);
        }
        return p;
    }
    public boolean updatePrincipal(Principal p, int director_id){
        boolean updated = false;
        if(p.getName().length() != 0 && 
            p.getLastname().length() != 0 && 
            p.getAddress().length() != 0 && 
            p.getSex().length() != 0 &&
            p.getPhoto_name().length() != 0 && 
            p.getDate_of_birth() != null && 
            p.getCi() != 0 ){
                mod.editPrincipalData(p, director_id);
                updated = true;
        }
        return updated;
    }
    public HashMap<Integer, String> getAllTeachers(){
        return mod.getAllTeachers();
    }
    public boolean checkMessage(Message m, String estado){
        boolean res = false;
        if( m.getTitle().length() != 0 &&
            m.getContent().length() != 0 &&
            m.getTeacher_id() != 0 && 
            m.getClassroom_id() != 0){
            if(estado.equals("enviar")){
                    res = mod.sendMessage(m);
            }
            else{
                    res = mod.resendMessage(m);
            }
        }
        return res;
    }
    public Object[][] getMessages(){
        return mod.getAllMessages();
    }
    
    public Object[][] getMonthAttendances(int month){
        Object[][] res = null;
        if(month > 0){
            res = mod.getMonthAttendances(month);
        }
        return res;
    }
}