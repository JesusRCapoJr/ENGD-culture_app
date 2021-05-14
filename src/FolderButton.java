import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FolderButton extends Button {
	private Folder folder;
	private JFrame frame; 
	
	public FolderButton(Folder folder, JFrame frame) { //? 
		super(); 
		this.folder = folder;
		this.frame = frame; 
		//this.world = PandativityFrame.getWorld(); 
		this.setText(folder.getTitle());
		this.createAction();
	}
	
	public void createAction() {                  // Action
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Put actions to be performed on click here");		// what it does goes here
				//(IGNORE: Actually can not do for some wierd reason)There's gotta be some FolderViewPanel??? 
				//PandativityFrame.reborn(); 
				try {
					constructAll();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				}
			};
		addActionListener(al); 
	}
	
	public void constructAll() throws Exception {
		//constructs everything 
		//world.add(new Button("Wow!",100,100,100,100)); 
		DesplayState1.reborn();
		new DesplayState2(frame,this.folder);
//		panel.setBackground(new Color(143, 188, 143));
//		panel.setBounds(10, 131, 1205, 704);
//		frame.getContentPane().add(panel);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(new Color(112, 128, 144));
//		panel_1.setBounds(1225, 216, 305, 619);
//		frame.getContentPane().add(panel_1);
//		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBackground(new Color(160, 82, 45));
//		panel_3.setBounds(10, 10, 1205, 109);
//		frame.getContentPane().add(panel_3);
//		panel_3.setLayout(null);
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
