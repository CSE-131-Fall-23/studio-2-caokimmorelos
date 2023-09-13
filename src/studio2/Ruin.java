package studio2;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
	System.out.println("Enter Start Amount: ");
	double start_amount = in.nextDouble();
	
	System.out.println("Enter Win Chance: ");
	double win_chance = in.nextDouble();
	
	System.out.println("Enter Win Limit: ");
	double win_limit = in.nextDouble();
	
	System.out.println();
	System.out.println();
	
	int rounds=0;
	
	while (start_amount < win_limit && start_amount > 0) {
		
	
		double current_iter = Math.random();
		String status;
		rounds++;
		
		if (current_iter <= win_chance) {
			status = "Win (+$1)";
			start_amount++;
		}
		else {
			status = "Lose (-$1)";
			start_amount--;
		}
		
		System.out.println("Number Generated: "+ current_iter);
		System.out.println(status + ": " + start_amount);
		System.out.println();
		

	}
	
	if (start_amount >= win_limit) {
		System.out.println();
		System.out.println();
		System.out.println("Game Over! Success in "+rounds+" rounds!");
	}
	else if (start_amount <= 0){
		System.out.println();
		System.out.println();
		System.out.println("Game Over! Ruin in "+rounds+" rounds!");
	}
	

  }
}
