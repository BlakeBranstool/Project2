import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LetterAvg {
	
	private static final int LINES_TO_SKIP = 3;
	private static final int STATION_ID_LENGTH = 4;
	
	private String letterAverage;
	private int numStations;
	private ArrayList<String> list;
	
	public LetterAvg(char letterAverage) throws IOException {
		this.letterAverage = letterAverage + "";
		list = new ArrayList<String>();
		findNumStations();
	}
	
	private void findNumStations() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Mesonet.txt")));

		for(int index = 0; index < LINES_TO_SKIP; ++index) {
			br.readLine();
		}
		
		String nextLine = br.readLine();
		numStations = 0;

		while((nextLine != null)) {
			nextLine = nextLine.replace(" ", "").substring(0, STATION_ID_LENGTH);
			
			if(nextLine.substring(0, 1).equalsIgnoreCase(letterAverage)) {
				list.add(nextLine);
				++numStations;
			}
			
			nextLine = br.readLine();
		}
		
		br.close();
	}

	public int numberOfStationWithLetterAvg() {
		return numStations;
	}
	
	public String toString() {
		String str = String.format("They are: \n");
		
		for(int index = 0; index < list.size(); ++index) {
			str += String.format("%s\n", list.get(index));
		}
		
		return str;
	}

}
