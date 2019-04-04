package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import poker.version_graphics.model.DeckOfCards;

public class ControlArea extends BorderPane{
    private DeckLabel lblDeck = new DeckLabel();
    private Region spacer = new Region(); // Empty spacer
    private Region leftSpacer = new Region(); //empty spacer for design purposes
    Button btnShuffle = new Button("Shuffle");
    Button btnDeal = new Button("Deal");
    Button btnExit = new Button ("Exit");
    Button btnFs = new Button("Fullscreen");
    Button addPlayer = new Button("+ Player");
    Button decreasePlayer = new Button("- Player");
    Button rulebtn = new Button ("Rules");
    Button changeMusicbtn = new Button("Change Music");
    Button stopMusicbtn = new Button("Stop Music");

    public ControlArea() {
    	super(); // Always call super-constructor first !!
    	
    	HBox controlBox = new HBox();
    	VBox musicBox = new VBox();
    	
    	//Change size music buttons
    	changeMusicbtn.setPrefSize(150, 25);
    	stopMusicbtn.setPrefSize(150, 25);
    	musicBox.setSpacing(5);
    	musicBox.getChildren().addAll(changeMusicbtn, stopMusicbtn);
    	
    	addPlayer.setPrefSize(100, 40);
    	decreasePlayer.setPrefSize(100, 40);
    	
    	btnExit.setPrefSize(80, 40);
    	btnDeal.setPrefSize(80, 40);
    	btnShuffle.setPrefSize(80, 40);
    	btnFs.setPrefSize(100, 40);
    	rulebtn.setPrefSize(80, 40);
    	
    	spacer.setPrefWidth(50);    	
    	leftSpacer.setPrefWidth(36);
    	controlBox.getChildren().addAll(leftSpacer,lblDeck, spacer, btnExit,musicBox, rulebtn, 
    													decreasePlayer, addPlayer, btnFs, btnShuffle, btnDeal);
    	controlBox.setSpacing(10);
    	this.setCenter(controlBox);
    

        HBox.setHgrow(spacer, Priority.ALWAYS); // Use region to absorb resizing
        this.setId("controlArea"); // Unique ID in the CSS
    }
    
    public void linkDeck(DeckOfCards deck) {
    	lblDeck.setDeck(deck);
    }
}
