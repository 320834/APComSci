package p8_2__p8_6;

public class PurseTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Purse purse = new Purse();
		purse.addCoin("Dime");
		purse.addCoin("Quarter");
		purse.addCoin("Penny");
		purse.addCoin("Nickel");
		Purse pursec = new Purse();
		pursec.addCoin("Dime");
		pursec.addCoin("Quarter");
		pursec.addCoin("Penny");
		pursec.addCoin("Nickel");
		System.out.println(pursec.sameContents(purse));
		System.out.println(pursec.sameCoins(purse));	
		System.out.println(purse);
		purse.reverse();
		System.out.println(pursec.sameCoins(purse));
		System.out.println(pursec.sameContents(purse));
		System.out.println(purse);
		Purse purseb = new Purse();
		purseb.addCoin("Half-Dollar");
		purseb.addCoin("Dollar Coin");
		System.out.println(pursec.sameCoins(purseb));
		System.out.println(purseb);
		purse.transfer(purseb);
		System.out.println(purse);
		System.out.println(purseb);
	}

}
