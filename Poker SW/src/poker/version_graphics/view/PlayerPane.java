package poker.version_graphics.view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.util.Duration;
import poker.version_graphics.model.Card;
import poker.version_graphics.model.HandType;
import poker.version_graphics.model.Player;


public class PlayerPane extends VBox {
    private Label lblName = new Label();
    private HBox hboxCards = new HBox();
    private Label lblEvaluation = new Label("--");
    private Label spacelbl = new Label("");
    private Label winlbl = new Label("Games won: ");
 //   private Label winevualate = new Label("-");
    
    // Link to player object
    private Player player;
    
    public PlayerPane() {
        super(); // Always call super-constructor first !!
        this.getStyleClass().add("player"); // CSS style class
        lblName.setPrefSize(50, 50);
        // Add child nodes, also added the winlabel and the winresultlabel
        HBox hb = new HBox();
        hb.getChildren().add(winlbl);
        this.getChildren().addAll(lblName, hboxCards,lblEvaluation, hb);
        
        // Add CardLabels for the cards
        for (int i = 0; i < 5; i++) {
            Label lblCard = new CardLabel();
            hboxCards.setSpacing(5);
            hboxCards.getChildren().addAll(lblCard);
        }
    }
    
    public void setPlayer(Player player) {
    	this.player = player;
    	updatePlayerDisplay(); // Immediately display the player information
    }
    
    public void updatePlayerDisplay() {
    	lblName.setText(player.getPlayerName());
    	for (int i = 0; i < Player.HAND_SIZE; i++) {
    		Card card = null;
    		if (player.getCards().size() > i) card = player.getCards().get(i);
    		CardLabel cl = (CardLabel) hboxCards.getChildren().get(i);
    		cl.setCard(card);
    		HandType evaluation = player.evaluateHand();
    		    		if (evaluation != null)
    			lblEvaluation.setText(evaluation.toString());
    		else
    			lblEvaluation.setText("--");
    		    	
    		    		//PathElement pe1 = new MoveTo(0, 500); // Start position
    		    		//PathElement pe2 = new LineTo(200, 200);
    		   //	PathElement pe3 = new ArcTo(50, 100, 0, 300, 450, false, false);
    		    		//Path path = new Path();
    		    		//path.getElements().add(pe1);
    		    		//path.getElements().add(pe2);
    		    		//path.getElements().add(pe3);
    		    		//PathTransition move = new PathTransition(Duration.millis(4000), path, cl);
    		   //	move.setAutoReverse(true);
    		    		//move.setCycleCount(Animation.INDEFINITE);
    		    		//move.play();
    	}
    }
}
