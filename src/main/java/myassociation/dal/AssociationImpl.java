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
    public boolean editarAssociacao(String nome, String nif, String presidente,
            String secretario, String tesoureiro, String vogal1, String vogal2,
            String vogal3, String vogal4, String vogal5, String morada,
            String telefone, String telemovel, String email, byte[] logotipo) {
        boolean associacaoeditada = false;

        try {
            String query = "UPDATE ASSOCIACAO SET nome = ?, nif = ?, presidente = ?,"
                    + " secretario = ?, tesoureiro =?, vogal1 =?, vogal2 = ?, "
                    + "vogal3 = ?, vogal4 = ?, vogal5 = ?, morada =?, telefone = ?,"
                    + "telemovel = ?, email = ?, logotipo = ?";
            PreparedStatement associacao = ConnectDB.conexaoBD().prepareStatement(query);

            associacao.setString(1, nome);
            associacao.setString(2, nif);
            associacao.setString(3, presidente);
            associacao.setString(4, secretario);
            associacao.setString(5, tesoureiro);
            associacao.setString(6, vogal1);
            associacao.setString(7, vogal2);
            associacao.setString(8, vogal3);
            associacao.setString(9, vogal4);
            associacao.setString(10, vogal5);
            associacao.setString(11, morada);
            associacao.setString(12, telefone);
            associacao.setString(13, telemovel);
            associacao.setString(14, email);
            associacao.setBytes(15, logotipo);
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
            String query = "SELECT nome, nif, presidente, secretario, tesoureiro, "
                    + "vogal1,vogal2, vogal3, vogal4, vogal5, morada, telefone, "
                    + "telemovel, email, logotipo FROM ASSOCIACAO";
            ResultSet rs = obterAssociacao.executeQuery(query);
            while (rs.next()) {
                associacao.setNome(rs.getString("nome"));
                associacao.setNif(rs.getString("nif"));
                associacao.setPresidente(rs.getString("presidente"));
                associacao.setSecretario(rs.getString("secretario"));
                associacao.setTesoureiro(rs.getString("tesoureiro"));
                associacao.setVogal1(rs.getString("vogal1"));
                associacao.setVogal2(rs.getString("vogal2"));
                associacao.setVogal3(rs.getString("vogal3"));
                associacao.setVogal4(rs.getString("vogal4"));
                associacao.setVogal5(rs.getString("vogal5"));
                associacao.setMorada(rs.getString("morada"));
                associacao.setTelefone(rs.getString("telefone"));
                associacao.setTelemovel(rs.getString("telemovel"));
                associacao.setEmail(rs.getString("email"));
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
