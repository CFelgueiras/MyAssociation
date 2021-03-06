/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.dal;

import java.util.ArrayList;
import myassociation.model.Sport;

/**
 *
 * @author Cláudio Felgueiras
 */
public interface ISportDAO {

    public boolean criarModalidade(String nome, String responsavel, boolean estado, String username);

    public Sport pesquisarModalidadePorNome(String nome);

    public ArrayList<Sport> listarModalidades(String dado, String pesquisa, boolean ativo);

    public String[] listaModalidades();
            
    public boolean editarModalidade(String nomeAntigo, String novoNome, String responsavel, boolean ativo, String username);

    public boolean inativarModalidade(String nome);

    public int getModalidadeIdByNome(String nome);
    
    public boolean inscreverModalidade(int numerosocio, String modalidade, String username);
}
