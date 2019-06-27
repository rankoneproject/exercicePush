import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField tF_Editeur;
	private JTextField tF_Code_postal;
	private JTextField tF_Code_editeur;
	private JTextField tF_Address;
	private JTable tabEditeur;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 479);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tF_Editeur = new JTextField();
		tF_Editeur.setBounds(138, 31, 116, 22);
		contentPane.add(tF_Editeur);
		tF_Editeur.setColumns(10);

		tF_Code_postal = new JTextField();
		tF_Code_postal.setBounds(138, 66, 116, 22);
		contentPane.add(tF_Code_postal);
		tF_Code_postal.setColumns(10);

		tF_Code_editeur = new JTextField();
		tF_Code_editeur.setEnabled(false);
		tF_Code_editeur.setBounds(383, 31, 116, 22);
		contentPane.add(tF_Code_editeur);
		tF_Code_editeur.setColumns(10);

		tF_Address = new JTextField();
		tF_Address.setBounds(383, 66, 116, 22);
		contentPane.add(tF_Address);
		tF_Address.setColumns(10);

		JLabel lb_Editeur = new JLabel("Editeur");
		lb_Editeur.setForeground(Color.CYAN);
		lb_Editeur.setBounds(63, 34, 56, 16);
		contentPane.add(lb_Editeur);

		JLabel lb_Code_postal = new JLabel("Code Postal");
		lb_Code_postal.setForeground(Color.CYAN);
		lb_Code_postal.setBounds(63, 69, 73, 16);
		contentPane.add(lb_Code_postal);

		JLabel lb_Code_editeur = new JLabel("Code Editeur");
		lb_Code_editeur.setForeground(Color.CYAN);
		lb_Code_editeur.setBounds(298, 34, 73, 16);
		contentPane.add(lb_Code_editeur);

		JLabel lb_Address = new JLabel("Adresse");
		lb_Address.setForeground(Color.CYAN);
		lb_Address.setBounds(298, 69, 73, 16);
		contentPane.add(lb_Address);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(59, 167, 719, 208);
		contentPane.add(scrollPane);

		tabEditeur = new JTable();
		tabEditeur.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// event mouse click pour recup donnée du tableau et les insert dans les text
				// field
				int iView = tabEditeur.getSelectedRow();
				int i = tabEditeur.convertRowIndexToModel(iView);
				TableModel model = tabEditeur.getModel();
				tF_Editeur.setText((String) model.getValueAt(i, 0));
				tF_Code_postal.setText((String) model.getValueAt(i, 1));
				tF_Code_editeur.setText((String) model.getValueAt(i, 2));
				tF_Address.setText((String) model.getValueAt(i, 3));

			}
		});
		tabEditeur.setBackground(Color.YELLOW);
		tabEditeur.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(tabEditeur);
		tabEditeur.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "\u00E9diteur", "code_postal", "code_\u00E9diteur", "address" }));

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(Color.ORANGE);
		btnRefresh.setBackground(Color.CYAN);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remplirTableEditeur();
			}
		});
		btnRefresh.setBounds(616, 65, 97, 25);
		contentPane.add(btnRefresh);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setForeground(Color.ORANGE);
		btnInsert.setBackground(Color.CYAN);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertEditeur();
			}
		});
		btnInsert.setBounds(616, 30, 97, 25);
		contentPane.add(btnInsert);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.ORANGE);
		btnDelete.setBackground(Color.CYAN);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEditeur();
			}
		});
		btnDelete.setBounds(383, 109, 116, 25);
		contentPane.add(btnDelete);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateEditeur();
			}
		});
		btnUpdate.setBackground(Color.CYAN);
		btnUpdate.setForeground(Color.ORANGE);
		btnUpdate.setBounds(138, 109, 116, 25);
		contentPane.add(btnUpdate);
		tabEditeur.getColumnModel().getColumn(1).setPreferredWidth(104);
		tabEditeur.getColumnModel().getColumn(1).setMinWidth(20);
		tabEditeur.getColumnModel().getColumn(2).setPreferredWidth(99);

		remplirTableEditeur();
	}

	// My code
	// --------------------------------------------------------------------------------------------------

	Editeur editeurGenerique = new Editeur();
	private JButton btnDelete;
	private JButton btnUpdate;

	private void remplirTableEditeur() {
		editeurGenerique.recupAllEditor();
		ArrayList<Editeur> listEditeur = editeurGenerique.getListEditeur();
		DefaultTableModel model = (DefaultTableModel) tabEditeur.getModel();
		Object row[] = new Object[4];
		model.setRowCount(0);
		for (int i = 0; i < listEditeur.size(); i++) {
			row[0] = listEditeur.get(i).getNom();
			row[1] = listEditeur.get(i).getCode_postal();
			row[2] = listEditeur.get(i).getCode_editeur();
			row[3] = listEditeur.get(i).getAdresse();
			model.addRow(row);
		}
	}

	private void insertEditeur() {
		String editeur = tF_Editeur.getText();
		String codePostal = tF_Code_postal.getText();
		String codeEditeur = tF_Code_editeur.getText();
		String address = tF_Address.getText();
		if (editeurGenerique.setEditor(editeur, codePostal, codeEditeur, address)) {
			JOptionPane.showMessageDialog(this, "L'éditeur à été correctement ajouté", "Insert",
					JOptionPane.INFORMATION_MESSAGE);
			remplirTableEditeur();
		}
		;
	}

	private void updateEditeur() {
			if(JOptionPane.showConfirmDialog(this, "Êtes vous sur de vouloir modifier ce compte?", "Modification", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
			String editeur = tF_Editeur.getText();
			String codePostal = tF_Code_postal.getText();
			String address = tF_Address.getText();
			String codeEditeur = tF_Code_editeur.getText();
				if(editeurGenerique.updateEditor(editeur, codePostal, address, codeEditeur)) {
				JOptionPane.showMessageDialog(this, "L'éditeur à été correctement modifié", "Update", JOptionPane.INFORMATION_MESSAGE);
				remplirTableEditeur();
				}
			}
		}

	private void deleteEditeur() {
		String codeEditeur = tF_Code_editeur.getText();
		if (editeurGenerique.delEditor(codeEditeur)) {
			JOptionPane.showMessageDialog(this, "L'éditeur à été correctement supprimé", "Delete",
					JOptionPane.INFORMATION_MESSAGE);
			remplirTableEditeur();
		}
		;
	}

}
