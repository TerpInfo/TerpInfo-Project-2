package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class TerpInfo implements ActionListener {

	public JFrame fMainFrame;
	JFrame fEventFrame, fTerpNavFrame, fBuildingMapFrame, fOfficeHoursFrame, fAVWFrame, fTerpMailFrame;
	EventFrame fEventHelper;
	JButton bTerpNav, bBuildingMap, bEvents, bOfficeHours, bAVW, bInternet;
	private JLabel lblCurrentTime;
	private JLabel lblCurrentDate;
	private JLabel lblNewLabel;
	public static TerpInfo instance;
	private JList list;
	private JPanel panel;
	private JLabel lblNewLabel_1;

	public TerpInfo( ) {
		fEventHelper = new EventFrame( );
		fEventFrame = fEventHelper.getFrame();
		
		fTerpNavFrame = new TerpNavFrame( ).getFrame();
		fBuildingMapFrame = new BuildingMapFrame( ).getFrame();
		fOfficeHoursFrame = new OfficeHoursFrame( ).getFrame();
		fAVWFrame = new AVWFrame( ).getFrame();
		fTerpMailFrame = new TerpMailFrame( ).getFrame();
		
		fMainFrame = new JFrame( );
		fMainFrame.getContentPane().setBackground(new Color(102, 102, 153));
		fMainFrame.setUndecorated( true );
		//fMainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  		
		fMainFrame.setSize( 1024, 768 );
		fMainFrame.getContentPane().setLayout( new java.awt.GridLayout( 3, 3 ) );
		fMainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		bTerpNav = new JButton( "TerpNav" );
		bTerpNav.setIcon(new ImageIcon(TerpInfo.class.getResource("/images/terpNav.jpg")));
		bTerpNav.addActionListener( this );
		fMainFrame.getContentPane().add( bTerpNav );
		
		bBuildingMap = new JButton( "Building Map" );
		bBuildingMap.setIcon(new ImageIcon(TerpInfo.class.getResource("/images/buildingDirections.jpg")));
		bBuildingMap.addActionListener( this );
		fMainFrame.getContentPane().add( bBuildingMap );
		
		JPanel timePanel = new JPanel( );
		timePanel.setBackground(new Color(102, 102, 153));
		timePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		fMainFrame.getContentPane().add( timePanel );
		timePanel.setLayout(new GridLayout(4, 1));
		
		lblCurrentTime = new JLabel("Current Time:");
		lblCurrentTime.setForeground(Color.LIGHT_GRAY);
		lblCurrentTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		timePanel.add(lblCurrentTime);
		
		ClockLabel clock = new ClockLabel( );
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setFont(new Font("Tahoma", Font.BOLD, 30));
		timePanel.add( clock );
		
		lblCurrentDate = new JLabel("Current Date:");
		lblCurrentDate.setForeground(Color.LIGHT_GRAY);
		lblCurrentDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		timePanel.add(lblCurrentDate);
		
		SimpleDateFormat ft = new SimpleDateFormat ("E dd/MM/yyyy");
		lblNewLabel = new JLabel(ft.format( new Date( ) ) );
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		timePanel.add(lblNewLabel);
		
		bEvents = new JButton( "Events" );
		bEvents.setIcon(new ImageIcon(TerpInfo.class.getResource("/images/eventList.jpg")));
		bEvents.addActionListener( this );
		fMainFrame.getContentPane().add( bEvents );

		bOfficeHours = new JButton( "Office Hours" );
		bOfficeHours.setIcon(new ImageIcon(TerpInfo.class.getResource("/images/officedoor.jpg")));
		bOfficeHours.addActionListener( this );
		fMainFrame.getContentPane().add( bOfficeHours );
				
		bAVW = new JButton( "Directions to AVW" );
		bAVW.setIcon(new ImageIcon(TerpInfo.class.getResource("/images/AVW.jpg")));
		bAVW.addActionListener( this );
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 102, 153));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Events", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		fMainFrame.getContentPane().add(panel);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"<html><pre style=\"font-size:120%;font-family:Tahoma Bold\">Sample Event\t \t  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</pre>\t</html>", "<html><pre style=\"font-size:120%;font-family:Tahoma Bold\">Sample Event\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</pre>\t</html>", "<html><pre style=\"font-size:120%;font-family:Tahoma Bold\">Sample Event\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</pre>\t</html>", "<html><pre style=\"font-size:120%;font-family:Tahoma Bold\">Sample Event\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</pre>\t</html>", "<html><pre style=\"font-size:120%;font-family:Tahoma Bold\">Sample Event\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</pre>\t</html>", "<html><pre style=\"font-size:120%;font-family:Tahoma Bold\">Sample Event\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</pre>\t</html>"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list);
		fMainFrame.getContentPane().add( bAVW );
		
		bInternet = new JButton( "TerpMail" );
		bInternet.setIcon(new ImageIcon(TerpInfo.class.getResource("/images/terpMailIcon.jpg")));
		bInternet.addActionListener( this );
		fMainFrame.getContentPane().add( bInternet );
		
		lblNewLabel_1 = new JLabel("<html>Build: TerpInfo v0.1<br/>\r\nImages courtesy of UMD, <br/>\r\nKookkai_nak / FreeDigitalPhotos.net <br/>\r\nhttp://dailyserving.com<br/>\r\nBy: Nathan Tucker, Nathan Wright, <br/>\r\nSam Martin, Sherwin Farhang</html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		fMainFrame.getContentPane().add(lblNewLabel_1);


		fMainFrame.setVisible( true );
	}
	
	public JFrame getMainFrame( ) {
		return fMainFrame;
	}

	public void actionPerformed( ActionEvent e ) {
		if( e.getSource() == bTerpNav ) {
			fMainFrame.setVisible( false );
			fTerpNavFrame.setVisible( true ); 
		}
		else if( e.getSource() == bBuildingMap ) {
			fMainFrame.setVisible( false );
			fBuildingMapFrame.setVisible( true );
		}
		else if( e.getSource() == bEvents ) {
			fMainFrame.setVisible( false );
			
			//update list of events before showing 
			
			fEventFrame.setVisible( true );
		}
		else if( e.getSource() == bOfficeHours ) {
			fMainFrame.setVisible( false );
			fOfficeHoursFrame.setVisible( true );
		}
		else if( e.getSource( ) == bAVW ) {
			fMainFrame.setVisible( false );
			fAVWFrame.setVisible( true );
		}
		else if( e.getSource() == bInternet ) {
			fMainFrame.setVisible( false );
			fTerpMailFrame.setVisible( true );
		}
	}
	
	public static void main(String[] args) {
		instance = new TerpInfo( );
	}

}

class ClockLabel extends JLabel implements ActionListener {

	SimpleDateFormat ft = new SimpleDateFormat ( "hh:mm:ss a" );

	public ClockLabel() {
		super( "00:00:00 AM" );
		setForeground( Color.LIGHT_GRAY );
		setText(ft.format( new Date( ) ) );
		Timer t = new Timer(1000, this);
		t.start();
	}

	public void actionPerformed(ActionEvent ae) {
		setText(ft.format( new Date( ) ) );
	}
}
