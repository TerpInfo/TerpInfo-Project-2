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

public class TerpInfo implements ActionListener {

	public JFrame fMainFrame;
	JFrame fEventFrame, fTerpNavFrame, fBuildingMapFrame, fOfficeHoursFrame, fAVWFrame;
	EventFrame fEventHelper;
	JButton bTerpNav, bBuildingMap, bEvents, bOfficeHours, bAVW, bInternet;
	private JLabel lQuickInfo;
	private JLabel lblCurrentTime;
	private JLabel lblCurrentDate;
	private JLabel lblNewLabel;
	public static TerpInfo instance;

	public TerpInfo( ) {
		fEventHelper = new EventFrame( );
		fEventFrame = fEventHelper.getFrame();
		
		fTerpNavFrame = new TerpNavFrame( ).getFrame();
		fBuildingMapFrame = new BuildingMapFrame( ).getFrame();
		fOfficeHoursFrame = new OfficeHoursFrame( ).getFrame();
		fAVWFrame = new AVWFrame( ).getFrame();
		
		fMainFrame = new JFrame( );
		fMainFrame.setUndecorated( true );
		fMainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  
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
		timePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		fMainFrame.getContentPane().add( timePanel );
		timePanel.setLayout(new GridLayout(4, 1));
		
		lblCurrentTime = new JLabel("Current Time:");
		lblCurrentTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		timePanel.add(lblCurrentTime);
		
		ClockLabel clock = new ClockLabel( );
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setFont(new Font("Tahoma", Font.BOLD, 30));
		timePanel.add( clock );
		
		lblCurrentDate = new JLabel("Current Date:");
		lblCurrentDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		timePanel.add(lblCurrentDate);
		
		SimpleDateFormat ft = new SimpleDateFormat ("E dd/MM/yyyy");
		lblNewLabel = new JLabel(ft.format( new Date( ) ) );
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		timePanel.add(lblNewLabel);
		
		bEvents = new JButton( "Events" );
		bEvents.addActionListener( this );
		fMainFrame.getContentPane().add( bEvents );

		bOfficeHours = new JButton( "Office Hours" );
		bOfficeHours.addActionListener( this );
		fMainFrame.getContentPane().add( bOfficeHours );
		
		lQuickInfo = new JLabel("Quick Info");
		fMainFrame.getContentPane().add(lQuickInfo);
				
		bAVW = new JButton( "Directions to AVW" );
		bAVW.setIcon(new ImageIcon(TerpInfo.class.getResource("/images/AVW.jpg")));
		bAVW.addActionListener( this );
		fMainFrame.getContentPane().add( bAVW );
		
		bInternet = new JButton( "Internet" );
		bInternet.addActionListener( this );
		fMainFrame.getContentPane().add( bInternet );


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
		setText(ft.format( new Date( ) ) );
		Timer t = new Timer(1000, this);
		t.start();
	}

	public void actionPerformed(ActionEvent ae) {
		setText(ft.format( new Date( ) ) );
	}
}
