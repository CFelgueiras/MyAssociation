/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myassociation.model.Association;

/**
 *
 * @author Cláudio Felgueiras
 */
public class AssociationImpl implements IAssociationDAO {

    @Override
    public boolean editarAssociacao(String nome, byte[] logotipo) {
        boolean associacaoeditada = false;

        try {
            String query = "UPDATE ASSOCIACAO SET nome = ?, logotipo = ?";
            PreparedStatement associacao = ConnectDB.conexaoBD().prepareStatement(query);

            associacao.setString(1, nome);
            associacao.setBytes(2, logotipo);
            associacao.executeUpdate();
            associacaoeditada = true;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(AssociationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return associacaoeditada;
    }

    @Override
    public Association obterAssociacao() {
        Association associacao = new Association();
        try {
            Statement obterAssociacao = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT nome,logotipo FROM ASSOCIACAO";
            ResultSet rs = obterAssociacao.executeQuery(query);
            while (rs.next()) {
                associacao.setNome(rs.getString("nome"));
                associacao.setLogotipo(rs.getBytes("logotipo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssociationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return associacao;
    }

    @Override
    public String[] listaNomesAssociacoes() {
        ArrayList<String> listaassociacoes = new ArrayList<>();

        try {
            Statement listaassoc = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT nome FROM ASSOCIACAO";
            ResultSet rs = listaassoc.executeQuery(query);

            while (rs.next()) {
                Association associacao = new Association();
                associacao.setNome(rs.getString("nome"));
                listaassociacoes.add(associacao.getNome());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(AssociationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] listaretorno = listaassociacoes.toArray(new String[listaassociacoes.size()]);

        return listaretorno;
    }

    @Override
    public int obterAssociacaoIDbyNome(String nomeassociacao) {
        int associd = 0;
        try {
            Statement idAssociacao = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT idassociacao from ASSOCIACAO WHERE nome = '" + nomeassociacao + "'";
            ResultSet rs = idAssociacao.executeQuery(query);
            while (rs.next()) {
                associd = rs.getInt("idassociacao");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(AssociationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return associd;
    }
}
