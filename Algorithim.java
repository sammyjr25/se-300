import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/* Cole Koenig
	10/24/21
	This is the algorithm function that takes in the scenario stuff and creates what will be used in GUI. 
	
*/


public class Algorithim {

	//labFile = new File("Lab_Answers.csv");
	//labResults = new File("Results.txt");
	 // THe 5 is the number of passengers that will be on the plane.
	private int n=0;
	private File TimeData; 
	File Time = new File("Time.csv");
	public Algorithim (int n,int Col) {
		Scenario Scenario = new Scenario(n);
		TimeData = new File("Time.csv");
		ArrayList<String[]> rawdata,dataj,datajSorted;
		String[] datajInner,lastName = new String[n];
		int[] difTime = new int[n];

		dataj= new ArrayList<String[]>();
		dataj = Scenario.loadsave(n);
		ArrayList<String[]> datajseat = new ArrayList<String[]>();
		datajSorted = new ArrayList<String[]>();
		
		for(int i =0; i< dataj.size(); i++) {
			String[] datas = dataj.get(i);
			for(int j = 0; j < datas.length; j++) {
				
				System.out.print(datas[j] + " " );
			}
			
			System.out.println();
			// line above shows the individual string arrays
		}
		
		
		
		
		
		
		//row
		int[] seatNum = new int [n];
		int[] bagMath = new int [n];
		int[] seatMath = new int [n];
		/**
		 * Everything above is just setting up for the stuff later. I grab the 'loadsave' stuff from scenario. I enter in n which is the number of passengers 
		 * which is implemented by GUI which is ulitmately entered by the user. n is used a bunch throughout the code and at first I used n becuase it was easy
		 * but became super critical to the code and I just ran with it. That way all my arrays are same size and I dont get like null pointers or anything.
		 * I write to timecsv later on and what I use in GUI to read the output of algorithm and can change the input of n and the Col you want to use sort and I can 
		 * just read it. It worked well. vey dynamic
		 */
		
		for(int i =0; i <dataj.size() ;i++) {
			datajInner = dataj.get(i);
			
			for(int j= 1; j <=1;j++) {
				//column
				 //the 5 makes it do the last name column 
				
				seatNum[i] = Integer.valueOf(datajInner[0].replaceAll("\\s+",""));
				lastName[i] = datajInner[Col];
				// Yeah this doesnt actually work. It keeps sorting like 10-11-12-20-21-22-23-30-31-32 binary bull shit
				if (Col<= 4) {
					lastName[i] = String.valueOf(datajInner[Col].replaceAll("\\s+",""));
					//System.out.println("yay");
				}
				else if (Col >4 ) {
					lastName[i] = datajInner[Col];
					//System.out.println("nay");
				}
			}
		}
		
		/** This above for loop is for getting the correct column starting to get sorted. It will rearrange and assign it into a matrix lastName[i]. THe sorted matrix
		 * is always lastName even if you're doing seatnumber or weight or anything because originally i as going to use inheritence but it worked out that 
		 * it would be dynamic if I just kept it like this so I went with it. It iterates through i and j so it does row and columns
		 * The if statement is for if you sort later on and use a integer and it's in a string form it will sort it binary so wont work correct.
		 * That way if you select a column like less than 5 they're all integers so this is required for it to work correctly.
		 * 
		 * 
		 */
		Arrays.sort(seatNum);
		Arrays.sort(lastName);
		/** This is a dope function that automatically sorts it smallest to largest or alphabetically automatically
		 * 
		 */

		// this keeps it all together
		for(int i = 0; i <lastName.length;i++) {
			for(int j =0;j <dataj.size(); j++) {
				if(lastName[i]== (dataj.get(j)[Col])) {
					datajSorted.add(dataj.get(j));
					//System.out.println(datajSorted.get(i));
					
				}
			}

		}
		
		for(int i = 0; i <seatNum.length;i++) {
			for(int j =0;j <dataj.size(); j++) {
				if(seatNum[i]== Integer.valueOf(dataj.get(j)[0])) {
					datajseat.add(dataj.get(j));
					//System.out.println(datajSorted.get(i)[0]);
					
				}
			}

		}
	
		int avgTime = 0;
		for(int i=0;i< lastName.length;i++) {
			bagMath[i] = 450+i*5 ;
			seatMath[i] = 240+7*Integer.valueOf(datajSorted.get(i)[0]);
			difTime[i] = bagMath[i] - seatMath[i]  ;
			if (difTime[i] < 0) {
				difTime[i] = 0;
			}
			avgTime = difTime[i] + avgTime;
		}
		
		avgTime =avgTime / n; // how to average the time
		
		/**
		 * These 3 for loops are for when you reorganize using Sort it keeps it all togther when it reassigns in the new matrix. Using the i and j to do both dimensions
		 * of the String Array. The last for loop is the math the times uses and is based on where the passenger is sat in the plane. We wanted to it to be 
		 * exponential but ended up kinda just doing this. It's just a constant pretty much math. 
		 */
		//System.out.println("Avg time: "+avgTime); // Output for avg time 
		// datajSorted.get(i)[9] so the i is the person it is traversing through of the 5 or 100 or 120 people selected. The 9 is the column. so like this is doing the person wait time.
		// THIS IS TO WRITE TO TIME DATA CSV USE THE "," STUFF
		try {
			FileWriter fr = new FileWriter(TimeData);
			BufferedWriter bw = new BufferedWriter(fr);
			
			String line;
			for(int i = 0; i<lastName.length;i++ ) {
				// Name then Person Time, then Bag Time, then Delta Time
				//line = "Passenger Name: "+datajSorted.get(i)[5]+", Sorted Number/Name: "+lastName[i] + ", Passenger Time:"  + seatMath[i]  + ", Bag Time:" + bagMath[i]  + ", Time Diff:" + difTime[i] ; // 9 is the column for time per person. This way it goes to the next column and then goes down to next row when it gets to the last one.
				line = datajSorted.get(i)[5]+","+lastName[i] + ","  + seatMath[i]  + "," + bagMath[i]  + "," + difTime[i]+","+avgTime ; 
				/**
				 * This write is super dope. I could only ever write to a txt file I thought and my SE major friend showed this to me so I can write, my quite literal
				 * comma seperated value document. (CSV). So this is how the results are written out everytime you run Algorithm(n,Col), n being number of people 
				 * and Col being the column you want to use to sort the passengers.
				 * 
				 */
				
				bw.write(line);
				bw.newLine() ;
				System.out.println(line);
				
			}
			
			bw.close() ;
		}

		catch (Exception e) {
			e.printStackTrace() ;
		}
		//System.out.println("Avg time: "+avgTime);
	}

	
	//public static void main(String[] args) {
		

		//Algorithim Ag = new Algorithim(1,3) ;
		//Ag.ReadIn(100);
		/**
		 *  This was before GUI so I can do tests. 
		 */
		
	//}
	 
	public  String[][] ReadIn(int Num_Pass) {
		String[][] sortedData = new String[Num_Pass][6];
		try {
			FileReader fr = new FileReader(Time);
			BufferedReader br = new BufferedReader(fr);
			String line;	
			br.readLine();
			
			int i = -1;
			while (( line = br.readLine() ) != null) {
				i = i+1 ;	
				// break the line up to columns. break on the comma and delete the comma
				sortedData[i][0] = line.split(",")[0];
				sortedData[i][1] = line.split(",")[1];
				sortedData[i][2] = line.split(",")[2];
				sortedData[i][3] = line.split(",")[3];
				sortedData[i][4] = line.split(",")[4];
				sortedData[i][5] = line.split(",")[5];
				
			}
				
		}
		
		catch	(Exception e) {
			e.printStackTrace() ;
		}
		
		return sortedData;
	}


}
/**
 * This final Method is for the GUI. It's so I can get Time written to a final array I can get out sortedData. With sortedData I have the proper full arranged info
 * of what I need in GUI. This is beautiful and with it I can easily change the number of passengers. Totally dynamic and is doooope. It goes through that while
 * loop and traverses the entire Time and so that way I dont miss anything. It's a pretty good way to do it and kinda the only way I could figure it out without
 * doing a buffered reader inside my GUI which would be really dumb and I didn't want to do that so here we are. 
 * 
*/