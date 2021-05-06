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
		frame.setBounds(100, 100, 1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel OverviewPanel = new JPanel();
		OverviewPanel.setBounds(701, 220, 675, 533);
		frame.getContentPane().add(OverviewPanel);
		
		JPanel SpritePanel = new JPanel();
		SpritePanel.setBounds(1037, 10, 339, 200);
		//
			SpriteForPanels sprite = new SpriteForPanels(frame,SpritePanel);
			sprite.Score = 2;
			sprite.update();
	
		//
		frame.getContentPane().add(SpritePanel);
		
		JButton btnNewButton = new JButton("openAnotherWindow");
		btnNewButton.setBounds(10, 34, 150, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("openAnotherWindow");
		btnNewButton_1.setBounds(185, 36, 151, 57);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("openAnotherWindow");
		btnNewButton_2.setBounds(365, 36, 151, 57);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add New Folder");
		btnNewButton_3.setBounds(541, 36, 150, 57);
		frame.getContentPane().add(btnNewButton_3);
		
		JPanel AddTaskPanel = new JPanel();
		AddTaskPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				TaskWindow.initialize();
			}
		});
		AddTaskPanel.setBounds(10, 127, 681, 626);
		frame.getContentPane().add(AddTaskPanel);
		
		JPanel TimeDatePanel = new JPanel();
		TimeDatePanel.setBounds(701, 10, 326, 200);
		frame.getContentPane().add(TimeDatePanel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				NathanTest2.initialize();
			}
		});
	}
}
