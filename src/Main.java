//package ballworlds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import util.Random;

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
	private static int width; 
	private static int height; 
	private static final Color[] BACKGROUND_COLORS = { Color.RED,
			Color.BLUE, Color.GREEN };
	private static HashMap<Folder, ArrayList<Task>> folder2Tasks = new HashMap<Folder, ArrayList<Task>>();
	private static HashMap<Task, ArrayList<Label>> task2Labels = new HashMap<Task, ArrayList<Label>>(); 
	private static HashMap<Label, ArrayList<Task>> label2Tasks = new HashMap<Label, ArrayList<Task>>(); 
	

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            ignored
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {		
		updateSize(); 
		//JFrame.setDefaultLookAndFeelDecorated(true);		//occasionally found code that makes the window slightly fancier
		JFrame pandativityFrame = new PandativityFrame();
		pandativityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pandativityFrame.setSize(new Dimension(width,height));
		JPanel navigationPanel = new JPanel();		
		
		// sprite testing
		
		try {SpriteNew
			sprite = new SpriteNew(pandativityFrame);
			System.out.println("We are after the sprite");
			sprite.Score = 2;
			
			for(int i = 0; i<10 ; i++){
				sprite.update();
				Thread.sleep(1 * 1000);
			}
			sprite.taskConpleted();
			
			for(int i = 0; i<500 ; i++){
				sprite.update();
				Thread.sleep(3 * 1000);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
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
	
	public static Set<Folder> getAllFolers(){
		return folder2Tasks.keySet(); 
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

}
