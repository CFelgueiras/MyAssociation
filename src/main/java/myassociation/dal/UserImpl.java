package myassociation.dal;

import Utils.EncryptUtils;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import myassociation.dto.EncryptResDTO;
import myassociation.model.User;

/**
 * Class that implements IUserDAO interface for user database data manipulation
 *
 * @author FELGUEIRAS
 */
public class UserImpl implements IUserDAO {

    AssociationImpl associacaoimpl = new AssociationImpl();

    @Override
    public boolean doLogin(String username, String password) {
        try {
            User utilizador = new User();
            PreparedStatement handler;
            ResultSet result;
            String query = ""
                    + "SELECT *"
                    + "  FROM UTILIZADOR"
                    + " WHERE UTILIZADOR = ?";
            handler = ConnectDB.conexaoBD()
                    .prepareStatement(query);
            handler.setString(1, username);
            result = handler.executeQuery();
            if (result.next()) {
                utilizador.setNome(result.getString("utilizador"));
                utilizador.setSalt(result.getString("salt"));
            }
            String loginQuery = ""
                    + "SELECT * "
                    + "  FROM UTILIZADOR "
                    + " WHERE UTILIZADOR = ?"
                    + " AND SENHA = ? ";
            handler = ConnectDB.conexaoBD()
                    .prepareStatement(loginQuery);
            String cryptPass = EncryptUtils.getEncyptionWithSalt(
                    password, utilizador.getSalt()
            );
            handler.setString(1, username);
            handler.setString(2, cryptPass);
            result = handler.executeQuery();
            if (result.next()) {
                
                return true;
            }
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(
                    UserImpl.class.getName()
            ).log(Level.SEVERE, null, ex);
            
            return false;
        } finally {
            try {
                ConnectDB.desconexaoBD();
            } catch (Exception ex) {
                Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean pesquisaUtilizador(String nome) {
        boolean userencontrado = false;
        try {
            String query = "SELECT utilizador FROM UTILIZADOR WHERE utilizador = ?";
            PreparedStatement login = ConnectDB.conexaoBD().prepareStatement(query);
            login.setString(1, nome);
            ResultSet resultLogin = login.executeQuery();

            if (resultLogin.next()) {
                User utilizador = new User();
                utilizador.setNome(resultLogin.getString("utilizador"));
                userencontrado = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ConnectDB.desconexaoBD();
            } catch (Exception ex) {
                Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userencontrado;
    }

    @Override
    public boolean criarUtilizador(String utilizador, String senha, String grupo) {
        boolean utilcriado = false;
        Calendar calendar = Calendar.getInstance();
        java.sql.Date date = new java.sql.Date(calendar.getTimeInMillis());

        int idgrupoutilizador = obterIdGrupoUtilizadorbyNome(grupo);

        try {

            boolean utiljaexiste = doLogin(utilizador, senha);

            if (!utiljaexiste) {
                String query = "INSERT INTO"
                        + " UTILIZADOR("
                        + "             utilizador,"
                        + "             senha,"
                        + "             datacriacao,"
                        + "             datamodificacao,"
                        + "             IDGRUPOUTILIZADOR,"
                        + "             salt"
                        + ") VALUES (?,?,?,?,?,?)";
                PreparedStatement criarutil = ConnectDB.conexaoBD()
                        .prepareStatement(query);
                EncryptResDTO hashPass = EncryptUtils.encrypt(senha);
                criarutil.setString(1, utilizador);
                criarutil.setString(2, hashPass.hash);
                criarutil.setDate(3, date);
                criarutil.setDate(4, date);
                criarutil.setInt(5, idgrupoutilizador);
                criarutil.setString(6, hashPass.salt);
                criarutil.executeUpdate();

                utilcriado = true;
            } else {
                utiljaexiste = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    UserImpl.class.getName()
            ).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(
                    UserImpl.class.getName()
            ).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ConnectDB.desconexaoBD();
            } catch (Exception ex) {
                Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return utilcriado;
    }

    @Override
    public ArrayList<User> searchUser(String dado, String pesquisa) {
        ArrayList<User> userlist = new ArrayList<>();

        try {
            Statement searchUser = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT * FROM UTILIZADOR WHERE " + dado + " like '%" + pesquisa + "%'";
            System.out.println(query);

            ResultSet rs = searchUser.executeQuery(query);

            while (rs.next()) {
                User user = new User();
                user.setNome(rs.getString("utilizador"));
                user.setDatacriacao(rs.getDate("datacriacao"));
                user.setDatacriacao(rs.getDate("datamodificacao"));
                userlist.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userlist;
    }

    @Override
    public int obterIdGrupoUtilizadorbyNome(String nomegrupo) {
        int grupoid = 0;
        try {
            Statement idGrupoUtilizador = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT idgrupoutilizador from GRUPOUTILIZADOR WHERE nomegrupo = '" + nomegrupo + "'";
            ResultSet rs = idGrupoUtilizador.executeQuery(query);
            while (rs.next()) {
                grupoid = rs.getInt("idgrupoutilizador");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(AssociationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grupoid;
    }

    public int obterIdUtilizadorbyNome(String utilizador) {
        int userid = 0;
        try {
            Statement idutilizador = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT idutilizador from UTILIZADOR WHERE utilizador = '" + utilizador + "'";
            ResultSet rs = idutilizador.executeQuery(query);
            while (rs.next()) {
                userid = rs.getInt("idutilizador");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userid;
    }

}
