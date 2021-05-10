import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
	
	private ArrayList<Task> allTasks = new ArrayList<Task>(); 
	//private static ButtonGroup allTaskButtons = new ButtonGroup(); 
	private ArrayList<Folder> allFolders = new ArrayList<Folder>(); 
	private final double BUTTON_WIDTH_RATIO = 0.4; 
	private final double BUTTON_CAP = 20; 
	private final int BUTTON_GAP = 10; 
	private Random rnd = new Random(); 
	
	private static HashMap<TaskButton, Boolean> allTaskButtons = new HashMap<TaskButton, Boolean>(); 
	//TODO: get allTasks/allFolders
	
	public HomeOverviewPanel(JPanel world) {
		super(); 
		this.world = world; 
		this.setBounds((int)(Main.getWidth()*(1-THIS_W_RATIO)), 0, (int)(Main.getWidth()*THIS_W_RATIO), (int)(Main.getHeight()*THIS_H_RATIO));
		this.setLayout(null);
		this.width = (int) (Main.getWidth()*THIS_W_RATIO);
		this.height = (int) (Main.getHeight()*THIS_H_RATIO); 
		//System.out.println("This.bounds: ULX:"+(int)(Main.getWidth()*(1-THIS_W_RATIO))+" ULY:"+0+" W:"+(int)(Main.getWidth()*THIS_W_RATIO)+" H:"+(int)(Main.getHeight()*THIS_H_RATIO));

		constructAll(); 
	}
	
	public HomeOverviewPanel(int upperLeftX, int upperLeftY, int width, int height) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		
		constructAll(); 
	}
	
	public void constructAll() {
		ArrayList<Label> labels = new ArrayList<Label>(); 
		labels.add(new Label("wa")); 
		for(int i=0; i<14; i++) {
			Task tsk = new Task("task"+i,"description",2,labels); 
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
					tsk.setDescription("meowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
					break;
				default: 
					tsk.setDescription("bruh");
			}
		 
		}
		
		int i = 0;

		int btnW = (int) (width*BUTTON_WIDTH_RATIO); 
		int btnH = (int) ((height-(BUTTON_CAP+1)*BUTTON_GAP)/BUTTON_CAP + height / (allTasks.size()*3.5));
		for(Task t:allTasks) {
			TaskButton btn = new TaskButton(this, t, width/2 + (width/2-btnW)/2, (i+1)*BUTTON_GAP+i*btnH, btnW, btnH); 
			allTaskButtons.put(btn, false); 
			this.add(btn); 
			i++; 
		}
		setVisible(true); 
		this.setBackground(Color.BLUE);
	}
	
	public static void cleanAll() {
		for(TaskButton i: allTaskButtons.keySet()) {
			allTaskButtons.put(i, false); 
			i.unClick();
		}
	}
	
	public void addTask(Task task) {
		this.allTasks.add(task); 
	}
	
}