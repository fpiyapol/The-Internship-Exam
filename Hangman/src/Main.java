
public class Main {

	public static void main(String[] args) {
		
		HangmanGameImplement game = new HangmanGameImplement();
		HangmanGameConsole ui = new HangmanGameConsole();
		
		ui.play(game);

	}

}
