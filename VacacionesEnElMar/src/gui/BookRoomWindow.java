package gui;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.CardLayout;

import net.miginfocom.swing.MigLayout;

import java.awt.Checkbox;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import logic.Agency;
import logic.Bill;
import logic.Cabin;
import logic.Cruiser;
import logic.Extra;
import logic.Ship;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class BookRoomWindow extends JDialog {
	private JPanel bookRoomPane;
	private JPanel bookProcessPane;
	private JPanel bookListPane;
	private JPanel bookheaderPane;
	private JPanel bookListHeaderPane;
	private JPanel bookPaneInput;
	private JPanel listOfReservesPane;
	private JLabel lblReservaCamarote;
	private JLabel lblCamarotesReservados;
	private JPanel footerPane;
	private JPanel localizationPane;
	private JPanel cabinTypePane;
	private JPanel personsInfoPane;
	private JRadioButton extRadioButton;
	private JRadioButton intRadioButton;
	private JRadioButton familiarRadioButton;
	private JRadioButton dobleRadioButton;
	private Panel ageOfPersonsPane;
	private Panel numPersonsPane;
	private Panel lblPane;
	private Panel textPane;
	private Label numPersonsLbl;
	private TextField numPersonsText;
	private Panel ageLblPane;
	private Panel ageTextPane;
	private Label agesLbl;
	private TextField agesTextField;
	private JScrollPane scrollExtras;
	private JScrollPane scrollExtra;
	private JPanel extraPane;	
	private JPanel leftPane;
	private JPanel rightPane;
	private JPanel cancelButtonPane;
	private JPanel nextButtonPane;
	private JButton nextButton;
	private JButton cancelButton;
	private JPanel resetPane;
	private JPanel addPane;
	private JButton addButton;
	private JButton resetButton;
	private JScrollPane scrollReserves;
	
	//
	private Bill bill;
	private Agency agency;
	private Cruiser cruiser;
	private Ship ship;
	private ArrayList<Cabin> cabins;
	private int cabinCounter=0;
	
	public int getCabinCounter() {
		return cabinCounter;
	}

	public void setCabinCounter(int cabinCounter) {
		this.cabinCounter = cabinCounter;
	}
	
	private JScrollPane scrollDates;
	private JPanel datesPane;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookRoomWindow dialog = new BookRoomWindow();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public ArrayList<Cabin> getCabins() {
		return cabins;
	}

	public void setCabins(ArrayList<Cabin> cabins) {
		this.cabins = cabins;
	}

	/**
	 * Create the dialog.
	 */
	public BookRoomWindow(Agency agency, Cruiser cruiser, Ship ship) {
		this.cruiser = cruiser;
		this.agency = agency;
		this.ship = ship;
		cabins = new ArrayList<Cabin>();
		setTitle("Tebo's cruisers: Proceso de reserva de camarotes");
		setBounds(100, 100, 663, 422);
		getContentPane().add(getBookRoomPane(), BorderLayout.CENTER);
		getContentPane().add(getFooterPane(), BorderLayout.SOUTH);

	}

	private JPanel getBookRoomPane() {
		if (bookRoomPane == null) {
			bookRoomPane = new JPanel();
			bookRoomPane.setLayout(new GridLayout(0, 2, 0, 0));
			bookRoomPane.add(getBookProcessPane());
			bookRoomPane.add(getBookListPane());
		}
		return bookRoomPane;
	}
	private JPanel getBookProcessPane() {
		if (bookProcessPane == null) {
			bookProcessPane = new JPanel();
			bookProcessPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			bookProcessPane.setLayout(new BorderLayout(0, 0));
			bookProcessPane.add(getBookheaderPane(), BorderLayout.NORTH);
			bookProcessPane.add(getBookPaneInput(), BorderLayout.CENTER);
		}
		return bookProcessPane;
	}
	private JPanel getBookListPane() {
		if (bookListPane == null) {
			bookListPane = new JPanel();
			bookListPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			bookListPane.setLayout(new BorderLayout(0, 0));
			bookListPane.add(getBookListHeaderPane(), BorderLayout.NORTH);
			//bookListPane.add(getListOfReservesPane(), BorderLayout.CENTER);
			bookListPane.add(getScrollReserves(), BorderLayout.CENTER);
		}
		return bookListPane;
	}
	private JPanel getBookheaderPane() {
		if (bookheaderPane == null) {
			bookheaderPane = new JPanel();
			bookheaderPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			bookheaderPane.add(getLblReservaCamarote());
		}
		return bookheaderPane;
	}
	private JPanel getBookListHeaderPane() {
		if (bookListHeaderPane == null) {
			bookListHeaderPane = new JPanel();
			bookListHeaderPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			bookListHeaderPane.add(getLblCamarotesReservados());
		}
		return bookListHeaderPane;
	}
	private JPanel getBookPaneInput() {
		if (bookPaneInput == null) {
			bookPaneInput = new JPanel();
			bookPaneInput.setLayout(new GridLayout(5, 1, 0, 0));
			bookPaneInput.add(getLocalizationPane());
			bookPaneInput.add(getCabinTypePane());
			bookPaneInput.add(getPersonsInfoPane());
			bookPaneInput.add(getScrollDates());
			//bookPaneInput.add(getScrollExtra());
			bookPaneInput.add(getScrollExtra());
			//bookPaneInput.add(getPanel());
			//bookPaneInput.add(getExtraPane());
		}
		return bookPaneInput;
	}
	protected JPanel getListOfReservesPane() {
		if (listOfReservesPane == null) {
			listOfReservesPane = new JPanel();
			listOfReservesPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			listOfReservesPane.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return listOfReservesPane;
	}
	private JLabel getLblReservaCamarote() {
		if (lblReservaCamarote == null) {
			lblReservaCamarote = new JLabel("Reserva Camarote");
			lblReservaCamarote.setFont(new Font("Tahoma", Font.BOLD, 15));
		}
		return lblReservaCamarote;
	}
	private JLabel getLblCamarotesReservados() {
		if (lblCamarotesReservados == null) {
			lblCamarotesReservados = new JLabel("Camarotes reservados");
			lblCamarotesReservados.setFont(new Font("Tahoma", Font.BOLD, 15));
		}
		return lblCamarotesReservados;
	}
	private JPanel getFooterPane() {
		if (footerPane == null) {
			footerPane = new JPanel();
			footerPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			footerPane.setLayout(new GridLayout(1, 0, 0, 0));
			footerPane.add(getLeftPane());
			footerPane.add(getPanel_3());
		}
		return footerPane;
	}
	private JPanel getLocalizationPane() {
		if (localizationPane == null) {
			localizationPane = new JPanel();
			localizationPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			ButtonGroup bg = new ButtonGroup();
			bg.add(getIntRadioButton());
			bg.add(getExtRadioButton());
			localizationPane.setLayout(new GridLayout(0, 2, 0, 0));
			localizationPane.add(getIntRadioButton());
			localizationPane.add(getExtRadioButton());
		}
		return localizationPane;
	}
	private JPanel getCabinTypePane() {
		if (cabinTypePane == null) {
			cabinTypePane = new JPanel();
			cabinTypePane.setBorder(new LineBorder(new Color(0, 0, 0)));
			ButtonGroup bj = new ButtonGroup();
			bj.add(getFamiliarRadioButton());
			bj.add(getDobleRadioButton());
			cabinTypePane.setLayout(new GridLayout(0, 2, 0, 0));
			cabinTypePane.add(getFamiliarRadioButton());
			cabinTypePane.add(getDobleRadioButton());
		}
		return cabinTypePane;
	}
	private JPanel getPersonsInfoPane() {
		if (personsInfoPane == null) {
			personsInfoPane = new JPanel();
			personsInfoPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			personsInfoPane.setLayout(new GridLayout(2, 0, 0, 0));
			personsInfoPane.add(getNumPersonsPane());
			personsInfoPane.add(getAgeOfPersonsPane());
		}
		return personsInfoPane;
	}
	private JRadioButton getExtRadioButton() {
		if (extRadioButton == null) {
			extRadioButton = new JRadioButton("Camarote Exterior");
			extRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return extRadioButton;
	}
	private JRadioButton getIntRadioButton() {
		if (intRadioButton == null) {
			intRadioButton = new JRadioButton("Camarote Interior");
			intRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return intRadioButton;
	}
	private JRadioButton getFamiliarRadioButton() {
		if (familiarRadioButton == null) {
			familiarRadioButton = new JRadioButton("Camarote Familiar");
			familiarRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return familiarRadioButton;
	}
	private JRadioButton getDobleRadioButton() {
		if (dobleRadioButton == null) {
			dobleRadioButton = new JRadioButton("Camarote Doble");
			dobleRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return dobleRadioButton;
	}
	private Panel getAgeOfPersonsPane() {
		if (ageOfPersonsPane == null) {
			ageOfPersonsPane = new Panel();
			ageOfPersonsPane.setLayout(new GridLayout(0, 2, 0, 0));
			ageOfPersonsPane.add(getAgeLblPane());
			ageOfPersonsPane.add(getAgeTextPane());
		}
		return ageOfPersonsPane;
	}
	private Panel getNumPersonsPane() {
		if (numPersonsPane == null) {
			numPersonsPane = new Panel();
			numPersonsPane.setLayout(new GridLayout(0, 2, 0, 0));
			numPersonsPane.add(getLblPane());
			numPersonsPane.add(getTextPane());
		}
		return numPersonsPane;
	}
	private Panel getLblPane() {
		if (lblPane == null) {
			lblPane = new Panel();
			lblPane.setLayout(new MigLayout("", "[140px]", "[24px]"));
			lblPane.add(getNumPersonsLbl(), "cell 0 0,alignx left,aligny top");
		}
		return lblPane;
	}
	private Panel getTextPane() {
		if (textPane == null) {
			textPane = new Panel();
			textPane.setLayout(new MigLayout("", "[138px]", "[40px]"));
			textPane.add(getNumPersonsText(), "cell 0 0,grow");
		}
		return textPane;
	}
	private Label getNumPersonsLbl() {
		if (numPersonsLbl == null) {
			numPersonsLbl = new Label("N\u00FAmero de Personas:");
			numPersonsLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return numPersonsLbl;
	}
	private TextField getNumPersonsText() {
		if (numPersonsText == null) {
			numPersonsText = new TextField();
		}
		return numPersonsText;
	}
	private Panel getAgeLblPane() {
		if (ageLblPane == null) {
			ageLblPane = new Panel();
			ageLblPane.setLayout(new MigLayout("", "[138px]", "[40px]"));
			ageLblPane.add(getAgesLbl(), "cell 0 0,grow");
		}
		return ageLblPane;
	}
	private Panel getAgeTextPane() {
		if (ageTextPane == null) {
			ageTextPane = new Panel();
			ageTextPane.setLayout(new MigLayout("", "[138px]", "[40px]"));
			ageTextPane.add(getAgesTextField(), "cell 0 0,grow");
		}
		return ageTextPane;
	}
	private Label getAgesLbl() {
		if (agesLbl == null) {
			agesLbl = new Label("Edades Personas");
			agesLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return agesLbl;
	}
	private TextField getAgesTextField() {
		if (agesTextField == null) {
			agesTextField = new TextField();
		}
		return agesTextField;
	}

	private JScrollPane getScrollExtra() {
		if (scrollExtra == null) {
			scrollExtra = new JScrollPane();
			scrollExtra.setViewportView(getExtraPane());
		}
		return scrollExtra;
	}
	private JPanel getExtraPane() {
		if (extraPane == null) {
			extraPane = new JPanel();
			extraPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			extraPane.setLayout(new GridLayout(0, 2, 0, 0));
			
			for(Extra extra: agency.getExtras()){
//				if(extra.getDenomination().equals("Cama supletoria")){
//					JCheckBox j = new JCheckBox(extra.getDenomination() + "(" + extra.getPriceOfExtra() + "€)");
//					extraPane.add(j);
//					j.setEnabled(false);
//				}
//				else
				extraPane.add(new JCheckBox(extra.getDenomination() + "(" + extra.getPriceOfExtra() + "€)"));
			}
			
		}
		return extraPane;
	}
	private JPanel getLeftPane() {
		if (leftPane == null) {
			leftPane = new JPanel();
			leftPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			leftPane.setLayout(new GridLayout(0, 2, 0, 0));
			leftPane.add(getPanel_4());
			leftPane.add(getPanel_1_2());
		}
		return leftPane;
	}
	private JPanel getPanel_3() {
		if (rightPane == null) {
			rightPane = new JPanel();
			rightPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			rightPane.setLayout(new GridLayout(0, 2, 0, 0));
			rightPane.add(getPanel_2());
			rightPane.add(getPanel_1_1());
		}
		return rightPane;
	}
	private JPanel getPanel_2() {
		if (cancelButtonPane == null) {
			cancelButtonPane = new JPanel();
			cancelButtonPane.setLayout(new GridLayout(0, 1, 0, 0));
			cancelButtonPane.add(getCancelButton());
		}
		return cancelButtonPane;
	}
	private JPanel getPanel_1_1() {
		if (nextButtonPane == null) {
			nextButtonPane = new JPanel();
			nextButtonPane.setLayout(new GridLayout(0, 1, 0, 0));
			nextButtonPane.add(getNextButton());
		}
		return nextButtonPane;
	}
	private JButton getNextButton() {
		if (nextButton == null) {
			nextButton = new JButton("Siguiente");
			nextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showRegisterDialog();
				}
			});
		}
		return nextButton;
	}
	
	private void showRegisterDialog(){
		JTextField name = new JTextField();
		JTextField nif = new JTextField();
		JTextField tlf = new JTextField();
		
		Object[] dialog = {"Nombre: ", name, "DNI/NIF", nif, "Teléfono",tlf};
		int otp = JOptionPane.showConfirmDialog(null, dialog, "Registro a nombre de:", JOptionPane.OK_CANCEL_OPTION);
		if (otp == JOptionPane.OK_OPTION) {
			this.bill = new Bill(name.getText(), tlf.getText(),getDateCombo().getSelectedItem().toString() , nif.getText());
			//System.out.println(agency.getBill(this.bill, cruiser, ship, cabins));
			agency.generateBill(bill, cruiser, ship, cabins);
			JOptionPane.showMessageDialog(null, "Se ha generado un .dat con el recibo de la reserva");
			dispose();
			//cruiser.getDepartureDates().remove();
			
			
		}else {
		    System.out.println("Cancelado");
		}
	}
	
	private JButton getCancelButton() {
		if (cancelButton == null) {
			cancelButton = new JButton("Cancel");
		}
		return cancelButton;
	}
	private JPanel getPanel_4() {
		if (resetPane == null) {
			resetPane = new JPanel();
			resetPane.setLayout(new GridLayout(1, 0, 0, 0));
			resetPane.add(getResetButton());
		}
		return resetPane;
	}
	private JPanel getPanel_1_2() {
		if (addPane == null) {
			addPane = new JPanel();
			addPane.setLayout(new GridLayout(1, 0, 0, 0));
			addPane.add(getAddButton());
		}
		return addPane;
	}
	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton("A\u00F1adir");
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToReservedPane();
				}
			});
		}
		return addButton;
	}
	
	private boolean checkForChildren(int[] ages){
		for(int age: ages){
			if(age>=1 && age<=16){
				return true;
			}
		}
		return false;
	}
	
	private void addToReservedPane(){
		//comprobamos que no existan campos vacios
		if((numPersonsText.getText() != "" && agesTextField.getText() != "") && ((intRadioButton.isSelected() || extRadioButton.isSelected()) && (familiarRadioButton.isSelected() || dobleRadioButton.isSelected()))){
			
			String[] aux = agesTextField.getText().split(",");
			int[] ages = new int[aux.length];
			for(int i=0; i<aux.length; i++){
				ages[i] = Integer.parseInt(aux[i]);
			}
			
//			if(){
//				
//			}
			//comprobamos que el nº de personas coincida con las edades, y permitiremos un excedente de uno para menores de 16
			Component[] comps = extraPane.getComponents();
			int dif = aux.length - Integer.parseInt(numPersonsText.getText());
			if((Integer.parseInt(numPersonsText.getText()) == ages.length) || (dif==1 && checkForChildren(ages))){
				for(int i=0; i<comps.length; i++){
					if(((JCheckBox) comps[i]).getText().equals("Cama supletoria"+"(" + agency.getExtras().get(i).getPriceOfExtra() + "€)")){
						if(dif!=1 && !checkForChildren(ages)){
							if(((JCheckBox) comps[i]).isSelected()){
								JOptionPane.showMessageDialog(null, "Solo puedes añadir una cama supletoria si es para un menor de 16 años");
								((JCheckBox) comps[i]).setSelected(false);
								break;
							}
						}else{
							((JCheckBox) comps[i]).setSelected(true);
						}
					}
				}
				
				if((familiarRadioButton.isSelected() && (Integer.parseInt(numPersonsText.getText())<=4)) || (dobleRadioButton.isSelected() && (Integer.parseInt(numPersonsText.getText())<=2))){
					Component[] listOfExtras = extraPane.getComponents();
					ArrayList<Extra> auxExtras = new ArrayList<Extra>();
					
					//validamos que extras estan checkeados y los metemos a un arraylist
					for(int i=0; i<listOfExtras.length; i++){
						if(((JCheckBox) listOfExtras[i]).isSelected()){
							if(((JCheckBox) listOfExtras[i]).getText().equals(agency.getExtras().get(i).getDenomination()+"("+agency.getExtras().get(i).getPriceOfExtra()+"€)")){
								auxExtras.add(agency.getExtras().get(i));
							}
						}
					}
					
					//añadimos el camarote tanto en GUI como en el modelo 
					Cabin cabin = new Cabin(familiarRadioButton.isSelected(), intRadioButton.isSelected(), Integer.parseInt(numPersonsText.getText()), ages, auxExtras);
					CabinJPane pane = new CabinJPane(cabin, this, cabinCounter);
					listOfReservesPane.add(pane);
					cabins.add(cabin);
					cabinCounter++;
					listOfReservesPane.revalidate();
					listOfReservesPane.repaint();

				}
			}
			
		}
	}

	
	
	
	private void deleteCabin(Cabin cabin){
		for(int i=0; i<cabins.size(); i++){
			if(cabin.equals(cabins.get(i))){
				cabins.remove(i);
			}
		}
	}
	
	private JButton getResetButton() {
		if (resetButton == null) {
			resetButton = new JButton("Reset");
		}
		return resetButton;
	}
	private JScrollPane getScrollReserves() {
		if (scrollReserves == null) {
			scrollReserves = new JScrollPane();
			scrollReserves.setViewportView(getListOfReservesPane());
		}
		return scrollReserves;
	}
	private JScrollPane getScrollDates() {
		if (scrollDates == null) {
			scrollDates = new JScrollPane();
			scrollDates.setViewportView(getDatesPane());
		}
		return scrollDates;
	}
	private JPanel getDatesPane() {
		if (datesPane == null) {
			datesPane = new JPanel();
			datesPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			datesPane.setLayout(new GridLayout(2, 1, 0, 0));
			datesPane.add(getLblNewLabel());
			//JComboBox combo = new JComboBox();
			//combo.setModel(new DefaultComboBoxModel(cruiser.getDepartureDates()));
			datesPane.add(getDateCombo());
		}
		return datesPane;
	}
	
	private JComboBox getDateCombo(){
		JComboBox comboDate = new JComboBox();
		comboDate.setModel(new DefaultComboBoxModel(cruiser.getDepartureDates()));
		return comboDate;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("  Selecciona la fecha del crucero:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblNewLabel;
	}
}

