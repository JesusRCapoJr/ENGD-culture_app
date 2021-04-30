//package ballworlds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
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
	//private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
	private final static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static final int WIDTH = gd.getDisplayMode().getWidth();
	public static final int HEIGHT = gd.getDisplayMode().getHeight();
	public static final Color[] BACKGROUND_COLORS = { Color.RED,
			Color.BLUE, Color.GREEN };

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {		
		JFrame pandativityFrame = new PandativityFrame();
		pandativityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pandativityFrame.setSize(new Dimension(WIDTH,HEIGHT));
		JPanel navigationPanel = new JPanel();		
	}


}
