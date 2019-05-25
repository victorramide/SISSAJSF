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
import javax.faces.bean.ViewScoped;

/**
 *
 * @author AlunoTI
 */
@ViewScoped
@ManagedBean
public class PedidoBean {

    private Pedido pedido;
    private List<Pedido> pedidos;
    private PedidoDAO pedidoDAO;

    @PostConstruct
    public void Init() {
        pedido = new Pedido();
        pedidos = new ArrayList<>();
        pedidoDAO = new PedidoDAO();
        //pedidos = pedidoDAO.listALL(); Provavelmente não teremos necessidade desse método.
    }
    
    public void salvar(){
        
    }
    
    public void editar(){
        
    }
    
    public void excluir(){
        
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }
}
