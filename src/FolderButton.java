import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FolderButton extends Button {
	private Folder folder;
	private PandativityFrame frame; 

	public FolderButton(Folder folder, PandativityFrame frame) { //? 
		super(); 
		this.folder = folder;
		this.frame = frame; 
		this.setText(folder.getTitle());
		this.createAction();
	}
	
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Put actions to be performed on click here");		// what it does goes here
				//PandativityFrame.reborn();
				//There's gotta be some FolderViewPanel??? 
				JPanel folderPanel = new JPanel(); 
				folderPanel.setBounds(0,0,Main.getWidth(),Main.getHeight());
				folderPanel.setBackground(Color.PINK);
				frame.reborn(); 
				frame.add(folderPanel); 
				folderPanel.setVisible(true);
				}
			};
		addActionListener(al); 
	}

}
