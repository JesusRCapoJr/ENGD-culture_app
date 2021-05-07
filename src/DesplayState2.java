import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class DesplayState2 {

	private JFrame frame = new JFrame();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DesplayState2 window = new DesplayState2();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * @wbp.parser.entryPoint
	 */
	public DesplayState2(JFrame MainFrame) throws Exception {
		frame = MainFrame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	public void initialize() throws Exception {
//		frame.removeAll();
//		frame.getComponent(0);
//		frame.getContentPane().setBackground(new Color(34, 139, 34));
//		frame.getContentPane().setLayout(null);
//		
		JPanel panel = new JPanel();
//		panel.removeAll();
		frame.getContentPane().removeAll();
		frame.setBounds(0, 0, 1920, 1080);
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(10, 131, 1205, 704);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		panel_1.setBounds(1225, 216, 305, 619);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(160, 82, 45));
		panel_3.setBounds(10, 10, 1205, 109);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 10, 175, 89);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(1020, 10, 175, 89);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(263, 10, 175, 89);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(766, 10, 175, 89);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(520, 10, 175, 89);
		panel_3.add(btnNewButton_4);
		
		JPanel SpritePanel = new JPanel();
		SpritePanel.setBackground(Color.WHITE);
		SpritePanel.setBounds(1263, 10, 241, 176);
		//
		SpriteForPanels sprite = new SpriteForPanels(frame,SpritePanel);
		sprite.Score = 2;
		sprite.update();

	//
		frame.getContentPane().add(SpritePanel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(50);
		progressBar.setBackground(new Color(34, 139, 34));
		progressBar.setBounds(1263, 192, 241, 14);
		frame.getContentPane().add(progressBar);
		frame.setBounds(0, 0, 1920, 1080);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
