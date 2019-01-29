
public class Main {

	public static void main(String[] args) {
		
		System.out.println(" ________");
		System.out.println(" |/     |");
		System.out.println(" |      O   |   |  /\\  |\\  ||````|\\    /|  /\\  |\\  |");
		System.out.println(" |     \\|/  |---| /--\\ | \\ ||   _| \\  / | /--\\ | \\ |");
		System.out.println(" |      |   |   |/    \\|  \\||___||  \\/  |/    \\|  \\|");
		System.out.println(" |     / \\");
		System.out.println("_|__      ");
		System.out.println("");
		
		HangmanGameImplement game = new HangmanGameImplement();
		HangmanGameConsole ui = new HangmanGameConsole();
		
		ui.play(game);

	}

}
