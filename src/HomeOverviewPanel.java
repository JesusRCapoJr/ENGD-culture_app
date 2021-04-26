import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeOverviewPanel extends JPanel{
	
	private JFrame world; 
	
	public HomeOverviewPanel(JFrame world) {
		this.world = world; 
		this.setBounds(0, 0, 200, 200);
		this.setSize(200,200);
		Button btn = new AddTaskButton(world, 100, 100, 100, 100); 
		btn.setSize(100, 100);
		add(btn); 
		setVisible(true); 
		this.setBackground(Color.BLUE);
	}
 
	
	
}
