/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.controller;

import java.util.ArrayList;
import myassociation.dal.SportImpl;
import myassociation.model.Sport;

/**
 *
 * @author Cláudio Felgueiras
 */
public class SportController {

    SportImpl sportDAO = new SportImpl();

    public boolean criarModalidade(String nome, String responsavel, boolean estado, String username) {
        return sportDAO.criarModalidade(nome, responsavel, estado, username);
    }

    public Sport pesquisarModalidadePorNome(String nome) {
        return sportDAO.pesquisarModalidadePorNome(nome);
    }

    public ArrayList<Sport> listarModalidades(String dado, String pesquisa, boolean ativo) {
        return sportDAO.listarModalidades(dado, pesquisa, ativo);
    }

    public boolean editarModalidade(String nome, String responsavel, boolean ativo, String username) {
        return sportDAO.editarModalidade(nome, responsavel, ativo, username);
    }

}
