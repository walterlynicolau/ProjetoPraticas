
package br.com.wns.projetoloja.dao.impl;

import br.com.wns.projetoloja.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoGeneric {
    
    private Connection connection;
    
    public Connection getConnection() throws SQLException{
        if(connection == null || connection.isClosed()){
           connection = ConnectionFactory.getConnection();
           connection.setAutoCommit(false);
        }
        return connection;
    }
    
    public void closeConnection(){
       ConnectionFactory.closeConnection();
    }
    
}
