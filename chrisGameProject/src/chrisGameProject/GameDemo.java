package chrisGameProject;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;

import com.perisic.sixeq.peripherals.GameGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8659360075269324321L;
	private JPanel contentPane;
	public JPanel panel;
	/**
	 * @wbp.nonvisual location=539,184
	 */
	JButton btnExitDemo = new JButton("Skip Demo");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		NativeInterface.open();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		NativeInterface.runEventPump();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				NativeInterface.close();// closing NI
			}
			
		}));
	}

	/**
	 * Create the frame.
	 */
	public GameDemo() {
		setTitle("Heart Game Demo");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel(new BorderLayout());
		contentPane.add(getBrowser(panel),BorderLayout.SOUTH);
		btnExitDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			GameGUI myGUI = new GameGUI();
    		myGUI.setLocationRelativeTo(null);
    		myGUI.setVisible(true);
    		
			}
		});
		panel.add(btnExitDemo ,BorderLayout.NORTH);
		btnExitDemo.setBounds(24, 0, 179, 78);
		btnExitDemo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExitDemo.setForeground(Color.black);
		btnExitDemo.setBackground(new Color(204, 204, 255));
		panel.setBounds(5, 0, 527, 385);
		contentPane.add(panel);
		
	}
	
	
	//this method will return panel with video
			public static JPanel getBrowser(JPanel dummy) {
				JWebBrowser wb = new JWebBrowser();
				wb.setMinimumSize(new Dimension(420,268));
				dummy.add(wb, BorderLayout.CENTER);
				wb.setBarsVisible(false);   
				wb.navigate("https://youtu.be/6dEH_pt1uKc./watch_popup?"); // use watch popup for fullscreen 
				
		
				return dummy;

			}
}
