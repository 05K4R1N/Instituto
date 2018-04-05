/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion;

import institucion.Views.Loggin.Loggin;
import institucion.Views.Teacher.Welcome;
/**
 *
 * @author master
 */
public class Institucion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Welcome w = new Welcome();
        w.setVisible(true);*/
        Loggin log = new Loggin();
        log.setVisible(true);
    }
}
