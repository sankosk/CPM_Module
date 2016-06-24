package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTextArea;

import logic.Agency;
import logic.Cruiser;
import logic.Ship;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoreInfoWindow extends JDialog {
	private JPanel containerPane;
	private JPanel cruiserPane;
	private JPanel ShipPane;
	private JPanel cruiserPicturePane;
	private JPanel cruiserInfoPane;
	private JLabel pictureLbl;
	private JPanel shipPicturePane;
	private JPanel shipInfoPane;
	private JLabel shipPictureLbl;
	private JPanel descriptionPane;
	private JPanel zonePane;
	private JPanel denominationPane;
	private JPanel outputPortPane;
	private JPanel itineraryPane;
	private JPanel durationPane;
	private JPanel datePane;
	private JPanel adultPane;
	private JLabel zoneLbl;
	private JLabel denominationLbl;
	private JLabel outputPortLbl;
	private JLabel lblItinerario;
	private JLabel durationLbl;
	private JLabel datesLbl;
	private JLabel lblAptoMenores;
	private JLabel descriptionLbl;
	private JPanel textAreaDescription;
	private JPanel shipDescriptionPane;
	private JPanel shipNamePane;
	private JPanel doubleExtRoomNumberPane;
	private JPanel doubleIntRoomNumPane;
	private JPanel familiarExtRoomNumPane;
	private JPanel familiarIntRoomNum;
	private JPanel doubleExtRoomPricePane;
	private JPanel doubleIntRoomPrice;
	private JPanel familiarExtRoomPrice;
	private JPanel familiarIntRoomPrice;
	private JLabel shipNameLbl;
	private JLabel doubleExtRoomNumLbl;
	private JLabel doubleIntRoomNumLbl;
	private JLabel familiarExtRoomNumLbl;
	private JLabel familiarIntRoomNumLbl;
	private JLabel doubleExtRoomPriceLbl;
	private JLabel lblPrecioCamaroteDoble;
	private JLabel lblPrecioCamaroteFamiliar;
	private JLabel lblPrecioCamaroteFamiliar_1;
	///
	private Cruiser cruiser;
	private Ship ship;
	private Agency agency;
	///
	private JPanel headerPane;
	private JPanel cruiserTitlePane;
	private JPanel shipTitlePane;
	private JLabel cruiserNamelbl;
	private JLabel shipNamelbl;
	private JPanel footerPane;
	private JPanel emptyPane;
	private JPanel buttonPane;
	private JButton cancelButton;
	private JButton bookButton;
	private JScrollPane cruiserDescriptionScroll;
	private JTextArea cruiserDescriptionText;
	private JScrollPane shipScroll;
	private JTextArea shipText;
	

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MoreInfoWindow dialog = new MoreInfoWindow();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the dialog.
	 */
	public MoreInfoWindow(Cruiser cruiser, Ship ship, Agency agency) {
		this.cruiser = cruiser;
		this.ship = ship;
		this.agency = agency;
		setTitle("Tebo's cruisers: Informaci\u00F3n detallada del crucero");
		final String cruiserCode = cruiser.getCruiserCode();
		final String shipCode = cruiser.getIdShip();
		
		//Gracias stackoverflow por tu sabidaruia <<addComponentListener>>
		addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentResized(ComponentEvent e) 
			{
				resizeImgLbl(pictureLbl, "/img/" + cruiserCode + ".jpg");
				resizeImgLbl(shipPictureLbl, "/img/" + shipCode + ".jpg");
			}
		});
		
		
		setBounds(100, 100, 894, 583);		
		getContentPane().add(getContainerPane(), BorderLayout.CENTER);
		getContentPane().add(getHeaderPane(), BorderLayout.NORTH);
		getContentPane().add(getFooterPane(), BorderLayout.SOUTH);

	}
	private JPanel getContainerPane() {
		if (containerPane == null) {
			containerPane = new JPanel();
			containerPane.setLayout(new GridLayout(1, 0, 0, 0));
			containerPane.add(getCruiserPane());
			containerPane.add(getShipPane());
		}
		return containerPane;
	}
	private JPanel getCruiserPane() {
		if (cruiserPane == null) {
			cruiserPane = new JPanel();
			cruiserPane.setLayout(new GridLayout(2, 0, 0, 0));
			cruiserPane.add(getCruiserPicturePane());
			cruiserPane.add(getCruiserInfoPane());
		}
		return cruiserPane;
	}
	private JPanel getShipPane() {
		if (ShipPane == null) {
			ShipPane = new JPanel();
			ShipPane.setLayout(new GridLayout(2, 0, 0, 0));
			ShipPane.add(getShipPicturePane());
			ShipPane.add(getShipInfoPane());
		}
		return ShipPane;
	}
	private JPanel getCruiserPicturePane() {
		if (cruiserPicturePane == null) {
			cruiserPicturePane = new JPanel();
			cruiserPicturePane.setBorder(new LineBorder(new Color(0, 0, 0)));
			cruiserPicturePane.setLayout(new GridLayout(1, 0, 0, 0));
			cruiserPicturePane.add(getPictureLbl());
		}
		return cruiserPicturePane;
	}
	private JPanel getCruiserInfoPane() {
		if (cruiserInfoPane == null) {
			cruiserInfoPane = new JPanel();
			cruiserInfoPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			cruiserInfoPane.setLayout(new GridLayout(9, 0, 0, 0));
			cruiserInfoPane.add(getZonePane());
			cruiserInfoPane.add(getDenominationPane());
			cruiserInfoPane.add(getOutputPortPane());
			cruiserInfoPane.add(getItineraryPane());
			cruiserInfoPane.add(getDurationPane());
			cruiserInfoPane.add(getDatePane());
			cruiserInfoPane.add(getAdultPane());
			cruiserInfoPane.add(getDescriptionPane());
			cruiserInfoPane.add(getTextAreaDescription());
		}
		return cruiserInfoPane;
	}
	private JLabel getPictureLbl() {
		if (pictureLbl == null) {
			pictureLbl = new JLabel("");
		}
		return pictureLbl;
	}
	private JPanel getShipPicturePane() {
		if (shipPicturePane == null) {
			shipPicturePane = new JPanel();
			shipPicturePane.setBorder(new LineBorder(new Color(0, 0, 0)));
			shipPicturePane.setLayout(new GridLayout(1, 0, 0, 0));
			shipPicturePane.add(getShipPictureLbl());
		}
		return shipPicturePane;
	}
	private JPanel getShipInfoPane() {
		if (shipInfoPane == null) {
			shipInfoPane = new JPanel();
			shipInfoPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			shipInfoPane.setLayout(new GridLayout(10, 0, 0, 0));
			shipInfoPane.add(getShipNamePane());
			shipInfoPane.add(getDoubleExtRoomNumberPane());
			shipInfoPane.add(getDoubleIntRoomNumPane());
			shipInfoPane.add(getFamiliarExtRoomNumPane());
			shipInfoPane.add(getFamiliarIntRoomNum());
			shipInfoPane.add(getDoubleExtRoomPricePane());
			shipInfoPane.add(getDoubleIntRoomPrice());
			shipInfoPane.add(getFamiliarExtRoomPrice());
			shipInfoPane.add(getFamiliarIntRoomPrice());
			shipInfoPane.add(getShipDescriptionPane());
		}
		return shipInfoPane;
	}
	private JLabel getShipPictureLbl() {
		if (shipPictureLbl == null) {
			shipPictureLbl = new JLabel("");
		}
		return shipPictureLbl;
	}
	private JPanel getDescriptionPane() {
		if (descriptionPane == null) {
			descriptionPane = new JPanel();
			FlowLayout flowLayout = (FlowLayout) descriptionPane.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			descriptionPane.add(getDescriptionLbl());
		}
		return descriptionPane;
	}
	private JPanel getZonePane() {
		if (zonePane == null) {
			zonePane = new JPanel();
			zonePane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			zonePane.add(getZoneLbl());
		}
		return zonePane;
	}
	private JPanel getDenominationPane() {
		if (denominationPane == null) {
			denominationPane = new JPanel();
			FlowLayout flowLayout = (FlowLayout) denominationPane.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			denominationPane.add(getDenominationLbl());
		}
		return denominationPane;
	}
	private JPanel getOutputPortPane() {
		if (outputPortPane == null) {
			outputPortPane = new JPanel();
			FlowLayout flowLayout = (FlowLayout) outputPortPane.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			outputPortPane.add(getOutputPortLbl());
		}
		return outputPortPane;
	}
	private JPanel getItineraryPane() {
		if (itineraryPane == null) {
			itineraryPane = new JPanel();
			FlowLayout flowLayout = (FlowLayout) itineraryPane.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			itineraryPane.add(getLblItinerario());
		}
		return itineraryPane;
	}
	private JPanel getDurationPane() {
		if (durationPane == null) {
			durationPane = new JPanel();
			FlowLayout fl_durationPane = (FlowLayout) durationPane.getLayout();
			fl_durationPane.setAlignment(FlowLayout.LEFT);
			durationPane.add(getDurationLbl());
		}
		return durationPane;
	}
	private JPanel getDatePane() {
		if (datePane == null) {
			datePane = new JPanel();
			FlowLayout fl_datePane = (FlowLayout) datePane.getLayout();
			fl_datePane.setAlignment(FlowLayout.LEFT);
			datePane.add(getDatesLbl());
		}
		return datePane;
	}
	private JPanel getAdultPane() {
		if (adultPane == null) {
			adultPane = new JPanel();
			FlowLayout fl_adultPane = (FlowLayout) adultPane.getLayout();
			fl_adultPane.setAlignment(FlowLayout.LEFT);
			adultPane.add(getLblAptoMenores());
		}
		return adultPane;
	}
	private JLabel getZoneLbl() {
		if (zoneLbl == null) {
			zoneLbl = new JLabel("Zone:" + cruiser.getZone());
			zoneLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return zoneLbl;
	}
	private JLabel getDenominationLbl() {
		if (denominationLbl == null) {
			denominationLbl = new JLabel("Denominaci\u00F3n:" + cruiser.getDenomination());
			denominationLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return denominationLbl;
	}
	private JLabel getOutputPortLbl() {
		if (outputPortLbl == null) {
			outputPortLbl = new JLabel("Puerto de Salida:" + cruiser.getOutputPort());
			outputPortLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return outputPortLbl;
	}
	private JLabel getLblItinerario() {
		if (lblItinerario == null) {
			String itinerary = "";
			String it[] = cruiser.getItinerary();
			
			for(int i=0; i<cruiser.getItinerary().length; i++){
				if(i==cruiser.getItinerary().length-1)
					itinerary += it[i];
				else
					itinerary += it[i] + ", ";
			}
			lblItinerario = new JLabel("Itinerario:" + itinerary);
			lblItinerario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblItinerario;
	}
	private JLabel getDurationLbl() {
		if (durationLbl == null) {
			durationLbl = new JLabel("Duraci\u00F3n:" + cruiser.getDuration() + " dias");
			durationLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return durationLbl;
	}
	private JLabel getDatesLbl() {
		if (datesLbl == null) {
			String[] dates = cruiser.getDepartureDates();
			String finalDates = "";
			for(int i=0; i<dates.length; i++){
				if(i == dates.length-1)
					finalDates += dates[i];
				else
					finalDates += dates[i] + ", ";
			}
			datesLbl = new JLabel("Fechas de Salida:" + finalDates);
			datesLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return datesLbl;
	}
	private JLabel getLblAptoMenores() {
		if (lblAptoMenores == null) {
			lblAptoMenores = new JLabel("Apto Menores:" + cruiser.getAptoMenores());
			lblAptoMenores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblAptoMenores;
	}
	private JLabel getDescriptionLbl() {
		if (descriptionLbl == null) {
			descriptionLbl = new JLabel("Descripci\u00F3n:");
			descriptionLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return descriptionLbl;
	}
	private JPanel getTextAreaDescription() {
		if (textAreaDescription == null) {
			textAreaDescription = new JPanel();
			textAreaDescription.setLayout(new GridLayout(0, 1, 0, 0));
			textAreaDescription.add(getCruiserDescriptionScroll());
		}
		return textAreaDescription;
	}

	private JPanel getShipDescriptionPane() {
		if (shipDescriptionPane == null) {
			shipDescriptionPane = new JPanel();
			shipDescriptionPane.setLayout(new GridLayout(0, 1, 0, 0));
			shipDescriptionPane.add(getShipScroll());
			//shipDescriptionPane.add(getShipText());
		}
		return shipDescriptionPane;
	}
	private JPanel getShipNamePane() {
		if (shipNamePane == null) {
			shipNamePane = new JPanel();
			shipNamePane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			shipNamePane.add(getShipNameLbl());
		}
		return shipNamePane;
	}
	private JPanel getDoubleExtRoomNumberPane() {
		if (doubleExtRoomNumberPane == null) {
			doubleExtRoomNumberPane = new JPanel();
			FlowLayout fl_doubleExtRoomNumberPane = (FlowLayout) doubleExtRoomNumberPane.getLayout();
			fl_doubleExtRoomNumberPane.setAlignment(FlowLayout.LEFT);
			doubleExtRoomNumberPane.add(getDoubleExtRoomNumLbl());
		}
		return doubleExtRoomNumberPane;
	}
	private JPanel getDoubleIntRoomNumPane() {
		if (doubleIntRoomNumPane == null) {
			doubleIntRoomNumPane = new JPanel();
			FlowLayout flowLayout = (FlowLayout) doubleIntRoomNumPane.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			doubleIntRoomNumPane.add(getDoubleIntRoomNumLbl());
		}
		return doubleIntRoomNumPane;
	}
	private JPanel getFamiliarExtRoomNumPane() {
		if (familiarExtRoomNumPane == null) {
			familiarExtRoomNumPane = new JPanel();
			FlowLayout flowLayout = (FlowLayout) familiarExtRoomNumPane.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			familiarExtRoomNumPane.add(getFamiliarExtRoomNumLbl());
		}
		return familiarExtRoomNumPane;
	}
	private JPanel getFamiliarIntRoomNum() {
		if (familiarIntRoomNum == null) {
			familiarIntRoomNum = new JPanel();
			FlowLayout flowLayout = (FlowLayout) familiarIntRoomNum.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			familiarIntRoomNum.add(getFamiliarIntRoomNumLbl());
		}
		return familiarIntRoomNum;
	}
	private JPanel getDoubleExtRoomPricePane() {
		if (doubleExtRoomPricePane == null) {
			doubleExtRoomPricePane = new JPanel();
			FlowLayout flowLayout = (FlowLayout) doubleExtRoomPricePane.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			doubleExtRoomPricePane.add(getDoubleExtRoomPriceLbl());
		}
		return doubleExtRoomPricePane;
	}
	private JPanel getDoubleIntRoomPrice() {
		if (doubleIntRoomPrice == null) {
			doubleIntRoomPrice = new JPanel();
			FlowLayout flowLayout = (FlowLayout) doubleIntRoomPrice.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			doubleIntRoomPrice.add(getLblPrecioCamaroteDoble());
		}
		return doubleIntRoomPrice;
	}
	private JPanel getFamiliarExtRoomPrice() {
		if (familiarExtRoomPrice == null) {
			familiarExtRoomPrice = new JPanel();
			FlowLayout flowLayout = (FlowLayout) familiarExtRoomPrice.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			familiarExtRoomPrice.add(getLblPrecioCamaroteFamiliar());
		}
		return familiarExtRoomPrice;
	}
	private JPanel getFamiliarIntRoomPrice() {
		if (familiarIntRoomPrice == null) {
			familiarIntRoomPrice = new JPanel();
			FlowLayout flowLayout = (FlowLayout) familiarIntRoomPrice.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			familiarIntRoomPrice.add(getLblPrecioCamaroteFamiliar_1());
		}
		return familiarIntRoomPrice;
	}
	private JLabel getShipNameLbl() {
		if (shipNameLbl == null) {
			shipNameLbl = new JLabel("Nombre del barco:" + ship.getDenomination());
			shipNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return shipNameLbl;
	}
	private JLabel getDoubleExtRoomNumLbl() {
		if (doubleExtRoomNumLbl == null) {
			doubleExtRoomNumLbl = new JLabel("N\u00BA camarotes dobles exteriores:" + ship.getNumOfExternDoubleCabin());
			doubleExtRoomNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return doubleExtRoomNumLbl;
	}
	private JLabel getDoubleIntRoomNumLbl() {
		if (doubleIntRoomNumLbl == null) {
			doubleIntRoomNumLbl = new JLabel("N\u00BA camarotes dobles interiores:" + ship.getNumOfInternDoubleCabin());
			doubleIntRoomNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return doubleIntRoomNumLbl;
	}
	private JLabel getFamiliarExtRoomNumLbl() {
		if (familiarExtRoomNumLbl == null) {
			familiarExtRoomNumLbl = new JLabel("N\u00BA camarotes familiares exteriores:" + ship.getNumOfExternFamiliarCabin());
			familiarExtRoomNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return familiarExtRoomNumLbl;
	}
	private JLabel getFamiliarIntRoomNumLbl() {
		if (familiarIntRoomNumLbl == null) {
			familiarIntRoomNumLbl = new JLabel("N\u00BA camarotes familiares interiores:" + ship.getNumOfInternFamiliarCabin());
			familiarIntRoomNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return familiarIntRoomNumLbl;
	}
	private JLabel getDoubleExtRoomPriceLbl() {
		if (doubleExtRoomPriceLbl == null) {
			doubleExtRoomPriceLbl = new JLabel("Precio camarote doble interior:" + ship.getPriceOfInternDoubleCabin());
			doubleExtRoomPriceLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return doubleExtRoomPriceLbl;
	}
	private JLabel getLblPrecioCamaroteDoble() {
		if (lblPrecioCamaroteDoble == null) {
			lblPrecioCamaroteDoble = new JLabel("Precio camarote doble exterior:" + ship.getPriceOfExternDoubleCabin());
			lblPrecioCamaroteDoble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPrecioCamaroteDoble;
	}
	private JLabel getLblPrecioCamaroteFamiliar() {
		if (lblPrecioCamaroteFamiliar == null) {
			lblPrecioCamaroteFamiliar = new JLabel("Precio camarote familiar interior:" + ship.getPriceOfInternFamiliarCabin());
			lblPrecioCamaroteFamiliar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPrecioCamaroteFamiliar;
	}
	private JLabel getLblPrecioCamaroteFamiliar_1() {
		if (lblPrecioCamaroteFamiliar_1 == null) {
			lblPrecioCamaroteFamiliar_1 = new JLabel("Precio camarote familiar exterior:" + ship.getPriceOfExternFamiliarCabin());
			lblPrecioCamaroteFamiliar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPrecioCamaroteFamiliar_1;
	}

	
	private void resizeImgLbl(JLabel lbl, String imgPath){
		Image orgImg = new ImageIcon(getClass().getResource(imgPath)).getImage();
		Image resizedImg = orgImg.getScaledInstance((int) lbl.getWidth(), (int) lbl.getHeight(), Image.SCALE_FAST);
		lbl.setIcon(new ImageIcon(resizedImg));
	}
	private JPanel getHeaderPane() {
		if (headerPane == null) {
			headerPane = new JPanel();
			headerPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			headerPane.setLayout(new GridLayout(0, 2, 0, 0));
			headerPane.add(getCruiserTitlePane());
			headerPane.add(getShipTitlePane());
		}
		return headerPane;
	}
	private JPanel getCruiserTitlePane() {
		if (cruiserTitlePane == null) {
			cruiserTitlePane = new JPanel();
			cruiserTitlePane.setBorder(new LineBorder(new Color(0, 0, 0)));
			cruiserTitlePane.add(getCruiserNamelbl());
		}
		return cruiserTitlePane;
	}
	private JPanel getShipTitlePane() {
		if (shipTitlePane == null) {
			shipTitlePane = new JPanel();
			shipTitlePane.setBorder(new LineBorder(new Color(0, 0, 0)));
			shipTitlePane.add(getShipNamelbl());
		}
		return shipTitlePane;
	}
	private JLabel getCruiserNamelbl() {
		if (cruiserNamelbl == null) {
			cruiserNamelbl = new JLabel("Denominaci\u00F3n:" + cruiser.getDenomination());
			cruiserNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return cruiserNamelbl;
	}
	private JLabel getShipNamelbl() {
		if (shipNamelbl == null) {
			shipNamelbl = new JLabel("Nombre del barco:" + ship.getDenomination());
			shipNamelbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return shipNamelbl;
	}
	private JPanel getFooterPane() {
		if (footerPane == null) {
			footerPane = new JPanel();
			footerPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			footerPane.setLayout(new GridLayout(0, 2, 0, 0));
			footerPane.add(getEmptyPane());
			footerPane.add(getButtonPane());
		}
		return footerPane;
	}
	private JPanel getEmptyPane() {
		if (emptyPane == null) {
			emptyPane = new JPanel();
			emptyPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return emptyPane;
	}
	private JPanel getButtonPane() {
		if (buttonPane == null) {
			buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			buttonPane.add(getCancelButton());
			buttonPane.add(getBookButton());
		}
		return buttonPane;
	}
	private JButton getCancelButton() {
		if (cancelButton == null) {
			cancelButton = new JButton("Cancelar");
		}
		return cancelButton;
	}
	private JButton getBookButton() {
		if (bookButton == null) {
			bookButton = new JButton("Reservar ahora");
			bookButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showBookRoomWindow();
				}
			});
		}
		return bookButton;
	}
	
	private void showBookRoomWindow(){
		BookRoomWindow bW = new BookRoomWindow(agency, cruiser, ship);
		bW.setLocationRelativeTo(this);
		bW.setModal(true);
		bW.setVisible(true);
		dispose();
	}
	
	private JScrollPane getCruiserDescriptionScroll() {
		if (cruiserDescriptionScroll == null) {
			cruiserDescriptionScroll = new JScrollPane();
			cruiserDescriptionScroll.setViewportView(getCruiserDescriptionText());
		}
		return cruiserDescriptionScroll;
	}
	private JTextArea getCruiserDescriptionText() {
		if (cruiserDescriptionText == null) {
			cruiserDescriptionText = new JTextArea();
			cruiserDescriptionText.setText(cruiser.getDescription());
		}
		return cruiserDescriptionText;
	}
	private JScrollPane getShipScroll() {
		if (shipScroll == null) {
			shipScroll = new JScrollPane();
			shipScroll.setViewportView(getShipText());
		}
		return shipScroll;
	}
	private JTextArea getShipText() {
		if (shipText == null) {
			shipText = new JTextArea();
			shipText.setText(ship.getDescription());
		}
		return shipText;
	}
}