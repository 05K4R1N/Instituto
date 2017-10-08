/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.BD;

import config.Conexion;
import institucion.Models.Users.Teacher;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
/**
 *
 * @author master
 */
public class TeacherBD {
    public  boolean add(Teacher t){
        boolean res = false;
        Connection conn = null;
        PreparedStatement ptmt = null;
        Date sql_date = new Date(t.getBirthday().getTime()); 
        String query = "UPDATE Teacher set first_name=?, last_name=?, birthday=?, address=?, place_birth=? WHERE id=?";
        try {
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setString(1, t.getFirst_name());
            ptmt.setString(2, t.getLast_name());
            ptmt.setDate(3, sql_date);
            ptmt.setString(4, t.getAddress());
            ptmt.setString(5, t.getPlace_birth());
            ptmt.setInt(6, 1);
            ptmt.executeUpdate();
            
            ptmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return res;
    }
    public Teacher getTeacherByID(int id){
        Teacher t = new Teacher();
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Teacher WHERE id = ?";
        try {
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, id);
            rs = ptmt.executeQuery();
            rs.next();
            t.setFirst_name(rs.getString("first_name"));
            t.setLast_name(rs.getString("last_name"));
            t.setBirthday(rs.getDate("birthday"));
            t.setPlace_birth(rs.getString("place_birth"));
            t.setAddress(rs.getString("address"));
			t.setPhoto(rs.getString("photo"));
            rs.close();
            ptmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return t;
    }
    public Object[][] getAttendances(int id){
        Object[][] attendances  = {};
        Connection conn         = null;
        ResultSet rs            = null;
        PreparedStatement ptmt  = null;
        String query        = "SELECT attendance_status, time_attendance FROM attendance WHERE teacher_id = ? LIMIT 15"; 
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, id);
            rs = ptmt.executeQuery();
            rs.beforeFirst();  
            rs.last();  
            int tam = rs.getRow(); 
            attendances = new Object[tam][2];
            rs = ptmt.executeQuery();
            int i=0;
            while(rs.next()){
                attendances[i][0] = rs.getString("attendance_status");
                attendances[i][1] = rs.getDate("time_attendance") + " " + rs.getTime("time_attendance");
                i++;
            }
            
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return attendances;
    }
    /* Method will be changed for other query*/
    public HashMap getClassRooms(){
        HashMap classrooms      = new HashMap();
        Connection conn     = null;
        ResultSet rs        = null;
        PreparedStatement ptmt = null;
        String query = "SELECT * FROM  classroom";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            rs = ptmt.executeQuery();
            while(rs.next()){
                classrooms.put(rs.getInt("id"), rs.getString("name"));
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return classrooms;
    }
	
	public Hashtable<Integer,String> getMessages(int classroom_id, int teacher_id){
		Hashtable<Integer,String> messages = new Hashtable();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT id, title "
					+ "FROM message "
					+ "WHERE teacher_id = ? AND classroom_id = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, teacher_id);
			ptmt.setInt(2, classroom_id);
			rs = ptmt.executeQuery();
			while(rs.next()){
				messages.put(rs.getInt("id"), rs.getString("title"));
			}
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);	
		}
		return messages;
	}
	public HashMap getSubjectsbyTeacherId(int id){
		HashMap subjects = new HashMap();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ptmt = null;
		String query = "SELECT id, name "
					+ "FROM subject "
					+ "WHERE teacher_id= ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			while(rs.next()){
				subjects.put(rs.getInt("id"), rs.getString("name"));
			}
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return subjects;
	}
	public String getMessageByID(int teacher_id){
		String message = "";
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT content "
						+ "FROM message "
						+ "WHERE id = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, teacher_id);
			rs = ptmt.executeQuery();
			rs.next();
			message = rs.getString("content");
			
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return message;
	}
	public void dropMessageByTeacherID(int message_id, int teacher_id){
		Connection conn = null;
		PreparedStatement ptmt = null;
		String sql = "DELETE FROM message where id = ? AND teacher_id = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, message_id);
			ptmt.setInt(2, teacher_id);
			ptmt.executeUpdate();
			
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	public ArrayList<String> getTeachersBySearch(String name){
		ArrayList<String> teachers = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT CONCAT(last_name, '-', first_name) as teacher_name "
					+ "FROM  Teacher "
					+ "WHERE first_name LIKE '%"+name+"%' OR last_name LIKE '%"+name+"%'";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			rs = ptmt.executeQuery();
			while(rs.next()){
				teachers.add(rs.getString("teacher_name"));
			}
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.err.println(e);
		}
		return teachers;
	}
	public int getTeacherID(String fname, String lname){
		int teacher_id = 0;
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT id "
					+ "FROM Teacher "
					+ "WHERE first_name LIKE '%"+fname+"%' AND last_name LIKE '%"+lname+"%'";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			rs = ptmt.executeQuery();
			rs.next();
			teacher_id = rs.getInt("id");
		}catch(SQLException e){
			System.out.println(e);
		}
		return teacher_id;
	}
	public ArrayList<String> getTeachersByClassroom(int classroom_id){
		ArrayList<String> teachers = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT CONCAT(A.last_name, ', ', A.first_name) as teachers_name "
						+ "FROM Teacher A, teacher_classroom B "
						+ "WHERE  B.teacher_id = A.id AND B.classroom_id = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, classroom_id);
			rs = ptmt.executeQuery();
			while(rs.next()){
				teachers.add(rs.getString("teachers_name"));
			}
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return teachers;
	}
}
