package chrisGameProject;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class CreateAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstnameTF;
	private JTextField usernameTFR;
	private JTextField emailTF;
	private JTextField lastnameTF;
	private JPasswordField passwordPF;
	private JPasswordField confirmpasswordPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setTitle("Register Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 383);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New User Register");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		lblNewLabel.setBounds(240, 10, 264, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(23, 105, 112, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(23, 156, 95, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email Id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(23, 209, 89, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(436, 158, 89, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(436, 213, 171, 27);
		contentPane.add(lblNewLabel_5);
		
		firstnameTF = new JTextField();
		firstnameTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		firstnameTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstnameTF.setBounds(145, 110, 201, 29);
		contentPane.add(firstnameTF);
		firstnameTF.setColumns(10);
		
		usernameTFR = new JTextField();
		usernameTFR.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameTFR.setBounds(145, 158, 201, 34);
		contentPane.add(usernameTFR);
		usernameTFR.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		emailTF.setBounds(145, 213, 201, 32);
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setForeground(Color.BLACK);
		registerBtn.addActionListener(new ActionListener() {
			public void infoMassage(String message,String tittle)
			{
				JOptionPane.showMessageDialog(null,message, tittle,JOptionPane.INFORMATION_MESSAGE);
				
			}
			// password encryption
	private static String hash(String data) {
				//create a string
	String hashed = "";
	try {
					//using messageDigest class to do conversion
					//creating messageDigest object
	MessageDigest md5 = MessageDigest.getInstance("MD5");
					// update the md5 object
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
			}// password encryption ENDS
			
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent e) {
				String firstname = firstnameTF.getText();
				String lastname  = lastnameTF.getText();
			    String username = usernameTFR.getText();
			    String email = emailTF.getText();
				String password = passwordPF.getText();
				String pass = hash (password);//password encryption
				String confirm_password = confirmpasswordPF.getText();
				String confirmpass = hash (confirm_password);//password encryption
			    String cf = new String (confirm_password);
				     //Validating Email Address using Regular Expression
				String emailRegex = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				    Pattern pattern = Pattern.compile(emailRegex);
		
	   if(firstnameTF.getText() .isEmpty() ||lastnameTF.getText().isEmpty() ||usernameTFR.getText().isEmpty() ||emailTF.getText().isEmpty() ||passwordPF.getText().isEmpty() ||confirmpasswordPF.getText().isEmpty())
		{
		 infoMassage("Please Fill In All Fields","Alert!!");
			return;		//program end     			
		}
	   if((pattern.matcher(email).matches())) 
	   {

	   }else {
			 //if Email Address is InValid
				infoMassage("InValid Email Address","Alert!!");
				return; //program end
	   }

	   if (cf.equals(password))
	   {
		   
	   }else {
		 //if Password Do Not  Match
	    	infoMassage("Password Do Not  Match","Alert!!");
	    	return; //program end
	   }
	   
		 try
		 //If the Username and Email are not unique, then it would proceed to adding the rest of the deatils to the database,due to the implementation of a try method
		 // Else The database will throw an error and a Message box is displayed due to the implementation of a catch method
		  {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamepdb","root","");
		 Statement stat = con.createStatement();
		 String insertQuery = "insert into user_details values(null,'"+firstname+"','"+lastname+"','"+username+"','"+pass+"','"+confirmpass+"','"+email+"' )";
		 stat.executeUpdate(insertQuery);  
		 infoMassage("Details Successfully Registered","Alert!!");
	 	 dispose();
	 	 UserLogin ul = new UserLogin();
	 	 ul.setLocationRelativeTo(null);
	 	 ul.setVisible(true);	
	
	  }
			 catch(Exception y){
				 infoMassage("Details Already Registered","Alert!!");
			 	 dispose();
			 	 UserLogin ul = new UserLogin();
			     ul.setLocationRelativeTo(null);
			 	 ul.setVisible(true);	
					    	
			 }	
			    

			}	});
		registerBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		registerBtn.setBounds(240, 257, 137, 32);
		contentPane.add(registerBtn);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameTFR.setText(" ");
				passwordPF.setText("");
			    firstnameTF.setText("");
				lastnameTF.setText("");
			    emailTF.setText("");
			    confirmpasswordPF.setText("");	
			}
		});
		resetBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		resetBtn.setBounds(540, 257, 95, 32);
		contentPane.add(resetBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainScreen frame = new MainScreen();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		exitBtn.setBounds(692, 257, 85, 32);
		contentPane.add(exitBtn);
		
		JButton btnNewButton_3 = new JButton("Already have account ? Sign In");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserLogin ul = new UserLogin();
				ul.setLocationRelativeTo(null);
				ul.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(250, 299, 367, 37);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_6 = new JLabel("Last Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(436, 108, 112, 27);
		contentPane.add(lblNewLabel_6);
		
		lastnameTF = new JTextField();
		lastnameTF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastnameTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lastnameTF.setBounds(616, 105, 171, 29);
		contentPane.add(lastnameTF);
		lastnameTF.setColumns(10);
		
		passwordPF = new JPasswordField();
		passwordPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordPF.setBounds(617, 156, 170, 28);
		contentPane.add(passwordPF);
		
		confirmpasswordPF = new JPasswordField();
		confirmpasswordPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		confirmpasswordPF.setBounds(617, 208, 170, 30);
		contentPane.add(confirmpasswordPF);
	}

}
