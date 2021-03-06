//Author: Jesus Capo, Edited By: All

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;


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
	public static SpriteForPanels sprite;
	public static TimeLabel timeLabel;
	
	private static int width; 
	private static int height; 
	
	public static ArrayList<Task> tasksList = new ArrayList<Task>();
	private static ArrayList<Folder> foldersList = new ArrayList<Folder>();
	private static ArrayList<Label> labelsList = new ArrayList<Label>();
	private static ArrayList<Integer> preferencesList = new ArrayList<Integer>();
	
	//color arrays
	private static ArrayList<Color> forestGreenTheme = new ArrayList<Color>();
	private static ArrayList<Color> arcticDayTheme = new ArrayList<Color>();
	private static ArrayList<Color> moonlitNightTheme = new ArrayList<Color>();
	private static ArrayList<Color> volcanoParadiseTheme = new ArrayList<Color>();
	
	//languages
	private static HashMap<String, String> chinese = new HashMap<String, String>();
	private static HashMap<String, String> english = new HashMap<String, String>();	

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {	
		
		//updateSize(); 
		JFrame.setDefaultLookAndFeelDecorated(true);		//occasionally found code that makes the window slightly fancier
		
		timeLabel = new TimeLabel();
		
		forestGreenTheme.add(new Color(107, 142, 35)); //Background color
		forestGreenTheme.add(new Color(105, 105, 105));//OverviewPanel color
		forestGreenTheme.add(new Color(255, 255, 255));//Spritepanel color
		forestGreenTheme.add(new Color(112, 128, 144));//Taskpanel color
		forestGreenTheme.add(new Color(34, 139, 34));//Progress bar color
		forestGreenTheme.add(new Color(160, 82, 45));// Navigation Panel Color
		forestGreenTheme.add(new Color(143, 188, 143));// Folder view color
		forestGreenTheme.add(new Color(102, 153, 51)); //Addtask panel color
		forestGreenTheme.add(new Color(102, 153, 0)); //Addtask panel options 1 color
		forestGreenTheme.add(new Color(255, 255, 0)); //Task Highlight Color
		
		arcticDayTheme.add(new Color(240, 255, 255)); //Background color
		arcticDayTheme.add(new Color(200, 240, 250));//OverviewPanel color
		arcticDayTheme.add(new Color(200, 255, 255));//Spritepanel color
		arcticDayTheme.add(new Color(200, 255, 255));//Taskpanel color
		arcticDayTheme.add(new Color(200, 255, 255));//Progress bar color
		arcticDayTheme.add(new Color(200, 240, 250));// Navigation Panel Color
		arcticDayTheme.add(new Color(200, 255, 255));// Folder view color
		arcticDayTheme.add(new Color(230, 255, 255)); //Addtask panel color
		arcticDayTheme.add(new Color(220, 255, 255)); //Addtask options 1 color
		arcticDayTheme.add(new Color(200, 230, 255)); //Task Highlight Color
		
		moonlitNightTheme.add(new Color(0, 20, 20)); //Background color
		moonlitNightTheme.add(new Color(0, 40, 40));//OverviewPanel color
		moonlitNightTheme.add(new Color(160, 160, 40));//Spritepanel color
		moonlitNightTheme.add(new Color(0, 40, 40));//Taskpanel color
		moonlitNightTheme.add(new Color(160, 160, 40));//Progress bar color
		moonlitNightTheme.add(new Color(160, 160, 40));// Navigation Panel Color
		moonlitNightTheme.add(new Color(0, 40, 40));// Folder view color
		moonlitNightTheme.add(new Color(0, 60, 60)); //Addtask panel color
		moonlitNightTheme.add(new Color(80, 100, 170)); //Addtask panel options 1 color
	    moonlitNightTheme.add(new Color(0, 120, 120)); //Task Highlight Color
		
		volcanoParadiseTheme.add(new Color(40, 20, 20)); //Background color
		volcanoParadiseTheme.add(new Color(180, 40, 40));//OverviewPanel color
		volcanoParadiseTheme.add(new Color(180, 30, 40));//Spritepanel color
		volcanoParadiseTheme.add(new Color(180, 40, 40));//Taskpanel color
		volcanoParadiseTheme.add(new Color(180, 160, 40));//Progress bar color
		volcanoParadiseTheme.add(new Color(140, 10, 0));// Navigation Panel Color
		volcanoParadiseTheme.add(new Color(180, 40, 40));// Folder view color
		volcanoParadiseTheme.add(new Color(200, 60, 60)); //Addtask panel color
		volcanoParadiseTheme.add(new Color(200, 30, 60)); //Addtask panel options 1 color
		volcanoParadiseTheme.add(new Color(245, 50, 50)); //Task Highlight Color
		
		//GENERAL
		english.put("Done", "Done"); //
		english.put("Cancel","Cancel"); //
		english.put("Options", "Options");
		english.put("What would you like to do?", "What would you like to do?"); //
		
		chinese.put("Done", "完成"); //
		chinese.put("Cancel","取消"); //
		chinese.put("Options", "选项");
		chinese.put("What would you like to do?", "您想做什么？"); //
		//chinese.put("What would you like to do?", "则撒？"); //A more aggressive way of asking... 
		
		//OPTIONS MENU options
		english.put("Options", "Options");
		english.put("How may we best assist you today?", "How may we best assist you today?");
		english.put("Help", "Help"); //
		english.put("Change Language","Change Language"); //
		english.put("Change Theme","Change Theme"); //
		
		chinese.put("Options", "选项");
		chinese.put("How may we best assist you today?", "您希望我做什么？");
		chinese.put("Help", "帮助"); //
		chinese.put("Change Language","更改语言"); //
		chinese.put("Change Theme","更改颜色主题"); //
		
		//HELP MENU options
		english.put("Help Menu", "Help Menu"); //
		english.put("What would you like help with?","What would you like help with?"); //
		english.put("How to rename a folder","How to rename a folder"); //
		english.put("How to delete or edit a task","How to delete or edit a task"); //
		
		chinese.put("Help Menu", "帮助菜单"); //
		chinese.put("What would you like help with?","如何..."); //
		chinese.put("How to rename a folder","重命名文件夹"); //
		chinese.put("How to delete or edit a task","编辑或删除任务"); //
		
		//HELP MENU results
		english.put("Right click a folder, write the new name, and confirm the change.", "Right click a folder, write the new name, and confirm the change."); //
		english.put("Click a task and you will be presented with the option to delete or edit the task.", "Click a task and you will be presented with the option to delete or edit the task."); //
		
		chinese.put("Right click a folder, write the new name, and confirm the change.", "右键文件夹以重命名"); //
		chinese.put("Right click a task and you will be presented with the option to delete or edit the task.", "右键任务以编辑或删除"); //TRANSLATE
		
		//LANGUAGES MENU options
		english.put("Language Selection", "Language Selection"); //
		english.put("What language would you like?", "What language would you like?"); //
		
		chinese.put("Language Selection", "选择语言"); //
		chinese.put("What language would you like?", "您说什么语言？"); //
		
		//THEMES options
		english.put("Theme Selection", "Theme Selection");
		english.put("How would you like the application to appear?","How would you like the application to appear?");
		english.put("Forest Green","Forest Green"); //
		english.put("Arctic Day","Arctic Day"); //
		english.put("Moonlit Night","Moonlit Night"); //
		english.put("Volcano Paradise","Volcano Paradise"); //
		
		chinese.put("Theme Selection", "选择颜色主题");
		chinese.put("How would you like the application to appear?","更改颜色主题");
		chinese.put("Forest Green","森林"); //
		chinese.put("Arctic Day","北极"); //
		chinese.put("Moonlit Night","月夜"); //
		chinese.put("Volcano Paradise","Volcano Paradise"); //
		
		//MISC
		english.put("Rename folder","Rename folder"); //
		english.put("Home","Home"); //
		english.put("Delete","Delete"); //
		english.put("Edit","Edit"); //
		
		chinese.put("Rename folder","重命名文件夹"); //
		chinese.put("Home","返回主页"); //
		chinese.put("Delete","删除"); //
		chinese.put("Edit","编辑"); //
		
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
		english.put("Please select a folder!","Please select a folder!");
		//english.put("Title","Title"); //
		
		
		chinese.put("Title","任务名（必填）"); //
//		chinese.put("Title",""); //
		chinese.put("Description","描述"); //
		chinese.put("Select designation folder","选择文件夹（必填）"); //
		chinese.put("Folder","选择文件夹"); //
		chinese.put("Select label","选择标签"); //
		chinese.put("Select priority","选择优先度"); //
		chinese.put("Low","低"); //
		//chinese.put("Low","别忘了就好"); //More of the same meaning... 
		chinese.put("Medium","中"); //
		chinese.put("High","高"); //
		chinese.put("Due Date:","计划完成日期"); //
		chinese.put("Time:","时间"); //
		chinese.put("Label","标签"); //
		chinese.put("Priority","优先度"); //
		chinese.put("Please select a folder!","Please select a folder!");
		
		//AddLabelFrame
		english.put("Label name: ", "Label name: "); 
		chinese.put("Label name: ", "标签名"); 
		
		//AddLabelButton
		english.put("Add a label", "Add a label"); 
		chinese.put("Add a label", "增加标签"); 
		
		//INITIALIZE FILES - DO NOT DELETE THESE COMMENTS - UNCOMMENT WHEN NEED TO INITIALIZE
//		Folder folder1 = new Folder("folder1",1);
//		Folder folder2 = new Folder("folder2",2);
//		Folder folder3 = new Folder("folder3",3);
//		Folder folder4 = new Folder("folder4",4);
//		
//		
//		registerFolder(folder1); 
//		System.out.println("folders"+foldersList.size());
//		registerFolder(folder2); 
//		System.out.println("folders"+foldersList.size());
//		registerFolder(folder3); 
//		System.out.println("folders"+foldersList.size());
//		registerFolder(folder4); 
//		System.out.println("folders"+foldersList.size());
//		
//		preferencesList.add(0); 
//		preferencesList.add(0); 
//		
		
//		
		
		//READ DATA FROM FILES

		final Saver saver = new Saver();
		//saver.save(preferencesList,tasksList,foldersList,labelsList); 
		saver.read(preferencesList,tasksList,foldersList,labelsList);
		System.out.println("folders"+foldersList.size());
		System.out.println(foldersList.get(3).getTitle());
		System.out.println("tasks"+tasksList.size());
		
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

		//For testing purposes so there won't be a thousand invisible labels... 
//		labelsList.clear();
//		for(Folder f:foldersList) {
//			f.getLabels().clear();
//		}
		
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


	/**
	 * 
	 * @return width. 
	 */
	public static int getWidth() {
		updateSize(); 
		return width; 
	}
	
	/**
	 * 
	 * @return height. 
	 */
	public static int getHeight() {
		updateSize(); 
		return height; 
	}
	
	/**
	 * Updates width and height to current screen resolution times some hard-coded ratio (currently (0.5, 0.5)). 
	 * Did not end up using, may show up in the future. 
	 */
	public static void updateSize() {
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth()/2;
		height = gd.getDisplayMode().getHeight()/2;
	}
	
	public static ArrayList<Folder> getAllFolders(){
		return foldersList; 
	}
	
	public static ArrayList<Task> getAllTasks(){
		return tasksList; 
	}
	
	public static ArrayList<Label> getAllLabels(){
		return labelsList;  
	}
	
	//Steven Xia: getXxxByXxx are already implemented in Folder, Task and Label classes. They'll never show up again. 
	
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
			case 3:
				return volcanoParadiseTheme;
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
	 * Registers the label. 
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
	
	/**
	 * Removes folder. Returns true if successful, false if not. 
	 * @param folder
	 * @return 
	 */
	public static boolean removeFolder(Folder folder) {
		if(foldersList.contains(folder)) {
			foldersList.remove(folder); 
			return true; 
		}else {
			return false; 
		}
	}
	
	/**
	 * Removes registration of label. 
	 * @param label
	 * @return true if successfully removed label. false if not, meaning label doesn't exist. 
	 */
	public static boolean removeLabel(Label label) {
		if(labelsList.contains(label)) {
			labelsList.remove(label); 
			return true; 
		}else {
			return false; 
		}
	}
	
	public SpriteForPanels getSprite() {
		return this.sprite;
		}
	
	public void updateSprite() throws Exception {
		this.sprite.update();
	}
	
	public void updateTimeLabel() throws Exception {
		this.timeLabel.update();
	}
	
	public static TimeLabel getTimeLabel() {
		return timeLabel;
	}
	
	public void taskConpleted() throws Exception {
		this.sprite.taskConpleted();
	}
	
	private static void createNewSprite() throws HeadlessException, IOException {
		sprite = new SpriteForPanels(new JFrame(), new JPanel());
	}

	//SORT BY DUE DATE
	
	public static ArrayList<Task> sortTasksBy(ArrayList<Task> inputTasks, String method) throws ParseException {
		
		ArrayList<Task> sortedTasks = new ArrayList<Task>();
		
		if(inputTasks == null) {
			System.out.println("Main.sortTasksBy() says to you: Nope. ArrayList tasks is null!");
			return sortedTasks; 
		}
		
		if (method.equals("due")) {
			for (Task inputT : inputTasks) { //Loop through each task
				int sortSize = sortedTasks.size();
				if (sortSize==0) { //If no elements in sorted list then add as first element
					sortedTasks.add(inputT);
				}
				else {
					for (int i=0;i<sortSize;i++) {//Loop through established sort, I need to do this to avoid comodification											
						Calendar inputCal = Calendar.getInstance();
						Calendar sortCal = Calendar.getInstance();
						inputCal.setTime(inputT.getDueDate());
						sortCal.setTime(sortedTasks.get(i).getDueDate());
						
						inputCal.set(inputCal.get(Calendar.YEAR), inputCal.get(Calendar.MONTH), inputCal.get(Calendar.DATE), inputT.getDueHour(),inputT.getDueMinute(),0);
						sortCal.set(sortCal.get(Calendar.YEAR), sortCal.get(Calendar.MONTH), sortCal.get(Calendar.DATE), sortedTasks.get(i).getDueHour(),sortedTasks.get(i).getDueMinute(),0);
				
						int comparison = inputCal.compareTo(sortCal);
						
						if (comparison<=0) {
							sortedTasks.add(i,inputT);
							break;
						}
						else if (i==(sortedTasks.size()-1)&&comparison>0) {
							sortedTasks.add(inputT);
							break;
						}
					
				}
			}
		}
		}		
		
		else if (method.equals("priority")) {
			for (Task inputT : inputTasks) { //Loop through each task
				int sortSize = sortedTasks.size();
				if (sortSize==0) { //If no elements in sorted list then add as first element
					sortedTasks.add(inputT);
					
				}
				else {
					for (int i=0;i<sortSize;i++) {//Loop through established sort, I need to do this to avoid comodification
	
						int inputPriority = inputT.getPriority();
						int sortPriority = sortedTasks.get(i).getPriority();
						
						if (inputPriority>=sortPriority) {
							sortedTasks.add(i,inputT);
							break;
						}
						
						else if (i==(sortedTasks.size()-1)&&inputPriority<sortPriority) {
							sortedTasks.add(inputT);
							break;
						}
					}
				}
			}
		}
		
		return sortedTasks; 
	}
}
	
//	/**
//	 * Sorts tasks (ArrayList) by method specified. Options available for the second parameter are "due", "priority" and "dueAndPriority". 
//	 * WARNING: The limits of priority is hard-coded ([0,3]) in sort by priority option. 
//	 * Did not end up using, may show up in the future. 
//	 * @param tasks
//	 * @param method
//	 */
//	public static void sortTasksBy(ArrayList<Task> tasks, String method) {
//		
//		if(tasks == null) {
//			System.out.println("Main.sortTasksBy() says to you: Nope. ArrayList tasks is null!");
//			return; 
//		}
//		
//		if(method.equals("due")) {
//			
//			//Gets all due dates and store them together with all Tasks
//			HashMap<Double, ArrayList<Task>> dueTasks = new HashMap<Double, ArrayList<Task>>(); 
//			for(Task t:tasks) {
//				double rawDue = getDueRaw(t); 
//				if(dueTasks.get(rawDue) == null) {
//					dueTasks.put(rawDue, new ArrayList<Task>()); 
//				}
//				dueTasks.get(rawDue).add(t); 
//			}
//			
//			
//			//Sorts dues in an increasing order 
//			double min = 302105162202.0; //1000 year after I coded this, the program will no longer run... 
//			double currentMax = 0.0; 
//			ArrayList<Double> dues = new ArrayList<Double>(); 
//			
//			for(double j:dueTasks.keySet()) {
//				for(double i:dueTasks.keySet()) {
//					//System.out.println("i value: "+i);
//					if(i < min && i >= currentMax) {
//						min = i; 
//					}
//				}
//				currentMax = min; 
//				//System.out.println("min value: "+min);
//				dues.add(min); 
//			}
//			
//			
//			//Finally, put them back
//			tasks.clear();
//			
//			for(double j:dues) {
//				for(Task t: dueTasks.get(j)) {
//					tasks.add(t); 
//				}
//			}
//			
//			
//			
//		}else if(method.equals("priority")) {
//			
//			//Gets all priorities and store them together with all Tasks
//			HashMap<Integer, ArrayList<Task>> priorTasks = new HashMap<Integer, ArrayList<Task>>(); 
//			for(Task t:tasks) {
//				int priority = t.getPriority(); 
//				if(priorTasks.get(priority) == null) {
//					priorTasks.put(priority, new ArrayList<Task>()); 
//				}
//				priorTasks.get(priority).add(t); 
//			}
//			
//			//Put them back
//			tasks.clear();
//			
//			for(int i=0; i<5; i++) {
//				if(priorTasks.get(i) != null) {
//					for(Task t:priorTasks.get(i)) {
//						tasks.add(t); 
//					}
//				}
//			}
//			
//		}else if(method.equals("dueAndPriority")){
//			
//			//Sort by due
//			sortTasksBy(tasks, "due"); 
//			
//			//Prepare and sort by priority in each time slot
//			ArrayList<ArrayList<Task>> tasksStrips = new ArrayList<ArrayList<Task>>(); 
//			double currentDue = 0; 
//			int index = -1; 
//			for(Task t:tasks) {
//				System.out.println(getDueRaw(t));
//				if(getDueRaw(t) != currentDue) {
//					ArrayList<Task> aStrip = new ArrayList<Task>(); 
//					aStrip.add(t); 
//					tasksStrips.add(aStrip); 
//					index++; 
//				}else {
//					if(index < 0) {
//						index = 0; 
//					}
//					tasksStrips.get(index).add(t); 
//				}
//			}
//			
//			for(int i=0;i<tasksStrips.size();i++) {
//				sortTasksBy(tasksStrips.get(i),"priority"); 
//			}
//			
//			//Finally, put them back
//			tasks.clear();
//			
//			for(int i=0;i<tasksStrips.size();i++) {
//				for(Task t:tasksStrips.get(i)) {
//					tasks.add(t); 
//				}
//			}
//			
//		}else {
//			System.out.println("Main.sortTasksBy() says to you: You made a typo :O");
//		}
//	}
//	
//	/**
//	 * Returns the raw form of due: yyyymmddhhmm in double. 
//	 * @param task
//	 * @return dateTimeRawInt
//	 */
//	public static double getDueRaw(Task task) {
//		String date = "2500/01/01"; 
//		String time = "00:00"; 
//		if(task.getDueDate() != null && !task.getDueDate().equals("yyyy/mm/dd")) {
//			date = task.getDueDateString(); 
//			if(date.length() != 10) {
//				System.out.println("Due date has an error in format :( Expected yyyy/mm/dd, got "+date);
//				date = "2500/01/01"; 
//			}
//		}
//		if(task.getDueTime() != null) {
//			time = task.getDueTime(); 
//			if(time.length() != 5) {
//				System.out.println("Due time has an error in format :( Expected hh:mm, got "+time);
//				time = "00:00"; 
//			}
//		}
//		String dateTimeRaw = date.substring(0,4)+date.substring(5,7)+date.substring(8,10)+time.substring(0,2)+time.substring(3,5);
//		//System.out.println("date: "+date+" time: "+time+" dateTimeRaw: "+dateTimeRaw);
//		double dateTimeRawInt = 0.0; 
//		
//		int l = dateTimeRaw.length() - 1; 
//		for(int i=0; i<=l; i++) {
//			double digit = 0; 
//			switch(dateTimeRaw.charAt(l-i)) {
//			case '1': 
//				digit = 1; 
//				break; 
//			case '2': 
//				digit = 2;
//				break;
//			case '3':
//				digit = 3;
//				break; 
//			case '4':
//				digit = 4;
//				break; 
//			case '5': 
//				digit = 5;
//				break; 
//			case '6': 
//				digit = 6;
//				break; 
//			case '7': 
//				digit = 7; 
//				break; 
//			case '8': 
//				digit = 8; 
//				break; 
//			case '9': 
//				digit = 9; 
//				break; 
//			default: 
//			}
//			dateTimeRawInt += digit * Math.pow(10, i); 
//			//System.out.println("What the hack: "+digit+", "+Math.pow(10, i));
//		} 
//		
//		if(dateTimeRawInt == 0) {
//			return 250001010000.0; 
//		}
//		//System.out.println(dateTimeRawInt);
//		return dateTimeRawInt; 
////	}
//
//}
