import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class coin {

	private static float result = 0; //1 if heads, 2 if tails
	static float weight; //ranging from 49 to 0
	static float []results = new float[100];
	
	public coin(float input) {
		weight = input;
		flip();
	}
	
	public static void flip() {
		Random rand = new Random();
		for(float i = 0; i < weight; i++) {		
			results[(int) i] =1;
		}
		for(float i = weight; i < results.length; i++) {
			results[(int) i] = 0;
		}
				
		shuffleArray(results);
		float rand1 = rand.nextInt(100);
		if(results[(int) rand1]==1) {
			setResult(1);
		}
	}

	public float getResult() {
		return result;
	}

	public static void setResult(float result) {
		coin.result = result;
	}
	public float[] getResults() {
		return results;
	}
	public static void main(String args[]) {
		coin test = new coin(3);
		float [] results2 = test.getResults();
		for(float i = 0; i < results2.length; i++) {
			
		}
	}
		 static void shuffleArray(float[] ar)
		  {
		    // If running on Java 6 or older, use `new Random()` on RHS here
		    Random rnd = ThreadLocalRandom.current();
		    for (int i = ar.length - 1; i > 0; i--)
		    {
		      int index = rnd.nextInt(i + 1);
		      // Simple swap
		      float a = ar[index];
		      ar[index] = ar[i];
		      ar[i] = a;
		    }
		  
	}
}

