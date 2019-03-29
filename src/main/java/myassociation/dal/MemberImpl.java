package myassociation.dal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import myassociation.controller.UserController;
import myassociation.model.Member;

/**
 *
 * @author FELGUEIRAS
 */
public class MemberImpl implements IMemberDAO {

    private UserController usercontroller = new UserController();
    private UserImpl userimpl = new UserImpl();
    private Calendar calendar = Calendar.getInstance();
    private AssociationImpl associacaoimpl = new AssociationImpl();

    @Override
    public boolean criarSocio(String numero, String nome, String morada, String nif, 
            String email, String telefone, String telemovel, byte[] fotografia, 
            boolean ativo, boolean apagado, String categoria, String username) {
        boolean sociocriado = false;

        int idutilizador = userimpl.obterIdUtilizadorbyNome(username);
        int idassociacao = 1;
        int idcategoria = getCategoriaIdPorNome(categoria);
        try {

            String query = "Insert into SOCIO (numero,nif,nome,telefone,telemovel,"
                    + "morada,email,ativo,fotografia,apagado,idutilizador,"
                    + "idassociacao,idcategoria,datacriacao,datamodif) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp,current_timestamp)";
            PreparedStatement socio = ConnectDB.conexaoBD().prepareStatement(query);

            socio.setString(1, numero);
            socio.setString(2, nif);
            socio.setString(3, nome);
            socio.setString(4, telefone);
            socio.setString(5, telemovel);
            socio.setString(6, morada);
            socio.setString(7, email);
            socio.setBoolean(8, ativo);
            socio.setBytes(9, fotografia);
            socio.setBoolean(10, apagado);
            socio.setInt(11, idutilizador);
            socio.setInt(12, idassociacao);
            socio.setInt(13, idcategoria);
            socio.executeUpdate();
            sociocriado = true;

        } catch (SQLException e) {
            System.out.println(e);
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return sociocriado;
    }

    @Override
    public ArrayList<Member> pesquisarSocio(String dado, String pesquisa, boolean ativo) {

        ArrayList<Member> listasocios = new ArrayList<>();

        try {
            Statement pesquisarSocio = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT s.NUMERO,s.NIF, s.NOME,s.TELEFONE,s.TELEMOVEL,"
                    + "s.MORADA,s.EMAIL,s.DATACRIACAO,s.DATAMODIF,u.UTILIZADOR,"
                    + "c.NOME as CATEGORIA,a.NOME as ASSOCIACAO FROM SOCIO s "
                    + "INNER JOIN UTILIZADOR u ON u.IDUTILIZADOR = s.IDUTILIZADOR\n"
                    + "INNER JOIN CATEGORIA c ON c.IDCATEGORIA = s.IDCATEGORIA\n"
                    + "INNER JOIN ASSOCIACAO a ON a.IDASSOCIACAO = s.IDASSOCIACAO\n"
                    + "WHERE s." + dado + " like '%" + pesquisa + "%'" + " AND s.ativo ='" + ativo + "' AND s.apagado = 0";
            ResultSet rs = pesquisarSocio.executeQuery(query);

            while (rs.next()) {
                Member socio = new Member();
                socio.setNumero(rs.getString("numero"));
                socio.setNif(rs.getString("nif"));
                socio.setNome(rs.getString("nome"));
                socio.setTelefone(rs.getString("telefone"));
                socio.setTelemovel(rs.getString("telemovel"));
                socio.setMorada(rs.getString("morada"));
                socio.setEmail(rs.getString("email"));
                socio.setDatacriacao(rs.getTimestamp("datacriacao"));
                socio.setDatamodif(rs.getTimestamp("datamodif"));
                socio.setCategoria(rs.getString("categoria"));
                socio.setUtilizador(rs.getString("utilizador"));
                listasocios.add(socio);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listasocios;
    }

    @Override
    public Member pesquisarSocioPorNumero(String numero) {
        Member socio = new Member();

        try {
            Statement pesquisarSocio = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT * FROM SOCIO WHERE NUMERO = '" + numero + "'";
            ResultSet rs = pesquisarSocio.executeQuery(query);

            while (rs.next()) {
                socio.setNumero(rs.getString("numero"));
                socio.setNif(rs.getString("nif"));
                socio.setNome(rs.getString("nome"));
                socio.setTelefone(rs.getString("telefone"));
                socio.setTelemovel(rs.getString("telemovel"));
                socio.setMorada(rs.getString("morada"));
                socio.setEmail(rs.getString("email"));
                socio.setDatacriacao(rs.getTimestamp("datacriacao"));
                socio.setDatamodif(rs.getTimestamp("datamodif"));
                socio.setFotografia(rs.getBytes("fotografia"));
                socio.setEstado(rs.getBoolean("ativo"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socio;
    }

    @Override
    public boolean inativarSocio(String numero) {
        boolean sociodesativado = false;
        try {
            String query = "UPDATE SOCIO SET ativo = ?, datamodif = current_timestamp WHERE numero = ?";
            PreparedStatement socio = ConnectDB.conexaoBD().prepareStatement(query);

            socio.setBoolean(1, false);
            socio.setString(2, numero);

            socio.executeUpdate();
            sociodesativado = true;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return sociodesativado;
    }

    @Override
    public boolean apagarSocio(String numero) {
        boolean socioapagado = false;
        try {
            String query = "UPDATE SOCIO SET APAGADO = ?, datamodif = current_timestamp WHERE numero =?";
            PreparedStatement socio = ConnectDB.conexaoBD().prepareStatement(query);
            socio.setBoolean(1, true);
            socio.setString(2, numero);
            socio.executeUpdate();
            socioapagado = true;

            CallableStatement apagarnumero = ConnectDB.conexaoBD().prepareCall("{call member_number_delete}");
            apagarnumero.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return socioapagado;
    }

    @Override
    public boolean editarSocio(String numero, String nome, String morada, String nif, String email, String telefone, String telemovel, byte[] fotografia, boolean ativo, String categoria, String username) {
        boolean sociocriado = false;
        int idutilizador = userimpl.obterIdUtilizadorbyNome(username);
        int idassociacao = 1;
        int idcategoria = getCategoriaIdPorNome(categoria);
        try {
            String query = "UPDATE SOCIO SET nif = ?,nome = ?,telefone = ?,telemovel = ?,morada = ?,email = ?,datamodif = current_timestamp, ativo = ?,fotografia = ?, idcategoria=?, idutilizador=?  WHERE numero = ?";
            PreparedStatement socio = ConnectDB.conexaoBD().prepareStatement(query);

            socio.setString(1, nif);
            socio.setString(2, nome);
            socio.setString(3, telefone);
            socio.setString(4, telemovel);
            socio.setString(5, morada);
            socio.setString(6, email);
            socio.setBoolean(7, ativo);
            socio.setBytes(8, fotografia);
            socio.setInt(9, idcategoria);
            socio.setInt(10, idutilizador);
            socio.setString(11, numero);

            socio.executeUpdate();
            sociocriado = true;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return sociocriado;
    }

    @Override
    public String totalSociosAtivos() {
        String totalsocios = "";
        try {
            Statement sociosativos = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT COUNT(*) as totalsociosativos FROM SOCIO WHERE ATIVO = 1 AND APAGADO = 0";
            ResultSet rs = sociosativos.executeQuery(query);

            while (rs.next()) {
                totalsocios = Integer.toString(rs.getInt("totalsociosativos"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalsocios;
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

    @Override
    public boolean criarCategoria(String nome) {
        boolean categoriacriada = false;
        boolean categoriajaexiste = procurarCategoriaPorNome(nome);
        System.out.println("categoriajaexiste: " + categoriajaexiste);
        if (!categoriajaexiste) {
            try {
                String query = "INSERT INTO CATEGORIA (nome) VALUES(?)";
                PreparedStatement categoria = ConnectDB.conexaoBD().prepareStatement(query);
                System.out.println(query);
                System.out.println(nome);
                categoria.setString(1, nome);
                categoria.executeUpdate();
                categoriacriada = true;
            } catch (SQLException ex) {
                System.out.println(ex);
                Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return categoriacriada;
    }

    public boolean procurarCategoriaPorNome(String nome) {
        boolean categoriaencontrada = true;

        try {
            Statement categorianome = ConnectDB.conexaoBD().createStatement();
            String query = "SELECT nome FROM CATEGORIA WHERE NOME ='" + nome + "'";
            ResultSet rs = categorianome.executeQuery(query);

            if (!rs.isBeforeFirst()) {
                categoriaencontrada = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoriaencontrada;
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
    public boolean renumerarSocios() {
        boolean renumeracao = false;

        try {
            CallableStatement renumerar = ConnectDB.conexaoBD().prepareCall("{call members_renumbering}");
            renumerar.execute();
            renumeracao = true;
        } catch (SQLException ex) {
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return renumeracao;
    }
}
