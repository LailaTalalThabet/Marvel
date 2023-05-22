package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import engine.*;
import listeners.StartScreenListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetNames extends JFrame implements ActionListener {
	private JTextField field1=new JTextField();
	private JTextField field2=new JTextField();
	private JButton submit=new JButton("Submit");
	private StartScreenListener listener;
	private Font customFont;
	public GetNames(){
		//fields and buttons
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
		field1.setText("Player1");
		field2.setText("Player2");
		field1.setPreferredSize(new Dimension(250,60));
		field2.setPreferredSize(new Dimension(250,60));
		field1.setBackground(Color.DARK_GRAY);
		field1.setForeground(Color.white);
		field1.setFont(customFont);
		field2.setBackground(Color.DARK_GRAY);
		field2.setForeground(Color.white);
		field2.setFont(customFont);
		submit.setPreferredSize(new Dimension(150,60));
		submit.setVerticalTextPosition(JButton.TOP);
		submit.setHorizontalTextPosition(JButton.CENTER);
		submit.setBackground(Color.DARK_GRAY);
		submit.setForeground(Color.white);
		submit.setFont(customFont);
		submit.setFocusable(true);
		submit.addActionListener(this);
		
		//frame
		
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0,1080, 720);
		
		//panels
		JPanel submitPanel=new JPanel();
		JPanel fillerUp=new JPanel();
		fillerUp.setPreferredSize(new Dimension(1080,300));
		submitPanel.setPreferredSize(new Dimension(1080,200));
		submitPanel.setPreferredSize(new Dimension(1080,200));
		JPanel left=new JPanel();
		JPanel right=new JPanel();
		left.setPreferredSize(new Dimension(400,0));
		right.setPreferredSize(new Dimension(400,0));
		this.add(left,BorderLayout.WEST);
		this.add(right,BorderLayout.EAST);
		this.add(submitPanel,BorderLayout.SOUTH);
		this.add(fillerUp,BorderLayout.NORTH);
		JPanel center=new JPanel(new BorderLayout());
		center.setPreferredSize(new Dimension(280,300));
		this.add(center,BorderLayout.CENTER);
		JPanel center2=new JPanel();
		center2.setPreferredSize(new Dimension(280,180));
		
		
		//adding
		
		center.add(field1,BorderLayout.NORTH);
		center.add(center2,BorderLayout.CENTER);
		center.add(field2,BorderLayout.SOUTH);
		submitPanel.add(submit);
		setTitle("The Conquerer");
		this.setBackground(Color.BLUE);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		repaint();
		
		
		
	}
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;

		// background image
		g2D.drawImage(new ImageIcon("red1.png").getImage(), -170,-80, null);

		// fix buttons
		submit.repaint();
		field1.repaint();
		field2.repaint();
		
	}
	
	public void setListener(StartScreenListener listener)
	{
		this.listener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submit) {
			if(field1.getText().equals("")||field2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter The Names","warning",JOptionPane.ERROR_MESSAGE);
			}
			else {
				DisplayAttributes d= new DisplayAttributes (new Player(field1.getText()),new Player(field2.getText()));
					//listener.onStartGame(field1.getText(),field2.getText(),this);
				
					
				
				//game=new Game(new Player(field1.getText()),new Player(field2.getText()));
				//this.nextView();
				this.dispose();
			}
		}
		
	}

}
