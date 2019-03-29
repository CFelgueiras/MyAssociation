package myassociation.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco Pereira
 */
public class QuotaImpl implements IQuotaDAO {


    @Override
    public boolean criarQuota(Double valor, Integer ano, Integer categoria) {
      boolean quotacriada = false;
        try {

            String query = "Insert into QUOTA (valor,ano,idcategoria, datacriacao,datamodificacao) "
                    + "VALUES (?,?,?,current_timestamp,current_timestamp)";
            PreparedStatement quota = ConnectDB.conexaoBD().prepareStatement(query);
            quota.setDouble(1, valor);
            quota.setInt(2, ano); 
            quota.setInt(3, categoria);
            quota.executeUpdate();
            quotacriada = true;

        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(QuotaImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return quotacriada;
    }

  @Override
    public String[] listaCategoriasSocios() {
        ArrayList<String> listacategorias = new ArrayList<>();

        try {
            Statement listaassoc = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT nome FROM CATEGORIA";
            ResultSet rs = listaassoc.executeQuery(query);

            while (rs.next()) {
                String categoria = rs.getString("nome");
                listacategorias.add(categoria);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(AssociationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] listaretorno = listacategorias.toArray(new String[listacategorias.size()]);

        return listaretorno;
    }

    public int getCategoriaIdPorNome(String nome) {
        int idcategoria = 0;

        try {
            Statement categoriaid = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT idcategoria FROM CATEGORIA WHERE NOME = '" + nome + "'";
            ResultSet rs = categoriaid.executeQuery(query);

            while (rs.next()) {
                idcategoria = rs.getInt("idcategoria");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idcategoria;
    }

    @Override
    public boolean verificaQuotaPorAnoCategoria(Integer ano, Integer categoria) {
          boolean verificaExistenciaQuota = false;

        try {
            Statement quotaexistente = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT idquota FROM Quota WHERE ANO = " + ano + " and IDCATEGORIA  = " + categoria;
            ResultSet rs = quotaexistente.executeQuery(query);

            if (rs.next()) {
                verificaExistenciaQuota=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificaExistenciaQuota;
    }


}
