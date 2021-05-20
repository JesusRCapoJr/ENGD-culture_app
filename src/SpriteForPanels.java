//Author: Nathan Atkinson

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//import test.Dimension;

/**
 * Summary  for class:
 * This class takes in a JPanel and a JFrame that it attaches itself to
 * After loading in all the sprite gifs files from texters it sets it base score and capture the system time to compare later to 
 * the system time when updated. If the time elapsed is above the defined interval then the score naturally decreases and the sprite
 * changes and the anker time resets. When tasks are completed the score increases, the sprites changes, and the time gets re-ankered.
 */

public class SpriteForPanels {
	private ArrayList<File> fileList = new ArrayList<File>();
	public int Score = 0;
//	private int width = 300;					//these variables that are commented out are if we would like to make it dynamic in the future
//	private int hight = 200;
//	private int yPoint = 20;
//	private int xPoint = 1600;
//	private Color BGC = new Color(255,255,255); 
	private JFrame world;						
	private JPanel panel;
	private LocalTime updatedTime = null;  
	private int timeCap = 10; //1hr in seconds is 43200   //interval of time the that has to pass for the sprite to degrade by one point. {in seconds}
	
	//
//	startTime = System.startTime;
	//
	
	
	public SpriteForPanels(JFrame world ,JPanel panel ) throws IOException{
		this.world = world;
		this.panel = panel;
		this.addFile("texture/low_productive.gif");				//loads in all gifs from the textures folder to be accessed vea an array list of files
		this.addFile("texture/low-mid_productive.gif");
		this.addFile("texture/mid_productive.gif");
		this.addFile("texture/mid-high_productive.gif");
		this.addFile("texture/High_Productive.gif");
//		System.out.println("All files added");
		updatedTime = java.time.LocalTime.now();				// sets anker time to the current system time
		this.initializing();									// this matters more for if it was dynamic. for now it sets visibility to true
	}
	public void taskConpleted() throws Exception {				/**Increases the the score which on update will change the displayed sprite to the
																 * next available spirit. it also re sets the anker time to the current system time 
																 * to be compared during update()
																 */
		Score++;
		updatedTime = java.time.LocalTime.now();
		this.update();
	}
	public void taskUnConpleted() throws Exception {			//Decreases the score and runs update wich will handle all other changes to the sprite
		Score--;
		this.update();
	}
	public void update() throws Exception {  					/** Compares local time to anker time. if the time has elapsed then the it decreases the score
																  * by one. This functions enforces the bounds of the score bing from 0-6.
																  * Finely the displayed sprite is changed to reflect the score.
																  */
	

		LocalTime timeDifrance = (java.time.LocalTime.now().minusSeconds(this.updatedTime.getSecond())); //Compares local time to anker time.
		
		if(timeDifrance.getSecond() > timeCap) {                  // if elapsed time is grater then time cap then the score decreases and anker time is reset
			Score--;
			updatedTime = java.time.LocalTime.now();
		}
//		this.world.remove(comp);
		
		
		if(Score<0) {											  // enforces score bounds to 0-6
			Score=0;
		}
		
		if(Score>6) {
			Score=6;
		}
		
//		System.out.println("the score is: " + Score);
																  //the sprite that is displayed is generated off of the score.
		if(this.Score<1) {//gifs for each score 0-1 = low
			this.displaySprite(0);
		}
		else if(this.Score<2) {//gifs for each score 2 = low -mid
			this.displaySprite(1);
		}
		else if(this.Score<3) {//gifs for each score 2-3 = mid
			this.displaySprite(2);
		}
		else if(this.Score<4) {//gifs for each score 3-4 = mid-high
			this.displaySprite(3);
		}
		else  {//gifs for each score 5+ = high
			this.displaySprite(4);
		}
		this.panel.revalidate();									// updates that panel (like packing but for panels)
		//
	}
	
	private void initializing() { 				//Commented out code would be useful for dynamic placement in the application
		
//	        panel.setBackground(BGC);
//	        panel.setSize(width, hight);
//	        panel.setLocation(xPoint, yPoint);
//	        world.setSize(width, hight);
//	        world.add(panel);
//	        world.pack(); 
////	        world.setLocationRelativeTo(null);//usfull to line things up
	        world.setVisible(true);
	}
	
	private void displaySprite(int positionInList) throws IOException {    //changes the sprite displayed by taking in the position of the sprite on the list.
		 File panaFile = this.fileList.get(positionInList);		//loads in the file from the array list
		 ImageIcon icon = new ImageIcon(panaFile.toString());	//makes an icon using the file location
		 JLabel label = new JLabel(icon,SwingConstants.CENTER); //creates a new JLable that is the previously generated icon and puts it in the center.
		 	this.panel.removeAll();								//clears the panel that has been passed into the sprite so there is no overlapping of spites
		 	this.panel.add(label);								//adds the generated JLable
		 	this.panel.setVisible(true);						//re-affirms that the panel is visible

		    
	}
//	public void desplaySprite(int positionInList) throws IOException {    //old version that would be useful when making the sprite dynamic
//		this.world.removeAll();//bad idea
//		 File panaFile = this.fileList.get(positionInList);
//		 ImageIcon icon = new ImageIcon(panaFile.toString());
//		 JLabel label = new JLabel(icon,SwingConstants.CENTER);
//		
//		    
//		    JPanel panel = new JPanel();
//	        panel.setBackground(BGC);
//
//	        panel.setSize(width, hight);
//	        panel.setLocation(xPoint, yPoint);
//	        panel.add(label);
//
//	        world.add(panel);
//	        world.pack(); 
////	        world.setLocationRelativeTo(null);//usfull to line things up
//	        world.setVisible(true);
//		    
//	}
	private void addFile(String newFileString) throws MalformedURLException { //called dering the first runing of the class to aid in the adding of files
		File newFile = new File(newFileString);					//creates a new file from the passed in string
		this.fileList.add(newFile);								//adds that new file to the array list
	}
	
	public void changeAttachments(JFrame world ,JPanel panel ) {
			this.world = world;
			this.panel = panel;
	}
	
}
