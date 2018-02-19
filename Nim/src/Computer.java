import java.util.Random;

public class Computer extends Player {
	public Computer(){
		this.name = "Computer";
	}
	
	public int randomNumber(int max, int min){
		Random r = new Random();
		int randInt = r.nextInt(max-min) + min;
		return randInt;
	}
	
	@Override
	public void play(Nim nimGame){
		int sticksRemaining = nimGame.getSticks();
		double halfOfPile = sticksRemaining / 2;
		Math.round(halfOfPile);
		
		if(halfOfPile == 1){
			nimGame.pickSticks(this, 1);
		} else {
			int amount = randomNumber((int) halfOfPile, 1);
			nimGame.pickSticks(this, amount);
		}
	}
}
