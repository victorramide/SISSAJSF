/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
//import java.sql.Date;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author victorramide
 */
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "numeroProcesso", length = 25, nullable = false)
    private String numeroProcesso;

    @Column(name = "classe")
    private String classe;

    @Column(name = "tipo", length = 10, nullable = false)
    private String tipo;

    @Column(name = "prioridade")
    private boolean prioridade;

    @Column(name = "sentença")
    private boolean sentenca;

    @Column(name = "excluido")
    private boolean excluido;

    @Column(name = "justificativa")
    private String justificativa;

    @Column(name = "oab", nullable = false)
    private String oab;

    @Column(name = "dataConclusao")
    @Temporal(TemporalType.DATE)
    private Calendar dataConclusao;

    public Pedido() {
        this.sentenca = false;
        this.excluido = false;
        this.dataConclusao = Calendar.getInstance(); //Corrigir o modelo da data.
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isSentenca() {
        return sentenca;
    }

    public void setSentenca(boolean sentenca) {
        this.sentenca = sentenca;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public Calendar getDataConclusao() {
        return dataConclusao;
    }

    public void setData(Calendar dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
