//Author: Steven Xia

import java.util.ArrayList;
import javax.swing.JPanel;

public class FolderLabelsPanel extends JPanel{
	
	private static Folder folder; 
	private int width;
	private int height; 
	private static ArrayList<LabelButton> allLabelButtons = new ArrayList<LabelButton>(); 
	private final double BUTTON_WIDTH_RATIO = 0.4; 
	private final double BUTTON_CAP = 40; 
	private final int BUTTON_GAP = 10; 
	private int btnH; 
	private int btnW; 
	

	/**
	 * Constructs a FolderLabelsPanel of folder. 
	 * @param upperLeftX
	 * @param upperLeftY
	 * @param width
	 * @param height
	 * @param folder
	 */
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
	
	/**
	 * Constructs all LabelButtons in this.folder. Does nothing if this.folder.getLabels == null. 
	 */
	public void constructAll() {
		
		if(this.folder.getLabels() == null) {
			return; 
		}
		
		AddLabelButton addLabel = new AddLabelButton(this.folder, 10, 10, 2*btnW, 30); 
		this.add(addLabel); 
		
		int i = 0;
		for(Label label:this.folder.getLabels()) {
			LabelButton btn = new LabelButton(this, this.folder, label, 10+(i%2)*(btnW+BUTTON_GAP), 50+((int)(i/2)+1)*(btnH+BUTTON_GAP)+i*btnH, btnW, btnH);
			btn.setBackground(Main.getChosenTheme().get(2));
			allLabelButtons.add(btn); 
			this.add(btn); 
			i++; 
		}
	}
	
	/**
	 * Unclicks all LabelButton. 
	 */
	public static void cleanAll() {
		for(LabelButton i: allLabelButtons) {
			i.unClick();
		}
	}
	
	/**
	 * Theoretically does what a F5 button does. Did not use in the program but may show up in the future. 
	 */
	public void f5() {
		this.repaint();
	}
	
}
