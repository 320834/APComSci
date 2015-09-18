package p8_2__p8_6;

import java.util.ArrayList;

public class Purse {
	ArrayList<String> list = new ArrayList<String>();
	public Purse(){
	}
	
	public void addCoin(String coinName){
		list.add(coinName);
	}
	
	public String toString(){
		String string ="";
		for(String v: list){
			string += v + ", ";
		}
		if(string.length()>2)
			return "Purse[" + string.substring(0, string.length() - 2) + "]";
		else
			return "Purse[]";
	}
	
	public void reverse(){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++)
			temp.add(list.get(i));
		list.clear();
		for(int i = temp.size() - 1; i >=0; i--)
			list.add(temp.get(i));
	}
	
	public void transfer(Purse other){
		for(String v: other.list)
			list.add(v);
		other.list.clear();
	}
	
	public boolean sameContents(Purse other){
		boolean same = true;
		if(this.list.size() == other.list.size()){
			for(int i = 0; i < this.list.size(); i ++)
				if(this.list.get(i).compareToIgnoreCase(other.list.get(i)) != 0)
					same = false;
		}
		else{
			same = false;
		}
		return same;
	}
	
	public boolean sameCoins(Purse other){
		int[] source = coinNumbers();
		int[] compare = other.coinNumbers();
		boolean flag = true;
		for(int i = 0; i < source.length; i++)
			if(source[i] != compare[i])
				flag = false;
		return flag;
	}
	
	public int[] coinNumbers(){
		int[] coins = new int[6];
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).compareToIgnoreCase("Penny") == 0)
				coins[0]++;
			else if(list.get(i).compareToIgnoreCase("Nickel") == 0)
				coins[1]++;
			else if(list.get(i).compareToIgnoreCase("Dime") == 0)
				coins[2]++;
			else if(list.get(i).compareToIgnoreCase("Quarter") == 0)
				coins[3]++;
			else if(list.get(i).compareToIgnoreCase("Half-Dollar") == 0)
				coins[4]++;
			else if(list.get(i).compareToIgnoreCase("Dollar Coin") == 0)
				coins[5]++;
		}
		return coins;
	}
}
