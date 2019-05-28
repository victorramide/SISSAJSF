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
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
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
        criteria.add(Restrictions.eq("excluido", false));
        return criteria.list();
    }

    public List<Pedido> processoPrioridade() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.or(Restrictions.eq("tipo", "despacho"), Restrictions.eq("tipo", "decisao")));
        criteria.add(Restrictions.eq("prioridade", true));
        criteria.add(Restrictions.eq("excluido", false));
        return criteria.list();
    }

    public List<Pedido> sentencaComum() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.eq("tipo", "sentenca"));
        criteria.add(Restrictions.eq("prioridade", false));
        criteria.add(Restrictions.eq("excluido", false));
        criteria.addOrder(Order.asc("dataConclusao"));
        return criteria.list();
    }

    public List<Pedido> sentencaPrioridade() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.eq("tipo", "sentenca"));
        criteria.add(Restrictions.eq("prioridade", true));
        criteria.add(Restrictions.eq("excluido", false));
        criteria.addOrder(Order.asc("dataConclusao"));
        return criteria.list();
    }

    public List<Pedido> processoExcluido() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.eq("excluido", true));
        return criteria.list();
    }

    public Pedido listExcluido(Long id, String justific) {
        Pedido retorno = null;
        org.hibernate.Session session = dao.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            retorno = (Pedido) session.get(Pedido.class, id);
            retorno.setJustificativa(justific);
            retorno.setExcluido(true);
            session.update(retorno);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
}
