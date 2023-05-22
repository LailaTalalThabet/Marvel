package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;
import exceptions.AbilityUseException;
import exceptions.NotEnoughResourcesException;
import model.abilities.Ability;

public class NormalAbilityView extends JFrame implements ActionListener {
	
	JButton back=new JButton("Back");
	JButton cast=new JButton("Cast");
	Ability x;
	Game g;
	JButton b;
	GameView v;
	
	public NormalAbilityView(Ability x,Game g,JButton b,GameView v) {
		this.v=v;
		back.addActionListener(this);
		cast.addActionListener(this);
		this.x=x;
		this.g=g;
		this.b=b;
		this.setBounds(100, 100, 500, 300);
		this.setLayout(new GridLayout(9,1));
		JLabel name = new JLabel("Name: "+x.getName());
		JLabel mana = new JLabel("Mana Cost: "+x.getManaCost());
		JLabel base= new JLabel("Base Cooldown: "+x.getBaseCooldown());
		JLabel curr= new JLabel("Current Cooldown: "+x.getCurrentCooldown());
		JLabel range= new JLabel("range: "+x.getCastRange());
		JLabel action= new JLabel("Required Action Points: "+x.getRequiredActionPoints());
		JLabel type= new JLabel("Type:"+x.getCastArea());
		this.add(name);
		this.add(mana);
		this.add(base);
		this.add(curr);
		this.add(range);
		this.add(action);
		this.add(type);
		this.add(back);
		this.add(cast);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			this.dispose();
		}
		if(e.getSource()==cast) {
			try {
				g.castAbility(x);
				v.updateBoard();v.updateDetails();
				v.revalidate();v.repaint();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (CloneNotSupportedException e1) {
				
				e1.printStackTrace();
			}
		}
		
	}

}
