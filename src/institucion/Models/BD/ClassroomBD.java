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
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Map.Entry.comparingByValue;
import java.util.stream.Collectors;
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
        String query = "SELECT id, name, lastname "
                    + "FROM student "
                    + "WHERE classroom = ? "
                    + "ORDER BY student.lastname ASC";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setString(1, classroom);
            rs = ptmt.executeQuery();
            while(rs.next()){
                students.put(rs.getInt("id"), rs.getString("lastname") + " "+rs.getString("name"));
            }
            students = students.entrySet()
                                                    .stream()
                                                    .sorted(comparingByValue())
                                                    .collect(
                                                        Collectors.toMap(e -> e.getKey(), 
                                                                        e -> e.getValue(), 
                                                                        (e1, e2) -> e2, LinkedHashMap::new)
                                                    );
            /*students.entrySet().stream()
                    .sorted(Map.Entry.<Integer, String>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(System.out::println);*/
            //System.out.println(students.entrySet().stream().sorted());
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
                System.out.println(e);
        }
        return students;
    }
    public String getClassroomByID(int id){
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String classroom = "";
        String query = "SELECT name "
                        + "FROM classroom "
                        + "WHERE id = ?";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, id);
            rs = ptmt.executeQuery();
            rs.next();

            classroom = rs.getString("name");

            rs.close();
            ptmt.close();
            conn.close();

        }catch(SQLException e){
                System.out.println(e);
        }
        return classroom;
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
    public HashMap<String, Integer> getClassroomNumbers(String classroom,
                                                        String sched,
                                                        String subject){
        HashMap<String, Integer> data   =   new HashMap();
        Connection conn                 =   null;
        PreparedStatement ptmt          =   null;
        ResultSet rs                    =   null;
        int subject_id                  =   0;
        String query_classroom  =   "SELECT capacity "
                                + "FROM classroom "
                                + "WHERE name = ? "
                                + "AND shift = ? "
                                + "AND subject_id = ?";
        
        String query_subject    =   "SELECT id "
                                + "FROM subject "
                                + "WHERE name = ?";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query_subject);
            ptmt.setString(1, subject);
            rs = ptmt.executeQuery();
            if(rs.next())
                subject_id = rs.getInt("id");
            
            ptmt = conn.prepareStatement(query_classroom);
            ptmt.setString(1, classroom);
            ptmt.setString(2, sched);
            ptmt.setInt(3, subject_id);
            rs = ptmt.executeQuery();
            if(rs.next()){
                data.put("capacity", rs.getInt("capacity"));
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
}
