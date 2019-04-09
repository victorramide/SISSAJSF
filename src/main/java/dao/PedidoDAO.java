/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            String sql = "insert into usuario (numeroProcesso, classe, tipo, prioridade, sentenca, oab, data) values (?, ?, ?, ?, ?, ?, ?)";
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
    
    public List<PedidoModel> listarPedidoComum() throws SQLException{
        
        List<PedidoModel> list = new ArrayList<PedidoModel>();
        String sql = "select * from pedido where tipo != 'sentenca' and prioridade != true and sentenca != true order by id";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        while(result.next()){
            PedidoModel pedidoModel = new PedidoModel();
            
            pedidoModel.setNumeroProcesso(result.getString("numeroProcesso"));
            pedidoModel.setClasse(result.getString("classe"));
            pedidoModel.setTipo(result.getString("tipo"));
            pedidoModel.setOab(result.getString("oab"));
            
            
            list.add(pedidoModel);
        }
        return list;
    }
    
    
    
}
