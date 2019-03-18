/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cláudio Felgueiras
 */
public class SportImpl implements ISportDAO {

    @Override
    public boolean criarModalidade(String nome, String responsavel, boolean estado) {
        boolean modalidadecriada = false;

        try {
            String query = "Insert into MODALIDADE (nome, responsavel, inativa, apagada, datacriacao,"
                    + " datamodificacao) Values(?,?,?,?,current_timestamp,current_timestamp)";

            PreparedStatement modalidade = ConnectDB.conexaoBD().prepareStatement(query);

            modalidade.setString(1, nome);
            modalidade.setString(2, responsavel);
            modalidade.setBoolean(3, estado);
            modalidade.setBoolean(4, false);

            modalidade.executeUpdate();
            modalidadecriada = true;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(SportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modalidadecriada;
    }
}
