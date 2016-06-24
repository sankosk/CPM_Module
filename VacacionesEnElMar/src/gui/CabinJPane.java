package gui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;

import logic.Cabin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CabinJPane extends JPanel {
	private JPanel jpaneHeader;
	private JPanel infoJpaneContainer;
	private JPanel ExtrasPane;
	private JPanel numPersonsPane;
	private JPanel ageOfPersonsPane;
	private JLabel numOfPersonsLbl;
	private JLabel lblEdadesDeOcupantes;
	private JLabel lblExtras;
	private Cabin cabin;
	private JLabel label;
	private BookRoomWindow brW;
	private JPanel panel;
	private JButton editButton;
	private JButton deleteBtn;
	private int cabinCounter;
	
	public BookRoomWindow getBrW() {
		return brW;
	}

	public void setBrW(BookRoomWindow brW) {
		this.brW = brW;
	}

	/**
	 * Create the panel.
	 */
	public CabinJPane(Cabin cabin, BookRoomWindow brW, int cabinCounter) {
		this.cabin = cabin;
		this.cabinCounter = cabinCounter;
		setBrW(brW);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		add(getJpaneHeader(), BorderLayout.NORTH);
		add(getInfoJpaneContainer(), BorderLayout.CENTER);
		add(getPanel(), BorderLayout.SOUTH);
		//System.out.println("CONTADOR:"+cabinCounter);

		//getBrW().getListOfReservesPane();
		//;

	}

	private JPanel getJpaneHeader() {
		if (jpaneHeader == null) {
			jpaneHeader = new JPanel();
			jpaneHeader.setLayout(new BorderLayout(0, 0));
			jpaneHeader.add(getLabel(), BorderLayout.SOUTH);
		}
		return jpaneHeader;
	}
	private JPanel getInfoJpaneContainer() {
		if (infoJpaneContainer == null) {
			infoJpaneContainer = new JPanel();
			infoJpaneContainer.setLayout(new GridLayout(3, 1, 0, 0));
			infoJpaneContainer.add(getNumPersonsPane());
			infoJpaneContainer.add(getAgeOfPersonsPane());
			infoJpaneContainer.add(getExtrasPane());
		}
		return infoJpaneContainer;
	}
	private JPanel getExtrasPane() {
		if (ExtrasPane == null) {
			ExtrasPane = new JPanel();
			ExtrasPane.add(getLblExtras());
		}
		return ExtrasPane;
	}
	private JPanel getNumPersonsPane() {
		if (numPersonsPane == null) {
			numPersonsPane = new JPanel();
			numPersonsPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			numPersonsPane.add(getNumOfPersonsLbl());
		}
		return numPersonsPane;
	}
	private JPanel getAgeOfPersonsPane() {
		if (ageOfPersonsPane == null) {
			ageOfPersonsPane = new JPanel();
			ageOfPersonsPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			ageOfPersonsPane.add(getLblEdadesDeOcupantes());
		}
		return ageOfPersonsPane;
	}
	private JLabel getNumOfPersonsLbl() {
		if (numOfPersonsLbl == null) {
			numOfPersonsLbl = new JLabel("N\u00FAmero de Ocupantes: " + cabin.getNumOfPersons() + " personas");
			numOfPersonsLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return numOfPersonsLbl;
	}
	private JLabel getLblEdadesDeOcupantes() {
		if (lblEdadesDeOcupantes == null) {
			lblEdadesDeOcupantes = new JLabel("Edades de Ocupantes:" + cabin.getAges() + " años");
			lblEdadesDeOcupantes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lblEdadesDeOcupantes;
	}
	private JLabel getLblExtras() {
		if (lblExtras == null) {
			lblExtras = new JLabel("Extras:" + cabin.getStringExtras());
			lblExtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lblExtras;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Tipo: Camarote " + cabin.getCabinType() + " " + cabin.getLocation());
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return label;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getEditButton());
			panel.add(getDeleteBtn());
		}
		return panel;
	}
	private JButton getEditButton() {
		if (editButton == null) {
			editButton = new JButton("Editar");
			editButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return editButton;
	}
	private JButton getDeleteBtn() {
		if (deleteBtn == null) {
			deleteBtn = new JButton("Borrar");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(cabinCounter >= getBrW().getCabins().size())
						cabinCounter--;
					
					getBrW().getCabins().remove(cabinCounter);
					getBrW().getListOfReservesPane().remove(cabinCounter);
					getBrW().setCabinCounter(getBrW().getCabinCounter()-1);
					getBrW().getListOfReservesPane().revalidate();
					getBrW().getListOfReservesPane().repaint();
					
				}
			});
		}
		return deleteBtn;
	}
}
