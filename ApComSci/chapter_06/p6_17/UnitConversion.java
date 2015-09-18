package p6_17;
/**
 * Exercise P6.17. Write a unit conversion program that asks users to identify the
unit from which they want to convert and the unit to which they want to convert.
Legal units are in,ft, mi, mm, cm, m, and km. Hint: Define objects of a class
Uni tConve rte r that convert to and from meters.
 * @author 320951
 */
public class UnitConversion {
	private String from, to;
	private double value;
	public UnitConversion(String a, String b, double v){
		from = a;
		to = b;
		value = v;
	}
	/**
	 * NOTE numbers value is multiplied by are the conversion factors
	 * @return
	 */
	public double calculate(){
	//INCHES
		if(from.equalsIgnoreCase("in") && to.equalsIgnoreCase("ft")){
			return value/12;
		}
		else if(from.equalsIgnoreCase("in") && to.equalsIgnoreCase("mi")){
			return value/12/5280;
		}
		else if(from.equalsIgnoreCase("in") && to.equalsIgnoreCase("mm")){
			return value*25.4;
		}
		else if(from.equalsIgnoreCase("in") && to.equalsIgnoreCase("cm")){
			return value*2.54;
		}
		else if(from.equalsIgnoreCase("in") && to.equalsIgnoreCase("m")){
			return value*0.0254;
		}
		else if(from.equalsIgnoreCase("in") && to.equalsIgnoreCase("km")){
			return value*0.0000254;
		}
	//FEET
		else if(from.equalsIgnoreCase("ft") && to.equalsIgnoreCase("in")){
			return value*12;
		}
		else if(from.equalsIgnoreCase("ft") && to.equalsIgnoreCase("mi")){
			return value/5280;
		}
		else if(from.equalsIgnoreCase("ft") && to.equalsIgnoreCase("mm")){
			return value*304.8;
		}
		else if(from.equalsIgnoreCase("ft") && to.equalsIgnoreCase("cm")){
			return value*30.48;
		}
		else if(from.equalsIgnoreCase("ft") && to.equalsIgnoreCase("m")){
			return value*0.3048;
		}
		else if(from.equalsIgnoreCase("ft") && to.equalsIgnoreCase("km")){
			return value*0.0003048;
		}
	//MILES
		else if(from.equalsIgnoreCase("mi") && to.equalsIgnoreCase("in")){
			return value*63360;
		}
		else if(from.equalsIgnoreCase("mi") && to.equalsIgnoreCase("ft")){
			return value*5280;
		}
		else if(from.equalsIgnoreCase("mi") && to.equalsIgnoreCase("mm")){
			return value*1609000;
		}
		else if(from.equalsIgnoreCase("mi") && to.equalsIgnoreCase("cm")){
			return value*160934;
		}
		else if(from.equalsIgnoreCase("mi") && to.equalsIgnoreCase("m")){
			return value*1609.34;
		}
		else if(from.equalsIgnoreCase("mi") && to.equalsIgnoreCase("km")){
			return value*1.60934;
		}
//MILLIMETERS
		else if(from.equalsIgnoreCase("mm") && to.equalsIgnoreCase("in")){
			return value*0.0393701;
		}
		else if(from.equalsIgnoreCase("mm") && to.equalsIgnoreCase("ft")){
			return value*0.00328084;
		}
		else if(from.equalsIgnoreCase("mm") && to.equalsIgnoreCase("mi")){
			return value*.00000062137;
		}
		else if(from.equalsIgnoreCase("mm") && to.equalsIgnoreCase("cm")){
			return value*0.1;
		}
		else if(from.equalsIgnoreCase("mm") && to.equalsIgnoreCase("m")){
			return value*0.001;
		}
		else if(from.equalsIgnoreCase("mm") && to.equalsIgnoreCase("km")){
			return value*.000001;
		}
//CENTIMETERS
		else if(from.equalsIgnoreCase("cm") && to.equalsIgnoreCase("in")){
			return value*0.393701;
		}
		else if(from.equalsIgnoreCase("cm") && to.equalsIgnoreCase("ft")){
			return value*0.0328084;
		}
		else if(from.equalsIgnoreCase("cm") && to.equalsIgnoreCase("mi")){
			return value*.0000062137;
		}
		else if(from.equalsIgnoreCase("cm") && to.equalsIgnoreCase("mm")){
			return value*10;
		}
		else if(from.equalsIgnoreCase("cm") && to.equalsIgnoreCase("m")){
			return value*0.01;
		}
		else if(from.equalsIgnoreCase("cm") && to.equalsIgnoreCase("km")){
			return value*.00001;
		}
//METERS
		else if(from.equalsIgnoreCase("m") && to.equalsIgnoreCase("in")){
			return value*39.3701;
		}
		else if(from.equalsIgnoreCase("m") && to.equalsIgnoreCase("ft")){
			return value*3.28084;
		}
		else if(from.equalsIgnoreCase("m") && to.equalsIgnoreCase("mi")){
			return value*0.000621371;
		}
		else if(from.equalsIgnoreCase("m") && to.equalsIgnoreCase("mm")){
			return value*1000;
		}
		else if(from.equalsIgnoreCase("m") && to.equalsIgnoreCase("cm")){
			return value*100;
		}
		else if(from.equalsIgnoreCase("m") && to.equalsIgnoreCase("km")){
			return value*0.001;
		}
//KILOMETERS
		else if(from.equalsIgnoreCase("km") && to.equalsIgnoreCase("in")){
			return value*39370.1;
		}
		else if(from.equalsIgnoreCase("km") && to.equalsIgnoreCase("ft")){
			return value*3280.84;
		}
		else if(from.equalsIgnoreCase("km") && to.equalsIgnoreCase("mi")){
			return value*0.621371;
		}
		else if(from.equalsIgnoreCase("km") && to.equalsIgnoreCase("mm")){
			return value*1000000;
		}
		else if(from.equalsIgnoreCase("km") && to.equalsIgnoreCase("cm")){
			return value*100000;
		}
		else if(from.equalsIgnoreCase("km") && to.equalsIgnoreCase("m")){
			return value*1000;
		}
		else return 0;
	}
}
