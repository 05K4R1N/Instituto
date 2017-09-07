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
}
