package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import logic.Agency;
import logic.Cruiser;
import logic.Ship;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class CruiserJpane extends JPanel {
	private JLabel cruiserPictLbl;
	private JPanel detailsPane;
	private JPanel zonePane;
	private JLabel zoneLbl;
	private JPanel outportPane;
	private JLabel outportLbl;
	private JPanel roomPricePane;
	private JLabel roomPriceLbl;
	private JPanel footerPane;
	private JButton moreInfoButton;
	private JButton bookButton;

	
	//details info declarations
	private String imgPath;
	private String zone;
	private String outputPort;
	private double price;
	private Cruiser cruiser;
	private Agency agency;
	private Ship ship;

	
	

	/**
	 * Create the panel.
	 */
	public CruiserJpane(Cruiser cruiser, Agency agency, boolean onsale) {
		this.cruiser = cruiser;
		this.agency = agency;
		this.ship = agency.searchShip(cruiser.getIdShip());
		if(onsale){
			imgPath = "/img/" + this.cruiser.getCruiserCode() + "_OFERTA.jpg";
			if(!cruiser.isOnSale())
				cruiser.putOnSale();
		}else{
			imgPath = "/img/" + this.cruiser.getCruiserCode() + ".jpg";
		}
			
		zone = this.cruiser.getDenomination();
		outputPort = this.cruiser.getOutputPort();
		price = 00.00; 
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new GridLayout(2, 1, 2, 2));
		add(getCruiserPictLbl());
		add(getDetailsPane());

	}
	
	private JLabel getCruiserPictLbl() {
		if (cruiserPictLbl == null) {
			cruiserPictLbl = new JLabel("");
			ImageIcon icon = new ImageIcon(MainWindow.class.getResource(imgPath));
			Image img = icon.getImage();
			Image redimImg = img.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
			ImageIcon redimIcon = new ImageIcon(redimImg);
			
			cruiserPictLbl.setIcon(redimIcon);
			cruiserPictLbl.setHorizontalAlignment(JLabel.CENTER);
			cruiserPictLbl.setVerticalAlignment(JLabel.CENTER);
		}
		return cruiserPictLbl;
	}
	private JPanel getDetailsPane() {
		if (detailsPane == null) {
			detailsPane = new JPanel();
			detailsPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			detailsPane.setLayout(new GridLayout(4, 1, 2, 2));
			detailsPane.add(getZonePane());
			detailsPane.add(getOutportPane());
			detailsPane.add(getRoomPricePane());
			detailsPane.add(getFooterPane());
		}
		return detailsPane;
	}
	private JPanel getZonePane() {
		if (zonePane == null) {
			zonePane = new JPanel();
			zonePane.add(getZoneLbl());
		}
		return zonePane;
	}
	private JLabel getZoneLbl() {
		if (zoneLbl == null) {
			zoneLbl = new JLabel("Zona: " + zone);
			zoneLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return zoneLbl;
	}
	private JPanel getOutportPane() {
		if (outportPane == null) {
			outportPane = new JPanel();
			outportPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
			outportPane.add(getOutportLbl());
		}
		return outportPane;
	}
	private JLabel getOutportLbl() {
		if (outportLbl == null) {
			outportLbl = new JLabel("Puerto de salida:" + outputPort);
			outportLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return outportLbl;
	}
	private JPanel getRoomPricePane() {
		if (roomPricePane == null) {
			roomPricePane = new JPanel();
			roomPricePane.add(getRoomPriceLbl());
		}
		return roomPricePane;
	}
	private JLabel getRoomPriceLbl() {
		if (roomPriceLbl == null) {
			roomPriceLbl = new JLabel("Camarotes desde:" + agency.cheapestCabin(cruiser));
			roomPriceLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return roomPriceLbl;
	}
	private JPanel getFooterPane() {
		if (footerPane == null) {
			footerPane = new JPanel();
			footerPane.add(getMoreInfoButton());
			footerPane.add(getBookButton());
		}
		return footerPane;
	}
	private JButton getMoreInfoButton() {
		if (moreInfoButton == null) {
			moreInfoButton = new JButton("Saber m\u00E1s");
			moreInfoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					showMoreInfoWindow();
				}
			});
		}
		return moreInfoButton;
	}
	
	private void showMoreInfoWindow(){
		MoreInfoWindow moreInfoWindow = new MoreInfoWindow(cruiser, ship, agency);
		moreInfoWindow.setLocationRelativeTo(this);
		moreInfoWindow.setModal(true);
		moreInfoWindow.setVisible(true);
	}
	
	private JButton getBookButton() {
		if (bookButton == null) {
			bookButton = new JButton("Reservar de inmediato");
			bookButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
	}
}
