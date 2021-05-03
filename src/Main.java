//package ballworlds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import util.Random;

/**
 * The starting point for the Pandativty application. It opens the pandativity frame.
 * 
 * This app is created by Nathan Atkinson, Jesus Capo, John Chung, Steven Xia, and Kieya McClung.
 */
public class Main {
	//Single monitor, fails for some reason
	//private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
	
	//Multiple monitor
	private static GraphicsDevice gd; 
	private static int width; 
	private static int height; 
	private static final Color[] BACKGROUND_COLORS = { Color.RED,
			Color.BLUE, Color.GREEN };

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {		
		updateSize(); 
		//JFrame.setDefaultLookAndFeelDecorated(true);		//occasionally found code that makes the window slightly fancier
		JFrame pandativityFrame = new PandativityFrame();
		pandativityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pandativityFrame.setSize(new Dimension(width,height));
		JPanel navigationPanel = new JPanel();		
		
		// sprite testing
		
		Sprite sprite = null;
		try {
		
			sprite = new Sprite(pandativityFrame);
			System.out.println("We are after the sprite");
			sprite.update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	public static int getWidth() {
		updateSize(); 
		return width; 
	}
	
	public static int getHeight() {
		updateSize(); 
		return height; 
	}
	
	public static void updateSize() {
		gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth()/2;
		height = gd.getDisplayMode().getHeight()/2;
	}

}
