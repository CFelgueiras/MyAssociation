/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.dal;

import java.util.ArrayList;
import myassociation.model.User;

/**
 *
 * @author FELGUEIRAS
 */
public interface IUserDAO {
    
    public boolean pesquisaLogin(String nome, String senha);
    
    public boolean pesquisaUtilizador(String nome);
    
    public boolean criarUtilizador(String nome, String senha, String grupo);
    
    public ArrayList<User> searchUser(String dado, String pesquisa);
    
    public int obterIdGrupoUtilizadorbyNome(String nomegrupo);
}
