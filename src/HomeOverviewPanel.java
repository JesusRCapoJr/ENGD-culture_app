import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private DesplayState1 desplayState;
	private JFrame frame;
	
	//private static ButtonGroup allTaskButtons = new ButtonGroup(); 
	private final double BUTTON_WIDTH_RATIO = 0.4; 
	private final double BUTTON_CAP = 20; 
	private final int BUTTON_GAP = 1; 
	private Random rnd = new Random(); 
	
	private int btnW; 
	private int btnH;
	
	private static ArrayList<TaskButton> allTaskButtons = new ArrayList<TaskButton>(); 
	
	/**
	 * Serves as a FolderOverviewPanel. This one also defines Color of the Panel. 
	 * @param folder
	 * @param upperLeftX
	 * @param upperLeftY
	 * @param width
	 * @param height
	 * @param color
	 */
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
	
	/**
	 * Serves as a FolderOverviewPanel since the two panels are similar. On debate of whether or not to actually merge them.
	 * Did not end up using but may return in the future.  
	 * @param folder
	 * @param upperLeftX
	 * @param upperLeftY
	 * @param width
	 * @param height
	 */
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
	
	/**
	 * Constructs a HomeOverviewPanel at (upperLeftX, upperLeftY) with size (width, height).
	 * Did not end up using but may return in the future. 
	 * @param upperLeftX
	 * @param upperLeftY
	 * @param width
	 * @param height
	 */
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
	
	/**
	 * What is actually used. Constructs a HomeOverviewPanel at (upperLeftX, upperLeftY) with size (width, height).
	 * @param upperLeftX
	 * @param upperLeftY
	 * @param width
	 * @param height
	 * @param desplayState
	 * @param frame
	 */
	public HomeOverviewPanel(int upperLeftX, int upperLeftY, int width, int height, DesplayState1 desplayState, JFrame frame) {
		super();
		//desplayState and frame are for later use in refreshing the page 
		this.desplayState = desplayState;
		this.frame=frame;
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.btnH = (int) ((height-(BUTTON_CAP+1)*BUTTON_GAP)/BUTTON_CAP); 
		this.btnW = (int) (width*BUTTON_WIDTH_RATIO); 
		
		constructAll(); 
	}
	
	/**
	 * Constructs all stuff to show all Tasks. 
	 */
	public void constructAll() {
		
		for(Folder folder:Main.getAllFolders()) {
			for(Task task:folder.getTasks()) {
				 tasks.add(task); 
			}
		}
//		test(); 
		this.setBackground(new Color(105, 105, 105));
		
		//sort by Due date, then priority. TBC
		//Main.sortTasksBy(tasks, "dueAndPriority");
		
		int i = 0; 
		for(Task task:tasks) {
			constructButton(i,task); 
			i++;
		}
		
		//TODO: make finished tasksd dark and have a delete option
	}
	
	/**
	 * Construct all stuff to show all Tasks in the Folder. 
	 * Did not end up using but may return in the future. 
	 */
	public void constructAllFolder() {
		ArrayList<Task> tasks = this.folder.getTasks(); 
		//Main.sortTasksBy(tasks, "dueAndPriority");
		int i=0; 
		for(Task task:Main.getAllTasks()) {
			constructButton(i,task); 
			i++; 
		}
		
		this.setBackground(this.color); 
	}
	
	/**
	 * Unclicks all TaskButtons. 
	 */
	public static void cleanAll() {
		for(TaskButton i: allTaskButtons) {
			i.unClick();
		}
	}
	
	/**
	 * Constructs a single group of stuff showing info of a Task. Is used in constructAll() and constructAllFolder(). 
	 * @param i
	 * @param task
	 */
	public void constructButton(int i, final Task task) {
		
		Color taskButtonBackground = new Color(255,255,255);	
		
		JButton deleteTaskButton = new JButton(Main.getLanguage().get("Delete"));
		deleteTaskButton.setBounds((width/2 + (width/2-btnW)/2)+200, 20+(i+1)*BUTTON_GAP+i*btnH, btnW-200, btnH);
		deleteTaskButton.setBackground(Color.RED);
		
		if (task.isCompleted()) {
			taskButtonBackground = Color.GRAY;
			this.add(deleteTaskButton);
		}
		
		TaskButton btn = new TaskButton(this, task, 10, 20+(i+1)*BUTTON_GAP+i*btnH, btnW, btnH,this.desplayState,frame);
		btn.setBackground(taskButtonBackground);
		btn.setToolTipText(task.getDescription());
		
		allTaskButtons.add(btn); 
		this.add(btn); 
		
		JButton taskDayLabel = new JButton(task.getDueDateString());
		taskDayLabel.setBounds(338, 20+(i+1)*BUTTON_GAP+i*btnH, btnW/3, btnH);
		taskDayLabel.setBackground(taskButtonBackground);
		this.add(taskDayLabel);
		
		JButton taskTimeLabel = new JButton(task.getDueTime());
		taskTimeLabel.setBounds(450, 20+(i+1)*BUTTON_GAP+i*btnH, btnW/3, btnH);
		taskTimeLabel.setBackground(taskButtonBackground);
		this.add(taskTimeLabel); 
		
		final JCheckBox chkbtn = new JCheckBox("");
		chkbtn.setBounds((width/2 + (width/2-btnW)/2)+150, 20+(i+1)*BUTTON_GAP+i*btnH, btnW-300, btnH);
		chkbtn.setBackground(taskButtonBackground);
		if (task.isCompleted()==false) {
			chkbtn.setSelected(false);
		} 
		else {
			chkbtn.setSelected(true);
		}
		this.add(chkbtn);
		
		chkbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (task.isCompleted()==false) {
				try {
					task.setCompleted(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				chkbtn.setSelected(true);
			} 
			else {
				try {
					task.setCompleted(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				chkbtn.setSelected(false);
			}
			desplayState.reborn();
	      	  try {
	      		  new DesplayState1(frame);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
		}
			

	            
		});
		
		deleteTaskButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
		        	  task.getFolder().removeTask(task);
		        	  Main.getAllTasks().remove(task);
		        	  desplayState.reborn();
			      	  try {
			      		  new DesplayState1(frame);
						} catch (Throwable e1) {
							e1.printStackTrace();
						} }
            });
		
		
		
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
					//tsk.setDueDateString("2021/02/12");
					break; 
				case 1: 
					tsk.setDescription("MA textbook P2.2, P3.4");
					//tsk.setDueDateString("2026/08/24");
					break;
				case 2: 
					tsk.setDescription(null);
					//tsk.setDueDateString("2034/09/29");
					break;
				case 3: 
					tsk.setDescription("1 meow meow meow meow 4 meow meow meow meow 8 meow meow meow meow 12 meow meow meow meow 16 meow meow meow meow 20 meow meow meow meow ");
					//tsk.setDueDateString("2001/03/09");
					break;
				default: 
					tsk.setDescription("bruh");
					//tsk.setDueDateString("2021/02/12");
			}
		 
		}
		
//		int i = 0; 
//		for(Task t:allTasks) {
//			constructButton(i, t); 
//			i++; 
//		}
		
//		setVisible(true); 
//		this.setBackground(Color.BLUE);
	}
}