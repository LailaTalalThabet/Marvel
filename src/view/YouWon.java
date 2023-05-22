package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Game;

public class YouWon extends JFrame implements ActionListener{
	GameView v;
	Game g;
	JLabel text=new JLabel("");
	JButton ok=new JButton("Ok");
	public YouWon(GameView v,Game g) {
		this.g=g;
		this.v=v;
		
		this.setBounds(100,100,500,500);
		this.setLayout(new BorderLayout());
		if(g.checkGameOver()==g.getFirstPlayer()) {
			text.setText(g.getFirstPlayer().getName()+" WON!");
		}
		else {
			text.setText(g.getSecondPlayer().getName()+" WON!");
		}
		this.add(text,BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		repaint();
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok) {
			v.dispose();
			this.dispose();
		}
		
	}
	

}
