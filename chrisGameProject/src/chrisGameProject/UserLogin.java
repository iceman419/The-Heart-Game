package chrisGameProject;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.perisic.sixeq.peripherals.GameGUI;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;



public class UserLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//Made public static because it allows input fron the JTextField to accessable from anywhere in the project Package
    public static JTextField usernameTF; 
	private JPasswordField passwordPF;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}

	/**
	 * Create the frame.
	 */
	
	public UserLogin() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblNewLabel.setBounds(211, 10, 163, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(71, 80, 98, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(71, 146, 89, 22);
		contentPane.add(lblNewLabel_2);
		
		usernameTF = new JTextField();
		usernameTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		usernameTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameTF.setBounds(171, 83, 215, 32);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			
			// password decryption
			private static String hash(String data) {
				String hashed = "";
				try {
					MessageDigest md5 = MessageDigest.getInstance("MD5");
					md5.update(data.getBytes());
					byte[] byteData = md5.digest();
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i< byteData.length; i++) {
						sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
					}
					hashed = sb.toString();
				}catch (NoSuchAlgorithmException e) {
					
				}
				return hashed;
			}// password decryption ENDS
			
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamepdb","root","");
				Statement stat = con.createStatement();
				String username = usernameTF.getText();
				String sql = "select * from user_details where username='"+username+"' and password = '"+hash(passwordPF.getText())+"'";
				ResultSet rs = stat.executeQuery(sql);
				if(rs.next()) {
					Icon icon = new javax.swing.ImageIcon(getClass().getResource("Wellcome Heart.png"));
					JOptionPane.showMessageDialog(null,username +" Your Login Was Successful!!", "Authentication", JOptionPane.INFORMATION_MESSAGE,icon);
					//JOptionPane.showMessageDialog(null, usernameTF.getText(), "Welcome To Heart Game", JOptionPane.INFORMATION_MESSAGE,icon);
					
                    dispose();
                  
                    NativeInterface.open();
    				JFrame sdf = new JFrame("Heart Game Demo");
    				sdf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    				sdf.getContentPane().add(DemoDisplay.getBrowser(),BorderLayout.CENTER); 
    				sdf.setBounds(350, 150, 690, 400);
    				sdf.setVisible(true);
    			
            		
            	    JButton button = new JButton("Skip Demo");
                    button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    sdf.dispose();
                    
            		GameGUI myGUI = new GameGUI();
            		myGUI.setLocationRelativeTo(null);
            		myGUI.setVisible(true);
                    	    		
                	}
                    	});
                    		
            		sdf.getContentPane().add(button,BorderLayout.EAST);
            		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
            		button.setForeground(Color.black);
            		button.setBackground(new Color(204, 204, 255));
            		sdf.setVisible(true);


				}else {
					if(usernameTF.getText().isEmpty() ||passwordPF.getText().isEmpty())
		    		{		    			
		    			JOptionPane.showMessageDialog(null,"Please enter a valid username and Password!!!");
		    					    			
		    		}
					else
	    			JOptionPane.showMessageDialog(null,"Incorrect Username Or Password");
	    		usernameTF.setText(" ");
				passwordPF.setText("");
	    		con.close();
			} 
			}catch(Exception y) {System.out.print(y);}
		    	
			
		    	
		    	}
		    
		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(171, 205, 85, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				usernameTF.setText(" ");
				passwordPF.setText("");
	    		
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(301, 205, 85, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create Account");
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				dispose();
				CreateAccount ca = new CreateAccount();
				ca.setLocationRelativeTo(null);
				ca.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(171, 247, 215, 38);
		contentPane.add(btnNewButton_2);
		
		passwordPF = new JPasswordField();
		passwordPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordPF.setBounds(171, 141, 215, 32);
		contentPane.add(passwordPF);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainScreen frame = new MainScreen();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHome.setBounds(171, 291, 215, 38);
		contentPane.add(btnHome);
	}
}


