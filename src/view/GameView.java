package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

public class GameView extends JFrame implements ActionListener,MouseListener {
	

	JLabel name1;
	JLabel name2;
	Ability x;
	JLabel Leader1;
	JLabel Leader2;
	JButton leader = new JButton("Cast Leader Ability");
	JLabel champ1 = new JLabel();
	JLabel champ2 = new JLabel();
	JLabel champ3 = new JLabel();
	JLabel champ4 = new JLabel();
	JLabel champ5 = new JLabel();
	JLabel champ6 = new JLabel();
	Champion currChamp;
	JPanel board = new JPanel(new GridLayout(5, 5));
	JPanel details = new JPanel(new GridLayout(9, 1));
	JPanel abilities = new JPanel(new GridLayout(10,1));
	JLabel detailsName = new JLabel();
	JLabel detailsType = new JLabel();
	JLabel detailsHp = new JLabel();
	JLabel detailsMana = new JLabel();
	JLabel detailsActionPoints = new JLabel();
	JLabel detailsRange = new JLabel();
	JLabel detailsDamage = new JLabel();
	JLabel detailsEffects = new JLabel();
	JButton ability1 = new JButton();
	JButton ability2 = new JButton();
	JButton ability3 = new JButton();
	// JButton Cast= new JButton("Cast");
	JLabel ability = new JLabel("Abilities");
	JLabel t1 = new JLabel();
	JLabel t2 = new JLabel();
	JLabel t3 = new JLabel();
	JLabel t4 = new JLabel();
	JLabel t5 = new JLabel();
	JLabel t6 = new JLabel();
	JLabel t = new JLabel("Turn Order");

	JLabel nextChamp;
	Game g;

	JToggleButton Attack = new JToggleButton("Attack");
	JButton End = new JButton("End Turn");
	JToggleButton Move = new JToggleButton("Move");
	JButton cell1 = new JButton();
	JButton cell2 = new JButton();
	JButton cell3 = new JButton();
	JButton cell4 = new JButton();
	JButton cell5 = new JButton();
	JButton cell6 = new JButton();
	JButton cell7 = new JButton();
	JButton cell8 = new JButton();
	JButton cell9 = new JButton();
	JButton cell10 = new JButton();
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
	JButton up = new JButton("UP");
	JButton down = new JButton("Down");
	JButton left = new JButton("Left");
	JButton right = new JButton("Right");
	JLabel a = new JLabel("");
	JLabel b = new JLabel("");
	JPanel p = new JPanel(new GridLayout(2, 3));
	JLabel n1=new JLabel();
	JLabel mana1=new JLabel();
	JLabel speed=new JLabel();
	JLabel type=new JLabel();
	JLabel mapt=new JLabel();
	JLabel damage=new JLabel();
	JLabel range=new JLabel();
	JLabel hp=new JLabel();
	JLabel effects=new JLabel();

	public GameView(Game g) throws IOException {
		this.g = g;
		// PriorityQueue p=new PriorityQueue(6);

		leader.addActionListener(this);
		t1.setText(((Champion) g.getTurnOrder().peekMin()).getName());

		cell1.addMouseListener(this);
		cell2.addMouseListener(this);
		cell3.addMouseListener(this);
		cell4.addMouseListener(this);
		cell5.addMouseListener(this);
		cell6.addMouseListener(this);
		cell7.addMouseListener(this);
		cell8.addMouseListener(this);
		cell9.addMouseListener(this);
		cell10.addMouseListener(this);
		cell11.addMouseListener(this);
		cell12.addMouseListener(this);
		cell13.addMouseListener(this);
		cell14.addMouseListener(this);
		cell15.addMouseListener(this);
		cell16.addMouseListener(this);
		cell17.addMouseListener(this);
		cell18.addMouseListener(this);
		cell19.addMouseListener(this);
		cell20.addMouseListener(this);
		cell21.addMouseListener(this);
		cell22.addMouseListener(this);
		cell23.addMouseListener(this);
		cell24.addMouseListener(this);
		cell25.addMouseListener(this);

		// g.placeChampions();

		currChamp = g.getCurrentChampion();
		this.setBounds(0, 0, 1300, 750);
		this.setLayout(new BorderLayout());
		name1 = new JLabel(g.getFirstPlayer().getName());
		name2 = new JLabel(g.getSecondPlayer().getName());
		

		JPanel up = new JPanel(new BorderLayout());
		up.setPreferredSize(new Dimension(0, 100));

		JPanel center = new JPanel(new BorderLayout());
		center.setPreferredSize(new Dimension(0, 500));

		JPanel down = new JPanel(new GridLayout(1, 10));
		down.setPreferredSize(new Dimension(0, 75));

		JPanel up1 = new JPanel(new BorderLayout());
		JPanel up2 = new JPanel(new BorderLayout());
		JPanel up3 = new JPanel(new BorderLayout());

		JPanel up11 = new JPanel(new BorderLayout());
		JPanel up12 = new JPanel(new GridLayout(1, 3));
		up11.setPreferredSize(new Dimension(0, 50));
		up12.setPreferredSize(new Dimension(0, 50));
		JPanel up21 = new JPanel(new BorderLayout());
		JPanel up22 = new JPanel(new GridLayout(1, 3));
		up21.setPreferredSize(new Dimension(0, 50));
		up22.setPreferredSize(new Dimension(0, 50));

		up1.setPreferredSize(new Dimension(350, 100));
		up3.setPreferredSize(new Dimension(600, 100));
		up2.setPreferredSize(new Dimension(350, 100));
		champ1.setText(g.getFirstPlayer().getTeam().get(0).getName());
		champ2.setText(g.getFirstPlayer().getTeam().get(1).getName());
		champ3.setText(g.getFirstPlayer().getTeam().get(2).getName());
		champ4.setText(g.getSecondPlayer().getTeam().get(0).getName());
		champ5.setText(g.getSecondPlayer().getTeam().get(1).getName());
		champ6.setText(g.getSecondPlayer().getTeam().get(2).getName());
		Leader1 = new JLabel("Leader Ability Not Used");
		Leader2 = new JLabel("Leader Ability Not Used");

		// editing up Panel
		add(up, BorderLayout.NORTH);
		up.add(up1, BorderLayout.WEST);
		up.add(up2, BorderLayout.EAST);
		up.add(up3, BorderLayout.CENTER);
		up1.add(up11, BorderLayout.NORTH);
		up1.add(up12, BorderLayout.SOUTH);

		up2.add(up21, BorderLayout.NORTH);
		up2.add(up22, BorderLayout.SOUTH);
		up11.add(name1, BorderLayout.NORTH);
		up21.add(name2, BorderLayout.NORTH);
		name1.setBackground(Color.BLUE);
		name2.setBackground(Color.RED);
		name1.setForeground(Color.RED);
		name2.setForeground(Color.BLUE);
		
		
		up11.add(Leader1, BorderLayout.SOUTH);
		up21.add(Leader2, BorderLayout.SOUTH);

		up12.add(champ1);
		up12.add(champ2);
		up12.add(champ3);
		up22.add(champ4);
		up22.add(champ5);
		up22.add(champ6);

		// Center Panel
		add(center, BorderLayout.CENTER);
		JPanel Details1 = new JPanel(new BorderLayout());
		JPanel abilities1 = new JPanel(new BorderLayout());
		Details1.setPreferredSize(new Dimension(400, 500));
		abilities1.setPreferredSize(new Dimension(300, 500));

		JPanel Filler1 = new JPanel();
		JPanel Filler2 = new JPanel();
		board.setPreferredSize(new Dimension(700, 500));
		details.setPreferredSize(new Dimension(300, 500));
		abilities.setPreferredSize(new Dimension(250, 500));

		Filler1.setPreferredSize(new Dimension(50, 500));
		Filler2.setPreferredSize(new Dimension(50, 500));

		center.add(Details1, BorderLayout.WEST);
		center.add(board, BorderLayout.CENTER);
		center.add(abilities1, BorderLayout.EAST);
		// Details1.add(Filler1,BorderLayout.EAST);
		abilities1.add(Filler2, BorderLayout.WEST);
		Details1.add(details, BorderLayout.WEST);
		abilities1.add(abilities, BorderLayout.EAST);

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

		this.updateBoard();
		// update Details
		this.updateDetails();
		// detailsEffects???
		details.add(detailsName);
		details.add(detailsType);
		details.add(detailsHp);
		details.add(detailsMana);
		details.add(detailsActionPoints);
		details.add(detailsRange);
		details.add(detailsDamage);
		//abilities.add(this.ability);
		details.add(leader);

		Ability x = currChamp.getAbilities().get(0);

		ability1.addActionListener(this);
		ability2.addActionListener(this);
		ability3.addActionListener(this);

		ability1.setText("Name:" + x.getName());
		ability2.setText("Name:" + currChamp.getAbilities().get(1).getName());
		ability3.setText("Name:" + currChamp.getAbilities().get(2).getName());
		/*abilities.add(ability1);
		abilities.add(ability2);
		abilities.add(ability3);*/
		abilities.add(n1);
		abilities.add(mana1);
		abilities.add(mapt);
		abilities.add(speed);
		abilities.add(range);
		abilities.add(damage);
		abilities.add(hp);
		abilities.setVisible(false);
		
		
		
		
		
		
		
	

		// akher panel
		Attack.addActionListener(this);

		this.Move.addActionListener(this);
		JPanel d = new JPanel(new BorderLayout());
		d.setPreferredSize(new Dimension(0, 150));
		JPanel down2 = new JPanel(new GridLayout(1, 2));
		down2.setPreferredSize(new Dimension(0, 75));

		add(d, BorderLayout.SOUTH);
		d.add(down, BorderLayout.SOUTH);
		d.add(down2, BorderLayout.NORTH);
		down2.add(t);
		down2.add(t1);

		down.add(this.Attack);
		down.add(this.Move);
		down.add(this.End);
		down.add(p);
		down.add(ability1);
		down.add(ability2);
		down.add(ability3);
		this.up.addActionListener(this);
		this.left.addActionListener(this);
		this.down.addActionListener(this);
		this.right.addActionListener(this);

		p.add(a);
		p.add(this.up);
		p.add(b);
		p.add(left);
		p.add(this.down);
		p.add(this.right);
		this.End.addActionListener(this);

		
		cell1.setFont(new Font("Arial", Font.PLAIN, 10));
		cell2.setFont(new Font("Arial", Font.PLAIN, 10));
		cell3.setFont(new Font("Arial", Font.PLAIN, 10));
		cell4.setFont(new Font("Arial", Font.PLAIN, 10));
		cell5.setFont(new Font("Arial", Font.PLAIN, 10));
		cell6.setFont(new Font("Arial", Font.PLAIN, 10));
		cell7.setFont(new Font("Arial", Font.PLAIN, 10));
		cell8.setFont(new Font("Arial", Font.PLAIN, 10));
		cell9.setFont(new Font("Arial", Font.PLAIN, 10));
		cell10.setFont(new Font("Arial", Font.PLAIN, 10));
		cell11.setFont(new Font("Arial", Font.PLAIN, 10));
		cell12.setFont(new Font("Arial", Font.PLAIN, 10));
		cell13.setFont(new Font("Arial", Font.PLAIN, 10));
		cell14.setFont(new Font("Arial", Font.PLAIN, 10));
		cell15.setFont(new Font("Arial", Font.PLAIN, 10));
		cell16.setFont(new Font("Arial", Font.PLAIN, 10));
		cell17.setFont(new Font("Arial", Font.PLAIN, 10));
		cell18.setFont(new Font("Arial", Font.PLAIN, 10));
		cell19.setFont(new Font("Arial", Font.PLAIN, 10));
		cell20.setFont(new Font("Arial", Font.PLAIN, 10));
		cell21.setFont(new Font("Arial", Font.PLAIN, 10));
		cell22.setFont(new Font("Arial", Font.PLAIN, 10));
		cell23.setFont(new Font("Arial", Font.PLAIN, 10));
		cell24.setFont(new Font("Arial", Font.PLAIN, 10));
		cell25.setFont(new Font("Arial", Font.PLAIN, 10));
		this.updateTurnOrder();

		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		repaint();
	}

	public void updateAbilities() {
		currChamp = g.getCurrentChampion();
		if (currChamp.getAbilities().size() > 0) {
			ability1.setText("Name:" + currChamp.getAbilities().get(0).getName());
			ability3.setText("");
			ability2.setText("");

		}
		if (currChamp.getAbilities().size() > 1) {
			ability2.setText("Name:" + currChamp.getAbilities().get(1).getName());
			ability3.setText("");

		}
		if (currChamp.getAbilities().size() > 2)
			ability3.setText("Name:" + currChamp.getAbilities().get(2).getName());

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
		cell1.setBackground(Color.LIGHT_GRAY);
		cell1.setForeground(Color.WHITE);
		cell2.setBackground(Color.LIGHT_GRAY);
		cell2.setForeground(Color.WHITE);
		cell3.setBackground(Color.LIGHT_GRAY);
		cell3.setForeground(Color.WHITE);
		cell4.setBackground(Color.LIGHT_GRAY);
		cell4.setForeground(Color.WHITE);
		cell5.setBackground(Color.LIGHT_GRAY);
		cell5.setForeground(Color.WHITE);
		cell6.setBackground(Color.LIGHT_GRAY);
		cell6.setForeground(Color.WHITE);
		cell7.setBackground(Color.LIGHT_GRAY);
		cell7.setForeground(Color.WHITE);
		cell8.setBackground(Color.LIGHT_GRAY);
		cell8.setForeground(Color.WHITE);
		cell9.setBackground(Color.LIGHT_GRAY);
		cell9.setForeground(Color.WHITE);
		cell10.setBackground(Color.LIGHT_GRAY);
		cell10.setForeground(Color.WHITE);
		cell11.setBackground(Color.LIGHT_GRAY);
		cell11.setForeground(Color.WHITE);
		cell12.setBackground(Color.LIGHT_GRAY);
		cell12.setForeground(Color.WHITE);
		cell13.setBackground(Color.LIGHT_GRAY);
		cell13.setForeground(Color.WHITE);
		cell14.setBackground(Color.LIGHT_GRAY);
		cell14.setForeground(Color.WHITE);
		cell15.setBackground(Color.LIGHT_GRAY);
		cell15.setForeground(Color.WHITE);
		cell16.setBackground(Color.LIGHT_GRAY);
		cell16.setForeground(Color.WHITE);
		cell17.setBackground(Color.LIGHT_GRAY);
		cell17.setForeground(Color.WHITE);
		cell18.setBackground(Color.LIGHT_GRAY);
		cell18.setForeground(Color.WHITE);
		cell19.setBackground(Color.LIGHT_GRAY);
		cell19.setForeground(Color.WHITE);
		cell20.setBackground(Color.LIGHT_GRAY);
		cell20.setForeground(Color.WHITE);
		cell21.setBackground(Color.LIGHT_GRAY);
		cell21.setForeground(Color.WHITE);
		cell22.setBackground(Color.LIGHT_GRAY);
		cell22.setForeground(Color.WHITE);
		cell23.setBackground(Color.LIGHT_GRAY);
		cell23.setForeground(Color.WHITE);
		cell24.setBackground(Color.LIGHT_GRAY);
		cell24.setForeground(Color.WHITE);
		cell25.setBackground(Color.LIGHT_GRAY);
		cell25.setForeground(Color.WHITE);

		if (g.getBoard()[0][0] != null) {
			if (g.getBoard()[0][0] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[0][0]) ) 
					cell21.setBackground(Color.RED);
				else
					cell21.setBackground(Color.BLUE);

				cell21.setText(
						((Champion) g.getBoard()[0][0]).getName() + ((Champion) g.getBoard()[0][0]).getCurrentHP());

			} else {
				cell21.setText("Cover" + ((Cover) g.getBoard()[0][0]).getCurrentHP());
			}
		}
		if (g.getBoard()[0][1] != null) {
			if (g.getBoard()[0][1] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[0][1]) ) 
					cell22.setBackground(Color.RED);
				else
					cell22.setBackground(Color.BLUE);
				cell22.setText(
						((Champion) g.getBoard()[0][1]).getName() + ((Champion) g.getBoard()[0][1]).getCurrentHP());
			} else {
				cell22.setText("Cover" + ((Cover) g.getBoard()[0][1]).getCurrentHP());
			}
		}
		if (g.getBoard()[0][2] != null) {
			if (g.getBoard()[0][2] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[0][2]) ) 
					cell23.setBackground(Color.RED);
				else
					cell23.setBackground(Color.BLUE);
				cell23.setText(
						((Champion) g.getBoard()[0][2]).getName() + ((Champion) g.getBoard()[0][2]).getCurrentHP());
			} else {
				cell23.setText("Cover" + ((Cover) g.getBoard()[0][2]).getCurrentHP());
			}
		}
		if (g.getBoard()[0][3] != null) {
			if (g.getBoard()[0][3] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[0][3]) ) 
					cell24.setBackground(Color.RED);
				else
					cell24.setBackground(Color.BLUE);
				cell24.setText(
						((Champion) g.getBoard()[0][3]).getName() + ((Champion) g.getBoard()[0][3]).getCurrentHP());
			} else {
				cell24.setText("Cover" + ((Cover) g.getBoard()[0][3]).getCurrentHP());
			}
		}
		if (g.getBoard()[0][4] != null) {
			if (g.getBoard()[0][4] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[0][4]) ) 
					cell25.setBackground(Color.RED);
				else
					cell25.setBackground(Color.BLUE);
				cell25.setText(
						((Champion) g.getBoard()[0][4]).getName() + ((Champion) g.getBoard()[0][4]).getCurrentHP());
			} else {
				cell25.setText("Cover" + ((Cover) g.getBoard()[0][4]).getCurrentHP());
			}
		}
		if (g.getBoard()[1][0] != null) {
			if (g.getBoard()[1][0] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[1][0]) ) 
					cell16.setBackground(Color.RED);
				else
					cell16.setBackground(Color.BLUE);
				cell16.setText(
						((Champion) g.getBoard()[1][0]).getName() + ((Champion) g.getBoard()[1][0]).getCurrentHP());
			} else {
				cell16.setText("Cover " + ((Cover) g.getBoard()[1][0]).getCurrentHP());
			}
		}
		if (g.getBoard()[1][1] != null) {
			if (g.getBoard()[1][1] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[1][1]) ) 
					cell17.setBackground(Color.RED);
				else
					cell17.setBackground(Color.BLUE);
				cell17.setText(
						((Champion) g.getBoard()[1][1]).getName() + ((Champion) g.getBoard()[1][1]).getCurrentHP());
			} else {
				cell17.setText("Cover" + ((Cover) g.getBoard()[1][1]).getCurrentHP());
			}
		}
		if (g.getBoard()[1][2] != null) {
			if (g.getBoard()[1][2] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[1][2]) ) 
					cell18.setBackground(Color.RED);
				else
					cell18.setBackground(Color.BLUE);
				cell18.setText(
						((Champion) g.getBoard()[1][2]).getName() + ((Champion) g.getBoard()[1][2]).getCurrentHP());
			} else {
				cell18.setText("Cover" + ((Cover) g.getBoard()[1][2]).getCurrentHP());
			}
		}
		if (g.getBoard()[1][3] != null) {
			if (g.getBoard()[1][3] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[1][3]) ) 
					cell19.setBackground(Color.RED);
				else
					cell19.setBackground(Color.BLUE);
				cell19.setText(
						((Champion) g.getBoard()[1][3]).getName() + ((Champion) g.getBoard()[1][3]).getCurrentHP());
			} else {
				cell19.setText("Cover" + ((Cover) g.getBoard()[1][3]).getCurrentHP());
			}
		}
		if (g.getBoard()[1][4] != null) {
			if (g.getBoard()[1][4] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[1][4]) ) 
					cell20.setBackground(Color.RED);
				else
					cell20.setBackground(Color.BLUE);
				cell20.setText(
						((Champion) g.getBoard()[1][4]).getName() + ((Champion) g.getBoard()[1][4]).getCurrentHP());
			} else {
				cell20.setText("Cover" + ((Cover) g.getBoard()[1][4]).getCurrentHP());
			}
		}
		if (g.getBoard()[2][0] != null) {
			if (g.getBoard()[2][0] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[2][0]) ) 
					cell11.setBackground(Color.RED);
				else
					cell11.setBackground(Color.BLUE);
				cell11.setText(
						((Champion) g.getBoard()[2][0]).getName() + ((Champion) g.getBoard()[2][0]).getCurrentHP());
			} else {
				cell11.setText("Cover" + ((Cover) g.getBoard()[2][0]).getCurrentHP());
			}
		}
		if (g.getBoard()[2][1] != null) {
			if (g.getBoard()[2][1] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[2][1]) ) 
					cell12.setBackground(Color.RED);
				else
					cell12.setBackground(Color.BLUE);
				cell12.setText(
						((Champion) g.getBoard()[2][1]).getName() + ((Champion) g.getBoard()[2][1]).getCurrentHP());
			} else {
				cell12.setText("Cover" + ((Cover) g.getBoard()[2][1]).getCurrentHP());
			}
		}
		if (g.getBoard()[2][2] != null) {
			if (g.getBoard()[2][2] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[2][2]) ) 
					cell13.setBackground(Color.RED);
				else
					cell13.setBackground(Color.BLUE);
				cell13.setText(
						((Champion) g.getBoard()[2][2]).getName() + ((Champion) g.getBoard()[2][2]).getCurrentHP());
			} else {
				cell13.setText("Cover" + ((Cover) g.getBoard()[2][2]).getCurrentHP());
			}
		}
		if (g.getBoard()[2][3] != null) {
			if (g.getBoard()[2][3] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[2][3]) ) 
					cell14.setBackground(Color.RED);
				else
					cell14.setBackground(Color.BLUE);
				cell14.setText(
						((Champion) g.getBoard()[2][3]).getName() + ((Champion) g.getBoard()[2][3]).getCurrentHP());
			} else {
				cell14.setText("Cover" + ((Cover) g.getBoard()[2][3]).getCurrentHP());
			}
		}
		if (g.getBoard()[2][4] != null) {
			if (g.getBoard()[2][4] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[2][4]) ) 
					cell15.setBackground(Color.RED);
				else
					cell15.setBackground(Color.BLUE);
				cell15.setText(
						((Champion) g.getBoard()[2][4]).getName() + ((Champion) g.getBoard()[2][4]).getCurrentHP());
			} else {
				cell15.setText("Cover" + ((Cover) g.getBoard()[2][4]).getCurrentHP());
			}
		}
		if (g.getBoard()[3][0] != null) {
			if (g.getBoard()[3][0] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[3][0]) ) 
					cell6.setBackground(Color.RED);
				else
					cell6.setBackground(Color.BLUE);
				cell6.setText(
						((Champion) g.getBoard()[3][0]).getName() + ((Champion) g.getBoard()[3][0]).getCurrentHP());
			} else {
				cell6.setText("Cover" + ((Cover) g.getBoard()[3][0]).getCurrentHP());
			}
		}
		if (g.getBoard()[3][1] != null) {
			if (g.getBoard()[3][1] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[3][1]) ) 
					cell7.setBackground(Color.RED);
				else
					cell7.setBackground(Color.BLUE);
				cell7.setText(
						((Champion) g.getBoard()[3][1]).getName() + ((Champion) g.getBoard()[3][1]).getCurrentHP());
			} else {
				cell7.setText("Cover" + ((Cover) g.getBoard()[3][1]).getCurrentHP());
			}
		}
		if (g.getBoard()[3][2] != null) {
			if (g.getBoard()[3][2] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[3][2]) ) 
					cell8.setBackground(Color.RED);
				else
					cell8.setBackground(Color.BLUE);
				cell8.setText(
						((Champion) g.getBoard()[3][2]).getName() + ((Champion) g.getBoard()[3][2]).getCurrentHP());
			} else {
				cell8.setText("Cover" + ((Cover) g.getBoard()[3][2]).getCurrentHP());
			}
		}
		if (g.getBoard()[3][3] != null) {
			if (g.getBoard()[3][3] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[3][3]) ) 
					cell9.setBackground(Color.RED);
				else
					cell9.setBackground(Color.BLUE);
				cell9.setText(
						((Champion) g.getBoard()[3][3]).getName() + ((Champion) g.getBoard()[3][3]).getCurrentHP());
			} else {
				cell9.setText("Cover" + ((Cover) g.getBoard()[3][3]).getCurrentHP());
			}
		}
		if (g.getBoard()[3][4] != null) {
			if (g.getBoard()[3][4] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[3][4]) ) 
					cell10.setBackground(Color.RED);
				else
					cell10.setBackground(Color.BLUE);
				cell10.setText(
						((Champion) g.getBoard()[3][4]).getName() + ((Champion) g.getBoard()[3][4]).getCurrentHP());
			} else {
				cell10.setText("Cover" + ((Cover) g.getBoard()[3][4]).getCurrentHP());
			}
		}
		if (g.getBoard()[4][0] != null) {
			if (g.getBoard()[4][0] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[4][0]) ) 
					cell1.setBackground(Color.RED);
				else
					cell1.setBackground(Color.BLUE);
				cell1.setText(
						((Champion) g.getBoard()[4][0]).getName() + ((Champion) g.getBoard()[4][0]).getCurrentHP());
			} else {
				cell1.setText("Cover" + ((Cover) g.getBoard()[4][0]).getCurrentHP());
			}
		}
		if (g.getBoard()[4][1] != null) {
			if (g.getBoard()[4][1] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[4][1]) ) 
					cell2.setBackground(Color.RED);
				else
					cell2.setBackground(Color.BLUE);
				cell2.setText(
						((Champion) g.getBoard()[4][1]).getName() + ((Champion) g.getBoard()[4][1]).getCurrentHP());
			} else {
				cell2.setText("Cover" + ((Cover) g.getBoard()[4][1]).getCurrentHP());
			}
		}
		if (g.getBoard()[4][2] != null) {
			if (g.getBoard()[4][2] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[4][2]) ) 
					cell3.setBackground(Color.RED);
				else
					cell3.setBackground(Color.BLUE);
				cell3.setText(
						((Champion) g.getBoard()[4][2]).getName() + ((Champion) g.getBoard()[4][2]).getCurrentHP());
			} else {
				cell3.setText("Cover" + ((Cover) g.getBoard()[4][2]).getCurrentHP());
			}
		}
		if (g.getBoard()[4][3] != null) {
			if (g.getBoard()[4][3] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[4][3]) ) 
					cell4.setBackground(Color.RED);
				else
					cell4.setBackground(Color.BLUE);
				cell4.setText(
						((Champion) g.getBoard()[4][3]).getName() + ((Champion) g.getBoard()[4][3]).getCurrentHP());
			} else {
				cell4.setText("Cover" + ((Cover) g.getBoard()[4][3]).getCurrentHP());
			}
		}
		if (g.getBoard()[4][4] != null) {
			if (g.getBoard()[4][4] instanceof Champion) {
				if(g.getFirstPlayer().getTeam().contains(g.getBoard()[4][4]) ) 
					cell5.setBackground(Color.RED);
				else
					cell5.setBackground(Color.BLUE);
				cell5.setText(
						((Champion) g.getBoard()[4][4]).getName() + ((Champion) g.getBoard()[4][4]).getCurrentHP());
			} else {
				cell5.setText("Cover" + ((Cover) g.getBoard()[4][4]).getCurrentHP());
			}
		}
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}

	public void updateDetails() {
		currChamp = g.getCurrentChampion();
		detailsName.setText("Name :  " + currChamp.getName());
		leader.setEnabled(false);
		if (currChamp instanceof Villain) {
			detailsType.setText("Type :  Villain");
		}
		if (currChamp instanceof AntiHero) {
			detailsType.setText("Type :  AntiHero");
		}
		if (currChamp instanceof Hero) {
			detailsType.setText("Type :  Hero");
		}
		detailsHp.setText("HP:  " + currChamp.getCurrentHP());
		detailsMana.setText("Mana: " + currChamp.getMana());
		detailsActionPoints.setText("Action Points Left: " + currChamp.getCurrentActionPoints());
		detailsRange.setText("Attack Range: " + currChamp.getAttackRange());
		detailsDamage.setText("Attack Damage: " + currChamp.getAttackDamage());
		if (g.getFirstPlayer().getLeader() == currChamp && !g.isFirstLeaderAbilityUsed()) {
			leader.setEnabled(true);
		}
		if (g.getSecondPlayer().getLeader() == currChamp && !g.isSecondLeaderAbilityUsed()) {
			leader.setEnabled(true);
		}
		this.repaint();
		this.revalidate();

	}

	public void updateTurnOrder() {
		t1.setText("");
		t1.setText(g.getTurnOrder().toString());
		this.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Attack) {
			Move.setSelected(false);
			Attack.setSelected(true);
		}

		if (e.getSource() == Move) {
			Attack.setSelected(false);
			Move.setSelected(true);

		}
		if (e.getSource() == leader) {

			try {
				g.useLeaderAbility();
				leader.setEnabled(false);
				if (g.isFirstLeaderAbilityUsed()) {
					this.Leader1.setText("Leader Ability Used");
				} else if (g.isSecondLeaderAbilityUsed())
					this.Leader2.setText("Leader Ability Used");
				if (g.checkGameOver() != null) {
					new YouWon(this, g);
				}
				this.updateBoard();
				this.updateDetails();
				this.repaint();
				this.revalidate();
			} catch (LeaderNotCurrentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LeaderAbilityAlreadyUsedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == this.up) {
			if (Move.isSelected()) {
				try {
					this.g.move(Direction.UP);
					this.updateBoard();
					this.updateDetails();
				} catch (NotEnoughResourcesException e1) {
					new ResExceptionView();

				} catch (UnallowedMovementException e1) {
					new MoveExceptionView();
				}

			}
			if (Attack.isSelected()) {
				try {
					g.attack(Direction.UP);
					this.updateBoard();
					this.updateDetails();
				} catch (NotEnoughResourcesException e1) {
					new ResExceptionView();
				} catch (ChampionDisarmedException e1) {
					new DisarmedExceptionView();
				} catch (InvalidTargetException e1) {
					new TargetExceptionView();
				}
			}
			if (g.checkGameOver() != null) {
				new YouWon(this, g);
			}
		}

		if (e.getSource() == this.down) {
			if (Move.isSelected()) {
				try {
					this.g.move(Direction.DOWN);
					this.updateBoard();
					this.updateDetails();
				} catch (NotEnoughResourcesException e1) {
					new ResExceptionView();

				} catch (UnallowedMovementException e1) {
					new MoveExceptionView();
				}

			}
			if (Attack.isSelected()) {
				try {
					g.attack(Direction.DOWN);
					this.updateBoard();
					this.updateDetails();
				} catch (NotEnoughResourcesException e1) {
					new ResExceptionView();
				} catch (ChampionDisarmedException e1) {
					new DisarmedExceptionView();
				} catch (InvalidTargetException e1) {
					new TargetExceptionView();
				}
			}
			if (g.checkGameOver() != null) {
				new YouWon(this, g);
			}
		}
		if (e.getSource() == this.left) {
			if (Move.isSelected()) {
				try {
					this.g.move(Direction.LEFT);
					this.updateBoard();
					this.updateDetails();
				} catch (NotEnoughResourcesException e1) {
					new ResExceptionView();

				} catch (UnallowedMovementException e1) {
					new MoveExceptionView();
				}

			}
			if (Attack.isSelected()) {
				try {
					g.attack(Direction.LEFT);
					this.updateBoard();
					this.updateDetails();
				} catch (NotEnoughResourcesException e1) {
					new ResExceptionView();
				} catch (ChampionDisarmedException e1) {
					new DisarmedExceptionView();
				} catch (InvalidTargetException e1) {
					new TargetExceptionView();
				}
			}
			if (g.checkGameOver() != null) {
				new YouWon(this, g);
			}
		}
			if (e.getSource() == this.right) {
				if (Move.isSelected()) {
					try {
						this.g.move(Direction.RIGHT);
						this.updateBoard();
						this.updateDetails();
					} catch (NotEnoughResourcesException e1) {
						new ResExceptionView();

					} catch (UnallowedMovementException e1) {
						new MoveExceptionView();
					}

				}
				if (Attack.isSelected()) {
					try {
						g.attack(Direction.RIGHT);
						this.updateBoard();
						this.updateDetails();
					} catch (NotEnoughResourcesException e1) {
						new ResExceptionView();
					} catch (ChampionDisarmedException e1) {
						new DisarmedExceptionView();
					} catch (InvalidTargetException e1) {
						new TargetExceptionView();
					}
				}
				if (g.checkGameOver() != null) {
					new YouWon(this, g);
				}
			}
			
			
		
		if (e.getSource() == this.ability1 && !ability1.getText().equals("")) {
			x = null;
			for (int i = 0; i < currChamp.getAbilities().size(); i++) {
				if (ability1.getText().equals("Name:" + currChamp.getAbilities().get(i).getName()))
					x = currChamp.getAbilities().get(i);
			}
			if (x.getCastArea() == AreaOfEffect.SINGLETARGET) {
				new SingleTargetView(x, this.g, ability1, this);

			} else if (x.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				new DirectionalView(x, this.g, ability1, this);

			} else {
				new NormalAbilityView(x, g, ability1, this);

			}
			if (g.checkGameOver() != null) {
				new YouWon(this, g);
			}

		}
		if (e.getSource() == this.ability2 && !ability2.getText().equals("")) {
			x = null;
			for (int i = 0; i < currChamp.getAbilities().size(); i++) {
				if (ability2.getText().equals("Name:" + currChamp.getAbilities().get(i).getName()))
					x = currChamp.getAbilities().get(i);
			}
			if (x.getCastArea() == AreaOfEffect.SINGLETARGET) {
				new SingleTargetView(x, this.g, ability2, this);

			} else if (x.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				new DirectionalView(x, this.g, ability2, this);

			} else {
				new NormalAbilityView(x, g, ability2, this);

			}
			if (g.checkGameOver() != null) {
				new YouWon(this, g);
			}

		}
		if (e.getSource() == this.ability3 && !ability3.getText().equals("")) {
			x = null;
			for (int i = 0; i < currChamp.getAbilities().size(); i++) {
				if (ability3.getText().equals("Name:" + currChamp.getAbilities().get(i).getName()))
					x = currChamp.getAbilities().get(i);
			}
			if (x.getCastArea() == AreaOfEffect.SINGLETARGET) {
				new SingleTargetView(x, this.g, ability3, this);

			} else if (x.getCastArea() == AreaOfEffect.DIRECTIONAL) {
				new DirectionalView(x, this.g, ability3, this);

			} else {
				new NormalAbilityView(x, g, ability3, this);

			}
			if (g.checkGameOver() != null) {
				new YouWon(this, g);
			}

		}
		if (e.getSource() == End) {
			g.endTurn();
			if (g.checkGameOver() != null) {
				new YouWon(this, g);
			}
			this.updateBoard();
			this.updateDetails();
			this.updateTurnOrder();
			this.updateAbilities();
			this.repaint();
			this.revalidate();

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(((JButton)e.getSource()).getText().equals(""))
				return;
		if(((JButton)e.getSource()).getText().contains("Cover"))
			return;
		Champion c=null;
		for(int i=0;i<g.getFirstPlayer().getTeam().size();i++) {
		    if(((JButton)e.getSource()).getText().equals(g.getFirstPlayer().getTeam().get(i).getName()+g.getFirstPlayer().getTeam().get(i).getCurrentHP())){
		    	c=g.getFirstPlayer().getTeam().get(i);
		    }
		}
		for(int i=0;i<g.getSecondPlayer().getTeam().size();i++) {
		    if(((JButton)e.getSource()).getText().equals(g.getSecondPlayer().getTeam().get(i).getName()+g.getSecondPlayer().getTeam().get(i).getCurrentHP())){
		    	c=g.getSecondPlayer().getTeam().get(i);
		    }
		}
		n1.setText("Name: "+c.getName());
		mana1.setText("Mana: "+c.getMana());
		speed.setText("Speed:  "+c.getSpeed());
		range.setText("Attack Range: "+c.getAttackRange());
		damage.setText("Attack damage: "+c.getAttackDamage());
		this.mapt.setText("Max Actions Per Turn: "+c.getMaxActionPointsPerTurn());
		hp.setText("Current Hp: "+c.getCurrentHP());
		abilities.setVisible(true);
		this.repaint();
		this.revalidate();
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		abilities.setVisible(false);
		this.revalidate();
		this.repaint();
		
	}

}
