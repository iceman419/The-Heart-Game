package chrisGameProject;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To The Heart Game");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblNewLabel.setBounds(106, 29, 398, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose ();
				UserLogin ul = new UserLogin();
				ul.setLocationRelativeTo(null);
				ul.setVisible(true);			
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(193, 139, 171, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateAccount ca = new CreateAccount();
				ca.setLocationRelativeTo(null);
				ca.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(193, 191, 171, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit Game");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(193, 243, 171, 42);
		contentPane.add(btnNewButton_2);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Please You Must Login to Play!!!","Alert",JOptionPane.INFORMATION_MESSAGE);
				//JOptionPane.showConfirmDialog(null,"Please You Must Login to Play!!! ","Alert!!",JOptionPane.YES_NO_CANCEL_OPTION);
		
			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPlay.setBounds(193, 87, 171, 42);
		contentPane.add(btnPlay);
	}

}
