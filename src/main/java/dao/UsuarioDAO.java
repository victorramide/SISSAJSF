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
}
