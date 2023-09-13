package studio2;
import java.util.Scanner;

public class RuinDaily {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
	System.out.println("Enter Start Amount: ");
	double start_amount = in.nextDouble();
	
	System.out.println("Enter Win Chance: ");
	double win_chance = in.nextDouble();
	
	System.out.println("Enter Win Limit: ");
	double win_limit = in.nextDouble();
	
	System.out.println("Enter Total Simulations: ");
	int totalSims = in.nextInt();
	
	System.out.println();
	System.out.println();
	
	
	double loss_counter=0;
	int count=1;
	
	for (int i=1; i<=totalSims; i++) {
		String status="WIN";
		int rounds=0;
		double current_amount = start_amount;
		while (current_amount < win_limit && current_amount > 0) {
		
			double current_iter = Math.random();
			rounds++;
			
			if (current_iter <= win_chance) {
				current_amount++;
			}
			else {
				current_amount--;
			}
			
		}
		
		if (current_amount == win_limit) {
			status="WIN";
			
		}
		else if (current_amount == 0){
			status="LOSE";
			loss_counter++;
		}
		
		System.out.println("Simulation "+count+": "+rounds+" "+ status);
		count++;
	}
	
	double expected_ruin;
	double a = (1-win_chance)/win_chance;
	if (win_chance==0.5) {
		expected_ruin = 1 - (start_amount/win_limit);
	}
	else {
		expected_ruin = (Math.pow(a,start_amount)- Math.pow(a,win_limit))/(1-Math.pow(a,win_limit));
	}
	
	double actual_ruin = loss_counter/totalSims;
	
	System.out.println("Ruin Rate from Simulation: "+ actual_ruin + " Expected Ruin Rate: "+ expected_ruin);
	
  }
}
