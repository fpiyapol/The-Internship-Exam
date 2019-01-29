import java.util.Scanner;

public class HangmanGameConsole {

	private Scanner scanner;
	private String category, character;
	
	public void play(HangmanGameImplement game) {
		
		scanner = new Scanner(System.in);
		
		//select category
		System.out.println("Select Category : ");
		System.out.println("\t1.Car");
		System.out.println("\t2.Network");
		
		category = scanner.nextLine();
		
		game.loadWords(category);
		
		//start game
		game.start();
		
		while(!game.isEnd()) {
			game.printGuessing();
			System.out.print("> ");
			character = scanner.nextLine();
			if(game.guess(character)) {
				
			}else {
				game.printHangman();
			}
		}
		
		game.printGuessing();
		game.summary();
	}
	
}
