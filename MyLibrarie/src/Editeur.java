import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Editeur {
	//je supprime tout 
	
	private String Nom;
	private String Code_postal;
	private String Code_editeur;
	private String Adresse;
    private ArrayList<Editeur> listEditeur = new ArrayList<>();
    private PreparedStatement pst;
    private ResultSet rs;
	
	
	public Editeur(String nom, String code_postal, String code_editeur, String adresse) {
		Nom = nom;
		Code_postal = code_postal;
		Code_editeur = code_editeur;
		Adresse = adresse;
	}
	
	public Editeur() {
	}
	
	
	
	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getCode_postal() {
		return Code_postal;
	}

	public void setCode_postal(String code_postal) {
		Code_postal = code_postal;
	}

	public String getCode_editeur() {
		return Code_editeur;
	}

	public void setCode_editeur(String code_editeur) {
		Code_editeur = code_editeur;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public ArrayList<Editeur> getListEditeur() {
		return listEditeur;
	}

	public void setListEditeur(ArrayList<Editeur> listEditeur) {
		this.listEditeur = listEditeur;
	}

	public void recupAllEditor() {		// method to get all data from table éditeur
        String request = "SELECT * FROM éditeur";
        MySQLConnec.ConnectDB();
        if (MySQLConnec.Conn != null) {		//test if connection to BDD is not null
            try {							// try/catch to BDD
            	pst = MySQLConnec.Conn.prepareStatement(request);		
                rs = pst.executeQuery();
                this.listEditeur = new ArrayList<>();
                while (rs.next()) {										//loop for read the content of the answer from BDD
                    String nomR = rs.getString("éditeur");
                    String code_postalR = rs.getString("code_postal");
                    String code_editeurR = rs.getString("code_éditeur");
                    String adresseR = rs.getString("address");
                    this.listEditeur.add(new Editeur(nomR, code_postalR, code_editeurR, adresseR));
                }
                pst.close();											// close the statement
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "problème avec recupAllEditor()" + ex.getMessage(), "Problème rencontré",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
	
	public boolean updateEditor(String editeur, String code_postal, String address, String code_editeur) {
		boolean test = false;
        String request = "UPDATE éditeur SET éditeur = ?, code_postal = ?, address = ? WHERE code_éditeur = ?";
        MySQLConnec.ConnectDB();
        if (MySQLConnec.Conn != null) {		//test if connection to BDD is not null
            try {							// try/catch to BDD
            	pst = MySQLConnec.Conn.prepareStatement(request);
            	pst.setString(1, editeur);
            	pst.setString(2, code_postal);
            	pst.setString(3, address);
            	pst.setString(4, code_editeur);
                pst.executeUpdate();
                test = true;
                pst.close();											// close the statement
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "problème avec updateEditor()" + ex.getMessage(), "Problème rencontré",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return test;
    }
	
	public boolean setEditor(String editeur, String code_postal, String code_editeur, String address) {
		boolean test = false;
		String request = "INSERT INTO éditeur VALUE (?, ?, ?, ?)";
		MySQLConnec.ConnectDB();
		if (MySQLConnec.Conn != null) {		//test if connection to BDD is not null
            try {							// try/catch to BDD
            	pst = MySQLConnec.Conn.prepareStatement(request);
            	pst.setString(1, editeur);
            	pst.setString(2, code_postal);
            	pst.setString(3, code_editeur);
            	pst.setString(4, address);
                pst.executeUpdate();
                test = true;
                pst.close();											// close the statement
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "problème avec setEditor()" + ex.getMessage(), "Problème rencontré",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
		return test;
	}
	
	public boolean delEditor(String code_editeur) {
		boolean test = false;
		String request = "DELETE FROM éditeur WHERE code_éditeur = ?";
		MySQLConnec.ConnectDB();
		if (MySQLConnec.Conn != null) {		//test if connection to BDD is not null
            try {							// try/catch to BDD
            	pst = MySQLConnec.Conn.prepareStatement(request);
            	pst.setString(1, code_editeur);
                pst.executeUpdate();
                test = true;
                pst.close();											// close the statement
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "problème avec delEditor()" + ex.getMessage(), "Problème rencontré",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
		return test;
	}

	@Override
	public String toString() {
		return "Editeur [Nom=" + Nom + ", Code_postal=" + Code_postal + ", Code_editeur=" + Code_editeur + ", Adresse="
				+ Adresse + "]";
	}
	
	
	
}
