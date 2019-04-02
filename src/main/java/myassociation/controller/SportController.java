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
    Sport modalidade = new Sport();

    public boolean criarModalidade(String nome, String responsavel, boolean estado, String username) {
        return sportDAO.criarModalidade(nome, responsavel, estado, username);
    }

    public Sport pesquisarModalidadePorNome(String nome) {
        return sportDAO.pesquisarModalidadePorNome(nome);
    }

    public ArrayList<Sport> listarModalidades(String dado, String pesquisa, boolean ativo) {
        return sportDAO.listarModalidades(dado, pesquisa, ativo);
    }

    public String[] listaModalidades() {
        return sportDAO.listaModalidades();
    }

    public boolean editarModalidade(String nomeAntigo, String novoNome, String responsavel, boolean ativo, String username) {
        return sportDAO.editarModalidade(nomeAntigo, novoNome, responsavel, ativo, username);
    }

    public boolean inativarModalidade(String nome) {
        return sportDAO.inativarModalidade(nome);
    }

    public String getNomeModalidade() {
        return modalidade.getNome();
    }

    public boolean inscreverModalidade(int numerosocio, String modalidade, String username) {
        return sportDAO.inscreverModalidade(numerosocio, modalidade, username);
    }

}
