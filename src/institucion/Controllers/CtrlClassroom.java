/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Controllers;

import institucion.Models.BD.ClassroomBD;
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
	public HashMap getClassroomByTeacher(int teacher_id){
		HashMap classrooms = new HashMap();
		if(teacher_id > 0){
			classrooms = mod.getClassroomsByTeacherID(teacher_id);
		}
		return classrooms;
	}
}
