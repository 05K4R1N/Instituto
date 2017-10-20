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
		if(mod.organizeActivity(a, action))
			res = true;
		return res;
	}
}
