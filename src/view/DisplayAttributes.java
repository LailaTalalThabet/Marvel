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
import javax.swing.JLabel;
import javax.swing.JPanel;
import engine.Game;
import engine.Player;
import model.world.Champion;

public class DisplayAttributes extends JFrame implements ActionListener {
private JPanel Grid = new JPanel(new GridLayout(3,5,10,10));
private JPanel Details = new JPanel();
private ArrayList<Champion> myChamps;
private ArrayList<JButton> characterButtons=new ArrayList<JButton>();
Font customFont;
JButton back=new JButton("Back");
JFrame ff=new JFrame();
JButton next=new JButton("Next");
Game r;
JButton Choose1 =new JButton("Choose this for Player1");
JButton  Choose2=new JButton("Choose this for Player2");
private int c=0;
private ArrayList<Champion >a=new ArrayList<Champion>();
private ArrayList<Champion >b=new ArrayList<Champion>();
private Champion cur;
private JButton curr;
ArrayList<Champion > Chosen=new ArrayList<Champion>();
Player a1;
Player b1;


	public DisplayAttributes(Player a1,Player b1) {
		//this.r=r;
		this.a1=a1;
		this.b1=b1;
		Game r=new Game(a1,b1);
		Grid.setPreferredSize(new Dimension(0,600));
		Grid.setBackground(Color.RED);
		
		Details.setPreferredSize(new Dimension (0,120));
		Details.add(next);
		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
			myChamps = Game.getAvailableChampions();
			
			this.setLayout(new BorderLayout());
			this.setBounds(0, 0,1380, 720);
			this.add(Grid,BorderLayout.SOUTH);
			this.add(Details,BorderLayout.NORTH);
			try {
			    //create the font to use. Specify the size!
			    customFont = Font.createFont(Font.PLAIN, new File("AvengeroRegular-zvgl.ttf")).deriveFont(18f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(customFont);
			} catch (IOException e) {
			    e.printStackTrace();
			} catch(FontFormatException e) {
			    e.printStackTrace();
			}
			
			for(int i = 0; i<myChamps.size();i++) {
				JButton b = new JButton();
				
				b.setText(myChamps.get(i).getName());
				b.setBackground(Color.DARK_GRAY);
				b.setForeground(Color.white);
				b.setFont(customFont);
				// add the controller as its ActionListener
				b.addActionListener(this);
				// add it to the products buy buttons panel
				Grid.add(b);
				// and also add it to the ArrayList for later use
				characterButtons.add(b);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Details.setBackground(Color.RED);
		String i="Click on a Champion to view his Details";
		JLabel inst = new JLabel(i);
		customFont.deriveFont(50);
		inst.setFont(this.customFont);
		back.addActionListener(this);
		Choose1.addActionListener(this);
		Choose2.addActionListener(this);
		next.addActionListener(this);
		next.setBackground(Color.DARK_GRAY);
		next.setForeground(Color.white);
		next.setFont(customFont);
		Details.add(inst);
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		repaint();
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(Chosen.size()==6) {
			ChoosingChampions j=new ChoosingChampions(a1,b1,Chosen);
			this.dispose();
		}
		else {
		curr=(JButton)e.getSource();
		int ChampionIndex=0;
		// get its index within the ArrayList of buttons
		
		for(int i=0;i<this.characterButtons.size();i++) {
			if(e.getSource()==characterButtons.get(i)){
				ChampionIndex=i;
				break;
			}
		}
		
		ChampionAttributes k=new ChampionAttributes(myChamps.get(ChampionIndex),this,(JButton)e.getSource());
		
		}
		
		
		}
	
	

}
