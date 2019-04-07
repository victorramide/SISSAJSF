/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor Ramide
 */
public class SingleConnection {
    
    private static String url ="jdbc:mysql://localhost:3306/sissa?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static String password="admin";
    private static String user="root";
    private static Connection connection = null;
    
    static{
        conectar();
    }

    public SingleConnection() {
        conectar();
    }
    
    private static void conectar(){
        try{
            if(connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
                System.out.println("Conectou com sucesso!");
            }           
        }catch(ClassNotFoundException | SQLException e){
        }
    }
    
    public static Connection getConnection(){
        return connection;
    }
}
