import java.util.Scanner;

public class Human extends Player {
	public Human(){
		this.name = "Human";
	}
	
	@Override
	public void play(Nim nimGame){
		Scanner sc = new Scanner(System.in);
		while (!sc.hasNextInt())
			sc.next();
		int amount = sc.nextInt();
		nimGame.pickSticks(this, amount);
	}
}
