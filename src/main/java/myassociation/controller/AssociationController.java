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

    public boolean editarAssociacao(String nome, String nif, String presidente, 
            String secretario, String tesoureiro, String vogal1, String vogal2, 
            String vogal3, String vogal4, String vogal5, String morada, 
            String telefone, String telemovel, String email, byte[] logotipo) {
        return associationDAO.editarAssociacao(nome, nif, presidente, secretario
                , tesoureiro, vogal1, vogal2, vogal3, vogal4, vogal5, morada, 
                telefone, telemovel, email, logotipo);
    }

    public Association obterAssociacao() {
        return associationDAO.obterAssociacao();
    }

    public String[] listaNomesAssociacoes() {
        return associationDAO.listaNomesAssociacoes();
    }

    public Image applicationIcon() {
        return association.applicationIcon();
    }
}
