/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Controllers;

import institucion.Models.BD.SecretaryBD;
import institucion.Models.Users.Secretary;

/**
 *
 * @author OscarT
 */
public class CtrlSecretary {
    
    private SecretaryBD mod;
    
    public CtrlSecretary(){
        mod = new SecretaryBD();
    }
    
    public Secretary getSecretaryId(int secretary_id){
        Secretary secretary = new Secretary();
        if(secretary_id > 0){
            secretary = mod.getSecretary(secretary_id);
        }
        return secretary;
    }
}
