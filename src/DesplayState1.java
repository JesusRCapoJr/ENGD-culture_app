//import java.awt.EventQueue;
//import java.awt.Point;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.IOException;
//import java.awt.Color;
//import javax.swing.JProgressBar;
//import java.awt.Component;
//import javax.swing.Box;
//import javax.swing.SwingConstants;
//import javax.swing.BoxLayout;
//
//public class NathanTest {
//
//	private JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NathanTest window = new NathanTest();
////					window.frame.getComponentAt(new Point(1300,100));
//					window.frame.setVisible(true);
//				} catch (Throwable e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 * @throws Throwable 
//	 */
//	public NathanTest() throws Throwable {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 * @throws Throwable 
//	 */
//	private void initialize() throws Throwable {
//		frame = new JFrame();
//		frame.getContentPane().setBackground(new Color(107, 142, 35));
//		frame.setBounds(0, 0, 1920, 1080);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		final JPanel OverviewPanel = new JPanel();                    /// might not be finle
//		OverviewPanel.setBackground(new Color(105, 105, 105));
//		OverviewPanel.setBounds(724, 208, 806, 627);
//		frame.getContentPane().add(OverviewPanel);
//		
//		JPanel SpritePanel = new JPanel();
//		SpritePanel.setBackground(new Color(255, 255, 255));
//		SpritePanel.setBounds(1028, 10, 241, 176);
//		//
//			SpriteForPanels sprite = new SpriteForPanels(frame,SpritePanel);
//			sprite.Score = 2;
//			sprite.update();
//	
//		//
//		frame.getContentPane().add(SpritePanel);
//		
//		JPanel AddTaskPanel = new JPanel();
//		AddTaskPanel.setBackground(new Color(112, 128, 144));
//		AddTaskPanel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
////				TaskWindow.initialize();
//			}
//		});
//		AddTaskPanel.setBounds(10, 149, 704, 686);
//		frame.getContentPane().add(AddTaskPanel);
//		
//		JProgressBar progressBar = new JProgressBar();
//		progressBar.setValue(50);
//		progressBar.setBackground(new Color(34, 139, 34));
//		progressBar.setBounds(1028, 183, 241, 14);
//		frame.getContentPane().add(progressBar);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(160, 82, 45));
//		panel.setBounds(10, 23, 704, 81);
//		frame.getContentPane().add(panel);
//		panel.setLayout(null);
//		
//		JButton btnNewButton = new JButton("Folder 1");
//		btnNewButton.setBounds(10, 10, 120, 60);
//		panel.add(btnNewButton);
//		
//		JButton btnNewButton_2 = new JButton("Folder 2");
//		btnNewButton_2.setBounds(200, 10, 120, 60);
//		panel.add(btnNewButton_2);
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		
//		JButton btnNewButton_1 = new JButton("Folder 2");
//		btnNewButton_1.setBounds(386, 10, 120, 60);
//		panel.add(btnNewButton_1);
//		
//		JButton btnNewButton_3 = new JButton("Add New Folder");
//		btnNewButton_3.setBounds(574, 10, 120, 60);
//		panel.add(btnNewButton_3);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				frame.setVisible(false);
//				try {
//					new DesplayState2(frame);
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
//	}
//}
//=======
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DesplayState1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesplayState1 window = new DesplayState1();
//					window.frame.getComponentAt(new Point(1300,100));
					window.frame.setVisible(true);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Throwable 
	 */
	public DesplayState1() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <SpriteForPanels>
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(107, 142, 35));
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		final JPanel OverviewPanel = new JPanel();                    /// might not be finle
//		OverviewPanel.setBackground(new Color(105, 105, 105));
//		OverviewPanel.setBounds(724, 208, 806, 627);
//		frame.getContentPane().add(OverviewPanel);
//		HomeOverviewPanel overviewPanel = new HomeOverviewPanel(724, 208, 806, 627); 
//		frame.getContentPane().add(overviewPanel); 
//		overviewPanel.setBackground(new Color(105, 105, 105));
//		
		JPanel SpritePanel = new JPanel();
		SpritePanel.setBackground(new Color(255, 255, 255));
		SpritePanel.setBounds(1028, 10, 241, 176);
		
		//
		
			SpriteForPanels sprite = new SpriteForPanels(frame, SpritePanel);
			sprite.Score = 2;
			sprite.update();
	
		//
			
		frame.getContentPane().add(SpritePanel);
		
		JPanel AddTaskPanel = new JPanel();
		AddTaskPanel.setBackground(new Color(112, 128, 144));
		AddTaskPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				TaskWindow.initialize();
//					new KieyaAddTaskTestWindow();
//				Task task = new Task();
//				new KieyaAddTaskTestWindow(task);
			}
		});
		AddTaskPanel.setBounds(10, 149, 704, 686);
		frame.getContentPane().add(AddTaskPanel);
		AddTaskPanel.setLayout(null);
		
		JButton AddNewTask = new JButton();
		//
			BufferedImage icon = ImageIO.read(new File("texture/rsz_1plus-icon-13078_1.png")); 
		
			AddNewTask.setIcon(new ImageIcon(icon));
		//
		AddNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Task task = new Task();
//				new KieyaAddTaskTestWindow(task).setVisible(true);
				
				//TEST WINDOW
				KieyaAddTaskTestWindow frame2 = new KieyaAddTaskTestWindow(task);
				
				frame.setVisible(true);
				
			}
		});
		AddNewTask.setBounds(489, 501, 215, 185);
		AddTaskPanel.add(AddNewTask);
		
		JProgressBar PandaProgressBar = new JProgressBar();
		PandaProgressBar.setValue(50);
		PandaProgressBar.setBackground(new Color(34, 139, 34));
		PandaProgressBar.setBounds(1028, 183, 241, 14);
		frame.getContentPane().add(PandaProgressBar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 82, 45));
		panel.setBounds(10, 23, 704, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton Folder_1 = new JButton("Folder 1");
		Folder_1.setBounds(10, 10, 120, 60);
		panel.add(Folder_1);
		
		JButton Folder_2 = new JButton("Folder 2");
		Folder_2.setBounds(200, 10, 120, 60);
		panel.add(Folder_2);
		Folder_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton Folder_3 = new JButton("Folder 3");
		Folder_3.setBounds(386, 10, 120, 60);
		panel.add(Folder_3);
		
		JButton Folder_4 = new JButton("Folder 4");
		Folder_4.setBounds(574, 10, 120, 60);
		panel.add(Folder_4);
		
		JLabel BackDrop = new JLabel("");
		BackDrop.setIcon(new ImageIcon(DesplayState1.class.getResource("texture/BackDrop.png"))); // change to backround
		BackDrop.setBounds(0, 0, 1540, 845);
		frame.getContentPane().add(BackDrop);
		Folder_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(false);
				try {
					new DesplayState2(frame);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
