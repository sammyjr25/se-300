import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;





public class Scenario {

	private File datafile;
	private File datasave;
	private ArrayList<String[]> rawdata;
	public ArrayList<String[]> sortedData;
	private ArrayList<String[]> loadedData;
	ArrayList<Integer> numbers;
	private int numbofPassengers, maxPassengers, minPassegers;
	
	public Scenario(int numbofPassengers) {
		//constructor
		 
		//Hard coded numbers to replace later
//		numbofPassengers = 10;
		
		this.numbofPassengers= numbofPassengers  ;
		
		//Range in the database to pull from
		maxPassengers = 149; // max passengers -1 (starts from 0)
		minPassegers = 0; 
		
		//Database name
		datafile = new File("Data.csv");
		
		//savefile name
		datasave = new File("Test.csv");
		
		//creates array-lists for later
		rawdata = new ArrayList<String[]>();
		sortedData = new ArrayList<String[]>();
		loadedData = new ArrayList<String[]>();
		
		numbers = new ArrayList<Integer>();
	}
	public ArrayList<String[]> parseDataBase() {
		//System.out.println("The Database has been parsed");
		
		//shows where it's looking for the Data.csv. If error please place Database (.csv) in location below
		//System.out.println(datafile.getAbsolutePath());
		
			// File reader that pulls all information from the database
			try {
				Scanner scan = new Scanner(datafile);
				scan.nextLine();
				
				while(scan.hasNextLine()) {
					String[] Data = scan.nextLine().split(",");
					rawdata.add(Data);
					}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			//outputs the rawData array-list
//			for(int i =0; i< rawdata.size(); i++) {
//				String[] dataj = rawdata.get(i);
//				for(int j = 0; j < dataj.length; j++) {
//				//	System.out.print(dataj[j] + " ");
//				}
//						
//			
//				// line above shows the individual string arrays
//			}
			
			return rawdata;
	}

	
	public ArrayList<String[]> passengerArrival() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("The data has been sorted into passager arrival order");
		
		// Calls the RandomNonRepeating number generator. (size, min, max) 

		ArrayList<Integer> list = getRandomNonRepeatingIntegers(numbofPassengers, minPassegers, maxPassengers);
	    System.out.println();

		
		

		// this allows only the passengerArrivale method needs to be called. 
		rawdata = new ArrayList<String[]>(parseDataBase());
		
//		for(int i =0; i< rawdata.size(); i++) {
//			String[] datas = rawdata.get(i);
//			for(int j = 0; j < datas.length; j++) {
//				
//				System.out.print(datas[j] + " " );
//			}
//			
//			System.out.println();
//			// line above shows the individual string arrays
//		}
		// This loop reorders the passengers to the order they arrive and adds their order number at the end of each string array in the array list
		
		for (int k = 0; k < list.size(); k++) {
	        
			// this adds the order number to the end of the string array
			
			//pulls out each string array from the arraylist based on the number-generator number selected
			// COLE	 use the .get( term) to sort which number of string you want. 
			String[] dataPre = rawdata.get(list.get(k)); 
			// array of nulls with +1 length than dataPre
			String[] dataPost = new String[dataPre.length + 1];
			
			// merges dataPre array and array of nulls
			System.arraycopy(dataPre, 0, dataPost, 0, dataPre.length);
			
			// adds number from number-generator to added null space
			dataPost[dataPre.length] = Integer.toString(k);
			

			// creates the sorted array-list
			sortedData.add(dataPost);
			

//			System.out.print(Integer.valueOf(dataPost[1]));

			
			//breaks due to how the numb gen works
			
			// if the passengers have more than one bag then add the second bag
//			if(Integer.valueOf(dataPost[1]) > 1) {
//				
//				for(int i =0; i< rawdata.size(); i++) {
//					String[] datas = rawdata.get(i);
//					if(dataPost[0]== datas[0]) {
////						numbers.add(i);
//						// merges dataPre array and array of nulls
//						System.arraycopy(datas, 0, dataPost, 0, datas.length);
//						
//						// adds number from number-generator to added null space
//						dataPost[datas.length] = Integer.toString(k);
//						sortedData.add(dataPost);
//						}
//					}
//				}
				
			

	    }
			//outputs the sortedData array-list
			for(int i =0; i< sortedData.size(); i++) {
				String[] datas = sortedData.get(i);
				for(int j = 0; j < datas.length; j++) {
					
					System.out.print(datas[j] + " " );
				}
				
				System.out.println();
				// line above shows the individual string arrays
			}
	    
		return sortedData;
		
	}
	
	//https://stackoverflow.com/questions/4040001/creating-random-numbers-with-no-duplicates (5 likes)
	// number generator for the non repeating generator
	public static int getRandomInt(int min, int max) {
	    Random random = new Random();
	    
	    return random.nextInt((max - min) + 1) + min;
	}

	public ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min,int max) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    
	    // ensures no double numbers
	    while (numbers.size() < size) {
	        int random = getRandomInt(min, max);
	        
	        if (!numbers.contains(random)) {
	            numbers.add(random);
	        }
	    }

	    return numbers;
	}
	
//	https://www.codegrepper.com/code-examples/java/convert+arraylist+to+csv+file+java
public void save() {
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("The Scenario has been saved");
	
	
	
	
	try {
	//File Writers
	FileWriter fw = new FileWriter(datasave);
    BufferedWriter bw = new BufferedWriter(fw);
   
    bw.write("Seat Number, # of bages, Weight, Dimention, Last Name, First Name, bagID, Arrival Order"); 
	bw.newLine();
    
    	for(int i =0; i< sortedData.size(); i++) {
		 String[] dataPre = sortedData.get(i); 

			for(int j = 0; j < dataPre.length; j++) {
				
				 if (j < dataPre.length - 1) {
					 System.out.print(dataPre[j] + ", " );
					 bw.write(dataPre[j] + ", " );
				 }else {
					 System.out.print(dataPre[j] + "\n" );
					 bw.write(dataPre[j]);
					 bw.newLine();
				 }
				 
				 
			}
	 }
	 bw.close();
	} catch (Exception e) {
		e.printStackTrace();
		
	}
    	
	}
	
	public ArrayList<String[]> loadsave(int n) {
	//	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//System.out.println("The Scerario has been loaded");
		
		//shows where it's looking for the Data.csv. If error please place Database (.csv) in location below
		//System.out.println(datafile.getAbsolutePath());
		
			// File reader that pulls all information from the database
			try {
				Scanner scan = new Scanner(datafile);
				scan.nextLine();
				
				for(int i=0; i<n;i++) {
					String[] Data = scan.nextLine().split(",");
					loadedData.add(Data);
					}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			//outputs the rawData array-list
			for(int i =0; i< loadedData.size(); i++) {
				String[] dataj = loadedData.get(i);
				for(int j = 0; j < dataj.length; j++) {
				//	System.out.print(dataj[j] + " ");
				}
				
				//System.out.println();
				// line above shows the individual string arrays
			}
			
			return loadedData;
			
			
	}


	public static void main(String[] args) {
		
//		Scenario Data = new Scenario();
//		Data.parseDataBase();
//		Data.passengerArrival();
//		Data.save();
//		Data.loadsave();
		
	}
	
	public ArrayList<String[]> getsortedData() {
	return this.loadedData;
	
	}
	
	
	
	
//	String[] dataj = rawdata.get(1); 
//	System.out.print(dataj[j] + " ");  // singles out sections of array
	
	
	//https://www.codegrepper.com/code-examples/java/java+read+csv+file+into+arraylist
	// good csv to array
	
	//https://stackoverflow.com/questions/4040001/creating-random-numbers-with-no-duplicates
	// non dup numb generator
	
	/* What this class will do 
	questions should incoming excel have seat number and number of bags?
	
	
	load text file - pass to algorithm
	or
	take input from manager
	intake number of bags and passengers
	intake from passenger/bag data
	use a while loop to process passenger/bag data
	keep order of passengers incoming and allocate seat number
	process multiple bags
	
	
	save text file -
	
	Useful Files
	https://www.aa.com/i18n/travel-info/baggage/checked-baggage-policy.jsp
	baggage data and weight / size
	dimensions up to 62 inches (length + width + height) Volume
	weight up to 50 lbs (70lbs for FC)
	Max 10 bags
	
	https://www.seatguru.com/airlines/Delta_Airlines/baggage.php
	confirm above
	
	https://www.infoworld.com/article/3534776/7-tools-and-services-for-real-time-collaborative-coding.html
	Real-time code sharing (Codeshare)
	
	https://www.javatpoint.com/how-to-read-excel-file-in-java
	read excel in java
	*/
	
	
	
}
