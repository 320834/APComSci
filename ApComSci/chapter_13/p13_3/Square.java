package p13_3;

@SuppressWarnings("serial")
public class Square extends java.awt.Rectangle{
	@SuppressWarnings("unused")
	private int x, y, s;
	
	public Square(int x, int y, int s){
		this.x = x;
		this.y = y;
		this.s = s;
		super.setLocation(x, y);
		super.setSize(s, s);
	}
	
	public int getArea(){
		return s*s;
	}
}
