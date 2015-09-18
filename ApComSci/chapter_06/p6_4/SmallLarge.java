package p6_4;

public class SmallLarge {
	private double s, m, l;
	public SmallLarge(double x, double y, double z){
		if(x > y && x > z)
			l = x;
		else
			if(y > z)
				l = y;
			else
				l = z;
		if(x < y && x < z)
			s = x;
		else
			if(y < z)
				s = y;
			else
				s = z;
		if(l != x && s != x)
			m = x;
		else
			if(l != y && s != y)
				m = y;
			else
				m = z;
	}
	public String getSort(){
		return s + "\n" + m + "\n" + l;
	}
}
