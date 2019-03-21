/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.controller;

import java.util.ArrayList;
import myassociation.dal.UserImpl;
import myassociation.model.User;

/**
 *
 * @author FELGUEIRAS
 */
public class UserController {

    UserImpl utilizadorDAO = new UserImpl();
    User utilizador = new User();
    
    public String username(){
        return utilizador.getNome();
    }
    public void setUsername(String username){
        utilizador.setNome(username);
    }

    public boolean pesquisaLogin(String nome, String senha) {
        return utilizadorDAO.doLogin(nome, senha);
    }
    
    public boolean pesquisaUtilizador(String nome){
        return utilizadorDAO.pesquisaUtilizador(nome);
    }

    public boolean criarUtilizador(String nome, String senha, String grupo) {
        return utilizadorDAO.criarUtilizador(nome, senha, grupo);
    }

    public ArrayList<User> searchUser(String dado, String pesquisa) {
        return utilizadorDAO.searchUser(dado, pesquisa);
    }
}
