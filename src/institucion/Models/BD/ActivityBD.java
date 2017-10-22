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
import java.util.HashMap;

/**
 *
 * @author o5k4r1n
 */
public class ActivityBD {
	public boolean organizeActivity(Act a, String action){
		Connection conn = null;
		PreparedStatement ptmt = null;
		Date sql_date = new Date(a.getDate_activity().getTime()); 
		boolean res = false;
		if(action.equals("insert")){
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
				
				res = true;
				
				ptmt.close();
				conn.close();
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		return res;
	}
	public Object[][] getActivities(){
		HashMap<Integer, String> classrooms = new HashMap<Integer, String>();
		Object[][] activities = {};
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query_1 = "SELECT id, name FROM classroom ";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query_1);
			rs = ptmt.executeQuery();
			while(rs.next()){
				classrooms.put(rs.getInt("id"), rs.getString("name"));
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			try{
				String query_2 = "SELECT * FROM activity";
				ptmt = conn.prepareStatement(query_2);
				rs = ptmt.executeQuery();
				rs.beforeFirst();  
				rs.last();  
				int tam = rs.getRow();
				activities = new Object[tam][5];
				rs = ptmt.executeQuery();
				int i = 0;
				while(rs.next()){
					activities[i][0] = rs.getInt("id");
					activities[i][1] = classrooms.get(rs.getInt("classroom_id"));
					activities[i][2] = rs.getString("activity_name");
					activities[i][3] = rs.getDate("activity_date");
					activities[i][4] = rs.getString("activity_time");
					i++;
				}
				rs.close();
				ptmt.close();
				conn.close();
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		return activities;
	}
	public Act getActivityByID(int id){
		Act a = new Act();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query  = "SELECT * "
				+ "FROM  activity "
				+ "WHERE id = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			rs.next();
			
			a.setClassroom_id(rs.getInt("classroom_id"));
			a.setName(rs.getString("activity_name"));
			a.setDescription(rs.getString("description"));
			a.setDate_activity(rs.getDate("activity_date"));
			a.setTime_activity(rs.getString("activity_time"));
			
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return a;
	}
}
