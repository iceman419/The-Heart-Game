package chrisGameProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreBoard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreBoard frame = new ScoreBoard();
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
	public ScoreBoard() {
		setTitle("All Players ScoreBoard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblscoreboard = new JLabel("Score Board");
		lblscoreboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblscoreboard.setBounds(273, 10, 107, 29);
		contentPane.add(lblscoreboard);
		
		JButton btnallps = new JButton("Show all Players Scores");
		btnallps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
					{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamepdb","root","");
					Statement stat = con.createStatement();
					String sql= "select * from Scoreboard";
					ResultSet rs = stat.executeQuery(sql);
					
					while (rs.next())// data will be added until finish
						
					{
						String serial = String.valueOf(rs.getInt("Serial")); // conversion string to int
						String date = rs.getString("Date");//Date is a column name 
						String time = rs.getString("Time");// Time is a column name 
						String username = rs.getString("Username");// Username is a column name 
						String score = String.valueOf(rs.getInt("Score"));// Score is a column name 
					
							
							//string array for storing the data into the jtable;
					
					String tbData[] = {serial,date,time,username,score};
					DefaultTableModel tblModel = (DefaultTableModel) table_1.getModel();
					
					// add string arry data into table_1
					tblModel.addRow(tbData);
					
					}	    
				    }
				   catch(Exception y){
				   System.out.println(y);
				   
				    }
			}
		});
		btnallps.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnallps.setBounds(10, 77, 179, 129);
		contentPane.add(btnallps);
		
		JButton btnmyScore = new JButton("Show My Score");
		btnmyScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 try
					{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamepdb","root","");
					Statement stat = con.createStatement();
					String user = UserLogin.usernameTF.getText();
					String sql= "select * from Scoreboard where Username='"+user+"'";
					ResultSet rs = stat.executeQuery(sql);
					
					while (rs.next())// data will be added until finish
						
					{
						String serial = String.valueOf(rs.getInt("Serial")); // conversion string to int
						String date = rs.getString("Date");//Date is a column name 
						String time = rs.getString("Time");// Time is a column name 
						String username = rs.getString("Username");// Username is a column name 
						String score = String.valueOf(rs.getInt("Score"));// Score is a column name 
					
							
							//string array for storing the data into the jtable;
					
					String tbData[] = {serial,date,time,username,score};
					DefaultTableModel tblModel = (DefaultTableModel) table_1.getModel();
					
					// add string arry data into table_1
					tblModel.addRow(tbData);
					
					}	    
				    }
				   catch(Exception y){
				   System.out.println(y);
				   
				    }
			
			}
		});
		btnmyScore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnmyScore.setBounds(10, 240, 179, 129);
		contentPane.add(btnmyScore);
		
		table = new JTable();
		table.setBounds(378, 162, -17, -6);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Serial", "Date", "Time", "Username", "Score"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(226, 49, 425, 320);
		contentPane.add(table_1);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserCookies UCookies = new UserCookies();
				UCookies.setVisible(true);
				UCookies.setLocationRelativeTo(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(10, 17, 85, 21);
		contentPane.add(btnBack);
	}
}
