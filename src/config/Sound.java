/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author o5k4r1n
 */
public class Sound {

	
    public Sound(){}
    public void reproduce(String fileSound){
        try {
            Player apl;
            try {
                apl = new Player(new FileInputStream(System.getProperty("user.dir")+"/src/sounds/"+fileSound));
                apl.play();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }
        catch (JavaLayerException e) {
            System.out.println(e);
        } 
    }
}
