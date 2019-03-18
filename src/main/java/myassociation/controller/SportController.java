/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.controller;

import myassociation.dal.SportImpl;

/**
 *
 * @author Cláudio Felgueiras
 */
public class SportController {

    SportImpl sportDAO = new SportImpl();

    public boolean criarModalidade(String nome, String responsavel, boolean estado) {
        return sportDAO.criarModalidade(nome, responsavel, estado);
    }

}
