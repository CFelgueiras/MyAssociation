/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.model;

import java.util.Date;

/**
 *
 * @author Cláudio Felgueiras
 */
public class Sport {

    private String nome;
    private String responsavel;
    private boolean estado;
    private String utilizador;
    private Date datacriacao;
    private Date datamodif;

    public Sport() {
    }

    public Sport(String nome, String responsavel) {
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public Sport(String nome, String responsavel, boolean estado, String utilizador) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.estado = estado;
        this.utilizador = utilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Date getDatamodif() {
        return datamodif;
    }

    public void setDatamodif(Date datamodif) {
        this.datamodif = datamodif;
    }

    @Override
    public String toString() {
        return "Sport{" + "nome=" + nome + ", responsavel=" + responsavel + ", estado=" + estado + ", utilizador=" + utilizador + ", datacriacao=" + datacriacao + ", datamodif=" + datamodif + '}';
    }
}
