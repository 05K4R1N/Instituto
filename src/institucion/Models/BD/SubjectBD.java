
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.BD;

import config.Conexion;
import institucion.Models.Users.Subject;
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
public class SubjectBD {
    
    public boolean processData(Subject subject, String action){
        boolean res             =   false;
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        ResultSet rs            =   null;
        try{
            conn = Conexion.getInstance().getConnection();
            String query = "";
            String subjectList = "";
            switch(action){
                case "add":
                    query = "INSERT INTO subject(name,description,schedules) "
                        + "VALUES (?,?,?)";
                    subjectList = String.join(",", subject.getSchedule().values());
                    ptmt = conn.prepareStatement(query);
                    ptmt.setString(1, subject.getName());
                    ptmt.setString(2, subject.getDescription());
                    ptmt.setString(3, subjectList);
                    break;
                case "update":
                    query = "UPDATE subject "
                            + "set name=?, description = ?, schedules=? "
                            + "WHERE id = ?";
                    subjectList = String.join(",", subject.getSchedule().values());
                    ptmt = conn.prepareStatement(query);
                    ptmt.setString(1, subject.getName());
                    ptmt.setString(2, subject.getDescription());
                    ptmt.setString(3, subjectList);
                    ptmt.setInt(4, subject.getSubjectId());
                    break;
            }
            ptmt.executeUpdate();
            res = true;
            
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        } 
        return res;
    }
	
    public Subject getSubjectById(int id){
        Subject subject = new Subject();
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String query = "SELECT * "
                    + "FROM subject "
                    + "WHERE id = ?";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, id);
            rs = ptmt.executeQuery();
            rs.next();
            subject.setName(rs.getString("name"));
            subject.setDescription(rs.getString("description"));
            String[] schedulesArr = rs.getString("schedules").split(",");
            HashMap<String, String> schedules = new HashMap<String, String>();
            schedules.put("Morning", schedulesArr[2]);
            schedules.put("Afternoon", schedulesArr[0]);
            schedules.put("Night", schedulesArr[1]);
            
            subject.setSchedule(schedules);
            
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
                System.out.println(e);
        }
        return subject;
    }
    
    public ArrayList<String> getAllNameSubjects(){
        ArrayList<String> subjects  =   new ArrayList<String>();
        Connection conn             =   null;
        PreparedStatement ptmt      =   null;
        ResultSet rs                =   null;
        String query = "SELECT name FROM subject";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            rs = ptmt.executeQuery();
            while(rs.next()){
                subjects.add(rs.getString("name"));
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return subjects;
    }
    
    public ArrayList<String> getShiftsByName(String name){
        ArrayList<String> shifts    = new ArrayList<String>();
        Connection conn             = null;
        PreparedStatement ptmt      = null;
        ResultSet rs                = null;
        String query = "SELECT shift "
                    + "FROM subject "
                    + "WHERE name = ?";
        try{
            conn    =   Conexion.getInstance().getConnection();
            ptmt    =   conn.prepareStatement(query);
            ptmt.setString(1, name);
            rs      =   ptmt.executeQuery();
            if(rs.next()){
                String[] data = rs.getString("shift").split(","); 
                for(String shift: data){
                    shifts.add(shift);
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return shifts;
    }
    
    public Object[][] getAllSubjects(){
        Object[][] subjects     =   {};
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        ResultSet rs            =   null;
        try{
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT * FROM subject";
            ptmt = conn.prepareStatement(query);
            rs = ptmt.executeQuery();
            rs.beforeFirst();
            rs.beforeFirst();  
            rs.last();  
            int tam = rs.getRow();
            subjects = new Object[tam][3];
            rs = ptmt.executeQuery();
            int i = 0;
            while(rs.next()){
                subjects[i][0] = rs.getInt("id");
                subjects[i][1] = rs.getString("name");
                subjects[i][2] = rs.getString("schedules");
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
    
    public boolean delete(int subjectId){
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        boolean res             =   false;
        try{
            conn = Conexion.getInstance().getConnection();
            String query = "DELETE FROM subject WHERE id = ?";
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, subjectId);
            
            ptmt.executeUpdate();
            res = true;
            
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
}
