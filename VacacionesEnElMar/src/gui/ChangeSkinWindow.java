package gui;
import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;


public class ChangeSkinWindow extends JDialog {
	private JComboBox comboBox;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeSkinWindow dialog = new ChangeSkinWindow();
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
	public ChangeSkinWindow() {
		setBounds(100, 100, 450, 131);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		getContentPane().add(getComboBox());
		getContentPane().add(getBtnNewButton());

	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"AutumnSkin", "BusinessBlackSteelSkin", "BusinessBlueSteelSkin", "BusinessSkin"}));
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return comboBox;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cambiar Skin");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return btnNewButton;
	}
}
