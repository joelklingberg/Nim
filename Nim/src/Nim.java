import java.util.Scanner;

public class Nim {
	private int sticks = 100;
	
	public int getSticks() {
		return sticks;
	}
	
	public void setSticks(int sticks) {
		this.sticks = sticks;
	}
	
	public void pickSticks(Player player, int amount) {
		if(amount > (getSticks() / 2)) {
			System.out.println("You may not pick more than half of the pile. Try again.");
			player.play(this);
		} else if(amount == 0) {
			System.out.println("You have to pick at least one stick. Try again.");
			player.play(this);
		} else {
			setSticks(this.sticks - amount);
			System.out.println(player.name + " picked " + amount + " sticks. There are " + getSticks() + " sticks remaining.");
		}
	}
	
	public void startGame(Player player1, Player player2){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many sticks should the game have?");
		while (!sc.hasNextInt())
			sc.next();
		int amount = sc.nextInt();
		this.setSticks(amount);
		
		Player playerTurn = player1;
		
		System.out.println("Game started. PREPARE FOR BATTLE. There are " + getSticks() + " sticks in the pile! " 
		+ playerTurn.name + " goes first!");
		
		// The game continues until only 1 stick remains:
		while(getSticks() != 1){
			if(playerTurn == player1){
				player1.play(this);
				playerTurn = player2;
			} else if (playerTurn == player2){
				player2.play(this);
				playerTurn = player1;
			}
			System.out.print(playerTurn.name + "s turn: ");
		}
		
		// Evaluates which player has won:
		if(playerTurn == player1){
			System.out.println("Game over. The winner is: " + player2.name);
		} else if(playerTurn == player2) {
			System.out.println("Game over. The winner is: " + player1.name);
		}
		
	}
}
