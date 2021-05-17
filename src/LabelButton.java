import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class LabelButton extends ToggleButton {
	private Label label;
	private Folder folder; 
	private boolean selected; 
	private FolderLabelsPanel flp; 
	
	public LabelButton(FolderLabelsPanel flp, Folder folder, Label label, int upperLeftX, int upperLeftY, int width, int height) { //? 
		super(label.getText(), upperLeftX, upperLeftY, width, height); 
		this.flp = flp; 
		this.label = label;
		this.folder = folder; 
		this.selected = false; 
		this.createAction();
	}
	
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Put actions to be performed on click here");		// what it does goes here				
					if(selected) {
						unClick(); 
					}else {
						FolderLabelsPanel.cleanAll();
						setSelected(true); 
						selected = true; 
					}
				}
			};
			
		//right click, code inspired by Jesus
		MouseAdapter ml = new MouseAdapter() {
			@SuppressWarnings("unchecked")
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					Object[] options = {Main.getLanguage().get("Delete"),
							Main.getLanguage().get("Edit"),Main.getLanguage().get("Cancel")};
              	  
			          int response = JOptionPane.showOptionDialog(null,
			        		Main.getLanguage().get("What would you like to do?"),
			        		Main.getLanguage().get("Options"),
				            JOptionPane.YES_NO_CANCEL_OPTION,
				            JOptionPane.QUESTION_MESSAGE,
				            null,
				            options,
				            options[2]);
			          if (response == 0) {
			        	  	folder.removeLabel(label);
			        	  	Main.getAllLabels().remove(label);
			        	  	flp.f5(); 
			        	  	
			          }else if (response == 1) {
			        	  	new AddLabelFrame(label, folder); 
			        	  	flp.f5();
			          }
				}
			}
		}; 
		addActionListener(al); 
		addMouseListener(ml); 
	}
	
	public void unClick() {
		selected = false; 
		this.setSelected(false);
	}
	
	public void displayLabel() {
		flp.f5();
	}
	
	public boolean getSelected() {
		return this.selected; 
	}
	
	public Label getThisLabel() {
		return this.label; 
	}
}
