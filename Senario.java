package SE300;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;




//https://jar-download.com/maven-repository-class-search.php?search_box=org.apache.poi.xssf.usermodel.XSSFSheet
//https://jar-download.com/maven-repository-class-search.php?search_box=org.apache.poi.xssf.usermodel.XSSFWorkbook
// https://stackoverflow.com/questions/14958732/how-can-i-add-the-apache-poi-library-in-eclipse-for-selenium-webdriver-project/23925352
// look into
public class Senario {

	private File datafile;
	//public File file;
	
	
	public Senario() {
		//constructor
		datafile = new File("Data.csv");
		//Path path = Paths.get("C:\\Users\\Hunter\\eclipse-workspace\\SE 300//DataBase.csv");
		//file = new File("data.txt");
		
	}
	public void parseFile() {
		// this will be to for the requirements
		
		System.out.println(datafile.getAbsolutePath());
		//System.out.println(datafile.exits(path));
		try {
			FileReader fr = new FileReader(datafile);
			BufferedReader br = new BufferedReader(fr);
			// make a String called line
			String line;

			// read the header line in the file
			line = br.readLine();
			// print out header line 
			System.out.println(line);

			// while line is equal to the next line of the bufferedreader is not equal to null
			// this means read the next line in the file until there are not more line to read
			while (  ( line = br.readLine() ) != null     ) {

				// make an array to hold the columns 
				String[] lineColumns;
				// break the line up to columns. break on the comma and delete the comma
				lineColumns = line.split(",");
				
				//testing colum setup
				try {
					//print every line
					System.out.println(lineColumns[0]);
					}catch ( Exception e ) {
					}
			
			}
			// when completely done with reading close the Reader
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Senario Data = new Senario();
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
