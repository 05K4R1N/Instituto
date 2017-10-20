/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.BD;

import config.Conexion;
import institucion.Models.Users.Act;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author o5k4r1n
 */
public class ActivityBD {
	public boolean organizeActivity(Act a, String action){
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		Date sql_date = new Date(a.getDate_activity().getTime()); 
		boolean res = false;
		String query = "INSERT INTO activity(classroom_id, activity_name, description, activity_date, activity_time) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, a.getClassroom_id());
			ptmt.setString(2, a.getName());
			ptmt.setString(3, a.getDescription());
			ptmt.setDate(4, sql_date);
			ptmt.setString(5, a.getTime_activity());
			
			ptmt.executeUpdate();
			
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return res;
	}
}
