import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FolderButton extends Button {
	private Folder folder;
	private PandativityFrame frame; 

	public FolderButton(Folder folder) { //? 
		super(); 
		this.folder = folder;
		this.world = PandativityFrame.getWorld(); 
		this.setText(folder.getTitle());
		this.createAction();
	}
	
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Put actions to be performed on click here");		// what it does goes here
				//(IGNORE: Actually can not do for some wierd reason)There's gotta be some FolderViewPanel??? 
				PandativityFrame.reborn(); 
				constructAll(); 
				}
			};
		addActionListener(al); 
	}
	
	public void constructAll() {
		//constructs everything 
		world.add(new Button("Wow!",100,100,100,100)); 
	}
//	/**
//	 * For test. Should be adapted into some FolderPanel in the future unless we decide on not having that
//	 */
//	public void test() {
//		JPanel folderPanel = new JPanel(); 
//		folderPanel.setBounds(0,0,Main.getWidth(),Main.getHeight());
//		folderPanel.setBackground(Color.PINK);
//		
//		PandativityFrame.add(folderPanel); 
//		folderPanel.setVisible(true);
//	}

}
