
import javafx.application.Platform;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class GUI extends Application
{

	int Width = 1200 ;
	int Height = 800;
	//SET UP PUBLIC STUFF
	GridPane pane = new GridPane();
	MenuBar menuBar = new MenuBar();
	BorderPane bp = new BorderPane();
	HBox hb = new HBox();
	Scene scene = new Scene(bp,Width,Height);
	ChoiceBox<String> algorithm_BOX = new ChoiceBox<>();
	int Num_Pass;
	//File Time = new File("Time.csv");
	//MAKE BUTTONS (AND OTHER NODES)...

	//START...
	@Override
	public void start(Stage stage) 
	{

		bp.setCenter(pane);
		bp.setTop(menuBar);
		stage.setScene(scene);
		stage.setTitle("baggage data base");
		stage.show();

		//color grid pane
		pane.setStyle("-fx-background-color: white");

		//MAKES AND SETS UP ALL BUTTONS...
		makeAllButtons();
	}
	/**
	 * Self explanatory. Makes and sets up all buttons. I define all the buttons and other items to add 
	 * in here and the respective events each has here.
	 * @author Gage
	 * @return 
	 * @apiNote This could be made static fairly easily (you'd probably give it pane and bp and 
	 * what-not as parameters and maybe even end up making this GUI class static (probably a good idea as it makes sense 
	 * to only have one of this class)). 
	 * This would be a good idea because generally a good rule for making
	 * code that is easy to test is: 
	 * <p>
	 * <b>"if you can make it static, its probably best to do so".</b>
	 * </p>
	 */
	public void makeAllButtons()
	{

		//Set Up Buttons.........................................................................
		Button baseline_BTN = new Button("baseline");
		Button results_BTN = new Button("results");
		Button exit_BTN = new Button("Exit");    
		Button algorithms_BTN= new Button("Run Algorithm");

		ChoiceBox<String> scenario_BOX = new ChoiceBox<>();

		TextField numPassIn = new TextField();

		//  int Num_Pass = content.add(Num_Pass);
		//Add items To Scene as Needed.........................................................

		//pane.add(baseline_BTN, 0, 3); 
		//pane.add(results_BTN, 0, 4); 
		//scenario_BOX.getItems().addAll("Seat location", "Bags ID","Number of bags for each passager", "when passagers checkin");
		//pane.add(scenario_BOX, 1,14);
		//pane.add(new Label("scenario: "), 0, 14);
		pane.add(exit_BTN, 0, 3); 
		pane.add(algorithms_BTN, 0,65);
		pane.add(numPassIn,1,50);
		pane.add(new Label("Algorithm:"), 0, 15);
		pane.add(new Label("Enter number of passengers"), 0, 50);
		algorithm_BOX.getItems().addAll("Last Name","First Name","Bag Weight","Volume of Bag");
		pane.add(algorithm_BOX, 1,15);
		//Set Button and Key Events for All Buttons.................................................
		
		baseline_BTN.setOnAction(e ->  bp.setCenter(makeBaselineGUIPane()));
		results_BTN.setOnAction(e ->  bp.setCenter(makeResultsGUIPane()));
		results_BTN.setOnAction(e ->  bp.setCenter(makeResultsGUIPane()));
		exit_BTN.setOnAction(e ->  Platform.exit());
		algorithms_BTN.setOnAction(e ->{ 
			
			Num_Pass = Integer.parseInt(numPassIn.getText());
			// This is the baseline code that is ran each and everytime the user selects an algorithm and it is to compare the two of them. 
			String[] columnNames = {"Last Name","Seat Number","Passenger Time","Baggage Time","Time Difference"};
			Algorithim Ag = new Algorithim(Num_Pass, 0);
			String[][] sortedData = Ag.ReadIn(Num_Pass);  

			DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); // this must be zero so it doesnt have blank rows. 
			JTable table = new JTable(tableModel);

			Object[][] data = new Object[sortedData.length][6]; // This is 5 for the size of the columns 

			for(int i = 0; i <Num_Pass;i++) {
				
				data[i][0] = sortedData[i][0];
				data[i][1] = sortedData[i][1];
				data[i][2] =sortedData[i][2];
				data[i][3] =sortedData[i][3];
				data[i][4] = sortedData[i][4];

				/**
				 * I basically have to do this because for JTable it needs a 2d Object array so this is what I did. It works out and writes out to the table 
				 * pretty good. It does it for the length of Num_Pass which is the number of passengers entered. That way it does it all the way down which works out
				 * perfectly now. 
				 */
				tableModel.addRow(data[i]);

			}
			int k = 1;
			String avgTime = sortedData[0][5];
			Font font = new Font("Verdana", Font.PLAIN, 12);
			table.setFont(font);
			table.setRowHeight(30);
			JFrame frame = new JFrame("Baseline");
			frame.setSize(600, 400);
			frame.add(new JScrollPane(table));
			frame.setLocation(350, 400);
			pane.add(new Label("Average time for the Baseline was "+avgTime+" seconds"),Width,100+k);
			frame.setVisible(true);
			k=k+1;
			//System.out.println("end of baseline");
			
			/** This huge IF statement is all for the different algorithms that the user will choose. 
			 * 
			 * 
			 */
			if ( algorithm_BOX.getValue() == "Last Name") {
				String[] columnLastName = {"Last Name","Algorithm","Passenger Time","Baggage Time","Time Difference"};
				Algorithim Ag_LastName = new Algorithim(Num_Pass, 5);
				String[][] sortedData_LastName = Ag_LastName.ReadIn(Num_Pass);  

				DefaultTableModel LastNameModel = new DefaultTableModel(columnLastName, 0);
				JTable table_LastName = new JTable(LastNameModel);

				Object[][] data_LastName = new Object[sortedData.length][6];

				for(int i = 0; i <Num_Pass;i++) {

					data_LastName[i][0] = sortedData_LastName[i][0];
					data_LastName[i][1] = sortedData_LastName[i][1];
					data_LastName[i][2] =sortedData_LastName[i][2];
					data_LastName[i][3] =sortedData_LastName[i][3];
					data_LastName[i][4] = sortedData_LastName[i][4];
					LastNameModel.addRow(data_LastName[i]);

				}
				String avgTime_lastName = sortedData_LastName[0][5];
				//ffSystem.out.println(avgTime);
				table_LastName.setFont(font);
				table_LastName.setRowHeight(30);
				JFrame frame_LastName = new JFrame("Last Name Algorithm");
				frame_LastName.setSize(600, 400);
				frame_LastName.add(new JScrollPane(table_LastName));
				frame_LastName.setVisible(true);
				frame_LastName.setLocation(950, 400);
				pane.add(new Label("Average time for this algorithm was "+avgTime_lastName+" seconds"),Width,400+k);
			}
			else if (( algorithm_BOX.getValue() == "First Name")) {
				String[] columnLastName = {"Last Name","Algorithm","Passenger Time","Baggage Time","Time Difference"};
				Algorithim Ag_FirstName = new Algorithim(Num_Pass, 4);
				String[][] sortedData_FirstName = Ag_FirstName.ReadIn(Num_Pass);  
				DefaultTableModel FirstNameModel = new DefaultTableModel(columnLastName, 0);
				JTable table_FirstName = new JTable(FirstNameModel);
				
				Object[][] data_FirstName = new Object[sortedData.length][6];
				
				
				for(int i = 0; i <Num_Pass;i++) {

					data_FirstName[i][0] = sortedData_FirstName[i][0];
					data_FirstName[i][1] = sortedData_FirstName[i][1];
					data_FirstName[i][2] =sortedData_FirstName[i][2];
					data_FirstName[i][3] =sortedData_FirstName[i][3];
					data_FirstName[i][4] = sortedData_FirstName[i][4];
					FirstNameModel.addRow(data_FirstName[i]);

				}
				String avgTime_FirstName = sortedData_FirstName[0][5];
				//ffSystem.out.println(avgTime);
				table_FirstName.setFont(font);
				table_FirstName.setRowHeight(30);
				JFrame frame_FirstName = new JFrame("First Name Algorithm");
				frame_FirstName.setSize(600, 400);
				frame_FirstName.add(new JScrollPane(table_FirstName));
				frame_FirstName.setVisible(true);
				frame_FirstName.setLocation(950, 400);
				pane.add(new Label("Average time for this algorithm was "+avgTime_FirstName+" seconds"),Width,400);
			}
			else if (( algorithm_BOX.getValue() == "Bag Weight")) {
				String[] columnLastName = {"Last Name","Weight (lbs)","Passenger Time","Baggage Time","Time Difference"};
				Algorithim Ag_LastName = new Algorithim(Num_Pass,2);
				String[][] sortedData_LastName = Ag_LastName.ReadIn(Num_Pass);  
				
				DefaultTableModel LastNameModel = new DefaultTableModel(columnLastName, 0);
				JTable table_LastName = new JTable(LastNameModel);

				Object[][] data_LastName = new Object[sortedData.length][6];

				for(int i = 0; i <Num_Pass;i++) {

					data_LastName[i][0] = sortedData_LastName[i][0];
					data_LastName[i][1] = sortedData_LastName[i][1];
					data_LastName[i][2] =sortedData_LastName[i][2];
					data_LastName[i][3] =sortedData_LastName[i][3];
					data_LastName[i][4] = sortedData_LastName[i][4];
					LastNameModel.addRow(data_LastName[i]);

				}
				String avgTime_lastName = sortedData_LastName[0][5];
				//ffSystem.out.println(avgTime);
				table_LastName.setFont(font);
				table_LastName.setRowHeight(30);
				JFrame frame_LastName = new JFrame("Weight Algorithm");
				frame_LastName.setSize(600, 400);
				frame_LastName.add(new JScrollPane(table_LastName));
				frame_LastName.setVisible(true);
				frame_LastName.setLocation(950, 400);
				pane.add(new Label("Average time for this algorithm was "+avgTime_lastName+" seconds"),Width,400);
				
			}
			else if (( algorithm_BOX.getValue() == "Volume of Bag")) {

			}



		});



	}

	public GridPane makeResultsGUIPane()
	{
		GridPane pane = new GridPane();
		TextField name = new TextField();

		pane.setStyle("-fx-background-color: black");
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("Name:"), 0, 0);
		pane.add(name, 1, 0);
		name.setPromptText("Ex.Sam.");
		return pane;
	}

	public GridPane makeBaselineGUIPane()
	{
		GridPane pane = new GridPane();
		TextField name = new TextField();

		pane.setStyle("-fx-background-color: black");
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("Name:"), 0, 0);
		pane.add(name, 1, 0);
		name.setPromptText("Ex.Sam Y.");
		return pane;
	}

	//MAIN...
	public static void main(String[] args) 
	{
		launch(args);


	}
}


/*

if ( algorithm_BOX.getValue() == "Baseline") {
				String[] columnNames = {"Last Name","Seat Number","Passenger Time","Baggage Time","Time Difference"};
				Algorithim Ag = new Algorithim(Num_Pass, 0);
				String[][] sortedData = Ag.ReadIn(Num_Pass);  

				DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
				JTable table = new JTable(tableModel);

				Object[][] data = new Object[sortedData.length][5];

				for(int i = 0; i <Num_Pass;i++) {

					//int SeatNumber = originalLeagueList.get(i).getPosition();


					//Object[] data = {sortedData[0], seatNumber, passengerTime, bagTime, diffTime};

					data[i][0] = sortedData[i][0];
					data[i][1] = sortedData[i][1];
					data[i][2] =sortedData[i][2];
					data[i][3] =sortedData[i][3];
					data[i][4] = sortedData[i][4];

					//System.out.println(data[i]);
					tableModel.addRow(data[i]);

				}
				//String avgTime = sortedData[0][5];
				//tableModel(avgTime);

				Font font = new Font("Verdana", Font.PLAIN, 12);
				table.setFont(font);
				table.setRowHeight(30);
				JFrame frame = new JFrame();
				frame.setSize(600, 400);
				frame.add(new JScrollPane(table));
				frame.setVisible(true);

			}
 */

