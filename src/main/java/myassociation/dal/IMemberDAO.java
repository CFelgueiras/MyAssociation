/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.dal;

import java.util.ArrayList;
import myassociation.model.Member;

/**
 *
 * @author FELGUEIRAS
 */
public interface IMemberDAO {
    
    public boolean criarSocio(String numero, String nome, String morada, String nif, String email, String telefone, String telemovel, byte[] fotografia, boolean ativo, boolean apagado, String categoria, String associacao, String username);
    public boolean editarSocio(String numero, String nome, String morada, String nif, String email, String telefone, String telemovel, byte[] fotografia, boolean ativo, String categoria, String associacao,String username);
    public boolean inativarSocio(String numero);
    public boolean apagarSocio(String numero);
    public ArrayList<Member> pesquisarSocio(String dado, String pesquisa, boolean ativo);
    public Member pesquisarSocioPorNumero(String numero);
    public String totalSociosAtivos();
    public String[] listaCategoriasSocios();
    public boolean criarCategoria(String nome);
    public boolean renumerarSocios();
}
