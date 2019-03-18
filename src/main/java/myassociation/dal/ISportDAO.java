/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.dal;

/**
 *
 * @author Cláudio Felgueiras
 */
public interface ISportDAO {
    
    public boolean criarModalidade(String nome, String responsavel, boolean estado);
    
}
