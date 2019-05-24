/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UsuarioDAO;
import database.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ViewScoped;

/**
 *
 * @author AlunoTI
 */
@SessionScoped
@ManagedBean
public class UsuarioBean {
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    private UsuarioDAO usuarioDAO;
    
     @PostConstruct
    public void Init() {
        usuario = new Usuario();
        usuarios = new ArrayList<>();
        usuarioDAO = new UsuarioDAO();
        usuarios = usuarioDAO.listALL(); //Provavelmente não teremos necessidade desse método.
    }
    
    public void salvar(){
        
    }
    
    public void editar(){
        
    }
    
    public void excluir(){
        
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
    
    
    
}
