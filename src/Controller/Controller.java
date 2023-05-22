package Controller;

import java.io.IOException;

import engine.Game;
import engine.Player;
import listeners.StartListener;
import listeners.StartScreenListener;
import view.*;


public class Controller implements StartScreenListener,StartListener {
	private Game theGame;
	private GetNames getNames;
	private StartView startView;
	
	public Controller() {
		startView=new StartView();
		startView.setListener(this);
	}

	public static void main(String[]args) {
	Controller c=new Controller();
	
}

public Game getTheGame() {
		return theGame;
	}

	
@Override
public void onStartGame(String player1Name, String player2Name, GetNames startScreen) {
	//theGame=new Game(new Player(player1Name),new Player(player2Name));
	//DisplayAttributes A= new DisplayAttributes(theGame);
}

@Override
public void onStart() {
	this.getNames=new GetNames();
	getNames.setListener(this);
	
}



}
