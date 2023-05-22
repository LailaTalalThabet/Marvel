package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listeners.StartListener;

public class StartView extends JFrame implements ActionListener{
	private JButton start = new JButton("Start");
	private GetNames g;
	private StartListener listener;
	private Font customFont; 
	public StartView(){
		try {
		    //create the font to use. Specify the size!
		    customFont = Font.createFont(Font.TRUETYPE_FONT, new File("AvengeroRegular-zvgl.ttf")).deriveFont(18f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		JPanel f=new JPanel();
		//f.setLayout(null);
		f.setPreferredSize(new Dimension(1080,200));
		this.setLayout(new BorderLayout());
		
		this.setBounds(0, 0,1080, 720);
		ImageIcon image=new ImageIcon("red1.png");
		this.setIconImage(image.getImage());
		//setContentPane(new JLabel(new ImageIcon("blue1.jpg")));
		
		//this.add(f,BorderLayout.SOUTH);
		//loadButton(start);
		start.setPreferredSize(new Dimension(150,60));
		start.setVerticalTextPosition(JButton.TOP);
		start.setHorizontalTextPosition(JButton.CENTER);
		start.setBackground(Color.DARK_GRAY);
		start.setForeground(Color.white);
		start.setFont(customFont);
		start.setFocusable(false);
		start.addActionListener(this);
		add(f,BorderLayout.SOUTH);
		f.add(start);
		
		this.setVisible(true);
		this.setPreferredSize(new Dimension(1080,720));
		setTitle("MARVEL ULTIMATE WAR");
		//start.setBorderPainted(false);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		repaint();
		
		
		
		
		
	}
	
	public void loadButton(JButton theButton)
	{
		theButton.setIcon(new ImageIcon("resources/" + theButton.getText() + "Image.jpg"));
		theButton.setPreferredSize(new Dimension(300, 220));
		theButton.setVerticalTextPosition(JButton.TOP);
		theButton.setHorizontalTextPosition(JButton.CENTER);
		theButton.setBackground(Color.DARK_GRAY);
		theButton.setForeground(Color.white);
		theButton.addActionListener(this);
	}
	public static void main(String[]args){
		StartView s=new StartView();
	}
	
	public void nextView(){
		g=new GetNames();
		//this.getContentPane().add(g);
	}
	public void setListener(StartListener s) {
		listener=s;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start){
			this.remove(start);
			listener.onStart();
			//this.nextView();
			//this.revalidate();
			//this.repaint();
			this.dispose();
		}
		
	}
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;

		// background image
		g2D.drawImage(new ImageIcon("red1.png").getImage(), -170,-80, null);

		// fix buttons
		start.repaint();
		
	}

}
