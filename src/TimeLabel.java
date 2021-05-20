//Jesus Capo

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class TimeLabel extends JLabel {
	
	int x;
	int y;
	int w;
	int h;
	SimpleDateFormat format;
	Calendar calendar;

	private static final long serialVersionUID = 1L;

	public TimeLabel(int x, int y, int w, int h) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.format = new SimpleDateFormat(" kk:mm | MM/dd");
		this.calendar = Calendar.getInstance();
		setText(format.format(calendar.getTime()));
		setFont(new Font("Tahoma", Font.BOLD, 20));
		setForeground(Color.WHITE);
		setOpaque(true);
		setBackground(Color.BLUE);
		setBounds(x, y, w, h);
	}
	
	public TimeLabel() {
		this.format = new SimpleDateFormat(" kk:mm | MM/dd");
		this.calendar = Calendar.getInstance();
	}
	
	public void create(int x, int y, int w, int h) {
		
		setText(format.format(calendar.getTime()));
		setFont(new Font("Tahoma", Font.BOLD, 20));
		setForeground(Color.BLACK);
		setOpaque(true);
		setBackground(new Color(255,255,255));
		setBounds(x, y, w, h);
	}
	
	public void update() {
		this.calendar = Calendar.getInstance();
		setText(format.format(calendar.getTime()));
	}
}
