import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PosAvg {

	
	private static final int LINES_TO_SKIP = 3;
	private static final int STATION_ID_LENGTH = 4;
	
	private String stid;
	private String previousVal1;
	private String previousVal2;
	private String afterVal1;
	private String afterVal2;
	
	public PosAvg(String stid) throws IOException {
		setStid(stid);
		indexOfStation();
	}
	
	public int indexOfStation() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Mesonet.txt")));

		for(int index = 0; index < LINES_TO_SKIP; ++index) {
			br.readLine();
		}
		
		String nextLine = br.readLine().replace(" ", "").substring(0, STATION_ID_LENGTH);
		int stationIndex = 1;
		previousVal1 = "";
		previousVal2 = "";
		
		while(!(nextLine.equals(this.stid))) {
			previousVal2 = previousVal1;
			previousVal1 = nextLine;
			nextLine = br.readLine().replace(" ", "").substring(0, STATION_ID_LENGTH);
			++stationIndex;
		}
		
		afterVal1 = br.readLine().replace(" ", "").substring(0, STATION_ID_LENGTH);
		afterVal2 = br.readLine().replace(" ", "").substring(0, STATION_ID_LENGTH);
		
		br.close();
		return stationIndex;
	}
	
	public String toString() {
		String str  = String.format("This index is average of %s and %s, %s and %s, and so on.", previousVal1, afterVal1, previousVal2, afterVal2);
		
		return str;
	}
	
	public String getStid() {
		return stid;
	}

	public void setStid(String stid) {
		this.stid = stid;
	}
	
}
