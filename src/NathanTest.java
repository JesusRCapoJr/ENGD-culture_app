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
import java.io.IOException;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;

public class NathanTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NathanTest window = new NathanTest();
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
	public NathanTest() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(107, 142, 35));
		frame.setBounds(100, 100, 1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel OverviewPanel = new JPanel();
		OverviewPanel.setBackground(new Color(105, 105, 105));
		OverviewPanel.setBounds(724, 220, 652, 533);
		frame.getContentPane().add(OverviewPanel);
		
		JPanel SpritePanel = new JPanel();
		SpritePanel.setBackground(new Color(255, 255, 255));
		SpritePanel.setBounds(1135, 10, 241, 176);
		//
			SpriteForPanels sprite = new SpriteForPanels(frame,SpritePanel);
			sprite.Score = 2;
			sprite.update();
	
		//
		frame.getContentPane().add(SpritePanel);
		
		JButton btnNewButton = new JButton("Folder 1");
		btnNewButton.setBounds(10, 10, 150, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Folder 2");
		btnNewButton_1.setBounds(196, 10, 151, 57);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Folder 2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(380, 10, 151, 57);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add New Folder");
		btnNewButton_3.setBounds(564, 10, 150, 57);
		frame.getContentPane().add(btnNewButton_3);
		
		JPanel AddTaskPanel = new JPanel();
		AddTaskPanel.setBackground(new Color(112, 128, 144));
		AddTaskPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				TaskWindow.initialize();
			}
		});
		AddTaskPanel.setBounds(10, 80, 704, 673);
		frame.getContentPane().add(AddTaskPanel);
		
		JPanel TimeDatePanel = new JPanel();
		TimeDatePanel.setBackground(new Color(105, 105, 105));
		TimeDatePanel.setBounds(724, 10, 401, 200);
		frame.getContentPane().add(TimeDatePanel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setBackground(new Color(34, 139, 34));
		progressBar.setBounds(1135, 196, 241, 14);
		frame.getContentPane().add(progressBar);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				NathanTest2.initialize();
			}
		});
	}
}
