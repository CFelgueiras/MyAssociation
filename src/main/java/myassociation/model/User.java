/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.model;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author FELGUEIRAS
 */
public class User {

    private String nome;
    private String senha;
    private Date datacriacao;

    public User() {
    }

    public User(String nome, String senha) throws IOException {
        this.nome = nome;
        this.senha = senha;
    }

    public User(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }

    @Override
    public String toString() {
        return "Utilizador:" + "utilizador:" + nome + ", senha:" + senha + '.';
    }

}
