/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import jdbcconnection.SingleConnection;
import model.UsuarioModel;

/**
 *
 * @author Victor Ramide
 */
public class UsuarioDAO {
    
    private Connection connection;

    public UsuarioDAO() {
       // connection = SingleConnection.getConnection();
    }
    
    public void create(UsuarioModel u) throws SQLException{
        try{
            String sql = "insert into usuario (nome, email, login, senha) values (?, ?, ?, ?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, u.getNome());
            insert.setString(2, u.getEmail());
            //insert.setString(3, u.getLogin());
            insert.setString(4, u.getSenha());
            insert.execute();
            connection.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            connection.close();
        }
    }    
}
