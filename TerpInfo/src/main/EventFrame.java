package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class EventFrame implements ItemListener, ActionListener {

	JFrame mainFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBack;
	private JCheckBox chckbxHost;
	
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
		panel.setBackground(new Color(102, 102, 153));
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{60, 50, 40, 51, 45, 0, 60, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 153));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Display List For", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{60, 60, 60, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnToday = new JButton("Today");
		GridBagConstraints gbc_btnToday = new GridBagConstraints();
		gbc_btnToday.fill = GridBagConstraints.BOTH;
		gbc_btnToday.insets = new Insets(0, 0, 5, 0);
		gbc_btnToday.gridx = 0;
		gbc_btnToday.gridy = 0;
		panel_2.add(btnToday, gbc_btnToday);
		
		JButton btnTomorrow = new JButton("Tomorrow");
		GridBagConstraints gbc_btnTomorrow = new GridBagConstraints();
		gbc_btnTomorrow.fill = GridBagConstraints.BOTH;
		gbc_btnTomorrow.insets = new Insets(0, 0, 5, 0);
		gbc_btnTomorrow.gridx = 0;
		gbc_btnTomorrow.gridy = 1;
		panel_2.add(btnTomorrow, gbc_btnTomorrow);
		
		JButton btnThisWeek = new JButton("This Week");
		GridBagConstraints gbc_btnThisWeek = new GridBagConstraints();
		gbc_btnThisWeek.fill = GridBagConstraints.BOTH;
		gbc_btnThisWeek.gridx = 0;
		gbc_btnThisWeek.gridy = 2;
		panel_2.add(btnThisWeek, gbc_btnThisWeek);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 153));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Event Name", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{40, 60, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_3.add(textField, gbc_textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.gridx = 0;
		gbc_btnSearch.gridy = 1;
		panel_3.add(btnSearch, gbc_btnSearch);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 102, 153));
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{45, 45, 45, 45, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JCheckBox chckbxNow = new JCheckBox("Now");
		chckbxNow.setForeground(Color.LIGHT_GRAY);
		chckbxNow.setBackground(new Color(102, 102, 153));
		GridBagConstraints gbc_chckbxNow = new GridBagConstraints();
		gbc_chckbxNow.fill = GridBagConstraints.BOTH;
		gbc_chckbxNow.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNow.gridx = 0;
		gbc_chckbxNow.gridy = 0;
		panel_4.add(chckbxNow, gbc_chckbxNow);
		
		JCheckBox chckbxFreeFood = new JCheckBox("Free Food");
		chckbxFreeFood.setForeground(Color.LIGHT_GRAY);
		chckbxFreeFood.setBackground(new Color(102, 102, 153));
		GridBagConstraints gbc_chckbxFreeFood = new GridBagConstraints();
		gbc_chckbxFreeFood.fill = GridBagConstraints.BOTH;
		gbc_chckbxFreeFood.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxFreeFood.gridx = 0;
		gbc_chckbxFreeFood.gridy = 1;
		panel_4.add(chckbxFreeFood, gbc_chckbxFreeFood);
		
		chckbxHost = new JCheckBox("Host");
		chckbxHost.setForeground(Color.LIGHT_GRAY);
		chckbxHost.setBackground(new Color(102, 102, 153));
		chckbxHost.addItemListener( this );
		GridBagConstraints gbc_chckbxHost = new GridBagConstraints();
		gbc_chckbxHost.fill = GridBagConstraints.BOTH;
		gbc_chckbxHost.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxHost.gridx = 0;
		gbc_chckbxHost.gridy = 2;
		panel_4.add(chckbxHost, gbc_chckbxHost);
		
		textField_1 = new JTextField();
		textField_1.setEditable( false );
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 3;
		panel_4.add(textField_1, gbc_textField_1);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("                                                                             ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 5;
		panel.add(label, gbc_label);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener( this );
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 6;
		panel.add(btnBack, gbc_btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		splitPane.setRightComponent(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY </h2> <br/> I like it<hr></html>", "<html><h2> CANDY2 </h2> <br/> I like it<hr></html>"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		scrollPane.setViewportView(list);
	}
	
	public void itemStateChanged( ItemEvent e ) {
		if( e.getSource() == chckbxHost ) {
			if( chckbxHost.isSelected() ) {				
				textField_1.setEditable( true );
			}
			else {	
				textField_1.setEditable( false );
			}
		}
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
