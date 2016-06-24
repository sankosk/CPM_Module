package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.CardLayout;

public class BillWindow extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillWindow dialog = new BillWindow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public BillWindow() {
		setBounds(100, 100, 515, 353);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNombre);
		
		JLabel lblDninif = new JLabel("DNI/NIF:");
		lblDninif.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblDninif);
		
		JLabel lbleiiCruceros = new JLabel("EII CRUCEROS S.L");
		lbleiiCruceros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lbleiiCruceros);
		
		JLabel lblDate = new JLabel("   |   ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblDate);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new CardLayout(0, 0));

	}

}
