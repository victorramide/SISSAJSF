/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Victor Ramide
 */
@ManagedBean (name="pedido")
public class PedidoModel {
    
    private String numeroProcesso;
    private String classe;
    private String tipo;
    private String oab;
    private Date data;
    private boolean prioridade;
    private boolean sentença;

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isSentença() {
        return sentença;
    }

    public void setSentença(boolean sentença) {
        this.sentença = sentença;
    }
    
    
}
