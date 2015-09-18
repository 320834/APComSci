package standard;

public class RabidRabbits {
	private int weight, hostility;
	private String name;
	public RabidRabbits(String n, int w, int h){
		weight = w;
		hostility = h;
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int getHostility(){
		return hostility;
	}
}
