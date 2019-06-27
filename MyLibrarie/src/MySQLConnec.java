import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public abstract class MySQLConnec {
	
	private static String Adresse = "jdbc:mysql://localhost:3306/mylibrarie?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static String Utilisateur = "root";
	private static String Password = "root";
	public static Connection Conn;

	public static void ConnectDB() {
        try {
            Conn = DriverManager.getConnection(Adresse, Utilisateur, Password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connexion impossible à la BDD");	
        }
    }
}
