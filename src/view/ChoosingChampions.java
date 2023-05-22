package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class ChoosingChampions extends JFrame implements ActionListener {
	ArrayList<Champion> champs;
	Game g;
	JToggleButton c1;
	JToggleButton c2;
	JToggleButton c3;
	JToggleButton cc1;
	JToggleButton cc2;
	JToggleButton cc3;
	String a="";
	String b="";
	JPanel fillerUp=new JPanel();
	JPanel center1=new JPanel(new GridLayout(2,3,50,10));
	//JPanel center2=new JPanel(new GridLayout(1,3,10,10));
	JPanel fillerDown=new JPanel();
	JButton hamada=new JButton("GO");
	Font customFont;
	Player a1;
	Player b1;
	public ChoosingChampions(Player a,Player b,ArrayList<Champion> champs) {
		this.a1=a;
		this.b1=b;

		this.champs=champs;
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
		
		c1=new JToggleButton(champs.get(0).getName());
		c2=new JToggleButton(champs.get(1).getName());
		c3=new JToggleButton(champs.get(2).getName());
		cc1=new JToggleButton(champs.get(3).getName());
		cc2=new JToggleButton(champs.get(4).getName());
		cc3=new JToggleButton(champs.get(5).getName());
		c1.addActionListener(this);
		c2.addActionListener(this);
		c3.addActionListener(this);
		cc1.addActionListener(this);
		cc2.addActionListener(this);
		cc3.addActionListener(this);
		fillerUp.setPreferredSize(new Dimension(1080,100));
		center1.setPreferredSize(new Dimension(1080,420));
		fillerDown.setPreferredSize(new Dimension(1080,200));
		c1.setBackground(Color.DARK_GRAY);
		c1.setForeground(Color.white);
		c1.setFont(customFont);
		c2.setBackground(Color.DARK_GRAY);
		c2.setForeground(Color.white);
		c2.setFont(customFont);
		c3.setBackground(Color.DARK_GRAY);
		c3.setForeground(Color.white);
		c3.setFont(customFont);
		cc1.setBackground(Color.DARK_GRAY);
		cc1.setForeground(Color.white);
		cc1.setFont(customFont);
		cc2.setBackground(Color.DARK_GRAY);
		cc2.setForeground(Color.white);
		cc2.setFont(customFont);cc1.setBackground(Color.DARK_GRAY);
		cc3.setBackground(Color.DARK_GRAY);
		cc3.setForeground(Color.white);
		cc3.setFont(customFont);
		hamada.setBackground(Color.DARK_GRAY);
		hamada.setForeground(Color.white);
		hamada.setFont(customFont);
		hamada.addActionListener(this);
		fillerUp.setBackground(Color.RED);
		center1.setBackground(Color.RED);
		fillerDown.setBackground(Color.RED);
	
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0,1080, 720);
		
		add(fillerUp,BorderLayout.NORTH);
		add(fillerDown,BorderLayout.SOUTH);
		add(center1,BorderLayout.CENTER);
		center1.add(c1);
		center1.add(c2);
		center1.add(c3);
		center1.add(cc1);
		center1.add(cc2);
		center1.add(cc3);
		fillerDown.add(hamada);
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		repaint();
		
		
		
		
		for(int i=0;i<6;i++) {
			if(i<3) {
				a1.getTeam().add(champs.get(i));
			}
			else {
				b1.getTeam().add(champs.get(i));
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==c1) {
			c1.setSelected(true);
			c2.setSelected(false);
			c3.setSelected(false);
			
		}
		if(e.getSource()==c2) {
			c2.setSelected(true);
			c1.setSelected(false);
			c3.setSelected(false);
			
		}
		if(e.getSource()==c3) {
			c3.setSelected(true);
			c1.setSelected(false);
			c2.setSelected(false);
			
		}
		if(e.getSource()==cc3) {
			cc3.setSelected(true);
			cc1.setSelected(false);
			cc2.setSelected(false);
			
		}
		if(e.getSource()==cc2) {
			cc2.setSelected(true);
			cc1.setSelected(false);
			cc3.setSelected(false);
			
		}
		if(e.getSource()==cc1) {
			cc1.setSelected(true);
			cc2.setSelected(false);
			cc3.setSelected(false);
			
		}
		if(e.getSource()==hamada) {
			if((c1.isSelected()||c2.isSelected()||c3.isSelected())&&(cc1.isSelected()||cc2.isSelected()||cc3.isSelected())) {
				if(c1.isSelected()) {
					a1.setLeader(champs.get(0));
				}
				if(c2.isSelected()) {
					a1.setLeader(champs.get(1));
				}
				if(c3.isSelected()) {
					a1.setLeader(champs.get(2));
				}
				if(cc1.isSelected()) {
					b1.setLeader(champs.get(0));
				}
				if(cc2.isSelected()) {
					b1.setLeader(champs.get(1));
				}
				if(cc3.isSelected()) {
					b1.setLeader(champs.get(2));
				}
				
				Game h=new Game(a1,b1);
				
					try {
						GameView gg=new GameView(h);
						this.dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			
				
				
			}
			else {
				JOptionPane.showMessageDialog(null, "please select a leader for both players", "Warning",
						JOptionPane.ERROR_MESSAGE);
				
			}
		}
		
	}

}
