//package ballworlds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 300;
	private static final Color[] BACKGROUND_COLORS = { Color.RED,
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
