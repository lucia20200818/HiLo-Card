import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardsHiLoGui extends Application {
	Image im1, im2;
	ImageView imv1, imv2;
	Button btnDealFC, btnDealSC;
	RadioButton high, low;
	Label lblFirstCard, lblSecondCard, lblNextCard, lblStatus;
	MenuBar mBar;
	Menu file, help;
	MenuItem mItemNewGame, mItemShuffle, mItemExit, mItemAbout;
	ProgressBar progBar;
	ProgressIndicator progInd;
	DeckOfCards deck;
	ToggleGroup toggleGroup;
	Card leftCard, rightCard;
int winTrack = 0;//keep track of how many highs and lows success were made by user
	public CardsHiLoGui() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		deck = new DeckOfCards();//new deck
		
		btnDealFC = new Button("<-Deal First Card");// first d button
		btnDealFC.setOnAction(e -> {
			// first button action
			
			try {

				firstCard();
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		});
		btnDealSC = new Button("Deal Second Card->");//second button
		btnDealSC.setOnAction(e -> {// second button action
			try {
				secondCard();
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		});
		//initiate radio button.labels menu items and progress bar
		high = new RadioButton("Higher");
		low = new RadioButton("Lower");
		toggleGroup = new ToggleGroup();
		lblFirstCard = new Label("First Card Dealt: ");
		lblSecondCard = new Label("Second Card Dealt: ");
		lblNextCard = new Label("Next card will be: ");
		lblStatus = new Label("Lower, You Win!");
		progBar = new ProgressBar();
		progInd = new ProgressIndicator();
		mBar = new MenuBar();
		file = new Menu("File");
		help = new Menu("Help");
		mItemNewGame = new MenuItem("New Game");

		mItemNewGame.setOnAction(ae -> {
			{
				deck = new DeckOfCards();// new deck is created
				winTrack = 0;// reset winTrack
				deck.shuffle();// shuffle the new deck

				float current_proccess = 0f;

				for (int i = 0; i < 10; i++) {
					current_proccess += 0.00;
					progBar.setProgress(current_proccess);
				}

				for (int i = 0; i < 10; i++) {
					current_proccess += 0.00;
					progInd.setProgress(current_proccess);
				}

			}
		});//end set game
		
		
		mItemShuffle = new MenuItem("Shuffle");
		mItemShuffle.setOnAction(e -> deck.shuffle());
		mItemExit = new MenuItem("Exit");
		mItemExit.setOnAction(e -> Platform.exit());

		mItemAbout = new MenuItem("About");
		//set progress bar size
		progBar.setProgress(0);
		progInd.setProgress(0);
		progBar.setMinSize(150, 20);
		progInd.setMinSize(100, 100);

	}

	public void secondCard() throws FileNotFoundException {

		// check if radio button was selected
		if (toggleGroup.getSelectedToggle() != null) {
			if (high.isSelected()) {
				// compare and make sure the right hand image is higher than the left side image

				rightCard = deck.dealTopCard();
				im2 = new Image(new FileInputStream("cards//" + rightCard.toString() + ".png"));
				imv2.setImage(im2);
				if (rightCard.rankIsGreaterThan(leftCard)) {
					// the user wins.
					lblStatus.setText("Win! It's Higher!");
					winTrack++;
					double progValue = progBar.getProgress();

					// Now increase the progress by 0.05.
					progValue = progValue + 0.2;
					if (progValue <= 0.4) {
						progBar.setStyle("-fx-accent: blue;");
						progInd.setStyle("-fx-accent: blue;");
					} else {
						if (progValue < 0.7) {
							progBar.setStyle("-fx-accent: green;");
							progInd.setStyle("-fx-accent: green;");
						} else {
							progBar.setStyle("-fx-accent: red;");
							progInd.setStyle("-fx-accent: red;");
						}
					}

					if (progValue <= 1) {

						progBar.setProgress(progValue);
						progInd.setProgress(progValue);
					} else {
						// Set the progress to 1
						progValue = 1;
						progBar.setProgress(progValue);
						progInd.setProgress(progValue);
					}

				} else {
					// when user is loss
					lblStatus.setText("Lose. It's Lower!");
				}

				// the player wins - update the status of the game

			}

			if (low.isSelected()) {
				// compare and make sure the right hand image is lower than the left side image

				rightCard = deck.dealTopCard();
				im2 = new Image(new FileInputStream("cards//" + rightCard.toString() + ".png"));
				imv2.setImage(im2);
				if (rightCard.rankIsLessThan(leftCard)) {
					// the user wins.
					lblStatus.setText("Win! It's Lower!");
					winTrack++;
					double progValue = progBar.getProgress();

					//  increase the progress by o.2.
					progValue = progValue + 0.2;
					if (progValue <= 0.4) {//when it's less than 0.4 , show blue
						progBar.setStyle("-fx-accent: blue;");
						progInd.setStyle("-fx-accent: blue;");
					} else {
						if (progValue < 0.7) {//when it's less than 0.7 , show green
							progBar.setStyle("-fx-accent: green;");
							progInd.setStyle("-fx-accent: green;");
						} else {//when it's greater than 0.7 , show red
							progBar.setStyle("-fx-accent: red;");
							progInd.setStyle("-fx-accent: red;");
						}
					}

					if (progValue <= 1) {

						progBar.setProgress(progValue);
						progInd.setProgress(progValue);
					} else {
						// Set the progress to 1.
						progValue = 1;
						progBar.setProgress(progValue);
						progInd.setProgress(progValue);
					}
				} else {
					// when user loss
					lblStatus.setText("Lose. It's Higher!");
				}

				// the player wins - update the status of the game

			} 

		}

	

	}

	public void firstCard() throws FileNotFoundException {//show the leftcard odject in left
		
		leftCard = deck.dealTopCard();
		im1 = new Image(new FileInputStream("cards//" + leftCard.toString() + ".png"));
		imv1.setImage(im1);
	}

	@Override
	public void start(Stage pStage) throws Exception {

		pStage.setTitle("Card-Hi-Lo 2020");
		pStage.setWidth(500);
		pStage.setHeight(500);

		// Create Layout
		VBox vbMain = new VBox();
		VBox mid = new VBox();
		GridPane gb = new GridPane();
		mItemExit.setOnAction(e -> pStage.close());
		// adding components
		file.getItems().addAll(mItemNewGame, mItemShuffle, mItemExit);
		help.getItems().add(mItemAbout);
		mBar.getMenus().addAll(file, help);
		// about
		mItemAbout.setOnAction(e -> showAbout());
		
		
		mid.getChildren().addAll(lblNextCard, high, low, btnDealFC, btnDealSC , progBar, progInd);
		mid.setSpacing(10);

		high.setToggleGroup(toggleGroup);
		low.setToggleGroup(toggleGroup);
		// gridPane
		// get the images
		im1 = new Image(new FileInputStream("cards//black_joker.png"));//before start game show joker
		im2 = new Image(new FileInputStream("cards//black_joker.png"));//before start game show joker
		imv1 = new ImageView(im1);
		imv2 = new ImageView(im2);
		gb.add(lblFirstCard, 0, 0);
		gb.add(lblSecondCard, 2, 0);
		gb.add(imv1, 0, 1);
		gb.add(mid, 1, 1);
		gb.add(imv2, 2, 1);
		gb.add(lblStatus, 2, 2);
		gb.setVgap(10);
		gb.setHgap(10);
		vbMain.getChildren().addAll(mBar, gb);
		
		gb.setAlignment(Pos.CENTER);
		gb.setPadding(new Insets(10, 15, 0, 15));
		// create scene
		Scene sc = new Scene(vbMain);
        sc.getStylesheets().add("mainStyle.css");
		// set scene
		pStage.setScene(sc);
		// show stage
		pStage.show();

	}
	public void showAbout() {
		Stage dialog = new Stage();
		dialog.setWidth(250);
		dialog.setHeight(180);
		dialog.setTitle("About");
//A label for dialog
		Label lblAbout = new Label("luchin chen 3001427");
//ok button
		Button btok = new Button("ok");
		
//Handle events
		btok.setOnAction(ae -> dialog.close());
//set button ok size
		btok.setMinWidth(120);

//layout for about dialog
		VBox vbAbout = new VBox();
		BorderPane dlgbp = new BorderPane();
		dlgbp.setCenter(btok);

		BorderPane bplbl = new BorderPane();
		bplbl.setCenter(lblAbout);

//set padding
		vbAbout.setPadding(new Insets(40));
		vbAbout.setSpacing(20);

//add component
		vbAbout.getChildren().add( bplbl);
		vbAbout.getChildren().add(dlgbp);

//set scene
		Scene absc = new Scene(vbAbout);
		dialog.setScene(absc);
		absc.getStylesheets().add("dialogStyle.css");
		dialog.show();

	}// show about.
	// launch app
	public static void main(String[] args) {
		launch();
	}

}
