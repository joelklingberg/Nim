
public class Main {

	public static void main(String[] args) {	
		Player computer1 = new Computer();
		Player human1 = new Human();
		Nim gameInstance = new Nim();
		gameInstance.startGame(computer1, human1);	
	}
}