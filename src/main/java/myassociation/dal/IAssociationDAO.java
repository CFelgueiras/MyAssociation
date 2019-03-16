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
    
    public boolean editarAssociacao(String nome, byte[] logotipo);
    public Association obterAssociacao();
    public String[] listaNomesAssociacoes();
    public int obterAssociacaoIDbyNome(String nomeassociacao);
}
