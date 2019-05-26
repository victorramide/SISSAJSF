/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Pedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Victor Ramide
 */
public class PedidoDAO extends GenericDAO<Pedido, Long> {

    public PedidoDAO() {
        super(Pedido.class);
    }

    public List<Pedido> processoComum() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.or(Restrictions.eq("tipo", "despacho"), Restrictions.eq("tipo", "decisao")));
        criteria.add(Restrictions.eq("prioridade", false));
        return criteria.list();
    }

    /*public void save(PedidoModel pedido){
        
        org.hibernate.Session sessao = dao.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = sessao.beginTransaction();
            sessao.save(pedido);
            sessao.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }     
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
        String sql = "select numeroProcesso, classe, tipo, oab from pedido where tipo != 'sentenca' and prioridade != true and sentenca != true order by id";
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
    
    public List<PedidoModel> listarPedidoPrioridade() throws SQLException{
        
        List<PedidoModel> list = new ArrayList<PedidoModel>();
        String sql = "select numeroProcesso, classe, tipo, oab from pedido where tipo != 'sentenca' and prioridade = true and sentenca != true order by id";
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
    public List<PedidoModel> listarPedidoSentencaComum() throws SQLException{
        
        List<PedidoModel> list = new ArrayList<PedidoModel>();
        String sql = "select numeroProcesso, classe, tipo, oab, data from pedido where tipo = 'sentenca' and prioridade != true and sentenca = true order by data";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        while(result.next()){
            PedidoModel pedidoModel = new PedidoModel();
            
            pedidoModel.setNumeroProcesso(result.getString("numeroProcesso"));
            pedidoModel.setClasse(result.getString("classe"));
            pedidoModel.setTipo(result.getString("tipo"));
            pedidoModel.setOab(result.getString("oab"));
            pedidoModel.setData(result.getDate("data"));
            
            list.add(pedidoModel);
        }
        return list;
    }  
    public List<PedidoModel> listarPedidoSentencaPrioridade() throws SQLException{
        
        List<PedidoModel> list = new ArrayList<PedidoModel>();
        String sql = "select numeroProcesso, classe, tipo, oab, data from pedido where tipo = 'sentenca' and prioridade = true and sentenca = true order by data";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        while(result.next()){
            PedidoModel pedidoModel = new PedidoModel();
            
            pedidoModel.setNumeroProcesso(result.getString("numeroProcesso"));
            pedidoModel.setClasse(result.getString("classe"));
            pedidoModel.setTipo(result.getString("tipo"));
            pedidoModel.setOab(result.getString("oab"));
            pedidoModel.setData(result.getDate("data"));
            
            
            list.add(pedidoModel);
        }
        return list;
    }  
    /*public List<PedidoExcluido> listarPedidoExcluido() throws SQLException{
        
        List<PedidoExcluido> list = new ArrayList<PedidoExcluido>();
        String sql = "select numeroProcesso, tipo, justificativa from excluidos order by id";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        while(result.next()){
            PedidoExcluido pedidoExcluido = new PedidoExcluido();
            
            pedidoExcluido.setNumeroProcesso(result.getString("numeroProcesso"));
            pedidoExcluido.setTipo(result.getString("tipo"));
            pedidoExcluido.setJustificativa(result.getString("justificativa"));
            
            
            list.add(pedidoExcluido);
        }
        return list;
    } */
    //Criar um remover para os processos que transfere os dados para a tabela de excluídos e depois apaga da tabela principal.
}
