
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class mainMenu extends Application {
	private Pane mainMenu;
	private Pane short_pane;
	private Pane long_pane;
	private int W = 750;
	private int H = 600 ;
	private int i = 0;
	int Distance = 0;
	private File Ranks;

	@Override
	public void start(Stage stage) {






		
	//	manager mg = new manager() ;


		mainMenu = new Pane();
		mainMenu.setStyle("-fx-background-color: lightblue;") ;
		stage.setTitle("Baggage Timing Calculator");

		Label menu_Title = new Label("Baggage Timing Calculator");
		menu_Title.setStyle("-fx-font-family: \"Comic Sans MS\"; -fx-font-size: 40; -fx-text-fill: darkblue;");

		Scene scene = new Scene(mainMenu, W, H);
		Button shortTerm,longTerm, exit, nextButton, previousButton;
		shortTerm = new Button("Short Term Investment") ;
		scene.setFill(Color.OLDLACE);
		longTerm = new Button("Long Term Investment") ;
		exit = new Button("Return to Main Menu") ;
		nextButton = new Button("Next") ;
		previousButton= new Button("Previous") ;

		// stockGenerator sg = new stockGenerator() ;
		//sg.parseFile();
		Label menu_txt = new Label("                       Hi welcome to the Stonk Generator 3000\n Please select if you wish to invest long term stonks or short term stonks") ;
		shortTerm.setLayoutX(W*1/6) ;
		shortTerm.setLayoutY(400) ;
		longTerm.setLayoutX(W*2/3) ;
		longTerm.setLayoutY(400) ;
		exit.setLayoutX(W-175);
		exit.setLayoutY(0);
		menu_txt.setLayoutX((W/2)-250);
		menu_txt.setLayoutY(300);
		menu_Title.setLayoutX(W*1/4);
		menu_Title.setLayoutY(50);
		mainMenu.getChildren().addAll(shortTerm,longTerm,menu_txt,menu_Title);
		i = 0;
		stage.setScene(scene);
		stage.show();


		// SHORT TERM ACTION EVENT HANDLER
		shortTerm.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				
				int Num_Pass = 10 ;
				int Col = 5; 
				
				 Algorithim Ag = new Algorithim(Num_Pass,Col);
				 
				 
				 
				 
				 
			//	mg.ShortTerm();
				
				

				System.out.println("Short term ayo") ;
				Ranks = new File("Ranks.txt");
				short_pane = new Pane() ;
				Distance = 0;
				i=0;
				//Scene short_scene = new Scene(short_scene, W, H);
				Scene short_scene = new Scene(short_pane,W,H) ;
				Label label = new Label("Short Term Generator");
				label.setStyle("-fx-font-family: \"Comic Sans MS\"; -fx-font-size: 25; -fx-text-fill: darkred;");
				label.setWrapText(true);
				short_pane.getChildren().addAll(nextButton, label,exit);
				nextButton.setLayoutX(W*0.475) ;
				nextButton.setLayoutY(325) ;

				label.setLayoutX(W*3/8);
				label.setLayoutY(H*.25);
				stage.setScene(short_scene);
				stage.show();

				// EXIT BUTTON EVENT HANDLER
				exit.setOnAction(new EventHandler<ActionEvent>() {
					@Override 
					public void handle(ActionEvent e) {

						stage.setScene(scene);
						stage.show();

					}

				});

				// NEXT BUTTON EVENT HANDLER
				nextButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override 
					public void handle(ActionEvent e) {
						i = i +1;
						Distance = Distance +125 ;
						Ranks = new File("Ranks.txt");
						try {

							FileReader fr = new FileReader(Ranks);
							BufferedReader br = new BufferedReader(fr);
							br.readLine();
							String[] ranks = new String[5] ;
							ranks[1] = br.readLine();
							ranks[2] = br.readLine();
							ranks[3] = br.readLine();
							ranks[4] = br.readLine();
							Label nextStock = new Label("The "+ i+" stock you should buy would be "+ranks[i]);
							short_pane.getChildren().add(nextStock) ;
							nextStock.setLayoutX(W/3.33);
							nextStock.setLayoutY(Distance);
							manager mg = new manager() ;

							if (i == 4 ) {
								i = 0;		
							}
							br.close();

						}

						catch(Exception er) {

							er.printStackTrace();
						}


					}

				});
			}
		});

		// LONG TERM ACTION EVENT HANDLER
		longTerm.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				mg.LongTerm();
				System.out.println("Long term ayo") ;
				long_pane = new Pane() ;
				Distance = 0;
				i=0;
				//Scene short_scene = new Scene(short_scene, W, H);
				Scene long_scene = new Scene(long_pane,W,H) ;
				Label long_Title = new Label("Long Term Generator");
				long_Title.setStyle("-fx-font-family: \"Comic Sans MS\"; -fx-font-size: 25; -fx-text-fill: darkred;");
				long_Title.setWrapText(true);
				long_pane.getChildren().addAll(nextButton, long_Title,exit);
				nextButton.setLayoutX(W*0.475) ;
				nextButton.setLayoutY(330) ;

				long_Title.setLayoutX(W*3/8);
				long_Title.setLayoutY(H*.25);
				stage.setScene(long_scene);
				stage.show();

				// EXIT BUTTON EVENT HANDLER
				exit.setOnAction(new EventHandler<ActionEvent>() {
					@Override 
					public void handle(ActionEvent e) {

						stage.setScene(scene);
						stage.show();

					}

				});
				// NEXT BUTTON EVENT HANDLER
				nextButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override 
					public void handle(ActionEvent e) {

						i = i +1;
						Distance = Distance +125 ;
						Ranks = new File("Ranks.txt");

						try {
							FileReader fr = new FileReader(Ranks);
							BufferedReader br = new BufferedReader(fr);
							br.readLine();
							String[] ranks = new String[5] ;
							ranks[1] = br.readLine();
							ranks[2] = br.readLine();
							ranks[3] = br.readLine();
							ranks[4] = br.readLine();
							Label nextStock = new Label("The "+ i+" stock you should buy would be "+ranks[i]);
							long_pane.getChildren().add(nextStock) ;
							nextStock.setLayoutX(W/3.33);
							nextStock.setLayoutY(Distance);

							br.close();

						}

						catch(Exception er) {
							//Error checking if you try to draw more than 4 stocks out. 
							i = 0;
							//er.printStackTrace();

						}

					}

				});
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
		/*
		stockGenerator SG = new stockGenerator() ;
		SG.parseFile();

		shortGenerator sg= new shortGenerator() ;
		longGenerator lg = new longGenerator() ;

		System.out.println(sg.getGME()) ;
		 */
	}
}