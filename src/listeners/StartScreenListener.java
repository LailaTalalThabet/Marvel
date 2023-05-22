package listeners;

import java.io.IOException;

import view.GetNames;

//import view.StartScreen;

public interface StartScreenListener {
	public void onStartGame(String player1Name, String player2Name, GetNames startScreen);
}
