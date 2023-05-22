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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.Game;
import model.world.Champion;

public class ChampionAttributes extends JFrame implements ActionListener {
	JButton back=new JButton("Back");
	JButton Choose=new JButton("Choose");
	DisplayAttributes d;
	Champion c;
	JButton b;
	boolean f=false;
	//int count;
	Font customFont;
	
	
	public ChampionAttributes(Champion c,DisplayAttributes d,JButton b) {
		//this.count=count;
		this.c=c;
		this.d=d;
		this.b=b;
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
		Choose.addActionListener(this);
		back.addActionListener(this);
		setLayout(new BorderLayout());
		setBounds(0, 0, 900, 500);
		JPanel p=new JPanel(new GridLayout(12,1));
		p.setPreferredSize(new Dimension(500,500));
		Choose.setBackground(Color.DARK_GRAY);
		Choose.setForeground(Color.white);
		Choose.setFont(customFont);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.white);
		back.setFont(customFont);
	    add(p,BorderLayout.CENTER);
		p.setBackground(Color.RED);

		JLabel name = new JLabel("Name      "+c.getName());
		JLabel mana = new JLabel("Mana      "+c.getMana());
		JLabel speed = new JLabel("Speed      "+c.getSpeed());
		JLabel hp=new JLabel("HP   "+c.getMaxHP());
		JLabel damage= new JLabel("Attack Damage      "+c.getAttackDamage());
		JLabel range = new JLabel("Attack Range      "+c.getAttackRange());
		JLabel actions = new JLabel("Max Actions Per Turn      "+c.getMaxActionPointsPerTurn());
		JLabel a1 = new JLabel("First Ability      "+c.getAbilities().get(0).getName());
		JLabel a2 = new JLabel("Second Ability      "+c.getAbilities().get(1).getName());
		JLabel a3 = new JLabel("Third Ability      "+c.getAbilities().get(2).getName());
		
		
		
		name.setFont(customFont);
		mana.setFont(customFont);
		speed.setFont(customFont);
		hp.setFont(customFont);
		damage.setFont(customFont);
		range.setFont(customFont);
		actions.setFont(customFont);
		a1.setFont(customFont);
		a2.setFont(customFont);
		a3.setFont(customFont);
	
		p.add(name);
		p.add(mana);
		p.add(speed);
		p.add(hp);
		p.add(damage);
		p.add(range);
		p.add(actions);
		p.add(a1);
		p.add(a2);
		p.add(a3);
		p.add(back);
		p.add(this.Choose);
		
		validate();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Choose) {
			d.Chosen.add(c);
			
			f=true;
			b.setEnabled(false);
			
		}
		this.dispose();
		
	}


}
