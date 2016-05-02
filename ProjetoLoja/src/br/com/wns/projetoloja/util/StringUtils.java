/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wns.projetoloja.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marly
 */
public class StringUtils {
    
    
    public static String formatarData(Date data){
        
        SimpleDateFormat formato = new  SimpleDateFormat("dd/MM/yyyy");  
        return formato.format(data);
    }
    
    public static Date converterData(String data) throws ParseException{
       
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       
         Date date= formato.parse(data);
         return date; 
    }  
}
