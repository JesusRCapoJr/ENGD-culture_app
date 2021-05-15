
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class DesplayState2 {

	private JFrame frame = new JFrame();
	private Folder folder;
	private int folderID;
	
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
	public DesplayState2(JFrame MainFrame, int folderID) throws Exception {
		frame = MainFrame;
		this.folderID=folderID;
		initialize();
	}
	
	public DesplayState2(JFrame MainFrame, Folder folder) throws Exception {
		frame = MainFrame;
		this.folder = folder;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	public void initialize() throws Exception {
		
		Color homeColor = new Color(200, 250, 200);
		Color folder1Color = new Color(255, 255, 255);
		Color folder2Color = new Color(255, 255, 255);
		Color folder3Color = new Color(255, 255, 255);
		Color folder4Color = new Color(255, 255, 255);
		
		switch(this.folderID) {
			case 1:
				folder1Color = Color.YELLOW;
				break;
			case 2:
				folder2Color = Color.YELLOW;
				break;
			case 3:
				folder3Color = Color.YELLOW;
				break;
			case 4:
				folder4Color = Color.YELLOW;
				break;
		}
		
//		frame.removeAll();
//		frame.getComponent(0);
//		frame.getContentPane().setBackground(new Color(34, 139, 34));
//		frame.getContentPane().setLayout(null);
//		
		JPanel panel = new JPanel();
//		panel.removeAll();
//		frame.getContentPane().removeAll();
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
		
		JButton BackToHome = new JButton("Home");
		BackToHome.setBackground(homeColor);
		BackToHome.setBounds(10, 10, 175, 89);
		panel_3.add(BackToHome);
		BackToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					backToHome();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton Folder1 = new JButton("Folder 1");
		Folder1.setBackground(folder1Color);
		Folder1.setBounds(263, 10, 175, 89);
		panel_3.add(Folder1);
		Folder1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runNewFolder(folder, 1);                     //change
			}
		});
		
		JButton Folder2 = new JButton("Folder 2");
		Folder2.setBackground(folder2Color);
		Folder2.setBounds(520, 10, 175, 89);
		panel_3.add(Folder2);
		Folder2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runNewFolder(folder, 2);                     //change
			}
		});
		
		JButton Folder3 = new JButton("Folder 3");
		Folder3.setBackground(folder3Color);
		Folder3.setBounds(766, 10, 175, 89);
		panel_3.add(Folder3);
		Folder3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runNewFolder(folder, 3);                     //change
			}
		});
		
		JButton Folder4 = new JButton("Folder 4");        //need to send it to the right folder form the array list of folders
		Folder4.setBackground(folder4Color);
		Folder4.setBounds(1020, 10, 175, 89);
		panel_3.add(Folder4);
		Folder4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runNewFolder(folder, 4);                     //change
			}
		});
		
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
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		
		JButton AddNewTask = new JButton();
			BufferedImage icon = ImageIO.read(new File("texture/rsz_1plus-icon-13078_1.png")); 
			AddNewTask.setIcon(new ImageIcon(icon));
		AddNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Task task = new Task();
//				task.setFolder(folder);
				KieyaAddTaskTestWindow frame2 = new KieyaAddTaskTestWindow(task);
				frame2.setVisible(true);
				
			}
		});
		AddNewTask.setBounds(1024, 516, 170, 170);
		panel.add(AddNewTask);
	}
	//
	
	private void backToHome() throws Throwable {
		this.reborn();
		
		try {
			new DesplayState1(this.frame);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void runNewFolder(Folder folder, int folderID) {
		this.reborn();
		try {
			new DesplayState2(frame, folderID);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void reborn() {
		Rectangle bounds = this.frame.getContentPane().getBounds();
		frame.getContentPane().removeAll();
		frame.setBounds(0, 0, 1920, 1080);
		frame.setVisible(true);
		frame.repaint();
		frame.getContentPane().repaint();
		frame.getContentPane().setBounds(bounds);
		
//		frame.add(world);
//		
//		world.removeAll();
//		world.repaint();
//		world.setBounds(0, 0, Main.getWidth(), Main.getHeight());

	}
}
