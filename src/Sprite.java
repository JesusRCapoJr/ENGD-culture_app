import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sprite {
	private ArrayList<URL> URLList;
	private double Score = 2;
	private double width;
	private double hight;
	private double yPoint;
	private double xPoint;
	private Color BGC = new Color(255,255,255); 
	private JFrame world;
	private double time = 3600;  //1hr in seconds
	
	
	public Sprite(){
//		this.addURL("https://piskel-imgstore-b.appspot.com/img/c8720580-a8f7-11eb-ab35-094b3278c51b.gif");
		this.addURL("texture/low_productive.gif");
		this.addURL("texture/low-mid_productive.gif");
		this.addURL("texture/mid_productive.gif");
		this.addURL("texture/mid-high_productive.gif");
		this.addURL("texture/High_Productive.gif");
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
	
	public void desplaySprite(int position) {    //main code from git hub
		//
//		URL url = getClass().getResource("texture/High Productive.gif");
		//
		 URL url = this.URLList.get(position);
		    Icon icon = new ImageIcon(url);
		    JLabel label = new JLabel(icon);
		 
		    JFrame f = new JFrame("Animation");
		    f.getContentPane().add(label);
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    f.pack();
		    f.setLocationRelativeTo(null);
		    f.setVisible(true);
	}
	public void addURL(String newURLString) {
		URL newURL= null;
		try {
			newURL = new URL(newURLString);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.URLList.add(newURL);
	}
}
