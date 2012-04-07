/* Todo:
 * 1. Replace the current GridBagLayout with a LayeredPane layout, nest "Back" button on the left side.
 * 2. Embed a web-browser element that will point to terpMail.
 */

package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class TerpMailFrame implements ActionListener {
	
	JFrame mainFrame;
	JButton btnBack;
	
	public TerpMailFrame( ) {
		mainFrame = new JFrame( );
		mainFrame.getContentPane().setBackground(new Color(102, 102, 153));
		mainFrame.setUndecorated( true );		
		mainFrame.setSize( 1024, 768 );
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		mainFrame.getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TerpMailFrame.class.getResource("/images/terpMailHolder.jpg")));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		mainFrame.getContentPane().add(label, gbc_label);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener( this );
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 1;
		mainFrame.getContentPane().add(btnBack, gbc_btnBack);
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
