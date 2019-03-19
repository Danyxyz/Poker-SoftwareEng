package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Stage;
import poker.version_graphics.PokerGame;
import poker.version_graphics.model.PokerGameModel;

public class PokerGameView {
	private HBox players;
	private ControlArea controls;
	private PokerGameModel model;
	private Label productionlbl = new Label ("Daniel & Kevin");
	private Label deckPlace = new Label ("Deckplace");
	private Region rg = new Region(); 
	
	public PokerGameView(Stage stage, PokerGameModel model) {
		this.model = model;
		
		// Create all of the player panes we need, and put them into an HBox
		players = new HBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
		}
		
		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic
		
		// Resizing the labels, correct the position of the label/region
		
		productionlbl.setPrefSize(100, 100);
	//	productionlbl.setTextFill(Color.GOLD);
		rg.setPrefSize(180, 100);

	
		// show Pokerchips on screen
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("poker/images/ChipTest.png"));	
		imageView.setLayoutY(300);
		
			
		// Put players and controls into a BorderPane
		
		BorderPane root = new BorderPane();
		root.setTop(players);
		root.setCenter(imageView);
		root.setLeft(deckPlace);
		root.setRight(productionlbl);
		root.setAlignment(productionlbl, Pos.BOTTOM_RIGHT);
		root.setBottom(controls);
		root.setId("rootStyle");
	
		
		// Disallow resizing - which is difficult to get right with images
		stage.setResizable(false);

        // Create the scene using our layout; then display it
        Scene scene = new Scene(root);
        scene.getStylesheets().add(
                getClass().getResource("poker.css").toExternalForm());
        stage.setTitle("Poker Miniproject");
        stage.setScene(scene);
        stage.show();		
	}
	
	
	public PlayerPane getPlayerPane(int i) {
		return (PlayerPane) players.getChildren().get(i);
	}
	
	public Button getShuffleButton() {
		return controls.btnShuffle;
	}
	
	public Button getDealButton() {
		return controls.btnDeal;
	}
	public Button getRankingButton() {
		return controls.btnRanking;
	}
}
