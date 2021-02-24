import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Generator {

	static float trials = 10000;
	
	public static void main (String[] args) throws IOException{
		
		//for every strategy
			//for every coin
				//for 10k times
					//for 50 flips
					//if balance == goal
						//increment and go to next of the 10k attempts
					//else keep flipping
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the starting balance");
			String sbal = reader.readLine();
			System.out.println("Enter the goal balance");
			String goal = reader.readLine();
			float sbalfloat = Float.parseFloat(sbal);
			float goalfloat = Float.parseFloat(goal);
			System.out.println("sbal = " + sbalfloat);
			System.out.println("goal = " + goalfloat);
			System.out.println("Computing...");
			generate(sbalfloat, goalfloat);
			System.out.println("Done!");
	}

	//i = strategies
	//j = odds of the coin
	//k = number of trials
	//l = number of times the coin can be flipped to see if you get to the goal outcome
	private static void generate(float sbal, float target) {
		float success = 0;
		 try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
			 StringBuilder sb = new StringBuilder();
			 sb.append("Starting Balance");
			 sb.append(',');
			 sb.append(sbal);
			 sb.append('\n');
			 sb.append("Goal Balance");
			 sb.append(',');
			 sb.append(target);
			 sb.append('\n');
			 sb.append('\n');
			 sb.append("Betting %");
			 sb.append(',');
			 sb.append("Coin Odds (%)");
			 sb.append(',');
			 sb.append("Odds of success (10k trials)");
			 sb.append('\n');
			 writer.write(sb.toString());
			 sb.setLength(0);
			 //i <= 100
		for(float i = 1; i <= 100; i++) {
			//j <= 49
			for(float j = 0; j < 100; j++) {
				coin coin1 = new coin(j);
			//k<=10000
				for (float k = 1; k <= trials; k++) {
					
					float goal = target;
					float balance = sbal;
					//l < 50
					for(float l = 0; l <50; l++) {
						if(coin1.flip() == 1) {
							
							balance = balance + (i/100)*balance;
							//System.out.println("new balance: " + balance);
						}
						else {
							balance = balance - (i/100)*balance;
							//System.out.println("new balance: " + balance);
						}
						if(balance >= goal) {
							success++;
							break;
						}
						
					}
					if(k == trials) {
						float successperc = success/trials;
						success = 0;
						sb.append(i);
						sb.append(',');
						sb.append((int)j);
						sb.append(',');
						sb.append(successperc);
						 sb.append('\n');
						 writer.write(sb.toString());
						 sb.setLength(0);
					}
					
					
				}
			}
		}
		
	}
		 catch (FileNotFoundException e) {
		      System.out.println(e.getMessage());
		 }
}
}

