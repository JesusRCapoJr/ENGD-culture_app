import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelButton extends ToggleButton {
	private Label label;
	private boolean selected = false; 
	
	public LabelButton(Label label, int upperLeftX, int upperLeftY, int width, int height) { //? 
		super(label.getText()); 
		this.label=label;
		this.createAction();
	}
	
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Put actions to be performed on click here");		// what it does goes here
				//----Steven Xia: using ToggleButton instead----
//				label.changeState();
//				changeColorState();
				//---------
				
					if(selected) {
						unClick(); 
					}else {
						FolderLabelsPanel.cleanAll();
						displayTask(); 
						setSelected(true); 
						selected = true; 
					}
				}
			};
		addActionListener(al); 
	}
	
	public void unClick() {
		selected = false; 
		this.setSelected(false);
	}
	
	public void displayTask() {
		
	}
}
