/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbcconnection.SingleConnection;
import model.PedidoModel;

/**
 *
 * @author Victor Ramide
 */
public class PedidoDAO {
    
    private Connection connection;

    public PedidoDAO() {
         connection = SingleConnection.getConnection();
    }
    
    public void create(PedidoModel p) throws SQLException{
        try{
            String sql = "insert into usuario (numeroProcesso, classe, tipo, prioridade, sentença, oab, data) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, p.getNumeroProcesso());
            insert.setString(2, p.getClasse());
            insert.setString(3, p.getTipo());
            insert.setBoolean(4, p.isPrioridade());
            insert.setBoolean(5, p.isSentença());
            insert.setString(6, p.getOab());
            insert.setDate(7, p.getData());
            insert.execute();
            connection.commit();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            connection.close();
        }
    }    
    
    
    
}
