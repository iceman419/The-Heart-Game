package chrisGameProject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import chrriis.common.UIUtils;
public class DemoDisplay {

	public static void main(String[] args) {
		
		NativeInterface.open();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame sdf = new JFrame("Heart Game Demo");
				sdf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
				sdf.getContentPane().add(getBrowser(),BorderLayout.CENTER);
				sdf.setBounds(350, 150, 690, 400);
				sdf.setVisible(true);

				JButton button = new JButton("Skip Demo");
        		button.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				;
        			}
        		});
        		
        		sdf.getContentPane().add(button,BorderLayout.EAST);
        		button.setFont(new Font("Tahoma", Font.BOLD, 18));
        		button.setForeground(Color.black);
        		button.setBackground(new Color(204, 204, 255));
        		sdf.setVisible(true);
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
	   //this method will return panel with video
		public static JPanel getBrowser() {
			JPanel wbPanel = new JPanel(new BorderLayout());
			JWebBrowser wb = new JWebBrowser();
            
			wbPanel.add(wb, BorderLayout.CENTER);
			wb.setBarsVisible(false);                                                                                           
			
			wb.navigate("https://www.youtube.com/watch?v=1OphXMJin6I&ab_channel=UFC-UltimateFightingChampionship?fs=1");
			//wb.navigate("https://youtu.be/4xLocjT4dE4./watch_popup?autoplay=1"); // use watch popup for fullscreen
	
			return wbPanel;

		}
		

	}

//setTitle("Heart Game Demo");
//
//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//setBounds(100, 100, 376, 311);
//contentPane = new JPanel();
//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//setContentPane(contentPane);
//contentPane.setLayout(null);
//
//JPanel panel = new JPanel(new BorderLayout());
//contentPane.add(getBrowser(panel),BorderLayout.SOUTH);
//panel.add(btnExitDemo ,BorderLayout.NORTH);
//
//btnExitDemo.setBounds(24, 0, 179, 78);
//btnExitDemo.setFont(new Font("Tahoma", Font.BOLD, 18));
//btnExitDemo.setForeground(Color.black);
//btnExitDemo.setBackground(new Color(204, 204, 255));
//panel.setBounds(5, 0, 527, 385);
//contentPane.add(panel);
//


//JFrame sdf = new JFrame("Heart Game Demo");
//sdf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
//sdf.getContentPane().add(DemoDisplay.getBrowser(),BorderLayout.CENTER); 
//sdf.setBounds(350, 150, 690, 400);
//sdf.setVisible(true);
//
//

//btnExitDemo.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		gamedemo.dispose();
//		
//		
//		GameGUI myGUI = new GameGUI();
//		myGUI.setLocationRelativeTo(null);
//		myGUI.setVisible(true);
//		
//	}
//});
//JButton button = new JButton("Skip Demo");
//button.addActionListener(new ActionListener() {
//public void actionPerformed(ActionEvent e) {
//sdf.dispose();
//
//GameGUI myGUI = new GameGUI();
//myGUI.setLocationRelativeTo(null);
//myGUI.setVisible(true);
//    		
//}
//});
////	
//gamedemo.getContentPane().add(btnExitDemo ,BorderLayout.NORTH);
//btnExitDemo.setFont(new Font("Tahoma", Font.BOLD, 18));
//btnExitDemo.setForeground(Color.black);
//gamedemo.setVisible(true);
//
//dispose();
//
//GameGUI myGUI = new GameGUI();
//myGUI.setLocationRelativeTo(null);
//myGUI.setVisible(true);

//}
//this method will return panel with video
//public static JPanel getBrowser(JPanel dummy) {
////JPanel wbPanel = new JPanel(new BorderLayout());
//JWebBrowser wb = new JWebBrowser();
//wb.setMinimumSize(new Dimension(420,268));
//
//dummy.add(wb, BorderLayout.CENTER);
//wb.setBarsVisible(false);                                                                                           
//wb.navigate("https://youtu.be/4xLocjT4dE4./watch_popup?autoplay=1"); // use watch popup for fullscreen
//
//return dummy;
//
//}

//play ends 
