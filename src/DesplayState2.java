
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;

public class DesplayState2 {

	private JFrame frame = new JFrame();
	private Folder folder;
	private int folderID;
	private ArrayList<Color> folderButtonColors;
	private DesplayState2 thisDesplay;
	
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
		this.thisDesplay=this;
		this.folderButtonColors = new ArrayList<Color>();
		this.folderID=folderID;
		this.folder=Main.getAllFolders().get(folderID-1);
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
		
		this.folderButtonColors.add(homeColor);
		this.folderButtonColors.add(folder1Color);
		this.folderButtonColors.add(folder2Color);
		this.folderButtonColors.add(folder3Color);
		this.folderButtonColors.add(folder4Color);
		
//		frame.removeAll();
//		frame.getComponent(0);
//		frame.getContentPane().setBackground(new Color(34, 139, 34));
//		frame.getContentPane().setLayout(null);
//		
		JPanel panel = new JPanel();
		panel.setLayout(null);
//		panel.removeAll();
//		frame.getContentPane().removeAll();
		//frame.setBounds(0, 0, 1920, 1080);
		frame.setBounds(0, 0, 1545, 950);
		panel.setBackground(Main.getChosenTheme().get(6));
		panel.setBounds(10, 131, 1205, 704); 
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Main.getChosenTheme().get(3));
		panel_1.setBounds(1225, 216, 305, 619);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Main.getChosenTheme().get(5));
		panel_3.setBounds(10, 10, 1205, 109);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		//-----------
		
		JButton BackToHome = new JButton("Home");
		BackToHome.setBackground(this.folderButtonColors.get(0));
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
		
		//Loop through all folders to showup inthe navigation panel
		for(final Folder f: Main.getAllFolders()) {
			int currentFolderIndex = f.getID();
			FolderButton aFolderBtn = new FolderButton(f,this.frame); 
			aFolderBtn.setBounds(250+(currentFolderIndex-1)*257, 10, 175, 89);
			aFolderBtn.setBackground(this.folderButtonColors.get(currentFolderIndex));
			panel_3.add(aFolderBtn); 
			
			aFolderBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					runNewFolder(f,f.getID());
				}
			});
			aFolderBtn.addMouseListener(new MouseAdapter() {
	               public void mousePressed(MouseEvent e) {
	                  if (e.getButton() == MouseEvent.BUTTON3) {
	                	  String newFolderName = (String)JOptionPane.showInputDialog(
	                              null,
	                              "Rename folder", 
	                              "Rolder Renamer",            
	                              JOptionPane.PLAIN_MESSAGE,
	                              null,            
	                              null, 
	                              f.getTitle()
	                           );
	                	  if (!newFolderName.isEmpty()) {
	                		  f.setTitle(newFolderName);
	                	  }
	                		  
	                	  
	                	  runNewFolder(f,f.getID());
	                  }
	               }
	            });
		}
		
		//Loop through all tasks in the folder
		int currentTaskNum = 1;
		for(final Task t: this.folder.getTasks()) {
			JButton taskButton = new JButton(t.getTitle()); 
			final JCheckBox completedTaskButton = new JCheckBox("");
			if (t.isCompleted()==false) {
				completedTaskButton.setSelected(false);
			} 
			else {
				completedTaskButton.setSelected(true);
			}
			JButton taskDayLabel = new JButton(t.getDueDate());
			JButton taskTimeLabel = new JButton(t.getDueTime());
			JButton deleteTaskButton = new JButton("Delete");
			
			taskButton.setBounds(10, 10+(currentTaskNum-1)*55, 500, 50);
			taskDayLabel.setBounds(10+550, 10+(currentTaskNum-1)*55, 200, 50);
			taskTimeLabel.setBounds(10+800, 10+(currentTaskNum-1)*55, 200, 50);
			completedTaskButton.setBounds(10+1035, 25+(currentTaskNum-1)*55, 20, 20);
			deleteTaskButton.setBounds(10+1080, 10+(currentTaskNum-1)*55, 100, 50);
			
			completedTaskButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			taskTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			deleteTaskButton.setFont(new Font("Tahoma", Font.PLAIN, 15));;
			taskButton.setToolTipText(t.getDescription());
			
			Color taskButtonBackground = new Color(255,255,255);	
			
			if (t.isCompleted()) {
				taskButtonBackground = Color.GRAY;
				panel.add(deleteTaskButton);
			}
			
			taskDayLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			taskButton.setBackground(taskButtonBackground);
			taskDayLabel.setBackground(taskButtonBackground);
			taskTimeLabel.setBackground(taskButtonBackground);
			deleteTaskButton.setBackground(Color.RED);
			completedTaskButton.setBackground(Main.getChosenTheme().get(6));
			
			//aFolderBtn.setBackground(this.folderButtonColors.get(currentFolderIndex));
			panel.add(taskButton); 
			panel.add(completedTaskButton);
			panel.add(taskDayLabel);
			panel.add(taskTimeLabel); 
			
			
			taskButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object[] options = {"Delete",
                            "Edit","Cancel"};
              	  
			          int response = JOptionPane.showOptionDialog(null,
			              "What would you like to do?",
			              "Options",
			              JOptionPane.YES_NO_CANCEL_OPTION,
			              JOptionPane.QUESTION_MESSAGE,
			              null,
			              options,
			              options[2]);
			          if (response==0) {
			        	  folder.removeTask(t);
			        	  Main.getAllTasks().remove(t);
			          }
			          else if (response==1) {
			        	  KieyaAddTaskTestWindow frame2 = new KieyaAddTaskTestWindow(t,true,thisDesplay);
			        	  frame2.setVisible(true);
			          }
              	  runNewFolder(folder,folder.getID());
				} 
			});
			
			completedTaskButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if (t.isCompleted()==false) {
					try {
						t.setCompleted(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					completedTaskButton.setSelected(true);
				} 
				else {
					try {
						t.setCompleted(false);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					completedTaskButton.setSelected(false);
				}
				runNewFolder();
			}
			});
			
			
			taskButton.addMouseListener(new MouseAdapter() {
	               public void mousePressed(MouseEvent e) {
	            	   
	               }	               
	            });
			
			deleteTaskButton.addMouseListener(new MouseAdapter() {
	               public void mousePressed(MouseEvent e) {
			        	  folder.removeTask(t);
			        	  Main.getAllTasks().remove(t);
			        	  runNewFolder(folder,folder.getID());
	               }
	            });
			currentTaskNum+=1;
		}
		
//		JButton Folder1 = new JButton("Folder 1");
//		Folder1.setBackground(folder1Color);
//		Folder1.setBounds(263, 10, 175, 89);
//		panel_3.add(Folder1);
//		Folder1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				runNewFolder(folder, 4);                     //change
//			}
//		});
		
		JPanel SpritePanel = new JPanel();
		SpritePanel.setBackground(Color.WHITE);
		SpritePanel.setBounds(1263, 10, 241, 176);
		
//		SpriteForPanels sprite = new SpriteForPanels(frame,SpritePanel);
//		sprite.Score = 2;
//		sprite.update();
		Main.sprite.changeAttachments(frame, SpritePanel);
		

		frame.getContentPane().add(SpritePanel);
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue((int) (Main.sprite.Score * 20));
		progressBar.setBackground(Main.getChosenTheme().get(4));
		progressBar.setBounds(1263, 192, 241, 14);
		frame.getContentPane().add(progressBar);
		//frame.setBounds(0, 0, 1920, 1080);
		frame.setBounds(0, 0, 1545, 950);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main.sprite.update();
		
//		
		JButton AddNewTask = new JButton();
			BufferedImage icon = ImageIO.read(new File("texture/rsz_1plus-icon-13078_1.png")); 
			AddNewTask.setIcon(new ImageIcon(icon));
		AddNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Task task = new Task();
//				task.setFolder(folder);
				KieyaAddTaskTestWindow frame2 = new KieyaAddTaskTestWindow(task,true,thisDesplay);
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
			Main.sprite.update();
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
	
	public void runNewFolder() {
		this.reborn();
		try {
			new DesplayState2(this.frame, this.folderID);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void reborn() {
		Rectangle bounds = frame.getContentPane().getBounds();
		frame.getContentPane().removeAll();
//		frame.setBounds(0, 0, 1920, 1080);
		frame.setBounds(0, 0, 1545, 950);
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
