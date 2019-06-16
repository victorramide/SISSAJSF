/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PedidoDAO;
import database.Pedido;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author AlunoTI
 */
@javax.faces.view.ViewScoped
@ManagedBean
public class PedidoBean {

    private Pedido pedido;
    private List<Pedido> pedidosComuns;
    private List<Pedido> pedidosPrioridade;
    private List<Pedido> pedidosSentencasComuns;
    private List<Pedido> pedidosSentencasPrioridade;
    private List<Pedido> pedidosRemovidos;
    private PedidoDAO pedidoDAO;

    @PostConstruct
    public void Init() {
        pedido = new Pedido();
        pedidoDAO = new PedidoDAO();
        pedidosComuns = pedidoDAO.listaPedidoComum();
        pedidosPrioridade = pedidoDAO.listaPedidoPrioridade();
        pedidosSentencasComuns = pedidoDAO.listaPedidoSentencaComum();
        pedidosSentencasPrioridade = pedidoDAO.listaPedidoSentencaPrioridade();
        pedidosRemovidos = pedidoDAO.listaPedidoRemovido();

    }

    public void salvar() {
        dataAtual();
        pedidoDAO.save(pedido);
        pedido = new Pedido();
    }

    public void excluirPedido(Long id) {
        Pedido p = pedidoDAO.delete(id);
        if (p != null) {
            pedido = p;
            pedidosRemovidos = pedidoDAO.listaPedidoRemovido();
        }
    }

    public void removerPedido(Long id) {
        pedidoDAO.removerPedido(id);
    }

    public void restaurarPedido(Long id) {
        pedidoDAO.restaurarPedido(id);
    }

    public void dataAtual() {
        Date data = new Date();
        if (pedido.getDataConclusao() == null) {
            pedido.setDataConclusao(data);
        }
    }
    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidosComuns() {
        pedidosComuns = pedidoDAO.listaPedidoComum();
        return pedidosComuns;
    }

    public void setPedidosComuns(List<Pedido> processosComum) {
        this.pedidosComuns = processosComum;
    }

    public List<Pedido> getPedidosPrioridade() {
        pedidosPrioridade = pedidoDAO.listaPedidoPrioridade();
        return pedidosPrioridade;
    }

    public void setPedidosPrioridade(List<Pedido> processosPrioridade) {
        this.pedidosPrioridade = processosPrioridade;
    }

    public List<Pedido> getPedidosSentencasComuns() {
        pedidosSentencasComuns = pedidoDAO.listaPedidoSentencaComum();
        return pedidosSentencasComuns;
    }

    public void setPedidosSentencasComuns(List<Pedido> sentencasComum) {
        this.pedidosSentencasComuns = sentencasComum;
    }

    public List<Pedido> getPedidosSentencasPrioridade() {
        pedidosSentencasPrioridade = pedidoDAO.listaPedidoSentencaPrioridade();
        return pedidosSentencasPrioridade;
    }

    public void setPedidosSentencasPrioridade(List<Pedido> sentencasPrioridade) {
        this.pedidosSentencasPrioridade = sentencasPrioridade;
    }

    public List<Pedido> getPedidosRemovidos() {
        pedidosRemovidos = pedidoDAO.listaPedidoRemovido();
        return pedidosRemovidos;
    }

    public void setPedidosRemovidos(List<Pedido> pedidosExcluidos) {
        this.pedidosRemovidos = pedidosExcluidos;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }
}
