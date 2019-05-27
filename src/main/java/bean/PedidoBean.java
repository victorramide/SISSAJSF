/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PedidoDAO;
import database.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author AlunoTI
 */
@ViewScoped
@ManagedBean
public class PedidoBean {

    private Pedido pedido;
    private List<Pedido> processosComum;
    private List<Pedido> processosPrioridade;
    private List<Pedido> sentencasComum;
    private List<Pedido> sentencasPrioridade;
    private List<Pedido> pedidosExcluidos;
    private PedidoDAO pedidoDAO;

    @PostConstruct
    public void Init() {
        pedido = new Pedido();
        processosComum = new ArrayList<>();
        processosPrioridade = new ArrayList<>();
        sentencasComum = new ArrayList<>();
        sentencasPrioridade = new ArrayList<>();
        pedidosExcluidos = new ArrayList<>();
        pedidoDAO = new PedidoDAO();
        //  pedidos = pedidoDAO.listALL(); //Provavelmente não teremos necessidade desse método.
    }

    public void salvar() {
        pedidoDAO.save(pedido);
        pedido = new Pedido();
    }

    public void deletePComum(Long id) {
        Pedido p = pedidoDAO.delete(id);
        if (p != null) {
            pedido = p;
            processosComum = pedidoDAO.processoComum();
        }
    }

    public void deletePPrioridade(Long id) {
        Pedido p = pedidoDAO.delete(id);
        if (p != null) {
            pedido = p;
            processosPrioridade = pedidoDAO.processoPrioridade();
        }
    }

    public void deleteSComum(Long id) {
        Pedido p = pedidoDAO.delete(id);
        if (p != null) {
            pedido = p;
            sentencasComum = pedidoDAO.sentencaComum();
        }
    }

    public void deleteSPrioridade(Long id) {
        Pedido p = pedidoDAO.delete(id);
        if (p != null) {
            pedido = p;
            sentencasPrioridade = pedidoDAO.sentencaPrioridade();
        }
    }

    public List<Pedido> getpComum() {
        processosComum = pedidoDAO.processoComum();
        return processosComum;
    }

    public List<Pedido> getpPrioridade() {
        processosPrioridade = pedidoDAO.processoPrioridade();
        return processosPrioridade;
    }

    public List<Pedido> getsComum() {
        sentencasComum = pedidoDAO.sentencaComum();
        return sentencasComum;
    }

    public List<Pedido> getsPrioridade() {
        sentencasPrioridade = pedidoDAO.sentencaPrioridade();
        return sentencasPrioridade;
    }

    public void editar() {

    }

    public void excluir() {

    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getProcessosComum() {
        return processosComum;
    }

    public void setProcessosComum(List<Pedido> processosComum) {
        this.processosComum = processosComum;
    }

    public List<Pedido> getProcessosPrioridade() {
        return processosPrioridade;
    }

    public void setProcessosPrioridade(List<Pedido> processosPrioridade) {
        this.processosPrioridade = processosPrioridade;
    }

    public List<Pedido> getSentencasComum() {
        return sentencasComum;
    }

    public void setSentencasComum(List<Pedido> sentencasComum) {
        this.sentencasComum = sentencasComum;
    }

    public List<Pedido> getSentencasPrioridade() {
        return sentencasPrioridade;
    }

    public void setSentencasPrioridade(List<Pedido> sentencasPrioridade) {
        this.sentencasPrioridade = sentencasPrioridade;
    }

    public List<Pedido> getPedidosExcluidos() {
        return pedidosExcluidos;
    }

    public void setPedidosExcluidos(List<Pedido> pedidosExcluidos) {
        this.pedidosExcluidos = pedidosExcluidos;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }
}
