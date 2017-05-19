/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Controllers;

import institucion.Models.BD.TeacherBD;
import institucion.Models.Users.Teacher;

/**
 *
 * @author master
 */
public class CtrlTeacher {

    private TeacherBD mod;
    public CtrlTeacher(){
        mod = new TeacherBD();
    }
    public boolean add(Teacher t){
        boolean added = false;
        System.out.println("entro");
        if(( t.getFirst_name().length() != 0 || !t.getFirst_name().equals(" ") ) || 
                (t.getLast_name().length() != 0 || !t.getLast_name().equals(" ")) || 
                (t.getBirthday().toString().isEmpty() || !t.getBirthday().toString().equals(" ")) || 
                (t.getPlace_birth().length() != 0 || !t.getPlace_birth().equals(" ")) || 
                (t.getAddress().length() != 0 || !t.getAddress().equals(" ")) ){
            mod.add(t);
            added = true;
        }
        return added;
    }
    public void saludo(){
        System.out.println("hola");
    }
}
