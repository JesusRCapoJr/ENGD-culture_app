import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NathanTest2 extends JFrame {
	
	public NathanTest2() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 35, 60, 60);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(100, 35, 150, 60);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(284, 35, 150, 60);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(465, 35, 150, 60);
		getContentPane().add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 136, 905, 617);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(925, 219, 451, 534);
		getContentPane().add(panel_1);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(925, 10, 451, 200);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				TaskWindow.initialize();
			}
		});
		panel_3.setBounds(715, 10, 200, 116);
		getContentPane().add(panel_3);
	}

	public static void main(String[] args) {
		initialize();
		
	}
	public static void initialize() {
		JFrame frame2 = new JFrame();
		frame2.setBounds(100, 100, 1400, 800);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
	}

}
