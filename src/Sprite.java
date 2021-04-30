import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//import test.Dimension;

public class Sprite {
	private ArrayList<File> fileList;
	private double Score = 2;
	private int width;
	private int hight;
	private int yPoint;
	private int xPoint;
	private Color BGC = new Color(255,255,255); 
	private JFrame world;
	private double time = 3600;  //1hr in seconds
	
	
	public Sprite(JFrame world) throws MalformedURLException{
		this.world = world;
		this.addFile("texture/low_productive.gif");
		this.addFile("texture/low-mid_productive.gif");
		this.addFile("texture/mid_productive.gif");
		this.addFile("texture/mid-high_productive.gif");
		this.addFile("texture/High_Productive.gif");
		this.yPoint = 20;
		this.xPoint = 1600;
	}
	public void taskConpleted() {
		Score++;
		time = 3600;
	}
	public void update() {// need a way to check time elapsed in the system
		//mabe use a time maker that updates and keeps track of the 
		
		if(time<1) {
			Score--;
			time = 3600;
		}
		if(Score<0) {
			Score=0;
		}
		
		if(this.Score<1) {//gifs for each score 0-1 = low
			this.desplaySprite(0);
		}
		else if(this.Score<2) {//gifs for each score 2 = low -mid
			this.desplaySprite(1);
		}
		else if(this.Score<3) {//gifs for each score 2-3 = mid
			this.desplaySprite(2);
		}
		else if(this.Score<4) {//gifs for each score 3-4 = mid-high
			this.desplaySprite(3);
		}
		else if(this.Score>4) {//gifs for each score 5+ = high
			this.desplaySprite(4);
		}
		
	}
	
	public void desplaySprite(int positionInList) throws IOException {    //main code from git hub
		//
//		URL url = getClass().getResource("texture/High Productive.gif");
		//
		 File panaFile = this.fileList.get(positionInList);
		 ImageIcon icon = new ImageIcon(panaFile.getCanonicalPath());
		    JLabel label = new JLabel(icon,SwingConstants.CENTER);
		 
//		    JFrame f = new JFrame("Animation");
//		    f.getContentPane().add(label);
//		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    f.pack();
//		    f.setLocationRelativeTo(null);
//		    f.setVisible(true);
		    
		    JPanel panel = new JPanel();
	        panel.setBackground(BGC);
	        panel.setPreferredSize(new java.awt.Dimension(width,hight));
	        panel.setLocation(xPoint, yPoint);
	        panel.add(label);
	        
	        
	        world.getContentPane().add(panel);
	        world.pack();
	        world.setVisible(true);
		    
	}
	public void addFile(String newFileString) throws MalformedURLException {
		File newFile = new File(newFileString);
		this.fileList.add(newFile);
	}
}
