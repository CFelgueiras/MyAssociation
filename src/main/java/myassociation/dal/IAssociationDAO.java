/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.dal;

import myassociation.model.Association;

/**
 *
 * @author Cláudio Felgueiras
 */
public interface IAssociationDAO {
    
    public boolean editarAssociacao(String nome, String nif, String presidente, 
            String secretario, String tesoureiro, String vogal1, String vogal2, 
            String vogal3, String vogal4, String vogal5, String morada, 
            String telefone, String telemovel, String email, byte[] logotipo);
    public Association obterAssociacao();
    public String[] listaNomesAssociacoes();
    public int obterAssociacaoIDbyNome(String nomeassociacao);
}
