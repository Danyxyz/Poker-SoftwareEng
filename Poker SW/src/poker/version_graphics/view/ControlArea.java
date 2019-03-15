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
    Button btnShuffle = new Button("Shuffle");
    Button btnDeal = new Button("Deal");
    Button btnRanking = new Button ("Ranking");

    public ControlArea() {
    	super(); // Always call super-constructor first !!
    	
    	HBox controlBox = new HBox();
    	btnRanking.setPrefSize(75, 30);
    	btnDeal.setPrefSize(75, 30);
    	btnShuffle.setPrefSize(75, 30);
    	spacer.setPrefWidth(250);
    	controlBox.getChildren().addAll(lblDeck, spacer, btnRanking, btnShuffle, btnDeal);
    	
    	this.setCenter(controlBox);
    

        //HBox.setHgrow(spacer, Priority.ALWAYS); // Use region to absorb resizing
        this.setId("controlArea"); // Unique ID in the CSS
    }
    
    public void linkDeck(DeckOfCards deck) {
    	lblDeck.setDeck(deck);
    }
}
