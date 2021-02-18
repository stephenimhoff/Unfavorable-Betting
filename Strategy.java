
public class Strategy {
private static float betperc; //ranges from 0 to 100(%) of wealth
private static float balance = 1000; //begins at 1000, we will chart performance

public Strategy(float bet) {
	setBetperc(bet);
	balance = 1000;
	}

public float getBetperc() {
	return betperc;
}

public static void setBetperc(float betperc) {
	Strategy.betperc = betperc;
}

public float getBalance() {
	return balance;
}

public void setBalance(float balance) {
	Strategy.balance = balance;
}
}
