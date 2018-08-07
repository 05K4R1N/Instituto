/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Controllers;

import institucion.Models.BD.ActivityBD;
import institucion.Models.Users.Act;

/**
 *
 * @author o5k4r1n
 */
public class CtrlActivity {
    private ActivityBD mod;

    public CtrlActivity(){
        mod = new ActivityBD();
    }
    public boolean organizeActivity(Act a, String action){
        boolean res = false;
        if(a.getName().length() != 0 &&
                a.getDescription().length() != 0 && 
                a.getDate_activity() != null &&
                a.getTime_activity() != null && 
                a.getClassroom_id() != 0)
            res = true;
        /*if(mod.organizeActivity(a, action))
                res = true;*/
        return res;
    }
    public Object[][] getActivities(){
        return mod.getActivities();
    }
    public Act getActivityById(int id){
        Act a = new Act();
        if( id > 0 ){
            a = mod.getActivityByID(id);
        }
        return a;
    }
    public boolean deleteActivity(int activity_id){
        boolean res = false;
        if( activity_id > 0 ){
            res = mod.deleteActivity(activity_id);
        }
        return res;
    }
}
