import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MilesTravelled {

	// Store data in Map
	static Map<Integer,Integer> data ;
	static Scanner scanData;

	public static void main(String args[]) {

		try {
			scanData = new Scanner(System.in);
			int noOfLines = 0;

			while(scanData.hasNext()) {
				noOfLines = scanData.nextInt();
				if(noOfLines ==-1) {
					System.exit(0);
				}else {
					readData(noOfLines);
					System.out.println(calculateMiles() +" miles");
				}
			}
		}catch(Exception ioe) {
			System.out.println("Exception reading data");
		}
	}

	//read Data
	private static void readData(int noOfLines) {
		data = new TreeMap<Integer,Integer>();

		while(noOfLines>0){
			if(scanData.hasNext()) {
				int speed = scanData.nextInt();
				int hours = scanData.nextInt();
				data.put(hours, speed);
			}
			noOfLines--;
		}
		//data.forEach((k,v)->System.out.println("Hours : " + k + " Speed : " + v));
	}

	//sum of miles
	private static Integer calculateMiles() {
		int miles = 0;
		int previous = 0;

		for (Map.Entry<Integer, Integer> entry : data.entrySet()) {			
			miles += entry.getValue()* (entry.getKey()-previous);
			previous = entry.getKey();
		}

		return miles;
	}

}
