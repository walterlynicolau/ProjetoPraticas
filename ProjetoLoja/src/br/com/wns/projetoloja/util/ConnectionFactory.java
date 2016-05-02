/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wns.projetoloja.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VALENA
 */
public class ConnectionFactory {
    private static Connection connection;

    public static Connection getConnection() {
        
        try {
            
            if(connection == null || connection.isClosed()){
                connection =  DriverManager.getConnection(PropertiesUtil.getConfValue(PropertiesUtil.JDBC_URL),
                                                          PropertiesUtil.getConfValue(PropertiesUtil.JDBC_USERNAME),
                                                          PropertiesUtil.getConfValue(PropertiesUtil.JDBC_PASSWORD));
            }
            return connection;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(){
        try{
            
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }   
}
