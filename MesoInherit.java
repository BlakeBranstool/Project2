
public class MesoInherit {
	private static final int STATION_ID_LENGTH = 4;

	private String stid;
	private int [] calAvg;
	
	private MesoStation mesoStation;
	
	public MesoInherit(MesoStation mesoStation) {
		setMesoStation(mesoStation);
		this.stid = mesoStation.getStID();
		calAvg = new int [3];
	}
	
	public MesoStation getMesoStation() {
		return mesoStation;
	}

	public void setMesoStation(MesoStation mesoStation) {
		this.mesoStation = mesoStation;
	}

	public int[] calAverage() {
		double sum = 0;
		double avg = 0;
		int temp = 0;
		
		for(int index = 0; index < STATION_ID_LENGTH; ++index) {
			sum += (int) stid.charAt(index);
		}
		
		avg = (sum / STATION_ID_LENGTH);
		
		calAvg[0] = (int) Math.ceil(avg);
		calAvg[1] = (int) Math.floor(avg);
		
		temp = (int)(avg * 10);
		
		if(temp % 10 >= 5) {
			calAvg[2] = calAvg[0];
		}
		else {
			calAvg[2] = calAvg[1];
		}
		
		return calAvg;
	}

	public char letterAverage() {
		// TODO Auto-generated method stub
		return 'c';
	}
	
}
