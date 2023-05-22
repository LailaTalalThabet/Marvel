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
import model.world.Direction;

public class DirectionalView extends JFrame implements ActionListener{
	JLabel ins=new JLabel("Click on Direction to cast ability");
	Ability x;
	Game g;
	JButton b;
	JButton back=new JButton("Back");
	JButton up=new JButton("UP");
	JButton down=new JButton("Down");
	JButton left=new JButton("Left");
	JButton right=new JButton("Right");
	GameView v;
	
	public DirectionalView(Ability x,Game g,JButton b,GameView v) {
		this.v=v;
		this.x=x;
		this.g=g;
		this.b=b;
		this.setBounds(200, 100, 700, 400);
		this.setLayout(new GridLayout(13,1));
		
		JLabel name = new JLabel("Name: "+x.getName());
		JLabel mana = new JLabel("Mana Cost: "+x.getManaCost());
		JLabel base= new JLabel("Base Cooldown: "+x.getBaseCooldown());
		JLabel curr= new JLabel("Current Cooldown: "+x.getCurrentCooldown());
		JLabel range= new JLabel("range: "+x.getCastRange());
		JLabel action= new JLabel("Required Action Points: "+x.getRequiredActionPoints());
		JLabel type= new JLabel("Type: Directional");
		up.addActionListener(this);
		down.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		back.addActionListener(this);
		this.add(ins);
		this.add(name);
		this.add(mana);
		this.add(base);
		this.add(curr);
		this.add(range);
		this.add(action);
		this.add(type);
		this.add(up);
		this.add(down);
		this.add(left);
		this.add(right);
		this.add(back);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		repaint();
		validate();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			this.dispose();
		}
		else if(e.getSource()==this.up){
			try {
				g.castAbility(x, Direction.UP);
				v.updateBoard();v.updateDetails();
				v.repaint();v.revalidate();
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
		else if(e.getSource()==this.down){
			try {
				g.castAbility(x, Direction.DOWN);
				v.updateBoard();v.updateDetails();
				v.repaint();v.revalidate();
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
		else if(e.getSource()==this.left){
			try {
				g.castAbility(x, Direction.LEFT);
				v.updateBoard();v.updateDetails();
				v.repaint();v.revalidate();
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
		else if(e.getSource()==this.right){
			try {
				g.castAbility(x, Direction.RIGHT);
				v.updateBoard();v.updateDetails();
				v.repaint();v.revalidate();
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
