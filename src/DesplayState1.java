//Author: Nathan Atkinson
//Additional Contributors: Jesus Capo, Steven Xia, Kieya McClung

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DesplayState1 {

	static JFrame frame;
	private DesplayState1 thisDesplay;
	String sortMethod;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DesplayState1 window = new DesplayState1();
////					window.frame.getComponentAt(new Point(1300,100));
//					window.frame.setVisible(true);
//				} catch (Throwable e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @throws Throwable 
	 */
	public DesplayState1() throws Throwable {
		frame = new JFrame();
		initialize();
		Main.sprite.Score = 2;
	}
	
	public DesplayState1(JFrame frame) throws Throwable {
		this.frame = frame;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <SpriteForPanels>
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
//		frame = new JFrame();
		this.thisDesplay=this;
		frame.getContentPane().setBackground(Main.getChosenTheme().get(0));
		//frame.setBounds(0, 0, 1920, 1080);
		frame.setBounds(0, 0, 1545, 950);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		final JPanel OverviewPanel = new JPanel();                    /// might not be finle
//		OverviewPanel.setBackground(Main.getChosenTheme().get(1));
//		OverviewPanel.setBounds(724, 208, 806, 627);
//		frame.getContentPane().add(OverviewPanel);
		HomeOverviewPanel overviewPanel = new HomeOverviewPanel(724, 208, 806, 627,this.thisDesplay,frame); 
		frame.getContentPane().add(overviewPanel); 
		overviewPanel.setBackground(Main.getChosenTheme().get(1));
//		
		JPanel SpritePanel = new JPanel();
		SpritePanel.setBackground(Main.getChosenTheme().get(2));
		SpritePanel.setBounds(1028, 10, 241, 176);
		
		Main.sprite.changeAttachments(frame, SpritePanel);
//			SpriteForPanels sprite = new SpriteForPanels(frame, SpritePanel);
//			sprite.Score = 2;
		Main.sprite.update();
	
		
			
		frame.getContentPane().add(SpritePanel);
		
		JPanel AddTaskPanel = new JPanel();
		AddTaskPanel.setBackground(Main.getChosenTheme().get(3));
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
		//AddNewTask.setBackground(Main.getChosenTheme().get(1));
		//
			BufferedImage icon = ImageIO.read(new File("texture/rsz_1plus-icon-13078_1.png")); 
		
			AddNewTask.setIcon(new ImageIcon(icon));
		//
		AddNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Task task = new Task();
				KieyaAddTaskTestWindow frame2 = new KieyaAddTaskTestWindow(task,false,thisDesplay,frame);
				frame2.setVisible(true);
				
			}
		});
		//AddNewTask.setBounds(534, 516, 170, 170);
		AddNewTask.setBounds(270, 225, 170, 170);
		AddTaskPanel.add(AddNewTask);
		
		Main.getTimeLabel().create(0, 795, 157, 40);
		frame.add(Main.getTimeLabel(),1,0);
		
		JProgressBar PandaProgressBar = new JProgressBar();
		PandaProgressBar.setValue((int) (Main.sprite.Score * 20));
		PandaProgressBar.setBackground(Main.getChosenTheme().get(4));
		PandaProgressBar.setBounds(1028, 183, 241, 14);
		frame.getContentPane().add(PandaProgressBar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Main.getChosenTheme().get(5));
		panel.setBounds(10, 23, 704, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Steven Xia: For testing LabelButton only
//		Folder newFolder = new Folder("la",4); 
//		Label label = new Label("du"); 
//		panel.add(new LabelButton(newFolder, label, 10, 10, 120, 120));
		
		//Settings Button
		JPanel settingsButtonPanel = new JPanel();
		settingsButtonPanel.setBounds(1425, 5, 100, 100);
		settingsButtonPanel.setBackground(Color.WHITE);
		settingsButtonPanel.setLayout(null);
		settingsButtonPanel.setVisible(true);
		frame.add(settingsButtonPanel);
		
		JButton settingsButton = new JButton(); 
		settingsButton.setBackground(Main.getChosenTheme().get(5));
		//settingsButton.setBackground(Color.BLACK);
		BufferedImage settingsIcon = ImageIO.read(new File("texture/resized_settings.png")); 
		
		settingsButton.setIcon(new ImageIcon(settingsIcon));
		settingsButtonPanel.add(settingsButton);
		settingsButton.setBounds(0, 0, 100, 100);
		
		settingsButtonPanel.add(settingsButton);
		settingsButton.setBounds(0, 0, 100, 100);
		
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Object[] optionsOptions = {
                            Main.getLanguage().get("Help"),Main.getLanguage().get("Change Language"),Main.getLanguage().get("Change Theme"),Main.getLanguage().get("Done")}; //"Help","Change Language","Change Theme","Done"
		        	  Object[] helpOptions = {
		        			  Main.getLanguage().get("How to rename a folder"),Main.getLanguage().get("How to delete or edit a task"),Main.getLanguage().get("Done")};//"How to rename a folder","How to delete or edit a task","Done"
		        	  Object[] languageOptions = {
	                            "English","简体中文","Done"};//"English","简体中文","Done"
		        	  Object[] themeOptions = {
		        			  Main.getLanguage().get("Forest Green"),Main.getLanguage().get("Arctic Day"),Main.getLanguage().get("Moonlit Night"),Main.getLanguage().get("Volcano Paradise"),Main.getLanguage().get("Done")};//"Forest Green","Arctic Day","Moonlit Night","Done"
              	  
			          int optionsResponse = JOptionPane.showOptionDialog(null,
			        		  Main.getLanguage().get("How may we best assist you today?"),
			        		  Main.getLanguage().get("Options"),
			              JOptionPane.YES_NO_CANCEL_OPTION,
			              JOptionPane.QUESTION_MESSAGE,
			              null,
			              optionsOptions,
			              optionsOptions[3]);
			          if (optionsResponse==0) {		              	  
				          int helpResponse = JOptionPane.showOptionDialog(null,
				        		  Main.getLanguage().get("What would you like help with?"),
				        		  Main.getLanguage().get("Help Menu"),
					              JOptionPane.YES_NO_CANCEL_OPTION,
					              JOptionPane.QUESTION_MESSAGE,
					              null,
					              helpOptions,
					              helpOptions[2]);
				          if (helpResponse==0) {
				        	  JOptionPane.showMessageDialog(null, Main.getLanguage().get("Right click a folder, write the new name, and confirm the change."));
				          }
				          else if (helpResponse==1) {
				        	  JOptionPane.showMessageDialog(null, Main.getLanguage().get("Right click a task and you will be presented with the option to delete or edit the task."));
				          }
			          }
			          else if (optionsResponse==1) {
				          int languageResponse = JOptionPane.showOptionDialog(null,
					              Main.getLanguage().get("What language would you like?"),
					              Main.getLanguage().get("Language Selection"),
					              JOptionPane.YES_NO_CANCEL_OPTION,
					              JOptionPane.QUESTION_MESSAGE,
					              null,
					              languageOptions,
					              languageOptions[2]);
				          switch (languageResponse) {
				          case 0:
				        	  Main.getPreferences().set(0, 0);		        	  
				        	  break;
				          case 1:
				        	  Main.getPreferences().set(0, 1); 
				        	  break;
		                	 
		      				}
				          reborn();
	                	  try {
	                		  new DesplayState1(frame);
	      				} catch (Throwable e1) {
	      					// TODO Auto-generated catch block
	      					e1.printStackTrace();
				          }
			          }
			          
			          else if (optionsResponse==2) {
				          int themeResponse = JOptionPane.showOptionDialog(null,
				        		  Main.getLanguage().get("How would you like the application to appear?"),
				        		  Main.getLanguage().get("Theme Selection"),
					              JOptionPane.YES_NO_CANCEL_OPTION,
					              JOptionPane.QUESTION_MESSAGE,
					              null,
					              themeOptions,
					              themeOptions[4]);
				          switch (themeResponse) {
				          case 0:
				        	  Main.getPreferences().set(1, 0);		        	  
				        	  break;
				          case 1:
				        	  Main.getPreferences().set(1, 1); 
				        	  break;
				          case 2:
				        	  Main.getPreferences().set(1, 2);
				        	  break;
				          case 3:
				        	  Main.getPreferences().set(1, 3);
				        	  break;
		                	 
		      				}
				          reborn();
	                	  try {
	                		  new DesplayState1(frame);
	      				} catch (Throwable e1) {
	      					// TODO Auto-generated catch block
	      					e1.printStackTrace();
				          }
			          }
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//Sort Button
		JPanel sortButtonPanel = new JPanel();
		sortButtonPanel.setBounds(1425, 150, 100, 40);
		sortButtonPanel.setBackground(Main.getChosenTheme().get(5));
		sortButtonPanel.setLayout(null);
		sortButtonPanel.setVisible(true);
		frame.add(sortButtonPanel);
		
		JButton sortButton = new JButton("Sort"); 
		sortButton.setBackground(Main.getChosenTheme().get(5));
		
		sortButtonPanel.add(sortButton);
		sortButton.setBounds(0, 0, 100, 40);
		
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (sortMethod) {
				case "priority":
					break;
				case "due":
					sortMethod="priority";
					break;
				}

				reborn();
				try {
          		  new DesplayState1(frame);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
		          }
			}
		});
		
		//Adds all folder buttons with proper names
		System.out.println("Folder Count: "+Main.getAllFolders().size());
		for(final Folder f: Main.getAllFolders()) {
			int currentFolderIndex = f.getID();
			FolderButton aFolderBtn = new FolderButton(f,this.frame);
			aFolderBtn.setBackground(Color.WHITE);
			aFolderBtn.setBounds(10+(currentFolderIndex-1)*188, 10, 120, 60);
			panel.add(aFolderBtn); 
//			aFolderBtn.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					runNewFolder(f.getID());
//				}
//			});
			aFolderBtn.addMouseListener(new MouseAdapter() {
	               public void mousePressed(MouseEvent e) {
	                  if (e.getButton() == MouseEvent.BUTTON3) {
	                	  String newFolderName = (String)JOptionPane.showInputDialog(
	                              null,
	                              Main.getLanguage().get("Rename folder"), 
	                              Main.getLanguage().get("Rename folder"),            
	                              JOptionPane.PLAIN_MESSAGE,
	                              null,            
	                              null, 
	                              f.getTitle()
	                           );
	                	  if (!newFolderName.isEmpty()) {
	                		  f.setTitle(newFolderName);
	                	  }
	                	  reborn();
	        	      	  try {
	        	      		  new DesplayState1(frame);
	        				} catch (Throwable e1) {
	        					// TODO Auto-generated catch block
	        					e1.printStackTrace();
	        				}
	                  }
	               }
	            });
		}
		


//		Folder_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				runNewFolder(2);
//			}
//		});

		
//		JLabel BackDrop = new JLabel("");
//		BackDrop.setIcon(new ImageIcon(DesplayState1.class.getResource("texture/BackDrop.png"))); // change to backround
//		BackDrop.setBounds(0, 0, 1540, 845);
//		frame.getContentPane().add(BackDrop);

	}
	
	private void runNewFolder(int folderID) {
//		frame.setVisible(false);
		reborn(); 
		
		try {
			new DesplayState2(frame,folderID);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		}
	}
	
//	private void runNewFolder(Folder folder, int folderID) {
//		reborn();
//		try {
//			new DesplayState2(frame , folder, folderID);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	
	public static void reborn() {
		Rectangle bounds = frame.getContentPane().getBounds();
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
