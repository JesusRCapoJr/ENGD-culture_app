import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class AddLabelButton extends Button {
	private JPanel world;
	private Color BGC = new Color(255, 0, 0, 0);
	private Folder folder; 

	/**
	 * 
	 * @param upperX
	 * @param upperY
	 * @param width
	 * @param height
	 */
	public AddLabelButton(double upperX, double upperY, double width, double height) {
		super(Main.getLanguage().get("add a label"),upperX, upperY, width, height); 
		this.folder = new Folder("lemon",0); 
	}
	
	public AddLabelButton(Folder folder, double upperX, double upperY, double width, double height) {
		super(Main.getLanguage().get("add a label"),upperX, upperY, width, height); 
		this.folder = folder; 
	}

	public void createAction() { // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddLabelFrame(folder); 
			}
		};
		addActionListener(al);
		
	}

}