/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author o5k4r1n
 */
public class ImagenPanel extends JPanel {
	
	private ImageIcon img;
	public ImagenPanel(ImageIcon img, int width, int height){
		this.img = img;
		this.setSize(300, 400); //se selecciona el tamaño del panel
	}

	@Override
	protected void paintComponent(Graphics g) {
		//se dibuja la imagen que tenemos en el paquete Images 
		//dentro de un panel
		g.drawImage(img.getImage(), 0, 0, 150, 150, null);

		setOpaque(false);
		super.paintComponent(g);
	}
	
}
