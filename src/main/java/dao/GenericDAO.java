/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AlunoTI
 */
public abstract class GenericDAO<T, Type extends Serializable> {
    
    private Class<T> persistenceClass;
    
    public GenericDAO(Class persistenceClass){
        super();
        this.persistenceClass = persistenceClass;
    }
    
    public T save(T entity) {
        T retorno = null;
        org.hibernate.Session sessao = dao.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = sessao.beginTransaction();
            retorno = (T)sessao.merge(entity);
            sessao.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        return retorno;
    }
    
       public T delete(Long id) {
        org.hibernate.Session session = dao.HibernateUtil.getSession();
        Transaction tx = null;
        
        T retorno = null;
        
        try {
            tx = session.beginTransaction();
            retorno = (T) session.get(persistenceClass, id);
            session.delete(retorno);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
       return retorno;
    }

    
    public List<T> listALL(){
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(persistenceClass);
        return criteria.list();
    }
    
    public T find(Long id){
        T retorno = null;
        
        try{
            Session sessao = dao.HibernateUtil.getSession();
            retorno = (T) sessao.get(persistenceClass, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return retorno;
    }
    
}
