package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BuildingMapFrame implements ItemListener, ActionListener {

	JFrame mainFrame;
	private JTextField textField;
	JCheckBox chckbxBathrooms;
	JLabel label_1, label_2, label_3, label_4, label_5;
	JLayeredPane panel_1;
	JButton btnBack, btnSearch, btnSecondFloor;
	
	public BuildingMapFrame( ) {
		mainFrame = new JFrame( );
		mainFrame.setUndecorated( true );	
		mainFrame.setSize( 701, 745 );
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		mainFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 33, 60, 78, 60, 60, 60, 43, 0, 45, 45, 45, 45, 45, 0, 60, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblRoom = new JLabel("Room:");
		GridBagConstraints gbc_lblRoom = new GridBagConstraints();
		gbc_lblRoom.insets = new Insets(0, 0, 5, 0);
		gbc_lblRoom.gridx = 0;
		gbc_lblRoom.gridy = 0;
		panel.add(lblRoom, gbc_lblRoom);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Find Room");
		btnSearch.addActionListener( this );
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
		gbc_btnSearch.gridx = 0;
		gbc_btnSearch.gridy = 2;
		panel.add(btnSearch, gbc_btnSearch);
		
		JLabel lblSearchFor = new JLabel("Directions To:");
		GridBagConstraints gbc_lblSearchFor = new GridBagConstraints();
		gbc_lblSearchFor.anchor = GridBagConstraints.SOUTH;
		gbc_lblSearchFor.insets = new Insets(0, 0, 5, 0);
		gbc_lblSearchFor.gridx = 0;
		gbc_lblSearchFor.gridy = 3;
		panel.add(lblSearchFor, gbc_lblSearchFor);
		
		JButton btnFindBathrooms = new JButton("Bathrooms");
		GridBagConstraints gbc_btnFindBathrooms = new GridBagConstraints();
		gbc_btnFindBathrooms.fill = GridBagConstraints.BOTH;
		gbc_btnFindBathrooms.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindBathrooms.gridx = 0;
		gbc_btnFindBathrooms.gridy = 4;
		panel.add(btnFindBathrooms, gbc_btnFindBathrooms);
		
		JButton btnFindComputerLabs = new JButton("Computer Labs");
		GridBagConstraints gbc_btnFindComputerLabs = new GridBagConstraints();
		gbc_btnFindComputerLabs.fill = GridBagConstraints.BOTH;
		gbc_btnFindComputerLabs.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindComputerLabs.gridx = 0;
		gbc_btnFindComputerLabs.gridy = 5;
		panel.add(btnFindComputerLabs, gbc_btnFindComputerLabs);
		
		JButton btnFindVendingMachines = new JButton("Vending Machines");
		GridBagConstraints gbc_btnFindVendingMachines = new GridBagConstraints();
		gbc_btnFindVendingMachines.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindVendingMachines.fill = GridBagConstraints.BOTH;
		gbc_btnFindVendingMachines.gridx = 0;
		gbc_btnFindVendingMachines.gridy = 6;
		panel.add(btnFindVendingMachines, gbc_btnFindVendingMachines);
		
		JLabel lblHighlight = new JLabel("Highlight:");
		GridBagConstraints gbc_lblHighlight = new GridBagConstraints();
		gbc_lblHighlight.insets = new Insets(0, 0, 5, 0);
		gbc_lblHighlight.gridx = 0;
		gbc_lblHighlight.gridy = 8;
		panel.add(lblHighlight, gbc_lblHighlight);
		
		chckbxBathrooms = new JCheckBox("Bathrooms");
		GridBagConstraints gbc_chckbxBathrooms = new GridBagConstraints();
		gbc_chckbxBathrooms.fill = GridBagConstraints.BOTH;
		gbc_chckbxBathrooms.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxBathrooms.gridx = 0;
		gbc_chckbxBathrooms.gridy = 9;
		chckbxBathrooms.addItemListener( this );
		panel.add(chckbxBathrooms, gbc_chckbxBathrooms);
		
		JCheckBox chckbxComputerLabs = new JCheckBox("Computer Labs");
		GridBagConstraints gbc_chckbxComputerLabs = new GridBagConstraints();
		gbc_chckbxComputerLabs.fill = GridBagConstraints.BOTH;
		gbc_chckbxComputerLabs.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxComputerLabs.gridx = 0;
		gbc_chckbxComputerLabs.gridy = 10;
		panel.add(chckbxComputerLabs, gbc_chckbxComputerLabs);
		
		JCheckBox chckbxPrinters = new JCheckBox("Printers");
		GridBagConstraints gbc_chckbxPrinters = new GridBagConstraints();
		gbc_chckbxPrinters.fill = GridBagConstraints.BOTH;
		gbc_chckbxPrinters.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxPrinters.gridx = 0;
		gbc_chckbxPrinters.gridy = 11;
		panel.add(chckbxPrinters, gbc_chckbxPrinters);
		
		JCheckBox chckbxVendingMachines = new JCheckBox("Vending Machines");
		GridBagConstraints gbc_chckbxVendingMachines = new GridBagConstraints();
		gbc_chckbxVendingMachines.fill = GridBagConstraints.BOTH;
		gbc_chckbxVendingMachines.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxVendingMachines.gridx = 0;
		gbc_chckbxVendingMachines.gridy = 12;
		panel.add(chckbxVendingMachines, gbc_chckbxVendingMachines);
		
		JCheckBox chckbxWaterFountains = new JCheckBox("Water Fountains");
		GridBagConstraints gbc_chckbxWaterFountains = new GridBagConstraints();
		gbc_chckbxWaterFountains.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxWaterFountains.fill = GridBagConstraints.BOTH;
		gbc_chckbxWaterFountains.gridx = 0;
		gbc_chckbxWaterFountains.gridy = 13;
		panel.add(chckbxWaterFountains, gbc_chckbxWaterFountains);
		
		JLabel label = new JLabel("                                                                             ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 14;
		panel.add(label, gbc_label);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener( this );
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.SOUTH;
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 15;
		panel.add(btnBack, gbc_btnBack);
		
		panel_1 = new JLayeredPane();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(BuildingMapFrame.class.getResource("/images/firstFloor.jpg")));
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(BuildingMapFrame.class.getResource("/images/location.jpg" )));
		label_2.setVisible( false );
		label_2.setBounds( 0, 0, 50, 50 );
		
		label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon(BuildingMapFrame.class.getResource("/images/location.jpg")));
		label_3.setVisible( false );
		label_3.setBounds( 0, 0, 50, 50 );
		
		label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setIcon(new ImageIcon(BuildingMapFrame.class.getResource("/images/lineup.jpg")));
		label_4.setVisible( false );
		label_4.setBounds( 0, 0, 5, 50 );
		
		label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setIcon(new ImageIcon(BuildingMapFrame.class.getResource("/images/lineright.jpg")));
		label_5.setVisible( false );
		label_5.setBounds( 0, 0, 50, 5 );
		
		btnSecondFloor = new JButton( "View Second Floor" );
		btnSecondFloor.addActionListener( this );
		btnSecondFloor.setHorizontalAlignment(SwingConstants.CENTER);
		btnSecondFloor.setBounds( 470, 110, 150, 40 );
		
		panel_1.add( btnSecondFloor );
		panel_1.add( label_5 );
		panel_1.add( label_4 );
		panel_1.add( label_3 );
		panel_1.add( label_2 );
		panel_1.add(label_1);
	}
	
	public void itemStateChanged( ItemEvent e ) {
		if( e.getSource() == chckbxBathrooms ) {
			if( chckbxBathrooms.isSelected() ) {
				Point label1start = panel_1.getLocationOnScreen();
				//this is static
				//the window will be resized
				//DON'T use absolute values
				//seriously
				label_2.setBounds( (int)label1start.getX() + 140, (int)label1start.getY() + 250, 50, 50 );
				label_2.setVisible( true );
				
				label_3.setBounds( (int)label1start.getX() + 125, (int)label1start.getY() + 180, 50, 50 );
				label_3.setVisible( true );
			}
			else {
				label_2.setVisible( false );
				label_3.setVisible( false );
			}
		}
	}
	
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnBack ) {
			mainFrame.setVisible( false );
			TerpInfo.instance.getMainFrame().setVisible( true );
			TerpInfo.instance.getMainFrame().requestFocus();
		}
		else if( e.getSource() == btnSecondFloor ) {
			label_1.setIcon(new ImageIcon(BuildingMapFrame.class.getResource("/images/secondFloor.jpg")));
		}
		else if( e.getSource() == btnSearch ) {
			if( textField.getText().equals( "1115" ) ) {
				Point label1start = panel_1.getLocationOnScreen();
				
				label_4.setBounds( (int)label1start.getX() + 205, (int)label1start.getY() + 350, 5, 110 );
				label_5.setBounds( (int)label1start.getX() + 205, (int)label1start.getY() + 350, 250, 5 );
				
				label_4.setVisible( true );
				label_5.setVisible( true );
			}
			else {
				JOptionPane.showMessageDialog( mainFrame, "Room not found!" );
			}
		}
	}
	
	public JFrame getFrame( ){
		return mainFrame;
	}
	
}
