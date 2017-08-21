/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author o5k4r1n
 */
public class ClassroomBD {
	public HashMap getClassroomsByTeacherID(int id){
		HashMap classrooms = new HashMap();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "";
		return classrooms;
	}
}
