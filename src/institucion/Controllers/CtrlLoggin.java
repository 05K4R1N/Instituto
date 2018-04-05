/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Controllers;

import institucion.Models.BD.LogginBD;

/**
 *
 * @author Oscar
 */
public class CtrlLoggin {
    private LogginBD mod;
    
    public CtrlLoggin(){
        mod = new LogginBD();
    }
    
    public boolean validateUser(String username, String pass){
        boolean res = false;
        res = mod.authorizeUser(username, pass);
        return res;
    }
}
