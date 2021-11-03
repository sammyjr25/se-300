
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

public class GUI extends Application
{


	//SET UP PUBLIC STUFF
	GridPane pane = new GridPane();
	MenuBar menuBar = new MenuBar();
	BorderPane bp = new BorderPane();
	HBox hb = new HBox();
	Scene scene = new Scene(bp,1050,1000);


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
        pane.setStyle("-fx-background-color: black");
        //hb.setStyle("-fx-background-color: black");
        
        //pane.add(new Label("go through the options"), 0, 0);
        //button location for buttons
        
        //buttons set on action to enter actions or close program
        
        
        //MAKES AND SETS UP ALL BUTTONS...
        makeAllButtons();
         
    }

    /**
     * Self explanatory. Makes and sets up all buttons. I define all the buttons and other items to add 
     * in here and the respective events each has here.
     * @author Gage
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
            Button algorithm_BTN = new Button("algorithm");
            Button scenario_BTN = new Button("scenario");
            Button results_BTN = new Button("results");
            Button exit_BTN = new Button("Exit");    
            
            
            //Add Buttons To Scene as Needed.........................................................
            pane.add(scenario_BTN, 0, 1); 
            pane.add(algorithm_BTN, 0, 2); 
            pane.add(baseline_BTN, 0, 3); 
            pane.add(results_BTN, 0, 4); 
            pane.add(exit_BTN, 0, 5); 
            
            //Set Button and Key Events for All Buttons.................................................

            scenario_BTN.setOnAction(e ->  bp.setCenter(makeScenarioGUIPane()));
            algorithm_BTN.setOnAction(e ->  bp.setCenter(makeAlgorithmGUIPane()));
            baseline_BTN.setOnAction(e ->  bp.setCenter(makeBaselineGUIPane()));
            results_BTN.setOnAction(e ->  bp.setCenter(makeResultsGUIPane()));
            results_BTN.setOnAction(e ->  bp.setCenter(makeResultsGUIPane()));
            exit_BTN.setOnAction(e ->  Platform.exit());
        }
        
        public GridPane makeScenarioGUIPane()
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
        
        public GridPane makeAlgorithmGUIPane()
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
        
        public GridPane makeResultsGUIPane()
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
