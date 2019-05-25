/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Victor Ramide
 */
public class UsuarioDAO extends GenericDAO<Usuario, Long> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario getUsuario(String nomeUsuario, String senha) {
        try {
            Usuario result = new Usuario();
            Session sessao = dao.HibernateUtil.getSession();
            Criteria criteria = sessao.createCriteria(Usuario.class);
            criteria.add(Restrictions.eq("nomeUsuario", nomeUsuario));
            criteria.add(Restrictions.eq("senha", senha));
            result = (Usuario) criteria.uniqueResult();       
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    /* public void save(UsuarioModel usuario) {
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

 /* public void save(UsuarioModel usuario) {
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
