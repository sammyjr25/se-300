import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/* Cole Koenig
	10/24/21
	Algorithm parent used to suck in the scenario information and boom




first come, last out
first come, first out
zone 1,2,3,4,etc , first out
zone 4,3,2,1,etc, first out
alphabetical, a-z first out
alphabetical z-a, first out
randomized based on seat number


I need sorted data into alg
ctrl /
numb of passengers is the random pull from database
Line 90 is how to sort
j is what column


algorithm(ArrayList<String[]> database) 
database = this.database ;

 */ 


public class Algorithim {

	//labFile = new File("Lab_Answers.csv");
	//labResults = new File("Results.txt");
	Scenario Scenario = new Scenario(5); // THe 5 is the number of passengers that will be on the plane.
	private static File TimeData; 

	public Algorithim (int n,int numPass) {

		String[] timeBags = new String[n] ;

		//Scenario.main(null);
		ArrayList<String[]> rawdata,dataj,datajSorted;
		int index=0;
		String[] datajInner,lastName = new String[n];
		int[] difTime = new int[n];
		rawdata = new ArrayList<String[]>();
		//rawdata = Scenario.parseDataBase();
		rawdata = Scenario.loadsave();

		dataj= new ArrayList<String[]>();
		datajSorted = new ArrayList<String[]>();
		for(int i =0; i< rawdata.size(); i++) {
			dataj.add(rawdata.get(i));

		}
		//row
		int[] seatNum = new int [n];
		int[] bagMath = new int [n];
		int[] seatMath = new int [n];
		for(int i =0; i <dataj.size() ;i++) {
			datajInner = dataj.get(i);
			//System.out.print(datajInner[i]);
			for(int j= 1; j <=1;j++) {
				//column
				lastName[i] = datajInner[5]; //the 5 makes it do the last name column 
				
				seatNum[i] = Integer.valueOf(datajInner[0].replaceAll("\\s+",""));

			}
		}
		
		Arrays.sort(seatNum);
		Arrays.sort(lastName);
		
		// System.out.println(lastName);
		
		// this keeps it all together
		for(int i = 0; i <lastName.length;i++) {
			for(int j =0;j <dataj.size(); j++) {
				if(lastName[i]== dataj.get(j)[n] ) {
					datajSorted.add(dataj.get(j));
					//System.out.println(datajSorted.get(i)[]);
					
				}
			}

		}
		
		int avgTime = 0;
		for(int i=0;i< lastName.length;i++) {
			bagMath[i] = 300+i*5 ;
			seatMath[i] = 240+7*seatNum[i];
			difTime[i] = bagMath[i] - seatMath[i]  ;
			if (difTime[i] < 0) {
				difTime[i] = 0;
			}
			avgTime = difTime[i] + avgTime;
		}
		avgTime =avgTime / n; // how to average the time
		System.out.println("Avg time: "+avgTime);
		// datajSorted.get(i)[9] so the i is the person it is traversing through of the 5 or 100 or 120 people selected. The 9 is the column. so like this is doing the person wait time.
		// THIS IS TO WRITE TO TIME DATA CSV USE THE "," STUFF
		try {
			FileWriter fr = new FileWriter(TimeData);
			BufferedWriter bw = new BufferedWriter(fr);

			//(240 +(7*seatNum[i])) 
			//(240 +(7*i)) 
			
			String line;
			for(int i = 0; i<lastName.length;i++ ) {
				// Name then Person Time, then Bag Time, then Delta Time
				line = lastName[i] + ","  + seatMath[i]  + "," + bagMath[i]  + "," + difTime[i] ; // 9 is the column for time per person. This way it goes to the next column and then goes down to next row when it gets to the last one.

				bw.write(line);
				bw.newLine() ;
				System.out.println(line);
				
			}
			
			bw.close() ;
		}

		catch (Exception e) {
			e.printStackTrace() ;
		}
		
	
	}

	public static void main(String[] args) {
		TimeData = new File("Time.csv");

		Algorithim Ag = new Algorithim(5,5) ;
		//5 = last name, 8 = time for bags, 9 = time for people

	}


}