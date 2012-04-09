/* Todo:
 * 1. Replace the current GridBagLayout with a LayeredPane layout, nest "Back" button on the left side.
 * 2. Embed a web-browser element that will point to terpMail.
 */

package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class TerpMailFrame implements ActionListener {
	
	JFrame mainFrame;
	JButton btnBack;
	private JLayeredPane layeredPane;
	
	public TerpMailFrame( ) {
		mainFrame = new JFrame( );
		mainFrame.getContentPane().setBackground(new Color(102, 102, 153));
		mainFrame.setUndecorated( true );		
		mainFrame.setSize( 1024, 768 );
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		mainFrame.getContentPane().setLayout(gridBagLayout);
		
		layeredPane = new JLayeredPane();
		GridBagConstraints gbc_layeredPane = new GridBagConstraints();
		gbc_layeredPane.fill = GridBagConstraints.BOTH;
		gbc_layeredPane.gridx = 0;
		gbc_layeredPane.gridy = 0;
		mainFrame.getContentPane().add(layeredPane, gbc_layeredPane);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 708, 220, 60);
		layeredPane.add(btnBack);
		btnBack.addActionListener( this );
		
		
		
		JLabel label = new JLabel("");
		label.setBounds(0, -74, 1024, 897);
		layeredPane.add(label);
		label.setIcon(new ImageIcon(TerpNavFrame.class.getResource("/images/terpMailHolder.jpg")));
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
