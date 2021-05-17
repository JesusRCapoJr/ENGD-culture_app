//package ballworlds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
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
	public static SpriteForPanels sprite;
	
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
	
	//languages
	private static HashMap<String, String> chinese = new HashMap<String, String>();
	private static HashMap<String, String> english = new HashMap<String, String>();
			
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
		
		//GENERAL
		english.put("Done", "Done"); //
		english.put("Cancel","Cancel"); //
		english.put("Options", "Options");
		english.put("What would you like to do?", "What would you like to do?"); //
		
		chinese.put("Done", "1"); //
		chinese.put("Cancel","2"); //
		chinese.put("Options", "3");
		chinese.put("What would you like to do?", "4"); //
		
		//OPTIONS MENU options
		english.put("Options", "Options");
		english.put("How may we best assist you today?", "How may we best assist you today?");
		english.put("Help", "Help"); //
		english.put("Change Language","Change Language"); //
		english.put("Change Theme","Change Theme"); //
		
		chinese.put("Options", "5");
		chinese.put("How may we best assist you today?", "6");
		chinese.put("Help", "7"); //
		chinese.put("Change Language","8"); //
		chinese.put("Change Theme","9"); //
		
		//HELP MENU options
		english.put("Help Menu", "Help Menu"); //
		english.put("What would you like help with?","What would you like help with?"); //
		english.put("How to rename a folder","How to rename a folder"); //
		english.put("How to delete or edit a task","How to delete or edit a task"); //
		
		chinese.put("Help Menu", "10"); //
		chinese.put("What would you like help with?","11"); //
		chinese.put("How to rename a folder","12"); //
		chinese.put("How to delete or edit a task","13"); //
		
		//HELP MENU results
		english.put("Right click a folder, write the new name, and confirm the change.", "Right click a folder, write the new name, and confirm the change."); //
		english.put("Right click a task and you will be presented with the option to delete or edit the task.", "Right click a task and you will be presented with the option to delete or edit the task."); //
		
		chinese.put("Right click a folder, write the new name, and confirm the change.", "14"); //
		chinese.put("Right click a task and you will be presented with the option to delete or edit the task.", "15"); //
		
		//LANGUAGES MENU options
		english.put("Language Selection", "Language Selection"); //
		english.put("What language would you like?", "What language would you like?"); //
		
		chinese.put("Language Selection", "16"); //
		chinese.put("What language would you like?", "17"); //
		
		//THEMES options
		english.put("Theme Selection", "Theme Selection");
		english.put("How would you like the application to appear?","How would you like the application to appear?");
		english.put("Forest Green","Forest Green"); //
		english.put("Arctic Day","Arctic Day"); //
		english.put("Moonlit Night","Moonlit Night"); //
		
		chinese.put("Theme Selection", "18");
		chinese.put("How would you like the application to appear?","19");
		chinese.put("Forest Green","20"); //
		chinese.put("Arctic Day","21"); //
		chinese.put("Moonlit Night","22"); //
		
		//MISC
		english.put("Rename folder","Rename folder"); //
		english.put("Home","Home"); //
		english.put("Delete","Delete"); //
		english.put("Edit","Edit"); //
		
		chinese.put("Rename folder","23"); //
		chinese.put("Home","24"); //
		chinese.put("Delete","25"); //
		chinese.put("Edit","26"); //
		
		//ADD TASK PANEL
		english.put("Title","Title"); //
		english.put("Description","Description"); //
		english.put("Select designation folder","Select designation folder"); //
		english.put("Folder","Folder"); //
		english.put("Select label","Select label"); //
		english.put("Select priority","Select priority"); //
		english.put("Low","Low"); //
		english.put("Medium","Medium"); //
		english.put("High","High"); //
		english.put("Due Date:","Due Date:"); //
		english.put("Time:","Time:"); //
		english.put("Label","Label"); //
		english.put("Priority","Priority"); //
		english.put("Title","Title"); //
		
		chinese.put("Title","27"); //
		chinese.put("Description","28"); //
		chinese.put("Select designation folder","29"); //
		chinese.put("Folder","30"); //
		chinese.put("Select label","31"); //
		chinese.put("Select priority","32"); //
		chinese.put("Low","33"); //
		chinese.put("Medium","34"); //
		chinese.put("High","35"); //
		chinese.put("Due Date:","36"); //
		chinese.put("Time:","37"); //
		chinese.put("Label","38"); //
		chinese.put("Priority","39"); //
		chinese.put("Title","40"); //
		
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
//		preferencesList.add(0); 
//		preferencesList.add(0); 
//		
		
//		
		
		//READ DATA FROM FILES

		final Saver saver = new Saver();
		//saver.save(preferencesList,tasksList,foldersList,labelsList); 
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
					createNewSprite();
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
		
		
//		System.out.println("we are outside of the timer");     // atemped one in having a globle update...
//		Timer timer = new Timer();
//		TimerTask task = new TimerTask() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					Main.sprite.update();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		};
//		timer.schedule(task, 10);
//		System.out.println("look the timer worked");
		
		GlobleUpdate GU = new GlobleUpdate();
		GU.start();
		
	}// end of main


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
	
	public static HashMap<String, String> getLanguage(){
		switch (preferencesList.get(0)) {
			case 0:
				return english;
			case 1:
				return chinese;
		}
		return english;
	}
	
	public static void addTaskToFolder(Task task, Folder folder) {
		registerFolder(folder); 
		folder.addTask(task);
	}
	
	public static void addLabelToTask(Label label, Task task) {
		registerLabel(label); 
		task.setLabel(label.getText());
	}
	
	/**
	 * Returns true if the folder is registered successfully, false if not, meaning the folder is already registered 
	 * @param folder
	 * @return
	 */
	public static boolean registerFolder(Folder folder) {
		if(foldersList.contains(folder)) {
			return false; 
		}else {
			foldersList.add(folder);
			return true; 
		}
	}
	
	/**
	 * Returns true if the label is registered successfully, false if not, meaning the label is already registered 
	 * @param folder
	 * @return
	 */
	public static boolean registerLabel(Label label) {
		if(labelsList.contains(label)) {
			return false; 
		}else {
			labelsList.add(label);
			return true; 
		}
	}
	
	public SpriteForPanels getSprite() {
		return this.sprite;
		}
	
	public void updateSprite() throws Exception {
	this.sprite.update();
	}
	
	public void taskConpleted() throws Exception {
		this.sprite.taskConpleted();
		}
	private static void createNewSprite() throws HeadlessException, IOException {
		sprite = new SpriteForPanels(new JFrame(), new JPanel());
	}
	
	/**
	 * Sorts tasks (ArrayList) by method specified. Options available for the second parameter are "due", "priority" and "dueAndPriority". 
	 * WARNING: The limits of priority is hard-coded ([0,3]) in sort by priority option. 
	 * @param tasks
	 * @param method
	 */
	public static void sortTasksBy(ArrayList<Task> tasks, String method) {
		
		if(tasks == null) {
			System.out.println("Main.sortTasksBy() says to you: Nope. ArrayList tasks is null!");
			return; 
		}
		
		if(method.equals("due")) {
			
			//Gets all due dates and store them together with all Tasks
			HashMap<Double, ArrayList<Task>> dueTasks = new HashMap<Double, ArrayList<Task>>(); 
			for(Task t:tasks) {
				double rawDue = getDueRaw(t); 
				if(dueTasks.get(rawDue) == null) {
					dueTasks.put(rawDue, new ArrayList<Task>()); 
				}
				dueTasks.get(rawDue).add(t); 
			}
			
			
			//Sorts dues in an increasing order 
			double min = 302105162202.0; //1000 year after I coded this, the program will no longer run... 
			double currentMax = 0.0; 
			ArrayList<Double> dues = new ArrayList<Double>(); 
			
			for(double j:dueTasks.keySet()) {
				for(double i:dueTasks.keySet()) {
					//System.out.println("i value: "+i);
					if(i < min && i >= currentMax) {
						min = i; 
					}
				}
				currentMax = min; 
				//System.out.println("min value: "+min);
				dues.add(min); 
			}
			
			
			//Finally, put them back
			tasks.clear();
			
			for(double j:dues) {
				for(Task t: dueTasks.get(j)) {
					tasks.add(t); 
				}
			}
			
			
			
		}else if(method.equals("priority")) {
			
			//Gets all priorities and store them together with all Tasks
			HashMap<Integer, ArrayList<Task>> priorTasks = new HashMap<Integer, ArrayList<Task>>(); 
			for(Task t:tasks) {
				int priority = t.getPriority(); 
				if(priorTasks.get(priority) == null) {
					priorTasks.put(priority, new ArrayList<Task>()); 
				}
				priorTasks.get(priority).add(t); 
			}
			
			//Put them back
			tasks.clear();
			
			for(int i=0; i<5; i++) {
				if(priorTasks.get(i) != null) {
					for(Task t:priorTasks.get(i)) {
						tasks.add(t); 
					}
				}
			}
			
		}else if(method.equals("dueAndPriority")){
			
			//Sort by due
			sortTasksBy(tasks, "due"); 
			
			//Prepare and sort by priority in each time slot
			ArrayList<ArrayList<Task>> tasksStrips = new ArrayList<ArrayList<Task>>(); 
			double currentDue = 0; 
			int index = -1; 
			for(Task t:tasks) {
				System.out.println(getDueRaw(t));
				if(getDueRaw(t) != currentDue) {
					ArrayList<Task> aStrip = new ArrayList<Task>(); 
					aStrip.add(t); 
					tasksStrips.add(aStrip); 
					index++; 
				}else {
					if(index < 0) {
						index = 0; 
					}
					tasksStrips.get(index).add(t); 
				}
			}
			
			for(int i=0;i<tasksStrips.size();i++) {
				sortTasksBy(tasksStrips.get(i),"priority"); 
			}
			
			//Finally, put them back
			tasks.clear();
			
			for(int i=0;i<tasksStrips.size();i++) {
				for(Task t:tasksStrips.get(i)) {
					tasks.add(t); 
				}
			}
			
		}else {
			System.out.println("Main.sortTasksBy() says to you: You made a typo :O");
		}
	}
	
	/**
	 * Returns the raw form of due: yyyymmddhhmm in double. 
	 * @param task
	 * @return dateTimeRawInt
	 */
	public static double getDueRaw(Task task) {
		String date = "2500/01/01"; 
		String time = "00:00"; 
		if(task.getDueDate() != null && !task.getDueDate().equals("yyyy/mm/dd")) {
			date = task.getDueDateString(); 
			if(date.length() != 10) {
				System.out.println("Due date has an error in format :( Expected yyyy/mm/dd, got "+date);
				date = "2500/01/01"; 
			}
		}
		if(task.getDueTime() != null) {
			time = task.getDueTime(); 
			if(time.length() != 5) {
				System.out.println("Due time has an error in format :( Expected hh:mm, got "+time);
				time = "00:00"; 
			}
		}
		String dateTimeRaw = date.substring(0,4)+date.substring(5,7)+date.substring(8,10)+time.substring(0,2)+time.substring(3,5);
		//System.out.println("date: "+date+" time: "+time+" dateTimeRaw: "+dateTimeRaw);
		double dateTimeRawInt = 0.0; 
		
		int l = dateTimeRaw.length() - 1; 
		for(int i=0; i<=l; i++) {
			double digit = 0; 
			switch(dateTimeRaw.charAt(l-i)) {
			case '1': 
				digit = 1; 
				break; 
			case '2': 
				digit = 2;
				break;
			case '3':
				digit = 3;
				break; 
			case '4':
				digit = 4;
				break; 
			case '5': 
				digit = 5;
				break; 
			case '6': 
				digit = 6;
				break; 
			case '7': 
				digit = 7; 
				break; 
			case '8': 
				digit = 8; 
				break; 
			case '9': 
				digit = 9; 
				break; 
			default: 
			}
			dateTimeRawInt += digit * Math.pow(10, i); 
			//System.out.println("What the hack: "+digit+", "+Math.pow(10, i));
		} 
		
		if(dateTimeRawInt == 0) {
			return 250001010000.0; 
		}
		//System.out.println(dateTimeRawInt);
		return dateTimeRawInt; 
	}

}
