import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//import test.Dimension;

public class Sprite {
	private ArrayList<File> fileList = new ArrayList<File>();
	public double Score = 1;
	private int width;
	private int hight;
	private int yPoint;
	private int xPoint;
	private Color BGC = new Color(255,255,255); 
	private JFrame world;
	private LocalTime updatedTime = null;  //1hr in seconds
	private int timeCap = 5;
	
	//
//	startTime = System.startTime;
	//
	
	
	public Sprite(JFrame world) throws MalformedURLException{
		this.world = world;
		this.addFile("texture/low_productive.gif");
		this.addFile("texture/low-mid_productive.gif");
		this.addFile("texture/mid_productive.gif");
		this.addFile("texture/mid-high_productive.gif");
		this.addFile("texture/High_Productive.gif");
		this.yPoint = 20;
		this.xPoint = 1600;
		System.out.println("All files added");
		updatedTime = java.time.LocalTime.now();
	}
	public void taskCompleted() throws Exception {
		Score++;
		updatedTime = java.time.LocalTime.now();
		this.update();
	}
	public void update() throws Exception {// need a way to check time elapsed in the system
		//mabe use a time maker that updates and keeps track of the 
		LocalTime timeDifference = (java.time.LocalTime.now().minusSeconds(this.updatedTime.getSecond()));
		
		if(timeDifference.getSecond() > timeCap) {
			Score--;
			updatedTime = java.time.LocalTime.now();
		}
		if(Score<0) {
			Score=0;
		}
		
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
		else if(this.Score>=4) {//gifs for each score 5+ = high
			this.displaySprite(4);
		}
		//
	}
	
	public void displaySprite(int positionInList) throws IOException {    //main code from git hub
		//
//		URL url = getClass().getResource("texture/High Productive.gif");
		//
		 File panaFile = this.fileList.get(positionInList);
		 ImageIcon icon = new ImageIcon(panaFile.toString());
		    JLabel label = new JLabel(icon,SwingConstants.CENTER);
		 
//		    JFrame f = new JFrame("Animation");
//		    f.getContentPane().add(label);
//		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    f.pack();
//		    f.setLocationRelativeTo(null);
//		    f.setVisible(true);
		    
		    JPanel panel = new JPanel();
	        panel.setBackground(BGC);
//	        panel.setPreferredSize(new java.awt.Dimension(width,hight));
	        panel.setSize(width, hight);
	        panel.setLocation(xPoint, yPoint);
	        panel.add(label);
	        
//	        world.setLocation(xPoint, yPoint);
//	        world.getContentPane().add(panel);
	        world.add(panel);
	        world.pack(); 
//	        world.setLocationRelativeTo(null);//usfull to line things up
	        //world.setVisible(true); //SET TO VISIBLE TO SHOW
//	        world.setLocation(xPoint, yPoint);
		    
	}
	public void addFile(String newFileString) throws MalformedURLException {
		File newFile = new File(newFileString);
		this.fileList.add(newFile);
	}
}
