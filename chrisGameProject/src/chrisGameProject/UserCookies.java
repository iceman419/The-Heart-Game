package chrisGameProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.perisic.sixeq.peripherals.GameGUI;

import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserCookies extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCookies UCookies = new UserCookies();
					UCookies.setVisible(true);
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameGUI myGUI = new GameGUI();
	    		myGUI.setLocationRelativeTo(null);
	    		myGUI.setVisible(true);
			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPlay.setBounds(136, 62, 179, 78);
		contentPane.add(btnPlay);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Icon icon = new javax.swing.ImageIcon(getClass().getResource("Wellcome Heart.png"));
				JOptionPane.showMessageDialog(null," Your Have Successful Logged Out!!", "Authentication", JOptionPane.INFORMATION_MESSAGE,icon);
				dispose();
				MainScreen frame = new MainScreen();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBounds(136, 175, 179, 78);
		contentPane.add(btnLogout);
	}
}
