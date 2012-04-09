package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class OfficeHoursFrame implements ActionListener {
	
	JFrame mainFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBack;
	
	public OfficeHoursFrame( ) {
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
		gbl_panel.rowHeights = new int[]{0, 60, 38, 0, 38, 0, 0, 60, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 153));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "View All", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{60, 60, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnTeachers = new JButton("Teachers");
		GridBagConstraints gbc_btnTeachers = new GridBagConstraints();
		gbc_btnTeachers.fill = GridBagConstraints.BOTH;
		gbc_btnTeachers.insets = new Insets(0, 0, 5, 0);
		gbc_btnTeachers.gridx = 0;
		gbc_btnTeachers.gridy = 0;
		panel_3.add(btnTeachers, gbc_btnTeachers);
		
		JButton btnTeachersIn = new JButton("Teachers In");
		GridBagConstraints gbc_btnTeachersIn = new GridBagConstraints();
		gbc_btnTeachersIn.fill = GridBagConstraints.BOTH;
		gbc_btnTeachersIn.gridx = 0;
		gbc_btnTeachersIn.gridy = 1;
		panel_3.add(btnTeachersIn, gbc_btnTeachersIn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 102, 153));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search by Name", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{40, 60, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.gridx = 0;
		gbc_btnSearch.gridy = 1;
		panel_1.add(btnSearch, gbc_btnSearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 153));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search by Class", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 5;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{40, 60, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 0;
		panel_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch_1 = new JButton("Search");
		GridBagConstraints gbc_btnSearch_1 = new GridBagConstraints();
		gbc_btnSearch_1.fill = GridBagConstraints.BOTH;
		gbc_btnSearch_1.gridx = 0;
		gbc_btnSearch_1.gridy = 1;
		panel_2.add(btnSearch_1, gbc_btnSearch_1);
		
		JLabel label = new JLabel("                                                                             ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		panel.add(label, gbc_label);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener( this );
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.fill = GridBagConstraints.BOTH;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 7;
		panel.add(btnBack, gbc_btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		splitPane.setRightComponent(scrollPane);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>( model);
		
		String temp = new File("").getAbsolutePath();
		temp += "\\res\\teachers.txt";
		
		int curEle = 0;
		String event;
		Scanner f;
		
		try {
			f = new Scanner( new File( temp ) ).useDelimiter( "\n");
			while( f.hasNext() ) {
				event = f.next();
				model.add( curEle, event);
				curEle++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		scrollPane.setViewportView(list);
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
