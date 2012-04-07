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
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class BuildingMapFrame implements ItemListener, ActionListener {

	DrawingCanvas k = new DrawingCanvas( );
	JFrame mainFrame;
	private JTextField textField;
	JCheckBox chckbxBathrooms;
	JLayeredPane panel_1;
	JButton btnBack, btnSearch, btnNextFloor, btnPrevFloor;
	int curFloor = 1;
	
	public BuildingMapFrame( ) {
		mainFrame = new JFrame( );
		mainFrame.setUndecorated( true );	
		mainFrame.setSize( 1024, 768 );
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		mainFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 153));
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 40, 38, 60, 52, 45, 0, 60, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 102, 153));
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Room", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(192, 192, 192)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{40, 60, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		
		btnSearch = new JButton("Find Room");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.gridx = 0;
		gbc_btnSearch.gridy = 1;
		panel_4.add(btnSearch, gbc_btnSearch);
		btnSearch.addActionListener( this );
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 153));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Directions To", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{60, 60, 60, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnFindBathrooms = new JButton("Bathrooms");
		GridBagConstraints gbc_btnFindBathrooms = new GridBagConstraints();
		gbc_btnFindBathrooms.fill = GridBagConstraints.BOTH;
		gbc_btnFindBathrooms.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindBathrooms.gridx = 0;
		gbc_btnFindBathrooms.gridy = 0;
		panel_3.add(btnFindBathrooms, gbc_btnFindBathrooms);
		
		JButton btnFindComputerLabs = new JButton("Computer Labs");
		GridBagConstraints gbc_btnFindComputerLabs = new GridBagConstraints();
		gbc_btnFindComputerLabs.fill = GridBagConstraints.BOTH;
		gbc_btnFindComputerLabs.insets = new Insets(0, 0, 5, 0);
		gbc_btnFindComputerLabs.gridx = 0;
		gbc_btnFindComputerLabs.gridy = 1;
		panel_3.add(btnFindComputerLabs, gbc_btnFindComputerLabs);
		
		JButton btnFindVendingMachines = new JButton("Vending Machines");
		GridBagConstraints gbc_btnFindVendingMachines = new GridBagConstraints();
		gbc_btnFindVendingMachines.fill = GridBagConstraints.BOTH;
		gbc_btnFindVendingMachines.gridx = 0;
		gbc_btnFindVendingMachines.gridy = 2;
		panel_3.add(btnFindVendingMachines, gbc_btnFindVendingMachines);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 153));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Highlight", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 5;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{45, 45, 45, 45, 45, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		chckbxBathrooms = new JCheckBox("Bathrooms");
		chckbxBathrooms.setForeground(Color.LIGHT_GRAY);
		chckbxBathrooms.setBackground(Color.BLUE);
		GridBagConstraints gbc_chckbxBathrooms = new GridBagConstraints();
		gbc_chckbxBathrooms.fill = GridBagConstraints.BOTH;
		gbc_chckbxBathrooms.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxBathrooms.gridx = 0;
		gbc_chckbxBathrooms.gridy = 0;
		panel_2.add(chckbxBathrooms, gbc_chckbxBathrooms);
		
		JCheckBox chckbxComputerLabs = new JCheckBox("Computer Labs");
		chckbxComputerLabs.setBackground(Color.PINK);
		GridBagConstraints gbc_chckbxComputerLabs = new GridBagConstraints();
		gbc_chckbxComputerLabs.fill = GridBagConstraints.BOTH;
		gbc_chckbxComputerLabs.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxComputerLabs.gridx = 0;
		gbc_chckbxComputerLabs.gridy = 1;
		panel_2.add(chckbxComputerLabs, gbc_chckbxComputerLabs);
		
		JCheckBox chckbxPrinters = new JCheckBox("Printers");
		chckbxPrinters.setForeground(Color.LIGHT_GRAY);
		chckbxPrinters.setBackground(Color.RED);
		GridBagConstraints gbc_chckbxPrinters = new GridBagConstraints();
		gbc_chckbxPrinters.fill = GridBagConstraints.BOTH;
		gbc_chckbxPrinters.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxPrinters.gridx = 0;
		gbc_chckbxPrinters.gridy = 2;
		panel_2.add(chckbxPrinters, gbc_chckbxPrinters);
		
		JCheckBox chckbxVendingMachines = new JCheckBox("Vending Machines");
		chckbxVendingMachines.setBackground(Color.ORANGE);
		GridBagConstraints gbc_chckbxVendingMachines = new GridBagConstraints();
		gbc_chckbxVendingMachines.fill = GridBagConstraints.BOTH;
		gbc_chckbxVendingMachines.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxVendingMachines.gridx = 0;
		gbc_chckbxVendingMachines.gridy = 3;
		panel_2.add(chckbxVendingMachines, gbc_chckbxVendingMachines);
		
		JCheckBox chckbxWaterFountains = new JCheckBox("Water Fountains");
		chckbxWaterFountains.setBackground(Color.GREEN);
		GridBagConstraints gbc_chckbxWaterFountains = new GridBagConstraints();
		gbc_chckbxWaterFountains.fill = GridBagConstraints.BOTH;
		gbc_chckbxWaterFountains.gridx = 0;
		gbc_chckbxWaterFountains.gridy = 4;
		panel_2.add(chckbxWaterFountains, gbc_chckbxWaterFountains);
		chckbxBathrooms.addItemListener( this );
		
		JLabel label = new JLabel("                                                                             ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		panel.add(label, gbc_label);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener( this );
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.SOUTH;
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 7;
		panel.add(btnBack, gbc_btnBack);
		
		panel_1 = new JLayeredPane();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		btnNextFloor = new JButton( "Up a Level" );
		btnNextFloor.addActionListener( this );
		btnNextFloor.setHorizontalAlignment(SwingConstants.CENTER);
		btnNextFloor.setBounds( 260, 40, 150, 40 );
		
		btnPrevFloor = new JButton( "Down a Level" );
		btnPrevFloor.setEnabled( false );
		btnPrevFloor.addActionListener( this );
		btnPrevFloor.setHorizontalAlignment(SwingConstants.CENTER);
		btnPrevFloor.setBounds( 100, 40, 150, 40 );
		
		panel_1.add( btnNextFloor );
		panel_1.add( btnPrevFloor );
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
		else if( e.getSource() == btnNextFloor ) {
			curFloor++;
			if( curFloor > 1 )
				btnPrevFloor.setEnabled( true );
			if( curFloor == 4) {
				btnNextFloor.setEnabled( false );
			}
			k.repaint();
		}
		else if( e.getSource() == btnPrevFloor ) {
			curFloor--;
			if( curFloor == 1 )
				btnPrevFloor.setEnabled( false );
			else if( curFloor < 4)
				btnNextFloor.setEnabled( true );
			k.repaint();
		}
		else if( e.getSource() == btnSearch ) {
			if( textField.getText().equals( "1115" ) ) {
				k.repaint();
			}
			else {
				JOptionPane.showMessageDialog( mainFrame, "Room not found!" );
				k.repaint();
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
	      
	      try {
	    	  switch( curFloor ) {
	    	  case 1:
	    		  img = ImageIO.read(BuildingMapFrame.class.getResource("/images/firstFloor.jpg"));
	    		  break;
	    	  case 2:
	    		  img = ImageIO.read(BuildingMapFrame.class.getResource("/images/secondFloor.jpg"));
	    		  break;
	    	  case 3:
	    		  img = ImageIO.read(BuildingMapFrame.class.getResource("/images/thirdFloor.jpg"));
	    		  break;
	    	  case 4:
	    		  img = ImageIO.read(BuildingMapFrame.class.getResource("/images/fourthFloor.jpg"));
	    		  break;
	    	  }
	      } catch (IOException e ) {
	    	  System.out.println( "COULDN'T FIND FLOOR FILE" );
	      }

	      g2D.drawImage( img, 0, 0, null );
	      
	      BasicStroke stroke = new BasicStroke(4f);
	      g2D.setStroke(stroke);
	      
	      if( chckbxBathrooms.isSelected() ) {
	    	  if( curFloor < 4 ) {
		    	  g2D.setColor( Color.blue );
		    	  g2D.draw( new Ellipse2D.Float(190f, 210f, 20f, 20f));
		    	  g2D.fill( new Ellipse2D.Float(190f, 210f, 20f, 20f) );
		    	  g2D.draw( new Ellipse2D.Float(170f, 130f, 20f, 20f));
		    	  g2D.fill( new Ellipse2D.Float(170f, 130f, 20f, 20f) );
	    	  }
	      }
	      
	      switch( Integer.valueOf( textField.getText() ) ) {
	      case 1115:
	    	  if( curFloor == 1 ) {
			      g2D.setColor( Color.red );
		    	  g2D.drawLine( 250, 330, 250, 480 );
		    	  g2D.drawLine( 250, 330, 550, 330 );
	    	  }
	    	  break;
	      default:
	    	  break;
	      }
	      
	    }
	  }
}
