package institucion.Controllers;

import config.Conexion;
import institucion.Models.BD.SubjectBD;
import institucion.Models.Users.Subject;
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
	
}
