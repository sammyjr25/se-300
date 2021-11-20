import java.util.ArrayList;
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
	
	public Algorithim () {
		
		
		Scenario Scenario = new Scenario();
		//Scenario.main(null);
		ArrayList<String[]> rawdata,dataj,datajSorted;
		int index=0;
		String[] datajInner,lastName = new String[149];
	    rawdata = new ArrayList<String[]>();
		rawdata = Scenario.parseDataBase();
		//System.out.print(rawdata);
		//Collections.sort(rawdata);  
		//System.out.println(rawdata+"fuck");
		dataj= new ArrayList<String[]>();
		datajSorted = new ArrayList<String[]>();
		for(int i =0; i< rawdata.size(); i++) {
			dataj.add(rawdata.get(i));
				 
			
			/*
			for(int j = 0; j < dataj.length; j++) {
				System.out.print(dataj[j] + " ");
			
			}
			*/
			// line above shows the individual string arrays
		}
		//row
		for(int i =0; i <dataj.size() -1;i++) {
			datajInner = dataj.get(i);

			for(int j= 1; j <=1;j++) {
				//column
					lastName[i] = datajInner[5];
					
			}
		}
		

        Arrays.sort(lastName);
        
		for(int i = 0; i <lastName.length;i++) {
			for(int j =0;j <dataj.size(); j++) {
				if(lastName[i]== dataj.get(j)[5] ) {
					datajSorted.add(dataj.get(j));
				}
			}
			
		}
		System.out.println(datajSorted.get(0)[5]);
	}
	
	public static void main(String[] args) {
	
		Algorithim Ag = new Algorithim() ;
		

	}







}


