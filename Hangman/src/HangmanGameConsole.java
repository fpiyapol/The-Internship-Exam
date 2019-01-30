import java.util.Scanner;

public class HangmanGameConsole {

	private Scanner scanner;
	private String category, character;
	
	public void play(HangmanGameImplement game) {
		
		scanner = new Scanner(System.in);
		
		//select category
		while(true) {
			System.out.println("Select Category : ");
			System.out.println("\t1.Car");
			System.out.println("\t2.Network");
			category = scanner.nextLine();
			if(!category.equals("1") && !category.equals("2")) {
				System.out.println("Invalid, Please enter number between 1-2");
			}else {
				break;
			}
		}
		
		
		
		game.loadWords(category);
		
		//start game
		game.start();
		
		while(!game.isEnd()) {
			game.printGuessing();
			System.out.print("> ");
			character = scanner.nextLine();
			if(game.checkInput(character)) {
				if(!game.guess(character)) {
					game.printHangman();
				}
			}
			
		}
		
		game.printGuessing();
		game.summary();
	}
	
}
