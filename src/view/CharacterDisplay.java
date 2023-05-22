package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import engine.*;
import model.world.Champion;
public class CharacterDisplay extends JFrame implements ActionListener {
private ArrayList<JButton> characterButtons;
private ArrayList<Champion> myChampions;
private JPanel p = new JPanel(new GridLayout(3,5));
private JButton submit;


	public CharacterDisplay(Game r) {
		myChampions = r.getAvailableChampions();
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0,1080, 720);
		add(p, BorderLayout.WEST);
		
		for(int i = 0; i<15;i++) {
			JButton b = new JButton();
			b.setText(myChampions.get(i).getName());
			// add the controller as its ActionListener
			b.addActionListener(this);
			// add it to the products buy buttons panel
			p.add(b);
			// and also add it to the ArrayList for later use
			characterButtons.add(b);
			
		}
		
		this.setVisible(true);
		validate();
		repaint();
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			JButton b = (JButton) e.getSource();
			// get its index within the ArrayList of buttons
			int ChampionIndex =characterButtons.indexOf(b);
			// get the corresponding product from the supermarket
			Champion c = myChampions.get(ChampionIndex);
			
		}
		
		// get the JButton that was clicked
		JButton b = (JButton) e.getSource();
		// get its index within the ArrayList of buttons
		int ChampionIndex =characterButtons.indexOf(b);
		// get the corresponding product from the supermarket
		Champion c = myChampions.get(ChampionIndex);
		// 
	}

}
