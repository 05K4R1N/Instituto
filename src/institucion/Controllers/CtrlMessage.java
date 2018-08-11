/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Controllers;

import institucion.Models.BD.MessageBD;

/**
 *
 * @author Oscar
 */
public class CtrlMessage {
    
    private MessageBD mod;
    public CtrlMessage(){
        mod = new MessageBD();
    }
    
    public boolean deleteMessage(int message_id){
        boolean res = false;
        if(mod.deleteMessageByID(message_id)){
            res = true;
        }
        return res;
    }
}
