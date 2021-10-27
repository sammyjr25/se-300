
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
/**
 * Purpose: MainMenu
 */
public class GUI extends Application
{


	//SET UP PUBLIC STUFF
	GridPane pane = new GridPane();
	MenuBar menuBar = new MenuBar();
	BorderPane bp = new BorderPane();
	HBox hb = new HBox();
	Scene scene = new Scene(bp,1050,1000);

//MAKE BUTTONS (AND OTHER NODES)...
		private Button m = new Button("cargo map");
		private Button a = new Button("algorithm");
		private Button s = new Button("scenario");
		private Button r = new Button("results");
		private Button X = new Button("Exit");	
		
	//START...
	@Override
	public void start(Stage stage) 
	{
		
		bp.setCenter(pane);
		bp.setTop(menuBar);
		stage.setScene(scene);
		stage.setTitle("baggage data base");
		stage.show();
		
		//Basic set up stuff..
		pane.setStyle("-fx-background-color: black");
		//hb.setStyle("-fx-background-color: black");
		
		pane.add(new Label("go through the options"), 0, 0);
		//button location for logbooks
		pane.add(s, 0, 1); 
		pane.add(a, 0, 2); 
		pane.add(m, 0, 3); 
		pane.add(r, 0, 4); 
		pane.add(X, 0, 5); 
		//buttons set on action to enter logbooks or close program
		//SS.setOnAction(e ->  bp.setCenter(SGUI.getGridPane()));
		//CD.setOnAction(e ->  bp.setCenter(CGUI.getGridPane()));
		//TD.setOnAction(e ->  bp.setCenter(TGUI.getGridPane()));
		X.setOnAction(e ->  Platform.exit());
		
	}


	//MAIN...
	public static void main(String[] args) 
	{
		launch(args);
	}

  }
