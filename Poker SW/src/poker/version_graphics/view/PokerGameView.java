package poker.version_graphics.view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
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
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Stage;
import javafx.util.Duration;
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
	private Timeline time;
	
	public PokerGameView(Stage stage, PokerGameModel model) {
		this.model = model;
		this.stage = stage;
		
		// Create all of the player panes we need, and put them into an HBox
		players = new HBox();
		for (int i = 0; i < PokerGame.NUM_PLAYERS; i++) {
			PlayerPane pp = new PlayerPane();
			pp.setPlayer(model.getPlayer(i)); // link to player object in the logic
			players.getChildren().add(pp);
			
			
			PathElement pe1 = new MoveTo(300, -100); //
			PathElement pe2 = new LineTo(300, 150);
			Path ppPath = new Path();
			ppPath.getElements().add(pe1);
			ppPath.getElements().add(pe2);
			PathTransition move = new PathTransition(Duration.seconds(2), ppPath, pp);
			
			move.play();
			
		}
		
		// Create the control area
		controls = new ControlArea();
		controls.linkDeck(model.getDeck()); // link DeckLabel to DeckOfCards in the logic
	
		
		// animate Controlarea
		PathElement pe1 = new MoveTo(620, 100); //start position
		PathElement pe2 = new LineTo(620, 30); // end position
		Path path = new Path();
		path.getElements().add(pe1);
		path.getElements().add(pe2);
		PathTransition move = new PathTransition(Duration.seconds(2), path, controls);
		
		move.play();
		
		// Resizing the labels, correct the position of the label/region
		
		productionlbl.setPrefSize(100, 100);
		rg.setPrefSize(180, 100);
		
		//show cardback
		ImageView cardBack = new ImageView();
		cardBack.setImage(new Image("poker/images/FHNW_Cardback.png"));
		cardBack.setLayoutY(5);
		VBox deckBox = new VBox();
		deckBox.getChildren().add(cardBack);
		deckBox.setAlignment(Pos.BOTTOM_RIGHT);

		//cardback Animation
		PathElement cbpe1 = new MoveTo(-100, 40); //start position
		PathElement cbpe2 = new LineTo(100, 50); // end position
		Path cbPath = new Path();
		cbPath.getElements().add(cbpe1);
		cbPath.getElements().add(cbpe2);
		PathTransition cbMove = new PathTransition(Duration.seconds(2.5), cbPath, cardBack);
		
		cbMove.play();
		
	
				
		//Pokerchips initializing
		ImageView chip = new ImageView();
		chip.setImage(new Image("poker/images/ChipTest.png"));	
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
		pokerLabel.setImage(new Image("poker/images/PokerTabelLabel2Transp.png"));
		
		//put the objects in layouts
		VBox vb = new VBox();
		HBox hb = new HBox();
		hb.getChildren().addAll(redChip, blueChip, chip, whiteChip, yellowChip);
		hb.setSpacing(65);
		hb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(hb, pokerLabel);
		vb.setAlignment(Pos.CENTER);
		
		//Animation for chips
  		PathElement p1 = new MoveTo(305, 6);
  		PathElement p2 = new LineTo(305,13);
          
          Path chipPath = new Path();
          chipPath.getElements().add(p1);
          chipPath.getElements().add(p2);
          
          PathTransition chipMove = new PathTransition(
        		  Duration.millis(400), chipPath, hb);
          chipMove.setAutoReverse(true);
          chipMove.setCycleCount(10);
          chipMove.play();
          
          
		//show Poker rankings
	    ImageView pokerRanking = new ImageView();
		pokerRanking.setImage(new Image("poker/images/Poker_Ranking2.png"));
		VBox rankingBox = new VBox();
		rankingBox.getChildren().addAll(pokerRanking, productionlbl);
		PathElement prpe1 = new MoveTo(600, 200); //start position
		PathElement prpe2 = new LineTo(185, 200); // end position
		Path prPath = new Path();
		prPath.getElements().add(prpe1);
		prPath.getElements().add(prpe2);
		PathTransition prMove = new PathTransition(Duration.seconds(3), prPath, rankingBox);
		
		prMove.play();
		
		
		// Put elements and controls into a BorderPane
		
		BorderPane root = new BorderPane();
		root.setTop(players);
		players.setAlignment(Pos.CENTER); //to center the cards
		root.setCenter(vb);
		root.setLeft(deckBox);
		root.setRight(rankingBox);
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
	public Button getAddPlayerBtn() {
		return controls.addPlayer;
	}
	public Stage getStage() {
		return this.stage;
	}
	public void startAnimation() {
		time = new Timeline();
		time.play();
	}
}
