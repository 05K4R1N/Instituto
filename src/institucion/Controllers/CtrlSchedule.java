/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Controllers;

import institucion.Models.BD.ScheduleBD;
import java.util.HashMap;

/**
 *
 * @author Oscar
 */
public class CtrlSchedule {
    
    private ScheduleBD mod;
    
    public CtrlSchedule(){
        mod = new ScheduleBD();
    }
    public boolean addSchedule(int teacher_id, String time){
        boolean res = false;
        if(teacher_id > 0 && time.length() != 0){
            res = mod.addSchedule(teacher_id, time);
        }
        return res;
    }
}
