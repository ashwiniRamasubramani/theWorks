import java.util.Scanner;

public class Multiplayer {

	static String[] playerFeat;
	static int uniqueFeat;
	static Scanner scanData;
	static int noOfPlayers = 0;
	static int noOfFeat = 0;

	public static void main(String[] args) {

		try {
			scanData = new Scanner(System.in);

				noOfPlayers = scanData.nextInt();
				noOfFeat = scanData.nextInt();

				//validate data range
				if( noOfPlayers < 1 || noOfPlayers > Math.pow(10, 5)) System.exit(0);
				else if (noOfFeat < 1 || noOfFeat >20 ) System.exit(0);
				else {
					playerFeat = new String[noOfPlayers];
					readData();
					System.out.println(getUniqueFeature());
				}
		}catch(Exception ioe) {
			System.out.println("Exception "+ioe.getMessage());
		}
	}

	//read data
	private static void readData() {
		for(int i=0; i<noOfPlayers; i++)
		{
			String feature=null;
			feature = scanData.next();
			if(feature.length() > noOfFeat) {
				System.exit(0);
			}
			playerFeat[i]=feature;
		}
	}

	private static String getUniqueFeature() {
		String uniqFeat="";

		if(playerFeat.length ==1) {
			StringBuffer sb = new StringBuffer();
			String A= playerFeat[0];
			
			for (int j = 0; j < A.length(); j++) {
				char ch = A.charAt(j);
				sb.append( (ch == '0'? '1' : '0') );
			}			
			return sb.toString();
		}

		else {

			String A = playerFeat[0];
			String B = playerFeat[1];
			uniqFeat = compute(A,B);

			for(int i=2;i<noOfPlayers;i++) {
				String c = playerFeat[i];
				uniqFeat = compute(c,uniqFeat);			 
			}
		}
		return uniqFeat;
	}

	//compute
	private static String compute(String A, String B) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < A.length(); j++) {
			sb.append(A.charAt(j)^B.charAt(j));
		} 
		//System.out.println("A "+ A+"B "+B + ": "+sb);
		return sb.toString();  
	}

}

