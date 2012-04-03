package main;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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

	DrawingCanvas k = new DrawingCanvas( );
	JFrame mainFrame;
	private JTextField textField;
	JCheckBox chckbxBathrooms;
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
		
		btnSecondFloor = new JButton( "View Second Floor" );
		btnSecondFloor.addActionListener( this );
		btnSecondFloor.setHorizontalAlignment(SwingConstants.CENTER);
		btnSecondFloor.setBounds( 470, 110, 150, 40 );
		

		panel_1.add( btnSecondFloor );
		panel_1.add( k );
		k.repaint();
	}
	
	public void itemStateChanged( ItemEvent e ) {
		if( e.getSource() == chckbxBathrooms ) {
			if( chckbxBathrooms.isSelected() ) {				
				k.repaint();
			}
			else {	
				k.repaint();
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
			//set img in drawcanvas to second floor
		}
		else if( e.getSource() == btnSearch ) {
			if( textField.getText().equals( "1115" ) ) {
				k.repaint();
			}
			else {
				JOptionPane.showMessageDialog( mainFrame, "Room not found!" );
			}
		}
	}
	
	public JFrame getFrame( ){
		return mainFrame;
	}
	
	
	class DrawingCanvas extends Canvas {
		BufferedImage img;
		
	    public DrawingCanvas() {
	      
	      try {
			img = ImageIO.read(BuildingMapFrame.class.getResource("/images/firstFloor.jpg"));
			setSize( img.getWidth(), img.getHeight() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }

	    public void paint(Graphics g) {
	      Graphics2D g2D = (Graphics2D) g;
	      
	      g2D.drawImage( img, 0, 0, null );
	      
	      BasicStroke stroke = new BasicStroke(4f);
	      g2D.setStroke(stroke);
	      
	      if( chckbxBathrooms.isSelected() ) {
	    	  g2D.setColor( Color.blue );
	    	  g2D.draw( new Ellipse2D.Float(180f, 190f, 20f, 20f));
	    	  g2D.fill( new Ellipse2D.Float(180f, 190f, 20f, 20f) );
	    	  g2D.draw( new Ellipse2D.Float(170f, 130f, 20f, 20f));
	    	  g2D.fill( new Ellipse2D.Float(170f, 130f, 20f, 20f) );
	      }
	      
	      switch( Integer.valueOf( textField.getText() ) ) {
	      case 1115:
		      g2D.setColor( Color.red );
	    	  g2D.drawLine( 240, 390, 240, 290 );
	    	  g2D.drawLine( 240, 290, 500, 290 );
	    	  break;
	      }
	      
	    }
	  }
}
