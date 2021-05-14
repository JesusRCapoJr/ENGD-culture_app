import java.awt.Color;

import javax.swing.JPanel;

public class FolderOverviewPanel extends JPanel{
	
	private int width;
	private int height; 
	private int btnHeight; 
	private final int GAP = 10; 
	private Folder myFolder; 
	
	public FolderOverviewPanel(int upperLeftX, int upperLeftY, int width, int height, Folder folder) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height;
		this.myFolder = folder; 
		this.setBackground(Color.GREEN);
		
		constructAll(); 
	}
	
	public void constructAll() {
		int iULY = 10; 
		for(Task task:Main.getTasksByFolder(myFolder)) {
			this.add(new FolderTaskPanel(10, iULY, width, btnHeight, task)); 
			iULY += btnHeight+GAP; 
		}
	}
}
