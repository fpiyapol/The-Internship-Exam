import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HangmanGameImplement {
	
	private ArrayList<String> words;
	private ArrayList<Character> guessing;
	private String word, hint;
	private Random random;
	private int no, incorrect, max_score, score;
	private boolean end, check;
	
	private String[] hangman = { " ________",
								" |/       ",
								" |        ",
								" |        ",
								" |        ",
								" |        ",
								"_|__      "};
	
	public void loadWords(String category) {
		try(BufferedReader reader = new BufferedReader(new FileReader(category+".txt"))){
			String tmp = "";
			
			words = new ArrayList<>();
			
			while((tmp = reader.readLine()) != null) {
				words.add(tmp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		random = new Random();
		no = random.nextInt(words.size());
		word = words.get(no).split(" - ")[0];
		hint = words.get(no).split(" - ")[1];
		
		System.out.println("Hint: " + "\" " + hint + " \"");
		
		guessing = new ArrayList<>();
		for(int chr = 0; chr < word.length(); chr++) {
			if(Character.isDigit(word.charAt(chr))) {
				guessing.add(word.charAt(chr));
			}else if(Character.isAlphabetic(word.charAt(chr))) {
				guessing.add('_');
			}else
				guessing.add(word.charAt(chr));
		}
		
		max_score = guessing.size() * 10;
		
	}
	
	public boolean guess(String character) {
		check = false;
		for(int chr = 0; chr < word.length(); chr++) {
			if(word.charAt(chr) == Character.toUpperCase(character.charAt(0)) || word.charAt(chr) == Character.toLowerCase(character.charAt(0))) {
				if(guessing.get(chr) != Character.toUpperCase(character.charAt(0)) && guessing.get(chr) != Character.toLowerCase(character.charAt(0))) {
					guessing.set(chr, word.charAt(chr));
					score += 10;
				}
				check = true;					
			}
		}
		
		if(!check) {
			score -= 5;
			incorrect += 1;
		}
		
		if(incorrect == 1) {
			hangman[1] =  " |/     | ";
		}else if(incorrect == 2) {
			hangman[2] = " |      O ";
		}else if(incorrect == 3) {
			hangman[3] = " |     \\| ";
		}else if(incorrect == 4) {
			hangman[3] = " |     \\|/";
		}else if(incorrect == 5) {
			hangman[4] = " |      | ";
			hangman[5] = " |     /   ";
		}else if(incorrect == 6) {
			hangman[5] = " |     / \\";
		}
		
		return check;
	}
	
	public boolean isEnd() {
		end = false;
		if(incorrect == 6) {
			end = true;
		}else {
			for(char c:guessing) {
				if(c == '_') {
					end = false;
					return end;
				}
			}
			end = true;
		}
		return end;
	}
	
	public void printGuessing() {
		for(char c:guessing) {
			System.out.print(c + " ");
		}
		
		System.out.println("\n" + score + "/" +max_score);
	}
	
	public void printHangman() {
		for(String hm:hangman) {
			System.out.println(hm);
		}
	}
	
	public void summary() {
		if(incorrect != 6) {
			System.out.println("You Win! score : " + score + "/" + max_score);
		}else {
			System.out.println("You lose. score : " + score + "/" + max_score);
		}
	}
}
