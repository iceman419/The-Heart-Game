package chrisGameProject;

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
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class ScoreBoard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		setBounds(100, 100, 794, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblscoreboard = new JLabel("Score Board");
		lblscoreboard.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblscoreboard.setBounds(291, 13, 167, 29);
		contentPane.add(lblscoreboard);
		
		JButton btnallps = new JButton("Show All Players Score");
		btnallps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
					{
						DefaultTableModel tbd = new DefaultTableModel();//Clearing the Entire JTable Out
						//Creating a List of Strings that will be Visible as Columns on The Table
						String tbData1[] = new String[]{"Serial","Date","Time","Username","Score"};
					
						for (int i =0;i< tbData1.length;i++)
						{
							tbd.addColumn("");
							
						}
						table_1.setModel(tbd);
						tbd.addRow(tbData1);
						
					 
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
		btnallps.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnallps.setBounds(291, 404, 250, 129);
		contentPane.add(btnallps);
		
		table_1 = new JTable();
		table_1.setBackground(Color.WHITE);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		table_1.setEnabled(false);// make table uneditable
		table_1.setForeground(Color.black);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Serial", "Date", "Time", "Username     ", "Score"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(32);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(74);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(137);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(174);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(37);
		table_1.setBounds(21, 74, 728, 320);
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
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(10, 17, 85, 21);
		contentPane.add(btnBack);
	}
}
