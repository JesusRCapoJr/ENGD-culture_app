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
		System.out.println("Overview construct 1"); 
		this.setLayout(null);
		this.width = width;
		this.height = height;
		this.myFolder = folder; 
		this.setBackground(Color.GREEN);
		
		this.constructAll(); 
		System.out.println("Overview constructed"); 
	}
	
	public void constructAll() {
		int iULY = 10; 
		for(Task task:myFolder.getTasks()) {
//			FolderTaskPanel taski = new FolderTaskPanel(10, iULY, width, btnHeight, task); 
//			this.add(taski); 
//			JPanel pnl = new JPanel(); 
//			pnl.setBounds(10, iULY, width, btnHeight); 
//			pnl.setBackground(Color.WHITE);
			this.add(new TaskButton(this, task, 10, iULY, width, btnHeight));
			System.out.println("Overview construct 2"); 
			iULY += btnHeight+GAP; 
		}
		this.repaint();
	}
}
