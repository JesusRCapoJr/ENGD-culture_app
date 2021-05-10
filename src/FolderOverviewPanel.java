import javax.swing.JPanel;

public class FolderOverviewPanel extends JPanel{
	
	private int width;
	private int height; 
	
	public FolderOverviewPanel(int upperLeftX, int upperLeftY, int width, int height) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		
		constructAll(); 
	}
	
	public void constructAll() {
		//words
	}
}
