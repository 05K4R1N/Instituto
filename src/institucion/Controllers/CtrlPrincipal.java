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
		if(mod.editPrincipalData(p, director_id)){
			updated = true;
		}
		return updated;
	}
	public HashMap<Integer, String> getAllTeachers(){
		return mod.getAllTeachers();
	}
	public boolean checkMessage(Message m, String estado){
		boolean res = false;
		if(!m.getTitle().isEmpty() || m.getTitle().length() != 0 ||
				!m.getContent().isEmpty() || m.getContent().length() != 0 || 
				m.getTeacher_id() != 0 || 
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
	public Object[][] getTodayAttendances(int classroom_id){
		Object[][] attendances = null;
		if(classroom_id > 0){
			attendances = mod.getTodayAttendances(classroom_id);
		}
		return attendances;
	}
}
