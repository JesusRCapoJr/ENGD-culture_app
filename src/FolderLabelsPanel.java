
import java.util.ArrayList;
import javax.swing.JPanel;


public class FolderLabelsPanel extends JPanel{
	
	private Folder folder; 
	private int width;
	private int height; 
	private static ArrayList<LabelButton> allLabelButtons = new ArrayList<LabelButton>(); 

	public FolderLabelsPanel(int upperLeftX, int upperLeftY, int width, int height, Folder folder) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.folder = folder; 
		
		constructAll(); 
	}
	
	public void constructAll() {
		for(Label label:this.folder.getLabels()) {
			
		}
	}
	
	public static void cleanAll() {
		for(LabelButton i: allLabelButtons) {
			i.unClick();
		}
	}
}
