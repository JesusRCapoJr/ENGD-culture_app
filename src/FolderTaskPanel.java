import javax.swing.JPanel;

public class FolderTaskPanel extends JPanel{
	
	private int width;
	private int height; 
	private Folder myFolder; 
	
	public FolderTaskPanel(int upperLeftX, int upperLeftY, int width, int height, Folder folder) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.myFolder = folder; 
		
		constructAll(); 
	}
	
	public void constructAll() {
		for(Task task:Main.getTasksByFolder(myFolder)) {
			//TODO: What to show? 
		}
	}
}
