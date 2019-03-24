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
import myassociation.controller.SportController;
import myassociation.model.Sport;

/**
 *
 * @author Cláudio Felgueiras
 */
public class SportImpl implements ISportDAO {

    private UserImpl userimpl = new UserImpl();
//    private SportController modalidadeController = new SportController();

    /**
     *
     * @param nome
     * @param responsavel
     * @param estado
     * @param username
     * @return
     */
    @Override
    public boolean criarModalidade(String nome, String responsavel, boolean estado, String username) {
        boolean modalidadecriada = false;

        int idutilizador = userimpl.obterIdUtilizadorbyNome(username);

        try {
            String query = "Insert into MODALIDADE (nome, responsavel, ativa, apagada, idutilizador, datacriacao,"
                    + " datamodificacao) Values(?,?,?,?,?,current_timestamp,current_timestamp)";

            PreparedStatement modalidade = ConnectDB.conexaoBD().prepareStatement(query);

            modalidade.setString(1, nome);
            modalidade.setString(2, responsavel);
            modalidade.setBoolean(3, estado);
            modalidade.setBoolean(4, false);
            modalidade.setInt(5, idutilizador);

            modalidade.executeUpdate();
            modalidadecriada = true;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(SportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modalidadecriada;
    }

    @Override
    public Sport pesquisarModalidadePorNome(String nome) {
        Sport modalidade = new Sport();
        try {
            Statement pesquisarModalidade = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT * FROM MODALIDADE WHERE NOME = '" + nome + "'";
            ResultSet rs = pesquisarModalidade.executeQuery(query);
            while (rs.next()) {
                modalidade.setNome(rs.getString("nome"));
                modalidade.setResponsavel(rs.getString("responsavel"));
                modalidade.setEstado(rs.getBoolean("ativa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modalidade;
    }

    @Override
    public ArrayList<Sport> listarModalidades(String dado, String pesquisa, boolean ativo) {
        ArrayList<Sport> listaModalidades = new ArrayList<>();

        try {
            Statement pesquisarModalidade = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT m.nome, m.responsavel, m.datacriacao,m.datamodificacao,u.utilizador \n"
                    + "FROM MODALIDADE m \n"
                    + "INNER JOIN UTILIZADOR u \n"
                    + "ON u.idutilizador = m.idutilizador\n"
                    + "WHERE m." + dado + " like '%" + pesquisa + "%'\n"
                    + "AND m.ativa = '" + ativo + "' AND m.apagada = 0";
            ResultSet rs = pesquisarModalidade.executeQuery(query);

            while (rs.next()) {
                Sport modalidade = new Sport();
                modalidade.setNome(rs.getString("nome"));
                modalidade.setResponsavel(rs.getString("responsavel"));
                modalidade.setDatacriacao(rs.getTimestamp("datacriacao"));
                modalidade.setDatamodif(rs.getTimestamp("datamodificacao"));
                modalidade.setUtilizador(rs.getString("utilizador"));
                listaModalidades.add(modalidade);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(SportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaModalidades;
    }

    @Override
    public boolean editarModalidade(String nomeAntigo, String novoNome, String responsavel, boolean ativo, String username) {
        boolean modalidadeEditada = false;
        int idutilizador = userimpl.obterIdUtilizadorbyNome(username);
        int idmodalidade = getModalidadeIdByNome(nomeAntigo);

        System.out.println("nome antigo: " + nomeAntigo);
        System.out.println("nome novo: " + novoNome);
        System.out.println(responsavel);
        System.out.println(ativo);
        System.out.println(idutilizador);
        System.out.println("id " + idmodalidade);
        try {
            String query = "UPDATE MODALIDADE SET nome=?, responsavel=?, ativa=?,"
                    + "datamodificacao=current_timestamp, idutilizador=? "
                    + " WHERE idmodalidade = ?";
            PreparedStatement modalidade = ConnectDB.conexaoBD().prepareStatement(query);
            modalidade.setString(1, novoNome);
            modalidade.setString(2, responsavel);
            modalidade.setBoolean(3, ativo);
            modalidade.setInt(4, idutilizador);
            modalidade.setInt(5, idmodalidade);

            modalidade.executeUpdate();
            modalidadeEditada = true;

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(SportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modalidadeEditada;
    }

    @Override
    public int getModalidadeIdByNome(String nome) {
        int idmodalidade = 0;

        try {
            Statement modalidadeid = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT idmodalidade FROM MODALIDADE WHERE NOME = '" + nome + "'";
            ResultSet rs = modalidadeid.executeQuery(query);

            while (rs.next()) {
                idmodalidade = rs.getInt("idmodalidade");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idmodalidade;
    }
}
