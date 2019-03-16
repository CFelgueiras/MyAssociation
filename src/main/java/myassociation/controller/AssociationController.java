/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.controller;

import java.awt.Image;
import myassociation.dal.AssociationImpl;
import myassociation.model.Association;

/**
 *
 * @author Cláudio Felgueiras
 */
public class AssociationController {

    AssociationImpl associationDAO = new AssociationImpl();
    Association association = new Association();

    public boolean editarAssociacao(String nome, byte[] logotipo) {
        return associationDAO.editarAssociacao(nome, logotipo);
    }

    public Association obterAssociacao() {
        return associationDAO.obterAssociacao();
    }

    public String[] listaNomesAssociacoes() {
        return associationDAO.listaNomesAssociacoes();
    }
    
    public Image applicationIcon(){
        return association.applicationIcon();
    }
}
