/* Todo:
 * 1. Implement more verbose instructions.
 * 3. Implement inside directions that use the sky-walk.
 */

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
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;

public class AVWFrame implements ActionListener {
	JFrame mainFrame;
	JButton btnInside, btnOutside;
	private JLabel label;
	private JLabel lblOutsidePic;
	private JButton btnBack;
	private JPanel panel_3;
	private JLabel lblExitThrough;
	private JPanel panel_2;

	public AVWFrame( ) {
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
		gbl_panel.columnWidths = new int[]{60, 0};
		gbl_panel.rowHeights = new int[]{60, 49, 0, 0, 60, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 153));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Route", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{60, 0};
		gbl_panel_3.rowHeights = new int[]{60, 60, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		btnInside = new JButton("Inside");
		GridBagConstraints gbc_btnInside = new GridBagConstraints();
		gbc_btnInside.fill = GridBagConstraints.BOTH;
		gbc_btnInside.insets = new Insets(0, 0, 5, 0);
		gbc_btnInside.gridx = 0;
		gbc_btnInside.gridy = 0;
		panel_3.add(btnInside, gbc_btnInside);
		
		btnOutside = new JButton("Outside");
		GridBagConstraints gbc_btnOutside = new GridBagConstraints();
		gbc_btnOutside.fill = GridBagConstraints.BOTH;
		gbc_btnOutside.gridx = 0;
		gbc_btnOutside.gridy = 1;
		panel_3.add(btnOutside, gbc_btnOutside);
		btnOutside.addActionListener( this );
		btnInside.addActionListener( this );
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 153));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Directions", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{60, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		lblExitThrough = new JLabel("");
		lblExitThrough.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblExitThrough = new GridBagConstraints();
		gbc_lblExitThrough.gridx = 0;
		gbc_lblExitThrough.gridy = 0;
		panel_2.add(lblExitThrough, gbc_lblExitThrough);
		lblExitThrough.setForeground(Color.LIGHT_GRAY);
		
		//Screw it Java layouts, place-holder to force size
		label = new JLabel("                                                                             ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.anchor = GridBagConstraints.SOUTH;
		gbc_label.gridx = 0;
		gbc_label.gridy = 3;
		panel.add(label, gbc_label);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener( this );
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 4;
		panel.add(btnBack, gbc_btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 153));
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
					}
		else if (e.getSource() == btnOutside ) { 
			lblOutsidePic.setVisible( true );
			lblExitThrough.setText("<html> <p>1. Exit through main door.</p> <br/>\r\n<p> 2. Walk straight ahead to streeet. </p> <br/>\r\n<p> 3. Turn right before crossing. </p> <br/>\r\n<p> 4. Turn right into first entrance. </p> <br/>\r\n<p> 5. Follow walkway around building. </p> <br/>\r\n<p> 6. Entrance to AVW will be on right. </p> <br/>\r\n</html>");
		}
		else if( e.getSource() == btnBack ) {
			mainFrame.setVisible( false );
			TerpInfo.instance.getMainFrame().setVisible( true );
			TerpInfo.instance.getMainFrame().requestFocus();
		}
	}
	
	public JFrame getFrame( ){
		return mainFrame;
	}
}
