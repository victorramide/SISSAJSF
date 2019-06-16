/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.Pedido;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Victor Ramide
 */
public class PedidoDAO extends GenericDAO<Pedido, Long> {

    public PedidoDAO() {
        super(Pedido.class);
    }

    public List<Pedido> listaPedidoComum() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.or(Restrictions.eq("tipo", "despacho"), Restrictions.eq("tipo", "decisao")));
        criteria.add(Restrictions.eq("prioridade", false));
        criteria.add(Restrictions.eq("excluido", false));
        return criteria.list();
    }

    public List<Pedido> listaPedidoPrioridade() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.or(Restrictions.eq("tipo", "despacho"), Restrictions.eq("tipo", "decisao")));
        criteria.add(Restrictions.eq("prioridade", true));
        criteria.add(Restrictions.eq("excluido", false));
        return criteria.list();
    }

    public List<Pedido> listaPedidoSentencaComum() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.eq("tipo", "sentenca"));
        criteria.add(Restrictions.eq("prioridade", false));
        criteria.add(Restrictions.eq("excluido", false));
        criteria.addOrder(Order.asc("dataConclusao"));
        return criteria.list();
    }

    public List<Pedido> listaPedidoSentencaPrioridade() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.eq("tipo", "sentenca"));
        criteria.add(Restrictions.eq("prioridade", true));
        criteria.add(Restrictions.eq("excluido", false));
        criteria.addOrder(Order.asc("dataConclusao"));
        return criteria.list();
    }

    public List<Pedido> listaPedidoRemovido() {
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.eq("excluido", true));
        return criteria.list();
    }

    public Pedido removerPedido(Long id) {
        Pedido retorno = null;
        org.hibernate.Session session = dao.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            retorno = (Pedido) session.get(Pedido.class, id);
            retorno.setExcluido(true);
            session.update(retorno);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
    public Pedido restaurarPedido(Long id) {
        Pedido retorno = null;
        org.hibernate.Session session = dao.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            retorno = (Pedido) session.get(Pedido.class, id);
            retorno.setJustificativa("");
            retorno.setExcluido(false);
            session.update(retorno);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
    
    public Long contarOabListaComum(String oab){
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.or(Restrictions.eq("tipo", "despacho"), Restrictions.eq("tipo", "decisao")));
        criteria.add(Restrictions.eq("prioridade", false));
        criteria.add(Restrictions.eq("excluido", false));
        criteria.setProjection(Projections.rowCount());  
        return (Long) criteria.uniqueResult();
    }
    
    public Long contarOabListaPrioridade(String oab){
        Session sessao = dao.HibernateUtil.getSession();
        Criteria criteria = sessao.createCriteria(Pedido.class);
        criteria.add(Restrictions.or(Restrictions.eq("tipo", "despacho"), Restrictions.eq("tipo", "decisao")));
        criteria.add(Restrictions.eq("prioridade", true));
        criteria.add(Restrictions.eq("excluido", false));
        criteria.setProjection(Projections.rowCount());  
        return (Long) criteria.uniqueResult();
    }
    
}
