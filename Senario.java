
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;



//https://jar-download.com/maven-repository-class-search.php?search_box=org.apache.poi.xssf.usermodel.XSSFSheet
//https://jar-download.com/maven-repository-class-search.php?search_box=org.apache.poi.xssf.usermodel.XSSFWorkbook
// https://stackoverflow.com/questions/14958732/how-can-i-add-the-apache-poi-library-in-eclipse-for-selenium-webdriver-project/23925352
// look into
public class Senario {

	private File datafile;
	private ArrayList<String[]> data;
	
	
	public Senario() {
		//constructor
		datafile = new File("Data.csv");
		data = new ArrayList<String[]>();
		//file = new File("data.txt");
		
	}
	public void parseFile() {
	
		
		//shows where it's looking for the datafile
		System.out.println(datafile.getAbsolutePath());
		
			// reader that works
			try {
				Scanner scan = new Scanner(datafile);
				scan.nextLine();
				//ArrayList<String[]> input = new ArrayList<String[]>();
				while(scan.hasNextLine()) {
					String[] Data = scan.nextLine().split(",");
					data.add(Data);
					}
				for(int i =0; i< data.size(); i++) {
					String[] dataj = data.get(i);
					for(int j = 0; j < dataj.length; j++) {
						System.out.print(dataj[j] + " ");
					}
					System.out.println();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}

	
	
	
	
	public static void main(String[] args) {
		Senario Data = new Senario();
		//calls parseFile
		Data.parseFile();
		
		
		
		
	}
	
    
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
