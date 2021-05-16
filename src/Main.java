//package ballworlds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.awt.EventQueue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import util.Random;
//Hello lemons and words!

/**
 * The starting point for the Pandativty application. It opens the pandativity frame.
 * 
 * This app is created by Nathan Atkinson, Jesus Capo, John Chung, Steven Xia, and Kieya McClung.
 */
public class Main {
	//Single monitor, fails for some reason
	//private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	//Multiple monitor
	private static GraphicsDevice gd; 
	private static JFrame frame;
	public SpriteForPanels sprite;
	
	private static int width; 
	private static int height; 
//	private static final Color[] BACKGROUND_COLORS = { Color.RED,
//			Color.BLUE, Color.GREEN };
	private static ArrayList<Task> tasksList = new ArrayList<Task>();
	private static ArrayList<Folder> foldersList = new ArrayList<Folder>();
	private static ArrayList<Label> labelsList = new ArrayList<Label>();
	private static ArrayList<Integer> preferencesList = new ArrayList<Integer>();
	
	//color arrays
	private static ArrayList<Color> forestGreenTheme = new ArrayList<Color>();
	private static ArrayList<Color> arcticDayTheme = new ArrayList<Color>();
	private static ArrayList<Color> moonlitNightTheme = new ArrayList<Color>();
			
	private static HashMap<Folder, ArrayList<Task>> folder2Tasks = new HashMap<Folder, ArrayList<Task>>();
	private static HashMap<Task, ArrayList<Label>> task2Labels = new HashMap<Task, ArrayList<Label>>(); 
	private static HashMap<Label, ArrayList<Task>> label2Tasks = new HashMap<Label, ArrayList<Task>>(); 
	
	

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {		
		updateSize(); 
		frame = new JFrame();
		JFrame.setDefaultLookAndFeelDecorated(true);		//occasionally found code that makes the window slightly fancier
		preferencesList.add(0); 
		preferencesList.add(0); 
		
		forestGreenTheme.add(new Color(107, 142, 35)); //Background color
		forestGreenTheme.add(new Color(105, 105, 105));//OverviewPanel color
		forestGreenTheme.add(new Color(255, 255, 255));//Spritepanel color
		forestGreenTheme.add(new Color(112, 128, 144));//Taskpanel color
		forestGreenTheme.add(new Color(34, 139, 34));//Progress bar color
		forestGreenTheme.add(new Color(160, 82, 45));// Navigation Panel Color
		forestGreenTheme.add(new Color(143, 188, 143));// Folder view color
		forestGreenTheme.add(new Color(102, 153, 51)); //Addtask panel color
		forestGreenTheme.add(new Color(102, 153, 0)); //Addtask panel options 1 color
		
		arcticDayTheme.add(new Color(240, 255, 255)); //Background color
		arcticDayTheme.add(new Color(200, 240, 250));//OverviewPanel color
		arcticDayTheme.add(new Color(200, 255, 255));//Spritepanel color
		arcticDayTheme.add(new Color(200, 255, 255));//Taskpanel color
		arcticDayTheme.add(new Color(200, 255, 255));//Progress bar color
		arcticDayTheme.add(new Color(200, 255, 255));// Navigation Panel Color
		arcticDayTheme.add(new Color(200, 255, 255));// Folder view color
		arcticDayTheme.add(new Color(230, 255, 255)); //Addtask panel color
		arcticDayTheme.add(new Color(220, 255, 255)); //Addtask options 1 color
		
		moonlitNightTheme.add(new Color(0, 20, 20)); //Background color
		moonlitNightTheme.add(new Color(0, 40, 40));//OverviewPanel color
		moonlitNightTheme.add(new Color(160, 160, 40));//Spritepanel color
		moonlitNightTheme.add(new Color(0, 40, 40));//Taskpanel color
		moonlitNightTheme.add(new Color(160, 160, 40));//Progress bar color
		moonlitNightTheme.add(new Color(160, 160, 40));// Navigation Panel Color
		moonlitNightTheme.add(new Color(0, 40, 40));// Folder view color
		moonlitNightTheme.add(new Color(0, 60, 60)); //Addtask panel color
		moonlitNightTheme.add(new Color(80, 100, 170)); //Addtask panel options 1 color
		
		//INITIALIZE FILES
//		Folder folder1 = new Folder("folder1",1);
//		Folder folder2 = new Folder("folder2",2);
//		Folder folder3 = new Folder("folder3",3);
//		Folder folder4 = new Folder("folder4",4);
//		
//		
//		foldersList.add(folder1);
//		foldersList.add(folder2);
//		foldersList.add(folder3);
//		foldersList.add(folder4);
//		
		
		//READ DATA FROM FILES

		final Saver saver = new Saver();
		saver.read(preferencesList,tasksList,foldersList,labelsList);
		System.out.println(foldersList.size());
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	saver.save(preferencesList,tasksList,foldersList,labelsList); 
	            System.out.println("Saved");
	        }
	    }, "Shutdown-thread"));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesplayState1 window = new DesplayState1();
//					DesplayState1 window = new DesplayState1(this.sprite);   // new sprite methed Nathan
//					window.frame.getComponentAt(new Point(1300,100));
					window.frame.setVisible(true);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});

		
//		//SETUP FRAMES
//		JFrame pandativityFrame = new PandativityFrame();
//		pandativityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pandativityFrame.setSize(new Dimension(width,height));
//		JPanel navigationPanel = new JPanel();	

//		
//		try {
//			//DATA
//            FileOutputStream data = new FileOutputStream("data.txt");
//
//            ObjectOutputStream output = new ObjectOutputStream(data);
//
//            output.writeInt(data1);
//            output.writeObject(data2);
//
//            FileInputStream fileStream = new FileInputStream("data.txt");
//            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
//
//            System.out.println(objectStream.readInt());
//            System.out.println(objectStream.readObject());
//
//            output.close();
//            objectStream.close();
//            
////			//TEST SPRITE
////			SpriteNew sprite = new SpriteNew(pandativityFrame);
////			System.out.println("We are after the sprite");
////			sprite.Score = 2;
////			
////			for(int i = 0; i<10 ; i++){
////				sprite.update();
////				Thread.sleep(1 * 1000);
////			}
////			sprite.taskConpleted();
////			
////			for(int i = 0; i<500 ; i++){
////				sprite.update();
////				Thread.sleep(3 * 1000);
////			}
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			e.getStackTrace();
//		}
	}


	public static int getWidth() {
		updateSize(); 
		return width; 
	}
	
	public static int getHeight() {
		updateSize(); 
		return height; 
	}
	
	public static void updateSize() {
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth()/2;
		height = gd.getDisplayMode().getHeight()/2;
		//System.out.println("Width: "+width*2+"Height: "+height*2); 
	}
	
	//should this return the folder list not folder2tasks? - Kieya
//	public static Set<Folder> getAllFolders(){
//		return folder2Tasks.keySet(); 
//		
//	}
	public static ArrayList<Folder> getAllFolders(){
		return foldersList; 
	}
	
	public static ArrayList<Task> getAllTasks(){
		return tasksList; 
	}
	
	public static Set<Label> getAllLabels(){
		return label2Tasks.keySet();  
	}
	
	public static ArrayList<Task> getTasksByFolder(Folder folder) {
		return folder2Tasks.get(folder); 
	}
	
	public static ArrayList<Label> getLabelsByTask(Task task){
		return task2Labels.get(task); 
	}
	
	public static ArrayList<Task> getTasksByLabel(Label label){
		return label2Tasks.get(label); 
	}
	
	public static ArrayList<Integer> getPreferences(){
		return preferencesList; 
	}
	
	public static ArrayList<Color> getChosenTheme(){
		switch (preferencesList.get(1)) {
			case 0:
				return forestGreenTheme;
			case 1:
				return arcticDayTheme;
			case 2:
				return moonlitNightTheme;
		}
		return forestGreenTheme;
	}
	
	public static void addTaskToFolder(Task task, Folder folder) {
		registerFolder(folder); 
		folder2Tasks.get(folder).add(task); 
	}
	
	public static void addLabelToTask(Label label, Task task) {
		registerLabel(label); 
		task2Labels.get(task).add(label); 
		label2Tasks.get(label).add(task); 
	}
	
	/**
	 * Returns true if the folder is registered successfully, false if not, meaning the folder is already registered 
	 * @param folder
	 * @return
	 */
	public static boolean registerFolder(Folder folder) {
		if(folder2Tasks.containsKey(folder)) {
			return false; 
		}else {
			folder2Tasks.put(folder, new ArrayList<Task>()); 
			return true; 
		}
	}
	
	/**
	 * Returns true if the label is registered successfully, false if not, meaning the label is already registered 
	 * @param folder
	 * @return
	 */
	public static boolean registerLabel(Label label) {
		if(label2Tasks.containsKey(label)) {
			return false; 
		}else {
			label2Tasks.put(label, new ArrayList<Task>()); 
			return true; 
		}
	}
	public void updateSprite() throws Exception {
	this.sprite.update();
	}
	
	public void taskConpleted() throws Exception {
		this.sprite.taskConpleted();
		}

}
