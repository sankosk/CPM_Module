package gui;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Agency;
import logic.Cruiser;
import logic.SortByDuration;
import logic.SortByOutputPort;
import logic.SortByPriceLessToMore;
import logic.SortByZone;
import logic.Sorter;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import org.jvnet.substance.SubstanceLookAndFeel;






import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.net.URL;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;


public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JPanel northPane;
	private JLabel logoPng;
	private JPanel cruisersPane;
	private JPanel showCruisersPane;
	private JPanel shortbyPane;
	private JMenu mnOpciones;
	private JMenu mnAyuda;
	
	//
	private Agency agency = new Agency();
	private ArrayList<Cruiser> cruiserList;
	private ArrayList<Cruiser> trueResults = new ArrayList<Cruiser>();
	private ArrayList<Cruiser> falseResults= new ArrayList<Cruiser>();
	private ArrayList<Cruiser> auxCruiserList; 
	
	//
	
	private JPanel filterPane;
	private JScrollPane scrollPane;
	private JScrollPane cruiserScroll;
	private JPanel panel;
	private JPanel nElemsPane;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNElementosPor;
	private JTextField nElemText;
	private JLabel lblOrdenarPor;
	private JComboBox comboBox;
	private JButton btnAplicar;
	private JPanel filterLabelPane;
	private JPanel filterLblPanel;
	private JLabel filterLbl;
	private JMenuItem mntmCambiarSkin;
	private JMenuItem mntmNuevaReserva;
	private JMenuItem mntmComprobarReserva;
	private JPanel filterPaneContent;
	private JPanel ageFilter;
	private JRadioButton childsRdbutton;
	private JRadioButton adultsRdbutton;
	private JPanel priceFilter;
	private JPanel panel_1;
	private JTextArea textArea;
	private JPanel onsalePane;
	private JPanel priceInputPane;
	private JLabel lblPrecioMximo;
	private JTextField maxPriceTextField;
	private JSlider maxPriceSlider;
	private JRadioButton onsaleRdb;
	private JRadioButton notOnsaleRdb;
	private JMenuItem mntmContenido;
	private JMenuItem mntmAcercaDe;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					//SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
				} catch (Exception e) {
					e.printStackTrace();
				}
			 
				MainWindow mainWindow = new MainWindow();
				mainWindow.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Tebo's Cruisers: Reserva tu crucero!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 641);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getNorthPane(), BorderLayout.NORTH);
		//contentPane.add(getCruisersPane(), BorderLayout.CENTER);
		//contentPane.add(getFilterPane(), BorderLayout.WEST);
		contentPane.add(getScrollPane(), BorderLayout.WEST);
		contentPane.add(getCruiserScroll(), BorderLayout.CENTER);
		initCruisers();
		cargaAyuda();
		//((JPanel) comps[onsale[0]]).setBorder(new LineBorder(new Color(0, 0, 0)));
		//((JPanel) comps[onsale[1]]).setBorder(new LineBorder(new Color(0, 0, 0)));
		
	}
	private void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		   try {
			    File fichero = new File("help/Ayuda.hs");
			    hsURL = fichero.toURI().toURL();
			    hs = new HelpSet(null, hsURL);
		}

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		     return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();

		   hb.enableHelpKey(getRootPane(),"introduccion", hs);
		   hb.enableHelpOnButton(mntmContenido, "introduccion", hs);
		  // hb.enableHelp(componente, "alias html concreto", hs);
		   
		 }
	
//	private void secondaryFilters(){
//	ArrayList<Cruiser> aux = cruiserList;
//	ArrayList<Cruiser> trueResults = new ArrayList<Cruiser>();
//	ArrayList<Cruiser> falseResults = new ArrayList<Cruiser>();
//	
//	boolean state=false;
//	for(int i=0; i<cruiserList.size(); i++){
//		Cruiser c = cruiserList.get(i);
//		if(c.isAptoMenores()){
//			trueResults.add(c);
//		}else{
//			falseResults.add(c);
//		}
//		
//		if(){
//			
//		}
//	}
//	
//	if(state)
//		loadCruisers(trueResults);
//	else
//		loadCruisers(falseResults);

//}
	
	//He comentado el metodo anterior porque aunque suponga menos iteraciones se hace menos dinámico
	//Separando el código podemos proporcionarle dinamismo al usar un evento de cambio de estado sobre un radiobutton
	private void sortByAge(){
		for(int i=0; i<cruiserList.size(); i++){
			Cruiser c = cruiserList.get(i);
			if(c.isAptoMenores()){
				trueResults.add(c);
			}
			else{
				falseResults.add(c);
			}
		}
		
	}
	
	private void sortBySales(){
		for(int i=0; i<cruiserList.size(); i++){
			Cruiser c = cruiserList.get(i);
			if(c.isOnSale())
				trueResults.add(c);
			else
				falseResults.add(c);
		}
	}

	private void sortByMaxPrice(){
		for(int i=0; i<cruiserList.size(); i++){
			Cruiser c = cruiserList.get(i);
			System.err.println(agency.cheapestCabin(c));
			if(agency.cheapestCabin(c) <= Integer.parseInt(maxPriceTextField.getText()))
				trueResults.add(c);
			else
				falseResults.add(c);
		}
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.WHITE);
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnOpciones());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Reserva");
			mnNewMenu.add(getMntmNuevaReserva());
			mnNewMenu.add(getMntmComprobarReserva());
		}
		return mnNewMenu;
	}
	private JPanel getNorthPane() {
		if (northPane == null) {
			northPane = new JPanel();
			northPane.setToolTipText("Header");
			northPane.setLayout(new BorderLayout(0, 0));
			northPane.add(getLogoPng(), BorderLayout.WEST);
			northPane.add(getPanel_1(), BorderLayout.CENTER);
		}
		return northPane;
	}
	private JLabel getLogoPng() {
		if (logoPng == null) {
			logoPng = new JLabel("");
			logoPng.setBackground(Color.WHITE);
			logoPng.setIcon(new ImageIcon(MainWindow.class.getResource("/img/logo.png")));
		}
		return logoPng;
	}
	private JPanel getCruisersPane() {
		if (cruisersPane == null) {
			cruisersPane = new JPanel();
			cruisersPane.setLayout(new BorderLayout(0, 0));
			cruisersPane.add(getShortbyPane(), BorderLayout.NORTH);
			cruisersPane.add(getShowCruisersPane(), BorderLayout.WEST);
		}
		return cruisersPane;
	}
	private JPanel getShowCruisersPane() {
		if (showCruisersPane == null) {
			showCruisersPane = new JPanel();
			showCruisersPane.setLayout(new GridLayout(0, 6, 0, 0));
		}
		return showCruisersPane;
	}
	private JPanel getShortbyPane() {
		if (shortbyPane == null) {
			shortbyPane = new JPanel();
			shortbyPane.setLayout(new GridLayout(0, 4, 0, 0));
			shortbyPane.add(getPanel());
			shortbyPane.add(getNElemsPane());
			shortbyPane.add(getPanel_2());
			shortbyPane.add(getPanel_3());
		}
		return shortbyPane;
	}
	private JMenu getMnOpciones() {
		if (mnOpciones == null) {
			mnOpciones = new JMenu("Opciones");
			mnOpciones.add(getMntmCambiarSkin());
		}
		return mnOpciones;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.add(getMntmContenido());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	
	private void initCruisers(){
		Component[] comps = showCruisersPane.getComponents();
		int[] onsale = agency.randomItsOnSale();
		cruiserList = agency.getCruisers();
		
		for(int i=0; i<cruiserList.size(); i++){
			if(i==onsale[0] || i==onsale[1]){
				//cruiserList.get(i)
				CruiserJpane cruiserJPane = new CruiserJpane(cruiserList.get(i), agency, true);
				showCruisersPane.add(cruiserJPane);
			}
			else{
				CruiserJpane cruiserJPane = new CruiserJpane(cruiserList.get(i), agency, false);
				showCruisersPane.add(cruiserJPane);
			}
		}	
	}
	
	private void loadCruisers(ArrayList<Cruiser> cruiserList){
		for(int i=0; i<cruiserList.size(); i++){
				CruiserJpane cruiserJPane = new CruiserJpane(cruiserList.get(i), agency, cruiserList.get(i).isOnSale());
				showCruisersPane.add(cruiserJPane);
		}	
	}
	
	private void loadCruisersSortedByZone(){
		//System.err.println(cruiserList.size());
		showCruisersPane.removeAll();
		cruiserList = showSortedByZone();
		//System.err.println(cruiserList.size());
		
		for(int i=0; i<cruiserList.size(); i++){
			CruiserJpane cruiserJPane = new CruiserJpane(cruiserList.get(i), agency, false);
			System.err.println(cruiserList.get(i).getZone());
			showCruisersPane.add(cruiserJPane);
		}
	}
	
	private void loadCruisersSortedByDuration(){
		showCruisersPane.removeAll();
		cruiserList = showSortedByDuration();
		
		for(int i=0; i<cruiserList.size(); i++){
			CruiserJpane cruiserJPane = new CruiserJpane(cruiserList.get(i), agency, false);
			showCruisersPane.add(cruiserJPane);
		}
	}
	
	private void loadCruisersSortedByOutputPort(){
		showCruisersPane.removeAll();
		cruiserList = showSortedByOutputPort();
		
		for(int i=0; i<cruiserList.size(); i++){
			CruiserJpane cruiserJPane = new CruiserJpane(cruiserList.get(i), agency, false);
			showCruisersPane.add(cruiserJPane);
		}
	}
	
	private void loadCruisersSortedByPriceLowToMore(){
		showCruisersPane.removeAll();
		cruiserList = showSortedByPriceLowToMore();
		
		for(int i=0; i<cruiserList.size(); i++){
			CruiserJpane cruiserJPane = new CruiserJpane(cruiserList.get(i), agency, false);
			showCruisersPane.add(cruiserJPane);
		}
			
	}
	
	private void loadCruisersSortedByPriceMoreToLow(){
		showCruisersPane.removeAll();
		cruiserList = showSortedByPriceMoreToLow();
		
		for(int i=0; i<cruiserList.size(); i++){
			CruiserJpane cruiserJPane = new CruiserJpane(cruiserList.get(i), agency, false);
			showCruisersPane.add(cruiserJPane);
		}	
	}
	
	public ArrayList<Cruiser> showSortedByZone(){
		Sorter sorter = new Sorter(new SortByZone(), cruiserList);
		return sorter.sortCruisers();
	}
	
	public ArrayList<Cruiser> showSortedByDuration(){
		Sorter sorter = new Sorter(new SortByDuration(), cruiserList);
		return sorter.sortCruisers();
	}
	
	public ArrayList<Cruiser> showSortedByOutputPort(){
		Sorter sorter = new Sorter(new SortByOutputPort(), cruiserList);
		return sorter.sortCruisers();
	}
	
	public ArrayList<Cruiser> showSortedByPriceLowToMore(){
		Sorter sorter = new Sorter(new SortByPriceLessToMore(), cruiserList);
		return sorter.sortCruisers();
	}
	
	public ArrayList<Cruiser> showSortedByPriceMoreToLow(){
		Sorter sorter = new Sorter(new SortByPriceLessToMore(), cruiserList);
		return sorter.sortCruisers();
	}
	
	private JPanel getFilterPane() {
		if (filterPane == null) {
			filterPane = new JPanel();
			filterPane.setLayout(new GridLayout(0, 1, 0, 0));
			filterPane.add(getFilterLabelPane());
		}
		return filterPane;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getFilterPane());
		}
		return scrollPane;
	}
	private JScrollPane getCruiserScroll() {
		if (cruiserScroll == null) {
			cruiserScroll = new JScrollPane();
			cruiserScroll.setViewportView(getCruisersPane());
		}
		return cruiserScroll;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblNElementosPor());
			panel.add(getNElemText());
			panel.add(getBtnAplicar());
		}
		return panel;
	}
	private JPanel getNElemsPane() {
		if (nElemsPane == null) {
			nElemsPane = new JPanel();
			nElemsPane.add(getLblOrdenarPor());
			nElemsPane.add(getComboBox());
		}
		return nElemsPane;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
		}
		return panel_3;
	}
	private JLabel getLblNElementosPor() {
		if (lblNElementosPor == null) {
			lblNElementosPor = new JLabel("N\u00BA elementos por fila");
			lblNElementosPor.setDisplayedMnemonic('E');
			lblNElementosPor.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblNElementosPor;
	}
	private JTextField getNElemText() {
		if (nElemText == null) {
			nElemText = new JTextField();
			nElemText.setColumns(10);
		}
		return nElemText;
	}
	private JLabel getLblOrdenarPor() {
		if (lblOrdenarPor == null) {
			lblOrdenarPor = new JLabel("Ordenar por:");
			lblOrdenarPor.setDisplayedMnemonic('R');
			lblOrdenarPor.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lblOrdenarPor;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedIndex()==0){
						loadCruisersSortedByZone();
						revalidate();
						repaint();
					}
					if(comboBox.getSelectedIndex()==1){
						loadCruisersSortedByDuration();
						revalidate();
						repaint();
					}
					if(comboBox.getSelectedIndex()==2){
						loadCruisersSortedByOutputPort();
						revalidate();
						repaint();
					}
					if(comboBox.getSelectedIndex()==3){
						loadCruisersSortedByPriceLowToMore();
						revalidate();
						repaint();
					}
					if(comboBox.getSelectedIndex()==4){
						loadCruisersSortedByPriceMoreToLow();
						revalidate();
						repaint();
					}
					if(comboBox.getSelectedIndex()==5){
						showCruisersPane.removeAll();
						initCruisers();
						revalidate();
						repaint();
					}
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Zona", "Duraci\u00F3n", "Puerto de Salida", "Precio (Menos a M\u00E1s)", "Precio (M\u00E1s a Menos)", "Todos"}));
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return comboBox;
	}
	private JButton getBtnAplicar() {
		if (btnAplicar == null) {
			btnAplicar = new JButton("Aplicar");
			btnAplicar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getShowCruisersPane().setLayout(new GridLayout(0, Integer.parseInt(nElemText.getText()), 0, 0));
					JOptionPane.showMessageDialog(null, "Se ha redimensionado correctamente!");
					revalidate();
					repaint();
				}
			});
		}
		return btnAplicar;
	}
	private JPanel getFilterLabelPane() {
		if (filterLabelPane == null) {
			filterLabelPane = new JPanel();
			filterLabelPane.setLayout(new GridLayout(0, 1, 0, 0));
			filterLabelPane.add(getFilterLblPanel());
		}
		return filterLabelPane;
	}
	private JPanel getFilterLblPanel() {
		if (filterLblPanel == null) {
			filterLblPanel = new JPanel();
			filterLblPanel.setLayout(new MigLayout("", "[128px,grow]", "[17px][grow]"));
			filterLblPanel.add(getFilterLbl(), "cell 0 0,alignx left,aligny top");
			filterLblPanel.add(getFilterPaneContent(), "cell 0 1,grow");
		}
		return filterLblPanel;
	}
	private JLabel getFilterLbl() {
		if (filterLbl == null) {
			filterLbl = new JLabel("Filtros Disponibles:");
			filterLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return filterLbl;
	}
	private JMenuItem getMntmCambiarSkin() {
		if (mntmCambiarSkin == null) {
			mntmCambiarSkin = new JMenuItem("Cambiar Skin");
			mntmCambiarSkin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "No esta en funcionamiento por varios problemas a la hora de exportar los .jar de diversos look and feels No-Nativos");
				}
			});
		}
		return mntmCambiarSkin;
	}
	private JMenuItem getMntmNuevaReserva() {
		if (mntmNuevaReserva == null) {
			mntmNuevaReserva = new JMenuItem("Nueva reserva");
			mntmNuevaReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mntmNuevaReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showCruisersPane.removeAll();
					initCruisers();
					revalidate();
					repaint();
				}
			});
		}
		return mntmNuevaReserva;
	}
	private JMenuItem getMntmComprobarReserva() {
		if (mntmComprobarReserva == null) {
			mntmComprobarReserva = new JMenuItem("Comprobar reserva");
			mntmComprobarReserva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
			mntmComprobarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nif = JOptionPane.showInputDialog("Escriba el NIF titular de la reserva: ");
					String[] listDir = new File("reservas/").list();
					boolean flag=false;
					for(int i=0; i<listDir.length; i++){
						if((nif+".dat").equals(listDir[i]))
							flag=true;
					}
					
					if(flag)
						JOptionPane.showMessageDialog(null, ""+nif+".dat"+ " : Existe la reserva");
					else
						JOptionPane.showMessageDialog(null, ""+nif+".dat"+ " : No existe la reserva");
				}
			});
		}
		return mntmComprobarReserva;
	}
	private JPanel getFilterPaneContent() {
		if (filterPaneContent == null) {
			filterPaneContent = new JPanel();
			filterPaneContent.setLayout(new GridLayout(0, 1, 0, 0));
			filterPaneContent.add(getPanel_1_1());
			filterPaneContent.add(getAgeFilter());
			filterPaneContent.add(getOnsalePane());
		}
		return filterPaneContent;
	}
	private JPanel getAgeFilter() {
		if (ageFilter == null) {
			ageFilter = new JPanel();
			ageFilter.setBorder(new LineBorder(new Color(0, 0, 0)));
			ageFilter.setLayout(new GridLayout(0, 1, 0, 0));
			ageFilter.add(getChildsRdbutton());
			ageFilter.add(getAdultsRdbutton());
			ButtonGroup bg = new ButtonGroup();
			bg.add(getChildsRdbutton());
			bg.add(getAdultsRdbutton());
		}
		return ageFilter;
	}
	private JRadioButton getChildsRdbutton() {
		if (childsRdbutton == null) {
			childsRdbutton = new JRadioButton("Apto Menores");
			childsRdbutton.setMnemonic('A');
			childsRdbutton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			childsRdbutton.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					showCruisersPane.removeAll();
					sortByAge();
					loadCruisers(trueResults);
					revalidate();
					repaint();
					falseResults.clear();					
				}
			});
		}
		return childsRdbutton;
	}
	private JRadioButton getAdultsRdbutton() {
		if (adultsRdbutton == null) {
			adultsRdbutton = new JRadioButton("No Apto Menores");
			adultsRdbutton.setMnemonic('N');
			adultsRdbutton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			adultsRdbutton.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					showCruisersPane.removeAll();
					sortByAge();
					loadCruisers(falseResults);
					revalidate();
					repaint();
					trueResults.clear();
				}
			});
		}
		return adultsRdbutton;
	}
	private JPanel getPanel_1_1() {
		if (priceFilter == null) {
			priceFilter = new JPanel();
			priceFilter.setBorder(new LineBorder(new Color(0, 0, 0)));
			priceFilter.setLayout(new BorderLayout(0, 0));
			priceFilter.add(getPriceInputPane(), BorderLayout.NORTH);
			priceFilter.add(getMaxPriceSlider(), BorderLayout.CENTER);
		}
		return priceFilter;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new MigLayout("", "[870px]", "[134px]"));
			panel_1.add(getTextArea(), "cell 0 0,grow");
		}
		return panel_1;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setWrapStyleWord(true);
			textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque dapibus egestas elit eu venenatis. Maecenas non malesuada augue.\r\n\r\nNam tincidunt id ligula lacinia dictum. In non finibus sapien, eu ultrices velit. Donec quis lectus felis. Nunc fringilla maximus justo quis mattis. Praesent non dui pellentesque erat laoreet consequat. Nam feugiat orci diam, eget tincidunt nisl ultrices eget. ");
			textArea.setLineWrap(true);
			textArea.setFont(new Font("Tahoma", Font.BOLD, 14));
			textArea.setEditable(false);
			textArea.setBackground(Color.WHITE);
		}
		return textArea;
	}
	

	private JPanel getOnsalePane() {
		if (onsalePane == null) {
			onsalePane = new JPanel();
			onsalePane.setBorder(new LineBorder(new Color(0, 0, 0)));
			onsalePane.setLayout(new GridLayout(3, 1, 0, 0));
			onsalePane.add(getOnsaleRdb());
			onsalePane.add(getNotOnsaleRdb());
			ButtonGroup bgSale = new ButtonGroup();
			bgSale.add(getOnsaleRdb());
			bgSale.add(getNotOnsaleRdb());

		}
		return onsalePane;
	}
	private JPanel getPriceInputPane() {
		if (priceInputPane == null) {
			priceInputPane = new JPanel();
			priceInputPane.setLayout(new MigLayout("", "[126px]", "[20px][20px]"));
			priceInputPane.add(getLblPrecioMximo(), "cell 0 0,grow");
			priceInputPane.add(getMaxPriceTextField(), "cell 0 1,grow");
		}
		return priceInputPane;
	}
	private JLabel getLblPrecioMximo() {
		if (lblPrecioMximo == null) {
			lblPrecioMximo = new JLabel("Precio M\u00E1ximo:");
			lblPrecioMximo.setDisplayedMnemonic('P');
		}
		return lblPrecioMximo;
	}
	private JTextField getMaxPriceTextField() {
		if (maxPriceTextField == null) {
			maxPriceTextField = new JTextField();
			maxPriceTextField.setColumns(10);
			maxPriceTextField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					maxPriceSlider.setValue(Integer.parseInt(maxPriceTextField.getText()));
					showCruisersPane.removeAll();
					sortByMaxPrice();
					loadCruisers(trueResults);
					revalidate();
					repaint();
					falseResults.clear();
				}
			});
		}
		return maxPriceTextField;
	}
	private JSlider getMaxPriceSlider() {
		if (maxPriceSlider == null) {
			maxPriceSlider = new JSlider();
			maxPriceSlider.setMajorTickSpacing(25);
			maxPriceSlider.setValue(100);
			maxPriceSlider.setPaintTicks(true);
			maxPriceSlider.setPaintLabels(true);
			maxPriceSlider.setMinorTickSpacing(10);
			maxPriceSlider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) 
				{
					maxPriceTextField.setText(String.valueOf(maxPriceSlider.getValue()));
					showCruisersPane.removeAll();
					sortByMaxPrice();
					loadCruisers(trueResults);
					revalidate();
					repaint();
					trueResults.clear();
				}
			});
		}
		return maxPriceSlider;
	}
	private JRadioButton getOnsaleRdb() {
		if (onsaleRdb == null) {
			onsaleRdb = new JRadioButton("En Oferta");
			onsaleRdb.setMnemonic('O');
			onsaleRdb.setFont(new Font("Tahoma", Font.PLAIN, 13));
			onsaleRdb.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					showCruisersPane.removeAll();
					sortBySales();
					loadCruisers(trueResults);
					revalidate();
					repaint();
					trueResults.clear();					
				}
			});
		}
		return onsaleRdb;
	}
	private JRadioButton getNotOnsaleRdb() {
		if (notOnsaleRdb == null) {
			notOnsaleRdb = new JRadioButton("Sin Oferta");
			notOnsaleRdb.setMnemonic('S');
			notOnsaleRdb.setFont(new Font("Tahoma", Font.PLAIN, 13));
			notOnsaleRdb.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					showCruisersPane.removeAll();
					sortBySales();
					loadCruisers(falseResults);
					revalidate();
					repaint();
					trueResults.clear();					
				}
			});
		}
		return notOnsaleRdb;
	}
	private JMenuItem getMntmContenido() {
		if (mntmContenido == null) {
			mntmContenido = new JMenuItem("Contenido");
			mntmContenido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		}
		return mntmContenido;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de");
			mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, InputEvent.CTRL_MASK));
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Esta aplicación ha sido desarrollada por: ESTEBAN MONTES MORALES para eñ módulo de prácticas de CPM");
				}
			});
		}
		return mntmAcercaDe;
	}
}
