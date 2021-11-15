package chrisGameProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Color;

public class MyScore extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyScore frame = new MyScore();
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
	public MyScore() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("My Score Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyscore = new JLabel("My Score Board");
		lblMyscore.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMyscore.setBounds(277, 10, 205, 32);
		contentPane.add(lblMyscore);
		
		JButton btnMyscoreBB = new JButton("Back");
		btnMyscoreBB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserCookies UCookies = new UserCookies();
				UCookies.setVisible(true);
				UCookies.setLocationRelativeTo(null);
			}
		});
		btnMyscoreBB.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMyscoreBB.setBounds(10, 19, 85, 38);
		contentPane.add(btnMyscoreBB);
		
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
					DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
					
					// add string arry data into table_1
					tblModel.addRow(tbData);
					
					}	    
				    }
				   catch(Exception y){
				   System.out.println(y);
				   
				    }
			
			
			}
		});
		btnmyScore.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnmyScore.setBounds(315, 404, 179, 129);
		contentPane.add(btnmyScore);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(227, 72, 11, -9);
		contentPane.add(tabbedPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setForeground(Color.black);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"serial", "Date", "Time", "Username", "Score"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(34);
		table.getColumnModel().getColumn(2).setPreferredWidth(171);
		table.getColumnModel().getColumn(3).setPreferredWidth(163);
		table.getColumnModel().getColumn(4).setPreferredWidth(38);
		table.setBounds(111, 60, 598, 320);
		contentPane.add(table);
	}
}
