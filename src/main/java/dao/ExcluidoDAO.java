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
import model.PedidoExcluido;

/**
 *
 * @author victorramide
 */
public class ExcluidoDAO {
    
    private Connection connection;

    public ExcluidoDAO() {
         connection = SingleConnection.getConnection();
    }
    
    public void create(PedidoExcluido e) throws SQLException{
        try{
            String sql = "insert into usuario (numeroProcesso, tipo, justificativa) values (?, ?, ?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, e.getNumeroProcesso());
            insert.setString(2, e.getTipo());
            insert.setString(3, e.getJustificativa());
            insert.execute();
            connection.commit();
        }catch(SQLException s){
            s.printStackTrace();
        }finally{
            connection.close();
        }
    }    
    
}
