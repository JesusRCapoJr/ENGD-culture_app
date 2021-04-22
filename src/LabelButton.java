import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelButton extends Button {
	private Label label;
	
	public LabelButton(Label label) { //? 
		super(); 
		this.label=label;
		this.setText(label.getText);
		this.createAction();
	}
	
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		System.out.println("Put actions to be preformed on click here");		// what it does goes here
				label.changeState();
//				super().this.changeColorState();
				this.changeColorState();
				}
			};
	}
	
}
