import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
* @author: Jorenne Flores & Jomar Batac
* @email: cs8bba & cs8bae
* @pid: A11974170 & A11964157
* @about: Brings to user to the kid's scenario and changes the nodes according 
* 				to the user's choices.
* 
*/

public class KidScenario {
	
	/*
	 * Begins the first scene for the kid character.
	 */
	public void play(){
		Start.changeNodes("bedroom.jpg", "Next", "");
		Start.removeSecondButton();
		Nightmare next = new Nightmare();
		Start.a.setOnAction(next);
	}
	
	/*
	 * Event handler for nightmare scene.
	 */
	public class Nightmare implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("bedroom2.jpg", "Next", "");
			Start.removeSecondButton();
			Bedroom next = new Bedroom();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for waking up scene. User must decide to shower or get 
	 * dressed right away.
	 */
	public class Bedroom implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("bedroom3.jpg", "A) Shower and get dressed", "B) Get "
					+ "dressed and go directly downstairs");
			Kitchen yum = new Kitchen();
			Start.a.setOnAction(yum);
			Start.b.setOnAction(yum);
		}
	}
	
	/*
	 * Event handler for getting hungry scene. User must decide to make themself 
	 * cereal or to have the maid make cereal.
	 */
	public class Kitchen implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("kidkitchen.jpg", "A) Make yourself cereal", "B) "
					+ "Have the maid make you cereal");
			Cereal yum = new Cereal();
			Start.a.setOnAction(yum);
			Start.b.setOnAction(yum);
		}
	}
	
	/*
	 * Event handler for choosing what to do scene. User decides to watch tv or
	 * to get video games from the basement.
	 */
	public class Cereal implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("kidkitchen2.jpg", "A) Watch TV", "B) Get your "
					+ "video games from the basement");
			TV tv = new TV();
			Start.a.setOnAction(tv);
			Basement basement = new Basement();
			Start.b.setOnAction(basement);
		}
	}
	
	/*
	 * Event handler for basement scene. Leads to death.
	 */
	public class Basement implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("basement.jpg", "Next", "");
			Start.removeSecondButton();
			BasementDeath death = new BasementDeath();
			Start.a.setOnAction(death);
		}
	}
	
	/*
	 * Event handler for dying in basement scene. Ghost pops up and user dies.
	 */
	public class BasementDeath implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("basementdeath.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for watching tv scene.
	 */
	public class TV implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("tv.jpg", "Next", "");
			Start.removeSecondButton();
			News next = new News();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for news report scene. User must decide to call mom or dad.
	 */
	public class News implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("news.jpg", "A) Call your mom", "B) Call your dad");
			CallMom mom = new CallMom();
			Start.a.setOnAction(mom);
			CallDad dad = new CallDad();
			Start.b.setOnAction(dad);
		}
	}
	
	/*
	 * Event handler for calling mom scene.
	 */
	public class CallMom implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("note.jpg", "Next", "");
			Start.removeSecondButton();
			Note next = new Note();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for reading note scene. User must decide to follow the sound
	 * or to get out.
	 */
	public class Note implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("note2.jpg", "A) Find out where the sound is "
					+ "coming from", "B) GET OUT NOW");
			TVSound sound = new TVSound();
			Start.a.setOnAction(sound);
			GetOut getout = new GetOut();
			Start.b.setOnAction(getout);
		}
	}
	
	/*
	 * Event handler for choosing to get out scene. Ghost pops up and user dies.
	 */
	public class GetOut implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("rodneykill.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for finding sound from tv scene.
	 */
	public class TVSound implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("static.jpg", "Next", "");
			Start.removeSecondButton();
			TVDeath death = new TVDeath();
			Start.a.setOnAction(death);
		}
	}
	
	/*
	 * Event handler for tv death scene. Ghost pops up and user dies.
	 */
	public class TVDeath implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("rodneytv.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for calling dad scene.
	 */
	public class CallDad implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("calldad.jpg", "Next", "");
			Start.removeSecondButton();
			PoliceCall next = new PoliceCall();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for police officer answering scene.
	 */
	public class PoliceCall implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("policecall.jpg", "Next", "");
			Start.removeSecondButton();
			RoomNoise next = new RoomNoise();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for hearing sound in room scene. User must decide to follow
	 * the sound or to get out.
	 */
	public class RoomNoise implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("roomnoise.jpg", "A) Find out where the sound is "
					+ "coming from", "B) GET OUT NOW");
			ClosetSound sound = new ClosetSound();
			Start.a.setOnAction(sound);
			GetOut getout = new GetOut();
			Start.b.setOnAction(getout);
		}
	}
	
	/*
	 * Event handler for hearing sound in closet scene.
	 */
	public class ClosetSound implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("closet.jpg", "Next", "");
			Start.removeSecondButton();
			ClosetDeath death = new ClosetDeath();
			Start.a.setOnAction(death);
		}
	}
	
	/*
	 * Event handler for finding ghost in closet scene. Ghost pops up and user 
	 * dies.
	 */
	public class ClosetDeath implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("closetdeath.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
}
