//Author:

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FolderButton extends Button {
	private Folder folder;
	private Task task;
	private JFrame frame; 
	private ActionListener al; 
	
	public FolderButton(Folder folder, JFrame frame) { //? 
		super(); 
		this.folder = folder;
		this.frame = frame; 
		//this.world = PandativityFrame.getWorld(); 
		this.setText(folder.getTitle());
		this.createAction();
	}
	
//	public FolderButton(Task task, JFrame frame) { //? 
//		super(); 
//		this.task = task;
//		this.frame = frame; 
//		this.world = PandativityFrame.getWorld(); 
//		this.setText(task.getTitle());
//		this.createAction();
//	}
	
	public void createAction() {                  // Action
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Put actions to be performed on click here");		// what it does goes here
				//(IGNORE: Actually can not do for some wierd reason)There's gotta be some FolderViewPanel??? 
				//PandativityFrame.reborn();  //For testing only
				//DesplayState1.reborn();
					try {
						//System.out.println("tried"); 
						constructAll();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			};
		addActionListener(al); 
		
		
	}
	
	public void constructAll() throws Exception {
		
//		new DesplayState2(frame,this.folder);
//		panel.setBackground(new Color(143, 188, 143));
//		panel.setBounds(10, 131, 1205, 704);
//		frame.getContentPane().add(panel);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(new Color(112, 128, 144));
//		panel_1.setBounds(1225, 216, 305, 619);
//		frame.getContentPane().add(panel_1);
//		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBackground(new Color(160, 82, 45));
//		panel_3.setBounds(10, 10, 1205, 109);
//		frame.getContentPane().add(panel_3);
//		panel_3.setLayout(null);
		
//--------Steven Xia: Above are code copied from DesplayState2 for constructing all panels---------
		
		DesplayState1.reborn();
		new DesplayState2(frame, this.folder.getID()); 
		
		//test(); 
	}
	
	/**
	 * For testing only
	 */
	public void test() {
		Folder la = new Folder("la",1); 
		Task tsk = new Task(); 
		tsk.setTitle("audwhaufhka");
		Task tsk2 = new Task(); 
		tsk2.setTitle("efesgf");
		la.addTask(tsk);
		la.addTask(tsk2);
		System.out.println("FolderButton pushed"); 
		HomeOverviewPanel foP = new HomeOverviewPanel(la, 10, 131, 1205, 704); 
		//PandativityFrame.reborn();
		world.add(foP); 
		Main.registerFolder(la); 
	}

	
}
