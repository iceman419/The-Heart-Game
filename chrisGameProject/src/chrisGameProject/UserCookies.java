package chrisGameProject;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.perisic.sixeq.peripherals.GameGUI;
import java.awt.BorderLayout;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class UserCookies extends JFrame {

	/**
	 *   https://github.com/iceman419 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField usernameTF;
	String user =  UserLogin.dummyvar; //Variable for getting the Users name from userlogin JFrame
	
	JButton btnExitDemo = new JButton("Skip Demo");
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCookies UCookies = new UserCookies();
					UCookies.setVisible(true);
					UCookies.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	
	public UserCookies() {
		setTitle("Cookies");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//play starts here
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NativeInterface.open();
				
				GameDemo gamedemo= new GameDemo();
				gamedemo.setLocationRelativeTo(null);
				gamedemo.setVisible(true);
			}
				

		});
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlay.setBounds(240, 10, 179, 78);
		contentPane.add(btnPlay);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Icon icon = new javax.swing.ImageIcon(getClass().getResource("Wellcome Heart.png"));
				
				int option = JOptionPane.showConfirmDialog(null,user+" Are you Sure You Want to Logged Out!", "You Are About to Logout!",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,icon);
				if(option == JOptionPane.YES_OPTION) {
						dispose();
						JOptionPane.showMessageDialog(null,"Your Have Successful Logged Out!! " + user,"Alert!!", JOptionPane.INFORMATION_MESSAGE,icon);
						MainScreen frame = new MainScreen();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);	
						
					}else {
						
					}	
				
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(240, 311, 179, 78);
		contentPane.add(btnLogout);
		
		JButton btnscoreBoard = new JButton("Score Board");
		btnscoreBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ScoreBoard frame = new ScoreBoard();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnscoreBoard.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnscoreBoard.setBounds(240, 109, 179, 78);
		contentPane.add(btnscoreBoard);
		
		JButton btnNewButton = new JButton("My Score");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyScore frame = new MyScore();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(240, 207, 179, 78);
		contentPane.add(btnNewButton);
	}
}
