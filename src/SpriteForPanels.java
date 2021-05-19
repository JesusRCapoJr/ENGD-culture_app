//Author: Nathan Atkinson

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalTime;
import java.util.ArrayList;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//import test.Dimension;

public class SpriteForPanels {
	private ArrayList<File> fileList = new ArrayList<File>();
	public int Score = 0;
//	private int width = 300;
//	private int hight = 200;
//	private int yPoint = 20;
//	private int xPoint = 1600;
//	private Color BGC = new Color(255,255,255); 
	private JFrame world;
	private JPanel panel;
	private LocalTime updatedTime = null;  
	private int timeCap = 10; //1hr in seconds is 43200
	
	//
//	startTime = System.startTime;
	//
	
	
	public SpriteForPanels(JFrame world ,JPanel panel ) throws IOException{
		this.world = world;
		this.panel = panel;
		this.addFile("texture/low_productive.gif");
		this.addFile("texture/low-mid_productive.gif");
		this.addFile("texture/mid_productive.gif");
		this.addFile("texture/mid-high_productive.gif");
		this.addFile("texture/High_Productive.gif");
		System.out.println("All files added");
		updatedTime = java.time.LocalTime.now();
		this.initializing();
	}
	public void taskConpleted() throws Exception {
		Score++;
		updatedTime = java.time.LocalTime.now();
		this.update();
	}
	public void taskUnConpleted() throws Exception {
		Score--;
		this.update();
	}
	public void update() throws Exception {// need a way to check time elapsed in the system
		//mabe use a time maker that updates and keeps track of the 
//		System.out.println("we are in sprite update");
		LocalTime timeDifrance = (java.time.LocalTime.now().minusSeconds(this.updatedTime.getSecond()));
		
		if(timeDifrance.getSecond() > timeCap) {
			Score--;
			updatedTime = java.time.LocalTime.now();
		}
//		this.world.remove(comp);
		
		
		if(Score<0) {
			Score=0;
		}
		
		if(Score>6) {
			Score=6;
		}
		
//		System.out.println("the score is: " + Score);
		
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
		this.panel.revalidate();
		//
	}
	
	private void initializing() { 
		
//	        panel.setBackground(BGC);
//	        panel.setSize(width, hight);
//	        panel.setLocation(xPoint, yPoint);
//	        world.setSize(width, hight);
//	        world.add(panel);
//	        world.pack(); 
////	        world.setLocationRelativeTo(null);//usfull to line things up
	        world.setVisible(true);
	}
	
	private void displaySprite(int positionInList) throws IOException {    //main code from git hub
		 File panaFile = this.fileList.get(positionInList);
		 ImageIcon icon = new ImageIcon(panaFile.toString());
		 JLabel label = new JLabel(icon,SwingConstants.CENTER);
		 	this.panel.removeAll();
		 	this.panel.add(label);
		 	this.panel.setVisible(true);

		    
	}
//	public void desplaySprite(int positionInList) throws IOException {    //main code from git hub
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
	public void addFile(String newFileString) throws MalformedURLException { ///not used i dont think
		File newFile = new File(newFileString);
		this.fileList.add(newFile);
	}
	
	public void changeAttachments(JFrame world ,JPanel panel ) {
			this.world = world;
			this.panel = panel;
	}
	
}
