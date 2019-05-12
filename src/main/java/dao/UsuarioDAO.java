/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.UsuarioModel;
import org.hibernate.Transaction;

/**
 *
 * @author Victor Ramide
 */
public class UsuarioDAO {
    
     public void save(UsuarioModel usuario) {
        org.hibernate.Session sessao = dao.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = sessao.beginTransaction();
            sessao.save(usuario);
            sessao.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }
    
    /*
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
    */
}
