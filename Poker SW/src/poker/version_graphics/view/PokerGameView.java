package poker.version_graphics.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
	private Stage stage = new Stage();
	
	public PokerGameView(Stage stage, PokerGameModel model) {
		this.model = model;
		this.stage = stage;
		
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
		ImageView chip = new ImageView();
		chip.setImage(new Image("poker/images/ChipTest.png"));	
		chip.setLayoutY(300);
		
		//show cardback
		ImageView cardBack = new ImageView();
		cardBack.setImage(new Image("poker/images/FHNW_Cardback.png"));
		cardBack.setLayoutY(5);
		VBox deckBox = new VBox();
		deckBox.getChildren().add(cardBack);
		deckBox.setAlignment(Pos.BOTTOM_RIGHT);
				
		//Pokerchips initializing
		ImageView redChip = new ImageView();
		redChip.setImage(new Image("poker/images/PokerChipBlue.png"));
		ImageView blueChip = new ImageView();
		blueChip.setImage(new Image("poker/images/PokerChipRed.png"));
		ImageView whiteChip = new ImageView();
		whiteChip.setImage(new Image("poker/images/PokerChipWhite.png"));
		ImageView yellowChip = new ImageView();
		yellowChip.setImage(new Image("poker/images/yellowChip.png"));
		
		//show Table label
		ImageView pokerLabel = new ImageView();
		pokerLabel.setImage(new Image("poker/images/PokerTabelLabel.png"));
		VBox vb = new VBox();
		HBox hb = new HBox();
		hb.getChildren().addAll(redChip, blueChip, chip, whiteChip, yellowChip);
		hb.setSpacing(65);
		hb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(hb, pokerLabel);
		vb.setAlignment(Pos.CENTER);
		

		
		
		//show Poker rankings
	/*	ImageView pokerRanking = new ImageView();
		pokerRanking.setImage(new Image("poker/images/Poker_Ranking2.png"));
		VBox rankingBox = new VBox();
		rankingBox.getChildren().addAll(pokerRanking, productionlbl);
		 */
		
		// Put elements and controls into a BorderPane
		
		BorderPane root = new BorderPane();
		root.setTop(players);
		players.setAlignment(Pos.CENTER); //to center the cards
		root.setCenter(vb);
		root.setLeft(deckBox);
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
        
        stage.setFullScreen(true);
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
	public Button getExitButton() {
		return controls.btnExit;
	}
	public Button getFSButton() {
		return controls.btnFs;
	}
	public Stage getStage() {
		return this.stage;
	}
}
