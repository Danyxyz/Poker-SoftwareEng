package poker.version_graphics.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RankingWindow {

	
	public static void display(String title) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		window.setHeight(1000);
		ImageView imageView = new ImageView();
		imageView.setImage(new Image("poker/images/Poker_Ranking.png"));
	
		
		
/*		Label label = new Label();
		label.setText("1. Royal flush \n"
				+ "2. Straight flush \n"
				+ "3. Four of kind \n"
				+ "4. Full house \n"
				+ "5. Flush \n"
				+ "6. Straight \n"
				+ "7. Three of a kind \n"
				+ "8. Two pair \n"
				+ "9. One pair \n"
				+ "10. High card \n"
				);
				*/
				
		Button exitbtn = new Button ("Exit");
		exitbtn.setOnAction(e -> window.close());
		

		
		
		
		BorderPane layout = new BorderPane();

		layout.setCenter(imageView);
		layout.setBottom(exitbtn);
		layout.setId("rankingWindow");
		
		
		Scene scene = new Scene (layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
