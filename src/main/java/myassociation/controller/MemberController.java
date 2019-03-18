package myassociation.controller;

import java.util.ArrayList;
import myassociation.dal.MemberImpl;
import myassociation.model.Member;

/**
 *
 * @author FELGUEIRAS
 */
public class MemberController {

    MemberImpl socioDAO = new MemberImpl();

    public boolean criarSocio(String numero, String nome, String morada, String nif, String email, String telefone, String telemovel, byte[] fotografia, boolean ativo, boolean apagado, String categoria, String username) {
        return socioDAO.criarSocio(numero, nome, morada, nif, email, telefone, telemovel, fotografia, ativo, apagado, categoria, username);
    }

    public boolean editarSocio(String numero, String nome, String morada, String nif, String email, String telefone, String telemovel, byte[] fotografia, boolean ativo, String categoria, String username) {
        return socioDAO.editarSocio(numero, nome, morada, nif, email, telefone, telemovel, fotografia, ativo, categoria, username);
    }

    public ArrayList<Member> pesquisarSocio(String dado, String pesquisa, boolean ativo) {
        return socioDAO.pesquisarSocio(dado, pesquisa, ativo);
    }

    public Member pesquisarSocioPorNumero(String numero) {
        return socioDAO.pesquisarSocioPorNumero(numero);
    }

    public boolean inativarSocio(String numero) {
        return socioDAO.inativarSocio(numero);
    }

    public boolean apagarSocio(String numero) {
        return socioDAO.apagarSocio(numero);
    }

    public String totalSociosAtivos() {
        return socioDAO.totalSociosAtivos();
    }

    public String[] listaCategoriasSocios() {
        return socioDAO.listaCategoriasSocios();
    }

    public boolean criarCategoria(String nome) {
        return socioDAO.criarCategoria(nome);
    }

    public boolean renumerarSocios(){
        return socioDAO.renumerarSocios();
    }
}
