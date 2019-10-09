
public abstract class MesoInherit {
	
	private MesoStation mesoStation;
	
	public MesoInherit(MesoStation mesoStation) {
		setMesoStation(mesoStation);
	}

	abstract int [] calAverage();
	
	abstract char letterAverage();
	
	public MesoStation getMesoStation() {
		return mesoStation;
	}

	public void setMesoStation(MesoStation mesoStation) {
		this.mesoStation = mesoStation;
	}
	
}
