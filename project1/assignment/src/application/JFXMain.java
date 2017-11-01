package application;

import java.io.FileNotFoundException;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class JFXMain extends Application {
	private String[] args; 
  
	public static void data(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(final Stage primaryStage) {
	primaryStage.setTitle("Network Flow Analyser");
    Group root = new Group();
    Scene scene = new Scene(root, 400, 300, Color.WHITE);

    MenuBar menuBar = new MenuBar();
    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

    //File menu
    Menu fileMenu = new Menu("File");
 
    MenuItem exitMenuItem = new MenuItem("Exit");
    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
    
    //Connections menu
    Menu netMenu = new Menu("Connections");
 
    //Action on source ip
    MenuItem srcip = new MenuItem("Clients", null);
    srcip.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
    	  //Create instance to read file
    	  NetworkModel model = ReadDataFile.ReadFile(1);	     
	      //Create a model, view to display src ip
	      DataView view = new DataView();
	      DataController controller = new DataController(model, view);
	      controller.updateViewSrcIP();        
      }
    });
    
    //Action on dst ip
    MenuItem dstip = new MenuItem("Servers", null);
    dstip.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
    	  //Create instance to read file
    	  NetworkModel model = ReadDataFile.ReadFile(2); 
	      //Create a model, view to display src ip
	      DataView view = new DataView();
	      DataController controller = new DataController(model, view);
	      controller.updateViewDstIP();      
      }
    });
    
    //Protocol menu
    Menu protoMenu = new Menu("Protocol");
 
    //Action on protocol
    MenuItem proto = new MenuItem("Protocol", null);
    proto.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
    	  //Create instance to read file
    	  NetworkModel model = ReadDataFile.ReadFile(3);       
	      //Create a model, view to display src ip
	      DataView view = new DataView();
	      DataController controller = new DataController(model, view);
	      controller.updateViewProto();        
      }
    });
    
    //Protocol menu
    Menu dportMenu = new Menu("Destination Port");
 
    //Action on protocol
    MenuItem dport = new MenuItem("Destination Port", null);
    dport.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
    	  //Create instance to read file
    	  NetworkModel model = ReadDataFile.ReadFile(4); 
    	  //Create a model, view to display src ip
	      DataView view = new DataView();
	      DataController controller = new DataController(model, view);
	      controller.updateViewDPort();        
      }
     });    
    
    //Mount menu
    fileMenu.getItems().addAll(new SeparatorMenuItem(), exitMenuItem);
    netMenu.getItems().addAll(new SeparatorMenuItem(), srcip, dstip);
    protoMenu.getItems().addAll(new SeparatorMenuItem(), proto);
    dportMenu.getItems().addAll(new SeparatorMenuItem(), dport);
    
    //Add the menus (order)
    menuBar.getMenus().addAll(fileMenu, netMenu, protoMenu, dportMenu);
    root.getChildren().add(menuBar);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
 
}
