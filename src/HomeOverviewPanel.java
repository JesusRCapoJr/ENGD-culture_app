import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeOverviewPanel extends JPanel{
	
	private JPanel world; 
	private final double THIS_W_RATIO = 0.5;
	private final double THIS_H_RATIO = 0.666666667;
	private int width; 
	private int height; 
	private Folder folder = null; 
	private Color color = new Color(143, 188, 143); 
	private ArrayList<Task> tasks = new ArrayList<Task>(); 
	
	//private static ButtonGroup allTaskButtons = new ButtonGroup(); 
	private final double BUTTON_WIDTH_RATIO = 0.4; 
	private final double BUTTON_CAP = 20; 
	private final int BUTTON_GAP = 1; 
	private Random rnd = new Random(); 
	
	private int btnW; 
	private int btnH;
	
	private static ArrayList<TaskButton> allTaskButtons = new ArrayList<TaskButton>(); 
	//TODO: get allTasks/allFolders
	
	public HomeOverviewPanel(Folder folder, int upperLeftX, int upperLeftY, int width, int height, Color color) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.btnH = (int) ((height-(BUTTON_CAP+1)*BUTTON_GAP)/BUTTON_CAP); 
		this.btnW = (int) (width*BUTTON_WIDTH_RATIO); 
		this.folder = folder; 
		this.color = color; 
				
		constructAllFolder(); 
	}
	
	public HomeOverviewPanel(Folder folder, int upperLeftX, int upperLeftY, int width, int height) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.btnH = (int) ((height-(BUTTON_CAP+1)*BUTTON_GAP)/BUTTON_CAP); 
		this.btnW = (int) (width*BUTTON_WIDTH_RATIO); 
		this.folder = folder; 
		
		constructAllFolder(); 
	}
	
	public HomeOverviewPanel(int upperLeftX, int upperLeftY, int width, int height) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.btnH = (int) ((height-(BUTTON_CAP+1)*BUTTON_GAP)/BUTTON_CAP); 
		this.btnW = (int) (width*BUTTON_WIDTH_RATIO); 
		
		constructAll(); 
	}
	
	public void constructAll() {
		
		for(Folder folder:Main.getAllFolders()) {
			for(Task task:folder.getTasks()) {
				 tasks.add(task); 
			}
		}
//		test(); 
		this.setBackground(new Color(105, 105, 105));
		
		//sort by Due date, then priority
		Main.sortTasksBy(tasks, "dueAndPriority");
		
		int i = 0; 
		for(Task task:tasks) {
			constructButton(i,task); 
			i++;
		}
		
		//TODO: make finished tasksd dark and have a delete option
	}
	
	public void constructAllFolder() {
		int i=0; 
		for(Task task:this.folder.getTasks()) {
			constructButton(i,task); 
			i++; 
		}
		
		this.setBackground(this.color); 
	}
	
	public static void cleanAll() {
		for(TaskButton i: allTaskButtons) {
			i.unClick();
		}
	}
	
	
	public void constructButton(int i, Task task) {
		//System.out.println(width); 
		//System.out.println("TaskButton Const");
		//TaskButton btn = new TaskButton(this, task, width/2 + (width/2-btnW)/2, (i+1)*BUTTON_GAP+i*btnH, btnW, btnH); 
		TaskButton btn = new TaskButton(this, task, 10, 10+(i+1)*BUTTON_GAP+i*btnH, btnW, btnH);
		btn.setBackground(Color.WHITE);
		
		allTaskButtons.add(btn); 
		this.add(btn); 
		
		
		CheckButton chkbtn = new CheckButton("", task, (width/2 + (width/2-btnW)/2)+250, 10+(i+1)*BUTTON_GAP+i*btnH, btnW-275, btnH);
		chkbtn.setBackground(Color.WHITE);
		this.add(chkbtn);
	}
	
	/**
	 * For test only
	 */
	public void test() { 
		ArrayList<Task> allTasks = new ArrayList<Task>(); 
		ArrayList<Label> labels = new ArrayList<Label>(); 
		labels.add(new Label("wa")); 
		for(int i=0; i<14; i++) {
			Task tsk = new Task(); 
			tsk.setTitle("Task"+i);
			allTasks.add(tsk);
			int j = rnd.nextInt(7); 
			switch(j) {
				case 0: 
					tsk.setDescription("wawawawawawa");
					break; 
				case 1: 
					tsk.setDescription("MA textbook P2.2, P3.4");
					break;
				case 2: 
					tsk.setDescription(null);
					break;
				case 3: 
					tsk.setDescription("1 meow meow meow meow 4 meow meow meow meow 8 meow meow meow meow 12 meow meow meow meow 16 meow meow meow meow 20 meow meow meow meow ");
					break;
				default: 
					tsk.setDescription("bruh");
			}
		 
		}
		
		int i = 0; 
		for(Task t:allTasks) {
			constructButton(i, t); 
			i++; 
		}
		
		setVisible(true); 
		this.setBackground(Color.BLUE);
	}
}