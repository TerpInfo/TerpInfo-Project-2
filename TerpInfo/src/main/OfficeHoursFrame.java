package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;

public class OfficeHoursFrame implements ActionListener {
	
	JFrame mainFrame;
	
	public OfficeHoursFrame( ) {
		mainFrame = new JFrame( );
		mainFrame.setUndecorated( true );	
		mainFrame.setSize( 1024, 768 );
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		mainFrame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
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
