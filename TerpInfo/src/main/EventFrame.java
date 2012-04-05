package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class EventFrame implements ActionListener {

	JFrame mainFrame;
	
	public EventFrame( ) {
		mainFrame = new JFrame( );
		mainFrame.setUndecorated( true );			
		mainFrame.setSize( 1024, 768 );
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		mainFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 2;
		panel.add(btnBack, gbc_btnBack);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
	}
	
	public void actionPerformed( ActionEvent e ) {
		/*if( e.getSource() == btnBack ) {
			mainFrame.setVisible( false );
			TerpInfo.instance.getMainFrame().setVisible( true );
			TerpInfo.instance.getMainFrame().requestFocus();
		}*/
	}

	
	public JFrame getFrame( ){
		return mainFrame;
	}
	
}
