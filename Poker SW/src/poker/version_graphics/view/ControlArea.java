package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import poker.version_graphics.model.DeckOfCards;

public class ControlArea extends BorderPane{
    private DeckLabel lblDeck = new DeckLabel();
    private Region spacer = new Region(); // Empty spacer
    private Region leftSpacer = new Region(); //empty spacer for design purposes
    Button btnShuffle = new Button("Shuffle");
    Button btnDeal = new Button("Deal");
    Button btnExit = new Button ("Exit");
    Button btnFs = new Button("Fullscreen");
    Button addPlayer = new Button("Add Player");
    Button decreasePlayer = new Button("decrease Player");

    public ControlArea() {
    	super(); // Always call super-constructor first !!
    	
    	HBox controlBox = new HBox();
    	addPlayer.setPrefSize(150, 50);
    	btnExit.setPrefSize(100, 50);
    	btnDeal.setPrefSize(100, 50);
    	btnShuffle.setPrefSize(100, 50);
    	btnFs.setPrefSize(150,50);
    	decreasePlayer.setPrefSize(150, 50);
    	spacer.setPrefWidth(50);
    	leftSpacer.setPrefWidth(50);
    	controlBox.getChildren().addAll(leftSpacer,lblDeck, spacer, btnExit, 
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
