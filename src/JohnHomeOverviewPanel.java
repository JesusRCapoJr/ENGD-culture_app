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

public class JohnHomeOverviewPanel extends JPanel{
	
	private JPanel world; 
	private final double THIS_W_RATIO = 0.5;
	private final double THIS_H_RATIO = 0.666666667;
	private int width; 
	private int height; 
	
	//private static ButtonGroup allTaskButtons = new ButtonGroup(); 
	private final double BUTTON_WIDTH_RATIO = 0.4; 
	private final double BUTTON_CAP = 20; 
	private final int BUTTON_GAP = 1; 
	private Random rnd = new Random(); 
	
	private int btnW; 
	private int btnH;
	
	private static ArrayList<TaskPanel> allTaskPanels = new ArrayList<TaskPanel>(); 
	//TODO: get allTasks/allFolders
	
//	public HomeOverviewPanel(JPanel world) {
//		super(); 
//		this.world = world; 
//		this.setBounds((int)(Main.getWidth()*(1-THIS_W_RATIO)), 0, (int)(Main.getWidth()*THIS_W_RATIO), (int)(Main.getHeight()*THIS_H_RATIO));
//		this.setLayout(null);
//		this.width = (int) (Main.getWidth()*THIS_W_RATIO);
//		this.height = (int) (Main.getHeight()*THIS_H_RATIO); 
//		//System.out.println("This.bounds: ULX:"+(int)(Main.getWidth()*(1-THIS_W_RATIO))+" ULY:"+0+" W:"+(int)(Main.getWidth()*THIS_W_RATIO)+" H:"+(int)(Main.getHeight()*THIS_H_RATIO));
//
//		constructAll(); 
//	}
//	Using bounds just makes a hack lot more sense 
	
	public JohnHomeOverviewPanel(int upperLeftX, int upperLeftY, int width, int height) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.btnH = (int) ((height-(BUTTON_CAP+1)*BUTTON_GAP)/BUTTON_CAP); 
		this.btnW = (int) (width*BUTTON_WIDTH_RATIO); 
		
		constructAll(); 
	}
	
	public void constructAll() {
//		int i = 0; 
//		for(Folder folder:Main.getAllFolers()) {
//			for(Task task:Main.getTasksByFolder(folder)) {
//				constructButton(i,task); 
//			}
//		}
		test(); 
	}
	
	public static void cleanAll() {
		for(TaskPanel i: allTaskPanels) {
			//i.unClick(); don't need right now
		}
	}
	
	
	public void constructPanel(int i, Task task) {
		//System.out.println(width); 
		//System.out.println("TaskButton Const");
		TaskPanel pnl = new TaskPanel(task); 
		allTaskPanels.add(pnl); 
		this.add(pnl); 
	}
	
	/**
	 * For test only
	 */
	public void test() { 
		ArrayList<Task> allTasks = new ArrayList<Task>(); 
		ArrayList<Label> labels = new ArrayList<Label>(); 
		labels.add(new Label("wa")); 
		for(int i=0; i<14; i++) {
			Task tsk = new Task("task "+i,"description",2,labels); 
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
			constructPanel(i, t); 
			i++; 
		}
		
		setVisible(true); 
		this.setBackground(Color.BLUE);
	}
}