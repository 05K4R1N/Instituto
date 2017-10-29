/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author o5k4r1n
 */
public class Tiempo {
	private String hour;
	private String minutes;
	private String seconds;
	private String ampm;
	private Calendar calendar;
	
	public Tiempo(){}
	
	public String calcular(){
		String res = "";
		Calendar calendario = new GregorianCalendar();

		Date fechaHoraActual = new Date();
		calendario.setTime(fechaHoraActual);

		ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
		if(ampm.equals("PM")){
			int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
			hour = h>9?""+h:"0"+h;
		}else{
			hour = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);            
		}
		minutes = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
		seconds = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND); 
		
		res = hour + " : " + minutes + " : " + seconds + " " + ampm;
		return res;
	}	
}