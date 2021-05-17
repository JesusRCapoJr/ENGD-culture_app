
import java.util.ArrayList;
import javax.swing.JPanel;


public class FolderLabelsPanel extends JPanel{
	
	private static Folder folder; 
	private int width;
	private int height; 
	private static ArrayList<LabelButton> allLabelButtons = new ArrayList<LabelButton>(); 
	private final double BUTTON_WIDTH_RATIO = 0.4; 
	private final double BUTTON_CAP = 40; 
	private final int BUTTON_GAP = 1; 
	private int btnH; 
	private int btnW; 
	

	public FolderLabelsPanel(int upperLeftX, int upperLeftY, int width, int height, Folder folder) {
		super();
		this.setBounds(upperLeftX, upperLeftY, width, height);
		this.setLayout(null);
		this.width = width;
		this.height = height; 
		this.folder = folder; 
		this.setBackground(Main.getChosenTheme().get(3));
		this.btnH = (int) ((height-(BUTTON_CAP+1)*(BUTTON_GAP/2))/(BUTTON_CAP/2)); 
		this.btnW = (int) (width*BUTTON_WIDTH_RATIO); 
		
		constructAll(); 
	}
	
	public void constructAll() {
		
		if(this.folder.getLabels() == null) {
			return; 
		}
		
		AddLabelButton addLabel = new AddLabelButton(this.folder, 10, 10, btnW, btnH); 
		
		int i = 0;
		for(Label label:this.folder.getLabels()) {
			LabelButton btn = new LabelButton(this, this.folder, label, 10+(i%2)*(btnW+BUTTON_GAP), 50+((i/2)+1)*BUTTON_GAP/2+i*btnH, btnW, btnH);
			btn.setBackground(Main.getChosenTheme().get(2));
			allLabelButtons.add(btn); 
			this.add(btn); 
			i++; 
		}
	}
	
	public static void cleanAll() {
		for(LabelButton i: allLabelButtons) {
			i.unClick();
		}
	}
	
	//Steven Xia: no longer useful 
//	/** 
//	 * Doesn't quite make sense here, but yeah here it is. May move to Main later. 
//	 * @param label
//	 */
//	public static void deleteLabel(Label label) {
//		try {
//			folder.getLabels().remove(label); 
//		}catch(Exception e) {
//			System.out.println("Label dosen't exist in this folder. Check your set-up. ");
//		}
//	}
	
	public void f5() {
		this.repaint();
		System.out.println("FolderLabelPanel: f5() called");
	}
}
