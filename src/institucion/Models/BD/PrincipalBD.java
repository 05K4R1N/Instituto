/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.BD;

import config.Conexion;
import institucion.Models.Users.Message;
import institucion.Models.Users.Principal;
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
public class PrincipalBD {
	
    public Principal getPrincipalByID(int director_id){
        Connection			conn    =   null;
        PreparedStatement               ptmt	=   null;
        ResultSet			rs	=   null;
        Principal			p       =   new Principal();

        String query = "SELECT * FROM principal where id = ?";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, director_id);
            rs = ptmt.executeQuery();
            rs.next();
            p.setName(rs.getString("name"));
            p.setLastname(rs.getString("lastname"));
            p.setSex(rs.getString("sex"));
            p.setAddress(rs.getString("address"));
            p.setDate_of_birth(rs.getDate("date_of_birth"));
            p.setCi(rs.getInt("ci"));
            p.setPhoto_name(rs.getString("photo"));

            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return p;
    }
    public void editPrincipalData(Principal p, int director_id){
        Connection  conn	=   null;
        PreparedStatement ptmt	=   null;
        ResultSet rs		=   null;

        Date principal_birthday = new Date(p.getDate_of_birth().getTime()); 
        String sex = (p.getSex().equals("Femenino"))?"F":"M";

        String query = "UPDATE principal set name = ?, "
                                        + "lastname = ?, "
                                        + "sex = ?, "
                                        + "photo = ?, "
                                        + "address = ?, "
                                        + "date_of_birth = ?, "
                                        + "ci = ? "
                                + "WHERE id = ?";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setString(1, p.getName());
            ptmt.setString(2, p.getLastname());
            ptmt.setString(3, sex);
            ptmt.setString(4, p.getPhoto_name());
            ptmt.setString(5, p.getAddress());
            ptmt.setDate(6, principal_birthday);
            ptmt.setInt(7, p.getCi());
            ptmt.setInt(8, director_id);

            ptmt.executeUpdate();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public HashMap getAllTeachers(){
        HashMap<Integer, String> teachers = new HashMap();
        Connection		conn	=	null;
        PreparedStatement	ptmt	=	null;
        ResultSet		rs	=	null;
        String query = "SELECT id, first_name, last_name "
                                + "FROM Teacher";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            rs	 = ptmt.executeQuery();
            while(rs.next()){
                    teachers.put(rs.getInt("id"), rs.getString("first_name") + " " + rs.getString("last_name"));
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return teachers;
    }

    public boolean sendMessage(Message m){
        Connection conn = null;
        PreparedStatement ptmt = null;
        boolean registered = false;

        String query = "INSERT INTO message (teacher_id, classroom_id, title, content, moment, resend) "
                                + "VALUES (?,?,?,?,?,?)";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, m.getTeacher_id());
            ptmt.setInt(2, m.getClassroom_id());
            ptmt.setString(3, m.getTitle());
            ptmt.setString(4, m.getContent());
            ptmt.setString(5, m.getMoment());
            ptmt.setInt(6, m.getResend());

            ptmt.executeUpdate();
            registered = true;
            ptmt.close();
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return registered;
    }
    public Object[][] getAllMessages(){
        Object[][] messages = {};
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String query = "SELECT * "
                    + "FROM message";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            rs = ptmt.executeQuery();
            rs.beforeFirst();  
            rs.last();  
            int tam = rs.getRow();
            messages = new Object[tam][7];
            rs = ptmt.executeQuery();
            int i = 0;
            while(rs.next()){
                messages[i][0]	= rs.getInt("id");
                messages[i][1]	= rs.getString("title");
                messages[i][2]	= rs.getString("content");
                messages[i][3]	= rs.getInt("resend");
                messages[i][4]	= rs.getInt("teacher_id");
                messages[i][5]	= rs.getInt("classroom_id");
                messages[i][6]	= rs.getInt("resend");
                i++;
            }

            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return messages;
    }
    public boolean resendMessage(Message m){
        boolean res = false;
        Connection conn = null;
        PreparedStatement ptmt = null;
        String query = "UPDATE message "
                    + "SET teacher_id = ?, classroom_id = ?, title = ?, content = ?, resend = ? "
                    + "WHERE id = ?";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, m.getTeacher_id());
            ptmt.setInt(2, m.getClassroom_id());
            ptmt.setString(3, m.getTitle());
            ptmt.setString(4, m.getContent());
            ptmt.setInt(5, m.getResend());
            ptmt.setInt(6, m.getId());

            ptmt.executeUpdate();
            res = true;
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
    public Object[][] getMonthAttendances(int month){
        Object[][] res          =   {};
        HashMap<Integer, String> teachers = new HashMap<Integer,String>();
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        ResultSet rs            =   null;
        String query_attendance =   "SELECT * "
                                + " FROM attendance "
                                + " WHERE MONTH(date_enter) = ? "
                                + " AND type_personal = 'teacher'";
        
        String query_teacher    =   "SELECT id, CONCAT(first_name,' ',last_name) as Profesor "
                                + "FROM teacher "
                                + "WHERE id IN "
                                + "(SELECT DISTINCT(personal_id) "
                                + "FROM attendance "
                                + "WHERE type_personal = 'teacher' AND "
                                + "MONTH(date_enter) = ? "
                                + "ORDER BY type_personal DESC)";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query_teacher);
            ptmt.setInt(1, month);
            rs  = ptmt.executeQuery();
            while(rs.next()){
                teachers.put(rs.getInt("id"), rs.getString("Profesor"));
            }
            ptmt = conn.prepareStatement(query_attendance);
            ptmt.setInt(1, month);
            rs = ptmt.executeQuery();
            rs.beforeFirst();  
            rs.last();  
            int tam =   rs.getRow(); 
            res     =   new Object[tam][3];
            rs      =   ptmt.executeQuery();
            int i   =   0;
            while(rs.next()){
                res[i][0]   =   teachers.get(rs.getInt("personal_id"));
                res[i][1]   =   rs.getString("attendance_status");
                res[i][2]   =   rs.getDate("date_enter") + " - " + rs.getTime("time_enter");
                i++;
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
}
