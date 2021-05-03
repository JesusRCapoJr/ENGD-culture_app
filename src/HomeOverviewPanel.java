import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeOverviewPanel extends JPanel{
	
	private JPanel world; 
	private final double THIS_W_RATIO = 0.25;
	private final double THIS_H_RATIO = 0.666666667;
	
	ArrayList<Task> allTasks = new ArrayList<Task>(); 
	ArrayList<Folder> allFolders = new ArrayList<Folder>(); 
	private final double BUTTON_WIDTH_RATIO = 0.8; 
	private final double BUTTON_CAP = 20; 
	private final int BUTTON_GAP = 10; 
	//TODO: get allTasks/allFolders
	
	public HomeOverviewPanel(JPanel world) {
		super(); 
		this.world = world; 
		this.setBounds((int)(Main.getWidth()*(1-THIS_W_RATIO)), 0, (int)(Main.getWidth()*THIS_W_RATIO), (int)(Main.getHeight()*THIS_H_RATIO));
		this.setLayout(null);
		System.out.println("This.bounds: ULX:"+(int)(Main.getWidth()*(1-THIS_W_RATIO))+" ULY:"+0+" W:"+(int)(Main.getWidth()*THIS_W_RATIO)+" H:"+(int)(Main.getHeight()*THIS_H_RATIO));

		ArrayList<Label> labels = new ArrayList<Label>(); 
		labels.add(new Label("wa")); 
		for(int i=0; i<14; i++) {
			allTasks.add(new Task("title"+i,"decription",2,labels)); 
		}
		
		int i = 0;
		int thisW = (int) (Main.getWidth()*THIS_W_RATIO);
		int thisH = (int) (Main.getHeight()*THIS_H_RATIO); 
		int btnW = (int) (thisW*BUTTON_WIDTH_RATIO); 
		int btnH = (int) ((thisH-(BUTTON_CAP+1)*BUTTON_GAP)/BUTTON_CAP + thisH / (allTasks.size()*3.5));
		for(Task t:allTasks) {
			this.add(new TaskButton(t, (thisW-btnW)/2, (i+1)*BUTTON_GAP+i*btnH, btnW, btnH)); 
			i++; 
		}
		setVisible(true); 
		this.setBackground(Color.BLUE);
	}
 
}