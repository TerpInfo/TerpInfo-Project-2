package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AVWFrame implements ActionListener {
	JFrame mainFrame;
	JLabel lblDirections, lblExitThrough, lblExitThrough2;
	JButton btnInside, btnOutside;
	private JLabel label;
	private JLabel lblOutsidePic;

	public AVWFrame( ) {
		mainFrame = new JFrame( );
		mainFrame.setUndecorated( true );	
		//mainFrame.setSize( 400, 400 );
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		mainFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{60, 0};
		gbl_panel.rowHeights = new int[]{0, 60, 60, 45, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblRoute = new JLabel("Route");
		GridBagConstraints gbc_lblRoute = new GridBagConstraints();
		gbc_lblRoute.insets = new Insets(0, 0, 5, 0);
		gbc_lblRoute.gridx = 0;
		gbc_lblRoute.gridy = 0;
		panel.add(lblRoute, gbc_lblRoute);
		
		btnInside = new JButton("Inside");
		btnInside.addActionListener( this );
		GridBagConstraints gbc_btnInside = new GridBagConstraints();
		gbc_btnInside.fill = GridBagConstraints.BOTH;
		gbc_btnInside.insets = new Insets(0, 0, 5, 0);
		gbc_btnInside.gridx = 0;
		gbc_btnInside.gridy = 1;
		panel.add(btnInside, gbc_btnInside);
		
		btnOutside = new JButton("Outside");
		btnOutside.addActionListener( this );
		GridBagConstraints gbc_btnOutside = new GridBagConstraints();
		gbc_btnOutside.fill = GridBagConstraints.BOTH;
		gbc_btnOutside.insets = new Insets(0, 0, 5, 0);
		gbc_btnOutside.gridx = 0;
		gbc_btnOutside.gridy = 2;
		panel.add(btnOutside, gbc_btnOutside);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		lblDirections = new JLabel("Directions");
		lblDirections.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirections.setVisible( false );
		GridBagConstraints gbc_lblDirections = new GridBagConstraints();
		gbc_lblDirections.fill = GridBagConstraints.VERTICAL;
		gbc_lblDirections.insets = new Insets(0, 0, 5, 0);
		gbc_lblDirections.gridx = 0;
		gbc_lblDirections.gridy = 0;
		panel_2.add(lblDirections, gbc_lblDirections);
		
		lblExitThrough = new JLabel("<html> <p>1. Exit through main door.</p> \r\n<p> 2. Walk straight ahead to streeet. </p>\r\n<p> 3. Turn right before crossing. </p>\r\n<p> 4. Turn right into first entrance. </p>\r\n<p> 5. Follow walkway around building. </p>\r\n<p> 6. Entrance to AVW will be on right. </p>\r\n</html>");
		lblExitThrough.setVisible( false );
		GridBagConstraints gbc_lblExitThrough = new GridBagConstraints();
		gbc_lblExitThrough.gridx = 0;
		gbc_lblExitThrough.gridy = 1;
		panel_2.add(lblExitThrough, gbc_lblExitThrough);
		
		lblExitThrough2 = new JLabel("Indoor directions");
		lblExitThrough2.setVisible( false );
		GridBagConstraints gbc_lblExitThrough2 = new GridBagConstraints();
		gbc_lblExitThrough2.gridx = 0;
		gbc_lblExitThrough2.gridy = 1;
		panel_2.add(lblExitThrough2, gbc_lblExitThrough2);
		
		//Screw it Java layouts, place-holder to force size
		label = new JLabel("                                                                             ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridx = 0;
		gbc_label.gridy = 7;
		panel.add(label, gbc_label);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblOutsidePic = new JLabel("");
		lblOutsidePic.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutsidePic.setVisible( false );
		lblOutsidePic.setIcon(new ImageIcon(AVWFrame.class.getResource("/images/avwoutside.jpg")));
		panel_1.add(lblOutsidePic, BorderLayout.CENTER);
	}

	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnInside ) {
			lblDirections.setVisible( true );
			lblExitThrough.setVisible( false );
			lblExitThrough2.setVisible( true );
			lblOutsidePic.setVisible( false );
		}
		else if (e.getSource() == btnOutside ) { 
			lblDirections.setVisible( true );
			lblExitThrough2.setVisible( false );
			lblExitThrough.setVisible( true );
			lblOutsidePic.setVisible( true );
		}
	}
	
	public JFrame getFrame( ){
		return mainFrame;
	}
}
