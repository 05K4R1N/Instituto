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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
/**
 *
 * @author master
 */
public class TeacherBD {

    public boolean assignSubject(int teacher_id, int year, String gestion, 
                                ArrayList<String> subjects){
        boolean res             =   false;
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        try{ 
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO teacher_subject "
                    + "(teacher_id, subject_id, year, gestion, available) VALUES ";
            int tam = subjects.size(), i = 0;
            for(String subject_id: subjects){
                query += "('"+teacher_id+"','"+subject_id+"','"+year+"','"+gestion+"','"+1+"')";
                i++;
                if( i < tam){
                    query += ", ";
                }
            }
            ptmt = conn.prepareStatement(query);
            
            ptmt.executeUpdate();
            res = true;
            ptmt.close();
            conn.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
    public String getPhotoName(int teacherId){
        String photo = "";
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT photo FROM teacher WHERE id = ?";
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, teacherId);
            rs = ptmt.executeQuery();
            if(rs.next()){
                photo = rs.getString("photo");
            }
            
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return photo;
    }
    
    public String[] getSubjectsAssigned(int teacher_id, int year, String gestion){
        String[] subjects = {};
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        ResultSet rs            =   null;
        try{
            conn            =   Conexion.getInstance().getConnection();
            String query    =   "SELECT subject_id "
                                + "FROM teacher_subject "
                                + "WHERE teacher_id = ? AND year = ? AND gestion = ?";
            ptmt            =   conn.prepareStatement(query);
            ptmt.setInt(1, teacher_id);
            ptmt.setInt(2, year);
            ptmt.setString(3, gestion);
            rs              =   ptmt.executeQuery();
            rs.beforeFirst();  
            rs.last();  
            int tam = rs.getRow();
            subjects = new String[tam];
            rs = ptmt.executeQuery();
            int i = 0;
            while(rs.next()){
                subjects[i] = rs.getString("subject_id");
                i++;
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return subjects;
    }
    public Object[][] getTeachersSubject(String[] subjects, String negative){
        Object assigned[][] = {};
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        ResultSet rs            =   null;
        try{
            conn = Conexion.getInstance().getConnection();
            int size = subjects.length;
            String query = "SELECT * "
                        + "FROM subject "
                        + "WHERE id "+negative+" IN (";
            String cond = "";
            for(int i = 0; i < size; i++){
                cond += ","+subjects[i];
            }
            cond = cond.replaceFirst(",", "");
            cond += ")";
            query += cond;
            ptmt = conn.prepareStatement(query);
            rs = ptmt.executeQuery();
            rs.beforeFirst();  
            rs.last();  
            int tam = rs.getRow();
            assigned = new Object[tam][3];
            rs = ptmt.executeQuery();
            int i = 0;
            while(rs.next()){
                assigned[i][0]  =   rs.getInt("id");
                assigned[i][1]  =   rs.getString("name");
                assigned[i][2]  =   rs.getString("schedules");
                i++;
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return assigned;
    }
    public boolean deleteTeacherById(int teacher_id){
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        boolean res             =   false;
        try{
            String[] queries ={ "DELETE FROM subject WHERE teacher_id = ?",
                                "DELETE FROM teacher_classroom WHERE teacher_id = ?",
                                "DELETE FROM message WHERE teacher_id = ?",
                                "DELETE FROM teacher WHERE id = ?"};
            
            conn = Conexion.getInstance().getConnection();
            for(String q: queries){
                ptmt = conn.prepareStatement(q);
                ptmt.setInt(1, teacher_id);
                ptmt.executeUpdate();
            }
            res = true;
            
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
    public Object[][] searchTeachersByCI(String ci){
        Object[][] teachers     =   null;
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        ResultSet rs            =   null;
        int i = 0;
        int tam = 0;
        try{
            String query = "SELECT * "
                        + "FROM teacher "
                        + "WHERE ci LIKE '%"+ci+"%'";
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            rs = ptmt.executeQuery();
            rs.beforeFirst();
            rs.last();
            tam = rs.getRow();
            teachers = new Object[tam][5];
            rs = ptmt.executeQuery();
            while(rs.next()){
                teachers[i][0] = rs.getInt("id");
                teachers[i][1] = rs.getString("first_name");
                teachers[i][2] = rs.getString("last_name");
                teachers[i][3] = rs.getDate("birthday");
                teachers[i][4] = rs.getString("username");
                i++;
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return teachers;
    }
    public Object[][] getAllTeachers(){
        Object[][] teachers = null;
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Teacher";
        int i = 0;
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            rs = ptmt.executeQuery();
            rs.beforeFirst();  
            rs.last();  
            int tam = rs.getRow();
            teachers = new Object[tam][5];
            rs = ptmt.executeQuery();
            while(rs.next()){
                teachers[i][0] = rs.getInt("id");
                teachers[i][1] = rs.getString("first_name");
                teachers[i][2] = rs.getString("last_name");
                teachers[i][3] = rs.getDate("birthday");
                teachers[i][4] = rs.getString("username");
                i++;
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return teachers;
    }
    public  boolean update(Teacher t){
        boolean res = false;
        Connection conn = null;
        PreparedStatement ptmt = null;
        Date sql_date = new Date(t.getBirthday().getTime()); 
        String query = "UPDATE Teacher "
                    + "SET first_name=?, "
                    + "last_name=?, "
                    + "ci = ?, "
                    + "birthday=?, "
                    + "address=?, "
                    + "place_birth=?, "
                    + "photo=?, "
                    + "username=?, "
                    + "password=? "
                    + "WHERE id=?";
        try {
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setString(1, t.getFirst_name());
            ptmt.setString(2, t.getLast_name());
            ptmt.setInt(3, t.getCi());
            ptmt.setDate(4, sql_date);
            ptmt.setString(5, t.getAddress());
            ptmt.setString(6, t.getPlace_birth());
            ptmt.setString(7, t.getPhoto());
            ptmt.setString(8, t.getUsername());
            ptmt.setString(9, t.getPassword());
            ptmt.setInt(10, t.getId());
            
            ptmt.executeUpdate();
            
            res = true;
            
            ptmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return res;
    }
    
    public boolean add(Teacher t){
        Connection conn = null;
        PreparedStatement ptmt = null;
        boolean res = false;
        try{
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO teacher (first_name, last_name, address, ci,"
                                            + "birthday, code, place_birth, photo, "
                                            + "username, password) VALUES "
                                            + "(?,?,?,?,?,?,?,?,?,?)";
            ptmt = conn.prepareStatement(query);
            ptmt.setString(1, t.getFirst_name());
            ptmt.setString(2, t.getLast_name());
            ptmt.setString(3, t.getAddress());
            ptmt.setInt(4, t.getCi());
            ptmt.setDate(5, new Date(t.getBirthday().getTime()));
            ptmt.setString(6, t.getCode());
            ptmt.setString(7, t.getPlace_birth());
            ptmt.setString(8, t.getPhoto());
            ptmt.setString(9, t.getUsername());
            ptmt.setString(10, t.getPassword());
            
            ptmt.executeUpdate();
            res = true;
            
            ptmt.close();
            conn.close();
            
        }catch(SQLException e){
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
            t.setAddress(rs.getString("address"));
            t.setCi(rs.getInt("ci"));
            t.setBirthday(rs.getDate("birthday"));
            t.setPlace_birth(rs.getString("place_birth"));
            t.setPhoto(rs.getString("photo"));
            t.setUsername(rs.getString("username"));
            
            rs.close();
            ptmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return t;
    }
    public Object[][] getAttendances(int id, int month){
        Calendar now            =   Calendar.getInstance();
        month                   =   (month == 0)?now.get(Calendar.MONTH) +1:month;
        Object[][] attendances  =   {};
        Connection conn         =   null;
        ResultSet rs            =   null;
        PreparedStatement ptmt  =   null;
        String query            = "SELECT attendance_status, date_enter, time_enter "
                                + "FROM attendance "
                                + "WHERE personal_id = ? AND MONTH(date_enter) = ?"; 
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, id);
            ptmt.setInt(2, month);
            rs = ptmt.executeQuery();
            rs.beforeFirst();  
            rs.last();  
            int tam = rs.getRow(); 
            attendances = new Object[tam][2];
            rs = ptmt.executeQuery();
            int i=0;
            while(rs.next()){
                attendances[i][0] = rs.getString("attendance_status");
                attendances[i][1] = rs.getDate("date_enter") + " - " + rs.getTime("time_enter");
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
    public String getTeacherNameByID(int teacher_id){
        String name = "";
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String query = "SELECT first_name, last_name "
                                + "FROM Teacher "
                                + "WHERE id = ?";
        try{
                conn = Conexion.getInstance().getConnection();
                ptmt = conn.prepareStatement(query);
                ptmt.setInt(1, teacher_id);
                rs = ptmt.executeQuery();
                rs.next();
                name = rs.getString("last_name")+", "+rs.getString("first_name");

                rs.close();
                ptmt.close();
                conn.close();
        }catch(SQLException e){
                System.out.println(e);
        }
        return name;
    }
}
