
import java.util.ArrayList;
import javax.swing.JPanel;


public class FolderLabelsPanel extends JPanel{
	
	private ArrayList<Label> labels = new ArrayList<Label>();
	private int width;
	private int height; 

	public FolderLabelsPanel(int upperLeftX, int upperLeftY, int width, int height) {
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
