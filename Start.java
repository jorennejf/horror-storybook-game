import java.io.File;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
* @author: Jorenne Flores & Jomar Batac
* @email: cs8bba & cs8bae
* @pid: A11974170 & A11964157
* @about: Creates the intro page and the very first scene that leads to other
* 				scenarios using a GUI.
* 
*/

public class Start extends Application{
	public static GridPane pane = new GridPane();
	public static ImageView image;
  public static Button a;
  public static Button b;
  Button c;
  ImageView introPic = new ImageView("TITLE.jpg");
	Button play = new Button("Play");
	
	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	public void start(Stage primaryStage) {
		primaryStage.setTitle("The Secret");	
		pane.setHgap(5);
		pane.setVgap(10);
		pane.setPadding(new Insets(20));
		
		//Intro Picture
		introPic.setFitHeight(600);
		introPic.setFitWidth(1200);
		pane.add(introPic, 0, 0);
		
		//Play Button
		play.setMaxWidth(Double.MAX_VALUE);
		pane.add(play, 0, 1);
		PlayGame p = new PlayGame();
		play.setOnAction(p);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		File f = new File("src/Background.mp3");
		AudioClip background = new AudioClip(f.toURI().toString());
		background.setCycleCount(180);
		background.play();
	}
	
	
	/*
	 * Sets the scene to the very first scenario in which the user chooses which
	 * character to play.
	 */
	public class PlayGame implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			
			//removes previous nodes
			pane.getChildren().remove(introPic);
			pane.getChildren().remove(play);
			
			changeNodes("family.jpg", "A) Barbara (Mom)", "B) Todd (Dad)");
			
			//Adds a third button for last character
			c = new Button("C) Preston (Kid)");
			c.setMaxWidth(Double.MAX_VALUE);
			pane.add(c, 0, 3);
			
			//Runs event handler for buttons
			Mom mom = new Mom();
			a.setOnAction(mom);
			Dad dad = new Dad();
			b.setOnAction(dad);
			Kid kid = new Kid();
			c.setOnAction(kid);

		}
	}
	
	/*
	 * Animates the image while playing a heartbeat sound effect and then brings 
	 * the user to the scenario for the mom character.
	 */
	public class Mom implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e1){
			
			//disables other choices while animation plays
			a.setDisable(true);
			b.setDisable(true);
			c.setDisable(true);
			
			File f = new File("src/heartbeat.wav");
			AudioClip heartbeat = new AudioClip(f.toURI().toString());
			heartbeat.play();
			
			ImageView momPic = new ImageView("mom.jpg"); //b&w picture
			FadeTransition ft = Animation(momPic);
			ft.setOnFinished(new EventHandler<ActionEvent>() {    
		    public void handle(ActionEvent event) {
		    	heartbeat.stop();
		    	MomScenario mom = new MomScenario();
		    	pane.getChildren().remove(c);
					mom.play();
		    }
			});	
			
		}
	}
	
	/*
	 * Animates the image while playing a heartbeat sound effect and then brings 
	 * the user to the scenario for the dad character.
	 */
	public class Dad implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e1){
			
			//disables other choices while animation plays
			a.setDisable(true);
			b.setDisable(true);
			c.setDisable(true);
			
			File f = new File("src/heartbeat.wav");
			AudioClip heartbeat = new AudioClip(f.toURI().toString());
			heartbeat.play();
			
			ImageView dadPic = new ImageView("dad.jpg"); //b&w picture
			FadeTransition ft = Animation(dadPic);
			ft.setOnFinished(new EventHandler<ActionEvent>() {    
		    public void handle(ActionEvent event) {
		    	heartbeat.stop();
		    	DadScenario dad = new DadScenario();
		    	pane.getChildren().remove(c);
					dad.play();
		    }
			});	
			
		}
	}
	
	
	/*
	 * Animates the image while playing a heartbeat sound effect and then brings 
	 * the user to the scenario for the kid character.
	 */
	public class Kid implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e1){
			
			//disables other choices while animation plays
			a.setDisable(true);
			b.setDisable(true);
			c.setDisable(true);
			
			File f = new File("src/heartbeat.wav");
			AudioClip heartbeat = new AudioClip(f.toURI().toString());
			heartbeat.play();
			
			ImageView kidPic = new ImageView("kid.jpg"); //b&w picture
			FadeTransition ft = Animation(kidPic);
			ft.setOnFinished(new EventHandler<ActionEvent>() {    
		    public void handle(ActionEvent event) {
		    	heartbeat.stop();
		    	KidScenario kid = new KidScenario();
		    	pane.getChildren().remove(c);
					kid.play();
		    }
			});	
			
		}
	}
	
	
	
	/*
	 * Changes the main image and the words on the buttons, and sets their sizes.
	 * @param i is the image
	 * @param A is the first choice
	 * @param B is the second choice
	 */
	public static void changeNodes(String i, String A, String B){
		
		//removes previous nodes
		pane.getChildren().remove(image);
		pane.getChildren().remove(a);
		removeSecondButton();
						
		//Image
		image = new ImageView(i);
		image.setFitHeight(540);
		image.setFitWidth(1200);
		pane.add(image, 0, 0);
		
		//Button A
		a = new Button(A);
		a.setMaxWidth(Double.MAX_VALUE);
		pane.add(a, 0, 1);
		
		//Button B
		b = new Button(B);
		b.setMaxWidth(Double.MAX_VALUE);
		pane.add(b, 0, 2);
				
	}
	
	
	/*
	 * Creates and plays the fade animation. Returns the FadeTransition.
	 * @param pic is the image that gets faded in
	 */
	public FadeTransition Animation(ImageView pic){
		pic.setFitHeight(540);
		pic.setFitWidth(1200);
		FadeTransition ft = new FadeTransition(Duration.millis(3000), pic);
		ft.setFromValue(0);
		ft.setToValue(1.0);
		ft.play();
		pane.add(pic, 0, 0);
		return ft;
	}
	

	

	/*
	 * Creates a new stage that displays the image of the ghost and plays a
	 * screaming sound.
	 */
	public static void Ghost(){
		
		//makes audio
		File f = new File("src/scream.wav");
		AudioClip scream = new AudioClip(f.toURI().toString());
		
		//makes image
		image = new ImageView("ghost.jpg");
		image.setFitHeight(540);
		image.setFitWidth(1200);
		
		scream.play();
		Stage stage = new Stage();
		StackPane p = new StackPane();
		p.getChildren().add(image);
		Scene s = new Scene(p);
		stage.setScene(s);
		stage.setTitle("DEATH");
		stage.show();
		
	}
	
	/*
	 * Removes second button from scene.
	 */
	public static void removeSecondButton(){
		pane.getChildren().remove(b);
	}
	
	/*
	 * Ends the game.
	 */
	public static class Quit implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			System.exit(0);
		}
	}
	

}
