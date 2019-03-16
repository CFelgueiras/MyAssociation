package myassociation.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Database connector class using Singleton Desing Patern
 * @author Claudio Felgueiras
 */
public class ConnectDB {

    private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;" +  
   "databaseName=MYASSOCIATION;user=sa;password=Myassociation2018;";  
    private static Connection conexao;

    /**
     * Method that opens database connection
     *
     * @return connection
     */
    public static Connection conexaoBD() {
        if (conexao == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                conexao = DriverManager.getConnection(CONNECTIONURL);
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Ligação à Base de dados impossivel." + "\n" + e);
            }
        }
        return conexao;
    }

    /**
     * Method that closes database connection
     */
    public static void desconexaoBD() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de Ligação à base de dados.", 0);
            }
        }
    }
}
