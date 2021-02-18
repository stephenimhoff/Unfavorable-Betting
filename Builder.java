import java.util.*;

public class Builder {

	public static void main(String args[]) {
		Random rand = new Random();
		//for(float i = 0; i <= 100; i++) {
			for(float i = 1; i <= 1; i++) {
				
			Strategy strat = new Strategy(i);
			System.out.println("INITIALIZING: " + strat.getBalance() + " " + strat.getBetperc());
			for(float j = 49; j<=49; j++) {
				
				coin coin1 = new coin(j);
				
				for(float k = 0; k < 100; k++) {
					float rand1 = rand.nextInt(100);
					
					float [] resultarr = coin1.getResults();
					if (resultarr[(int) rand1] ==1){
						System.out.println("you won");
						float  newbalance = (strat.getBalance() + (i/100)*strat.getBalance());
						System.out.println("NEW BALANCE IS " + newbalance);
						 strat.setBalance(newbalance);
						
						 System.out.println("Strategy: " + i/100 + " Coin odds: " + j + " Ending Balance: " + strat.getBalance());
					}
					else {
						//lose
						System.out.println("you lost");
						float  newbalance = strat.getBalance() - ((i/100)*strat.getBalance());
						 strat.setBalance(newbalance);
						 System.out.println("Strategy: " + i/100 + " Coin odds: " + j + " Ending Balance: " + strat.getBalance());
					}
					
				}
				
			}
		}
	}


}