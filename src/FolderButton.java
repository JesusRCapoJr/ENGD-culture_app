import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FolderButton extends Button {
	private Folder folder;

	public FolderButton(Folder folder) { //? 
		super(); 
		this.folder=folder;
		this.setText(folder.getTitle());
		this.createAction();
	}
	
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Put actions to be performed on click here");		// what it does goes here
				//world.die()???
				//There's gotta be some FolderViewPanel??? 
				JFrame frame = new JFrame();
				
				frame.setSize(Main.getWidth(), Main.getHeight());
				frame.setTitle("Pandativity");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(null);
				
				}
			};
		addActionListener(al); 
	}

}
