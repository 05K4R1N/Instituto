/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.BD;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author o5k4r1n
 */
public class ClassroomBD {
	public ArrayList<String> getClassRooms(){
		ArrayList<String> classrooms = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT name FROM classroom";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			rs = ptmt.executeQuery();
			while(rs.next()){
				classrooms.add(rs.getString("name"));
			}
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return classrooms;
	}
	public HashMap getClassroomStudents(String classroom){
		HashMap<Integer, String> students = new HashMap<Integer, String>();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT id, name, lastname FROM student WHERE classroom = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, classroom);
			rs = ptmt.executeQuery();
			while(rs.next()){
				students.put(rs.getInt("id"), rs.getString("lastname") + " "+rs.getString("name"));
			}
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return students;
	}
	public int getClassroomID(String classroom){
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int id = 0;
		String query = "SELECT id "
					+ "FROM classroom "
					+ "WHERE name=?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, classroom);
			rs = ptmt.executeQuery();
			rs.next();
			id = rs.getInt("id");
			
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return id;
	}
	public HashMap<String, Integer> getClassroomNumbers(String classroom){
		HashMap<String, Integer> data = new HashMap();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT capacity, occupied "
				+ "FROM classroom "
				+ "WHERE name = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, classroom);
			rs = ptmt.executeQuery();
			rs.next();
			data.put("capacity", rs.getInt("capacity"));
			data.put("occupied", rs.getInt("occupied"));
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return data;
	}
}
