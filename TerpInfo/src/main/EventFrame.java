package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventFrame implements ActionListener {

	JFrame mainFrame;
	JButton btnBack;
	
	public EventFrame( ) {
		mainFrame = new JFrame( );
		mainFrame.setUndecorated( true );			
		mainFrame.setSize( 1024, 768 );
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		btnBack = new JButton("Back");
		btnBack.addActionListener( this );
		mainFrame.getContentPane().add(btnBack, BorderLayout.CENTER);
	}
	
	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == btnBack ) {
			mainFrame.setVisible( false );
			TerpInfo.instance.getMainFrame().setVisible( true );
			TerpInfo.instance.getMainFrame().requestFocus();
		}
	}

	
	public JFrame getFrame( ){
		return mainFrame;
	}
	
}
