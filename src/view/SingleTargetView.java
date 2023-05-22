package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
import exceptions.AbilityUseException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import model.abilities.Ability;
import model.world.Champion;
import model.world.Cover;

public class SingleTargetView extends JFrame implements ActionListener{
	Ability x;
	Game g;
	JButton b;
	JPanel down=new JPanel();
	JButton back=new JButton("Back");
	JPanel details=new JPanel(new GridLayout(8,1));
	JPanel board=new JPanel(new GridLayout(5,5));
	JPanel Board=new JPanel(new BorderLayout());
	JButton cell1 = new JButton();
	JButton  cell2 = new JButton();
	JButton cell3 = new JButton();
	JButton  cell4 = new JButton();
	JButton  cell5 = new JButton();
	JButton  cell6 = new JButton();
	JButton  cell7 = new JButton();
	JButton  cell8 = new JButton();
	JButton  cell9 = new JButton();
	JButton  cell10 = new JButton();
	JButton cell11 = new JButton();
	JButton cell12 = new JButton();
	JButton cell13 = new JButton();
	JButton cell14 = new JButton();
	JButton cell15 = new JButton();
	JButton cell16 = new JButton();
	JButton cell17 = new JButton();
	JButton cell18 = new JButton();
	JButton cell19 = new JButton();
	JButton cell20 = new JButton();
	JButton cell21 = new JButton();
	JButton cell22 = new JButton();
	JButton cell23 = new JButton();
	JButton cell24 = new JButton();
	JButton cell25 = new JButton();
	GameView v;
	
	public SingleTargetView(Ability x,Game g,JButton b,GameView v) {
		this.x=x;
		this.b=b;
		this.g=g;
		this.v=v;
		
		this.setBounds(0, 0, 1300, 750);
		this.setLayout(new GridLayout(10,1));
		Board.setPreferredSize(new Dimension(800,550));
		details.setPreferredSize(new Dimension(400,550));
		JPanel f1=new JPanel();
		f1.setPreferredSize(new Dimension(50,550));
		JPanel f2=new JPanel();
		f2.setPreferredSize(new Dimension(50,550));
		
		board.add(cell1);
		board.add(cell2);
		board.add(cell3);
		board.add(cell4);
		board.add(cell5);
		board.add(cell6);
		board.add(cell7);
		board.add(cell8);
		board.add(cell9);
		board.add(cell10);
		board.add(cell11);
		board.add(cell12);
		board.add(cell13);
		board.add(cell14);
		board.add(cell15);
		board.add(cell16);
		board.add(cell17);
		board.add(cell18);
		board.add(cell19);
		board.add(cell20);
		board.add(cell21);
		board.add(cell22);
		board.add(cell23);
		board.add(cell24);
		board.add(cell25);
		cell1.addActionListener(this);
		cell2.addActionListener(this);
		cell3.addActionListener(this);
		cell4.addActionListener(this);
		cell5.addActionListener(this);
		cell6.addActionListener(this);
		cell7.addActionListener(this);
		cell8.addActionListener(this);
		cell9.addActionListener(this);
		cell10.addActionListener(this);
		cell11.addActionListener(this);
		cell12.addActionListener(this);
		cell13.addActionListener(this);
		cell14.addActionListener(this);
		cell15.addActionListener(this);
		cell16.addActionListener(this);
		cell17.addActionListener(this);
		cell18.addActionListener(this);
		cell19.addActionListener(this);
		cell20.addActionListener(this);
		cell21.addActionListener(this);
		cell22.addActionListener(this);
		cell23.addActionListener(this);
		cell24.addActionListener(this);
		cell25.addActionListener(this);
		
		
		this.updateBoard();
		JLabel ins=new JLabel("Choose a cell to Cast ability");
		JLabel name = new JLabel("Name: "+x.getName());
		JLabel mana = new JLabel("Mana Cost: "+x.getManaCost());
		JLabel base= new JLabel("Base Cooldown: "+x.getBaseCooldown());
		JLabel curr= new JLabel("Current Cooldown: "+x.getCurrentCooldown());
		JLabel range= new JLabel("range: "+x.getCastRange());
		JLabel action= new JLabel("Required Action Points: "+x.getRequiredActionPoints());
		JLabel type= new JLabel("Type: Single Target");
		this.add(details,BorderLayout.WEST);
		this.add(Board,BorderLayout.EAST);
		Board.add(f1,BorderLayout.EAST);
		Board.add(f2,BorderLayout.WEST);
		Board.add(board,BorderLayout.CENTER);
		back.addActionListener(this);
		down.setPreferredSize(new Dimension(1300,100));
		this.add(down,BorderLayout.SOUTH);
		down.add(back);
		details.add(ins);
		details.add(name);
		details.add(mana);
		details.add(base);
		details.add(curr);
		details.add(range);
		details.add(action);
		details.add(type);

		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		repaint();
		validate();
	}
	public void updateBoard() {
		cell1.setText("");
		cell2.setText("");
		cell3.setText("");
		cell4.setText("");
		cell5.setText("");
		cell6.setText("");
		cell7.setText("");
		cell8.setText("");
		cell9.setText("");
		cell10.setText("");
		cell11.setText("");
		cell12.setText("");
		cell13.setText("");
		cell14.setText("");
		cell15.setText("");
		cell16.setText("");
		cell17.setText("");
		cell18.setText("");
		cell19.setText("");
		cell20.setText("");
		cell21.setText("");
		cell22.setText("");
		cell23.setText("");
		cell24.setText("");
		cell25.setText("");
		
		if(g.getBoard()[0][0]!=null) {
			if(g.getBoard()[0][0] instanceof Champion) {
			   cell21.setText(((Champion)g.getBoard()[0][0]).getName()+((Champion)g.getBoard()[0][0]).getCurrentHP());
			}
			else {
				cell21.setText("Cover"+((Cover)g.getBoard()[0][0]).getCurrentHP());
			}
		}
		if(g.getBoard()[0][1]!=null) {
			if(g.getBoard()[0][1] instanceof Champion) {
			   cell22.setText(((Champion)g.getBoard()[0][1]).getName()+((Champion)g.getBoard()[0][1]).getCurrentHP());
			}
			else {
				cell22.setText("Cover"+((Cover)g.getBoard()[0][1]).getCurrentHP());
			}
		}
		if(g.getBoard()[0][2]!=null) {
			if(g.getBoard()[0][2] instanceof Champion) {
			   cell23.setText(((Champion)g.getBoard()[0][2]).getName()+((Champion)g.getBoard()[0][2]).getCurrentHP());
			}
			else {
				cell23.setText("Cover"+((Cover)g.getBoard()[0][2]).getCurrentHP());
			}
		}
		if(g.getBoard()[0][3]!=null) {
			if(g.getBoard()[0][3] instanceof Champion) {
			   cell24.setText(((Champion)g.getBoard()[0][3]).getName()+((Champion)g.getBoard()[0][3]).getCurrentHP());
			}
			else {
				cell24.setText("Cover"+((Cover)g.getBoard()[0][3]).getCurrentHP());
			}
		}
		if(g.getBoard()[0][4]!=null) {
			if(g.getBoard()[0][4] instanceof Champion) {
			   cell25.setText(((Champion)g.getBoard()[0][4]).getName()+((Champion)g.getBoard()[0][4]).getCurrentHP());
			}
			else {
				cell25.setText("Cover"+((Cover)g.getBoard()[0][4]).getCurrentHP());
			}
		}
		if(g.getBoard()[1][0]!=null) {
			if(g.getBoard()[1][0] instanceof Champion) {
			   cell16.setText(((Champion)g.getBoard()[1][0]).getName()+((Champion)g.getBoard()[1][0]).getCurrentHP());
			}
			else {
				cell16.setText("Cover "+((Cover)g.getBoard()[1][0]).getCurrentHP());
			}
		}
		if(g.getBoard()[1][1]!=null) {
			if(g.getBoard()[1][1] instanceof Champion) {
			   cell17.setText(((Champion)g.getBoard()[1][1]).getName()+((Champion)g.getBoard()[1][1]).getCurrentHP());
			}
			else {
				cell17.setText("Cover"+((Cover)g.getBoard()[1][1]).getCurrentHP());
			}
		}
		if(g.getBoard()[1][2]!=null) {
			if(g.getBoard()[1][2] instanceof Champion) {
			   cell18.setText(((Champion)g.getBoard()[1][2]).getName()+((Champion)g.getBoard()[1][2]).getCurrentHP());
			}
			else {
				cell18.setText("Cover"+((Cover)g.getBoard()[1][2]).getCurrentHP());
			}
		}
		if(g.getBoard()[1][3]!=null) {
			if(g.getBoard()[1][3] instanceof Champion) {
			   cell19.setText(((Champion)g.getBoard()[1][3]).getName()+((Champion)g.getBoard()[1][3]).getCurrentHP());
			}
			else {
				cell19.setText("Cover"+((Cover)g.getBoard()[1][3]).getCurrentHP());
			}
		}
		if(g.getBoard()[1][4]!=null) {
			if(g.getBoard()[1][4] instanceof Champion) {
			   cell20.setText(((Champion)g.getBoard()[1][4]).getName()+((Champion)g.getBoard()[1][4]).getCurrentHP());
			}
			else {
				cell20.setText("Cover"+((Cover)g.getBoard()[1][4]).getCurrentHP());
			}
		}
		if(g.getBoard()[2][0]!=null) {
			if(g.getBoard()[2][0] instanceof Champion) {
			   cell11.setText(((Champion)g.getBoard()[2][0]).getName()+((Champion)g.getBoard()[2][0]).getCurrentHP());
			}
			else {
				cell11.setText("Cover"+((Cover)g.getBoard()[2][0]).getCurrentHP());
			}
		}
		if(g.getBoard()[2][1]!=null) {
			if(g.getBoard()[2][1] instanceof Champion) {
			   cell12.setText(((Champion)g.getBoard()[2][1]).getName()+((Champion)g.getBoard()[2][1]).getCurrentHP());
			}
			else {
				cell12.setText("Cover"+((Cover)g.getBoard()[2][1]).getCurrentHP());
			}
		}
		if(g.getBoard()[2][2]!=null) {
			if(g.getBoard()[2][2] instanceof Champion) {
			   cell13.setText(((Champion)g.getBoard()[2][2]).getName()+((Champion)g.getBoard()[2][2]).getCurrentHP());
			}
			else {
				cell13.setText("Cover"+((Cover)g.getBoard()[2][2]).getCurrentHP());
			}
		}
		if(g.getBoard()[2][3]!=null) {
			if(g.getBoard()[2][3] instanceof Champion) {
			   cell14.setText(((Champion)g.getBoard()[2][3]).getName()+((Champion)g.getBoard()[2][3]).getCurrentHP());
			}
			else {
				cell14.setText("Cover"+((Cover)g.getBoard()[2][3]).getCurrentHP());
			}
		}
		if(g.getBoard()[2][4]!=null) {
			if(g.getBoard()[2][4] instanceof Champion) {
			   cell15.setText(((Champion)g.getBoard()[2][4]).getName()+((Champion)g.getBoard()[2][4]).getCurrentHP());
			}
			else {
				cell15.setText("Cover"+((Cover)g.getBoard()[2][4]).getCurrentHP());
			}
		}
		if(g.getBoard()[3][0]!=null) {
			if(g.getBoard()[3][0] instanceof Champion) {
			   cell6.setText(((Champion)g.getBoard()[3][0]).getName()+((Champion)g.getBoard()[3][0]).getCurrentHP());
			}
			else {
				cell6.setText("Cover"+((Cover)g.getBoard()[3][0]).getCurrentHP());
			}
		}
		if(g.getBoard()[3][1]!=null) {
			if(g.getBoard()[3][1] instanceof Champion) {
			   cell7.setText(((Champion)g.getBoard()[3][1]).getName()+((Champion)g.getBoard()[3][1]).getCurrentHP());
			}
			else {
				cell7.setText("Cover"+((Cover)g.getBoard()[3][1]).getCurrentHP());
			}
		}
		if(g.getBoard()[3][2]!=null) {
			if(g.getBoard()[3][2] instanceof Champion) {
			   cell8.setText(((Champion)g.getBoard()[3][2]).getName()+((Champion)g.getBoard()[3][2]).getCurrentHP());
			}
			else {
				cell8.setText("Cover"+((Cover)g.getBoard()[3][2]).getCurrentHP());
			}
		}
		if(g.getBoard()[3][3]!=null) {
			if(g.getBoard()[3][3] instanceof Champion) {
			   cell9.setText(((Champion)g.getBoard()[3][3]).getName()+((Champion)g.getBoard()[3][3]).getCurrentHP());
			}
			else {
				cell9.setText("Cover"+((Cover)g.getBoard()[3][3]).getCurrentHP());
			}
		}
		if(g.getBoard()[3][4]!=null) {
			if(g.getBoard()[3][4] instanceof Champion) {
			   cell10.setText(((Champion)g.getBoard()[3][4]).getName()+((Champion)g.getBoard()[3][4]).getCurrentHP());
			}
			else {
				cell10.setText("Cover"+((Cover)g.getBoard()[3][4]).getCurrentHP());
			}
		}
		if(g.getBoard()[4][0]!=null) {
			if(g.getBoard()[4][0] instanceof Champion) {
			   cell1.setText(((Champion)g.getBoard()[4][0]).getName()+((Champion)g.getBoard()[4][0]).getCurrentHP());
			}
			else {
				cell1.setText("Cover"+((Cover)g.getBoard()[4][0]).getCurrentHP());
			}
		}
		if(g.getBoard()[4][1]!=null) {
			if(g.getBoard()[4][1] instanceof Champion) {
			   cell2.setText(((Champion)g.getBoard()[4][1]).getName()+((Champion)g.getBoard()[4][1]).getCurrentHP());
			}
			else {
				cell2.setText("Cover"+((Cover)g.getBoard()[4][1]).getCurrentHP());
			}
		}
		if(g.getBoard()[4][2]!=null) {
			if(g.getBoard()[4][2] instanceof Champion) {
			   cell3.setText(((Champion)g.getBoard()[4][2]).getName()+((Champion)g.getBoard()[4][2]).getCurrentHP());
			}
			else {
				cell3.setText("Cover"+((Cover)g.getBoard()[4][2]).getCurrentHP());
			}
		}
		if(g.getBoard()[4][3]!=null) {
			if(g.getBoard()[4][3] instanceof Champion) {
			   cell4.setText(((Champion)g.getBoard()[4][3]).getName()+((Champion)g.getBoard()[4][3]).getCurrentHP());
			}
			else {
				cell4.setText("Cover"+((Cover)g.getBoard()[4][3]).getCurrentHP());
			}
		}
		if(g.getBoard()[4][4]!=null) {
			if(g.getBoard()[4][4] instanceof Champion) {
			   cell5.setText(((Champion)g.getBoard()[4][4]).getName()+((Champion)g.getBoard()[4][4]).getCurrentHP());
			}
			else {
				cell5.setText("Cover"+((Cover)g.getBoard()[4][4]).getCurrentHP());
			}
		}
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			dispose();
		}
		else if(e.getSource()==cell1) {
			try {
				g.castAbility(x, 4, 0);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell2) {
			try {
				g.castAbility(x, 4, 1);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell3) {
			try {
				g.castAbility(x, 4, 2);
				v.updateBoard();v.updateDetails();
				b.setEnabled(false);
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell5) {
			try {
				g.castAbility(x, 4, 4);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell6) {
			try {
				g.castAbility(x, 3, 0);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell7) {
			try {
				g.castAbility(x, 3, 1);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell8) {
			try {
				g.castAbility(x, 3, 2);
				v.updateBoard();v.updateDetails();
				this.dispose();
				b.setText("");
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell9) {
			try {
				g.castAbility(x, 3, 3);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell10) {
			try {
				g.castAbility(x, 3, 4);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell11) {
			try {
				g.castAbility(x, 2, 0);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell12) {
			try {
				g.castAbility(x, 2, 1);
				v.updateBoard();v.updateDetails();
				this.dispose();
				b.setText("");
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell13) {
			try {
				g.castAbility(x, 2, 2);
				v.updateBoard();v.updateDetails();
				this.dispose();
				b.setText("");
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell14) {
			try {
				g.castAbility(x, 2, 3);
				b.setText("");
				v.updateBoard();v.updateDetails();
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell15) {
			try {
				g.castAbility(x, 2, 4);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell16) {
			try {
				g.castAbility(x, 1, 0);
				v.updateBoard();v.updateDetails();
				this.dispose();
				b.setText("");
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell17) {
			try {
				g.castAbility(x, 1, 1);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell18) {
			try {
				g.castAbility(x, 1, 2);
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell19) {
			try {
				g.castAbility(x, 1, 3);
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell20) {
			try {
				g.castAbility(x, 1, 4);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell21) {
			try {
				g.castAbility(x, 0, 0);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell22) {
			try {
				g.castAbility(x, 0, 1);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell23) {
			try {
				g.castAbility(x, 0, 2);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell24) {
			try {
				g.castAbility(x, 0, 3);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cell25) {
			try {
				g.castAbility(x, 0, 4);
				v.updateBoard();v.updateDetails();
				b.setText("");
				this.dispose();
			} catch (NotEnoughResourcesException e1) {
				new ResExceptionView();
			} catch (AbilityUseException e1) {
				new AbilityExceptionView();
			} catch (InvalidTargetException e1) {
				new TargetExceptionView();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		}
		v.repaint();v.revalidate();
		
		
		
	}

}
