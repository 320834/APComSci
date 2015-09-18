package p4_14;

public class MilitaryTime {
	private int hours, minutes;
	@SuppressWarnings("unused")
	private String firstTime, secondTime, time, hour1, hour2, minute1, minute2;
	public MilitaryTime(int t1, int t2){
		firstTime = ""+t1;
		secondTime = ""+t2;
		if(t1 < 1000)
			firstTime = 0 + firstTime;
		if(t2 < 1000)
			secondTime = 0 + secondTime;
		hour1 = firstTime.substring(0, 2);
		hour2 = secondTime.substring(0, 2);
		minute1 = firstTime.substring(2);
		minute2 = secondTime.substring(2);
		if(t1 > t2){
			hour1 = "" + (23 - Integer.parseInt(hour1));
			minute1 = "" + (60 - Integer.parseInt(minute1));
			hours = Integer.parseInt(hour2) + Integer.parseInt(hour1);
			minutes = Integer.parseInt(minute2) + Integer.parseInt(minute1);
			if(minutes > 60){
				minutes -= 60;
				hours++;
			}
		}else
		if(firstTime == secondTime){
			hours = 24;
			minutes = 0;
		}
		else if(Integer.parseInt(minute2) > Integer.parseInt(minute1)){
			hours = Integer.parseInt(hour2) - Integer.parseInt(hour1);
			minutes = Integer.parseInt(minute2) - Integer.parseInt(minute1);
		}	
		else{
			hour2 = ""+(Integer.parseInt(hour2)-1);
			minute2 = ""+(Integer.parseInt(minute2)+60);
			hours = Integer.parseInt(hour2) - Integer.parseInt(hour1);
			minutes = Integer.parseInt(minute2) - Integer.parseInt(minute1);
		}
	}
	public int getHours(){
		return hours;
	}
	public int getMinutes(){
		return minutes;
	}
}
