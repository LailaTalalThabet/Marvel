package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import engine.Game;
import engine.Player;

public class Quiz3 extends JFrame implements ActionListener{
	Game g= new Game(new Player ("p1"),new Player("P2"));
	
	public Quiz3() {
		try {
			g.loadAbilities("Abilities.csv");
			g.loadChampions("Champions.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setPreferredSize(new Dimension(1200,750));
		
		
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.validate();
		this.repaint();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
