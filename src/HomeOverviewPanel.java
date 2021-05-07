import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeOverviewPanel extends JPanel{
	
	private JPanel world; 
	private final double THIS_W_RATIO = 0.25;
	private final double THIS_H_RATIO = 0.666666667;
	
	ArrayList<Task> allTasks = new ArrayList<Task>(); 
	private static ButtonGroup allTaskss = new ButtonGroup(); 
	ArrayList<Folder> allFolders = new ArrayList<Folder>(); 
	private final double BUTTON_WIDTH_RATIO = 0.8; 
	private final double BUTTON_CAP = 20; 
	private final int BUTTON_GAP = 10; 
	//TODO: get allTasks/allFolders
	
	public HomeOverviewPanel(JPanel world) {
		super(); 
		this.world = world; 
		Random rnd = new Random(); 
		this.setBounds((int)(Main.getWidth()*(1-THIS_W_RATIO)), 0, (int)(Main.getWidth()*THIS_W_RATIO), (int)(Main.getHeight()*THIS_H_RATIO));
		this.setLayout(null);
		System.out.println("This.bounds: ULX:"+(int)(Main.getWidth()*(1-THIS_W_RATIO))+" ULY:"+0+" W:"+(int)(Main.getWidth()*THIS_W_RATIO)+" H:"+(int)(Main.getHeight()*THIS_H_RATIO));

		ArrayList<Label> labels = new ArrayList<Label>(); 
		labels.add(new Label("wa")); 
		for(int i=0; i<14; i++) {
			Task tsk = new Task("title"+i,"decription",2,labels); 
			allTasks.add(tsk);
			int j = rnd.nextInt(7); 
			switch(j) {
				case 0: 
					tsk.setDescription("wawawawawawa");
					break; 
				case 1: 
					tsk.setDescription("dadada");
					break;
				case 2: 
					tsk.setDescription("wula!");
					break;
				case 3: 
					tsk.setDescription("meow");
					break;
				default: 
					tsk.setDescription("bruh");
			}
		 
		}
		
		int i = 0;
		int thisW = (int) (Main.getWidth()*THIS_W_RATIO);
		int thisH = (int) (Main.getHeight()*THIS_H_RATIO); 
		int btnW = (int) (thisW*BUTTON_WIDTH_RATIO); 
		int btnH = (int) ((thisH-(BUTTON_CAP+1)*BUTTON_GAP)/BUTTON_CAP + thisH / (allTasks.size()*3.5));
		for(Task t:allTasks) {
			TaskButton btn = new TaskButton(world, t, (thisW-btnW)/2, (i+1)*BUTTON_GAP+i*btnH, btnW, btnH); 
			allTaskss.add(btn); 
			this.add(btn); 
			i++; 
		}
		setVisible(true); 
		this.setBackground(Color.BLUE);
	}
	
	public static void cleanAll() {
		allTaskss.clearSelection();
	}
 
}