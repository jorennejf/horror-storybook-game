import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
* @author: Jorenne Flores & Jomar Batac
* @email: cs8bba & cs8bae
* @pid: A11974170 & A11964157
* @about: Brings to user to the dad's scenario and changes the nodes according 
* 				to the user's choices.
* 
*/

public class DadScenario {
	
	/*
	 * Begins the first scene for the dad character.
	 */
	public void play(){
		Start.changeNodes("dadbegins.jpg", "Next", "");
		Start.removeSecondButton();
		Bed bed = new Bed();
		Start.a.setOnAction(bed);
	}
	
	/*
	 * Event handler for waking up scene. User must decide to shower or to just
	 * get dressed right away.
	 */
	public class Bed implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("dadbed.jpg", "A) Shower and get dressed", "B) Get dressed"
				+ " and go directly downstairs");
			Cars cars = new Cars();
			Start.a.setOnAction(cars);
			Start.b.setOnAction(cars);
		}
	}
	
	/*
	 * Event handler for choosing transportation scene.
	 */
	public class Cars implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("dadcars.jpg", "A) Drive your Porsche", "B) Have the "
					+ "limo driver take you");
			MomScenario.Porsche porsche = new MomScenario.Porsche();
			Start.a.setOnAction(porsche);
			Limo limo = new Limo();
			Start.b.setOnAction(limo);
		}
	}
	
	/*
	 * Event handler for limo scene.
	 */
	public class Limo implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("dadlimo.jpg", "Next", "");
			Start.removeSecondButton();
			Building next = new Building();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for arriving at work scene.
	 */
	public class Building implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("building.jpg", "Next", "");
			Start.removeSecondButton();
			Office next = new Office();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for arriving at office scene.
	 */
	public class Office implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("office.jpg", "Next", "");
			Start.removeSecondButton();
			Voicemail next = new Voicemail();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for checking voicemail scene. User must choose whether or
	 * not to listen to voicemail messages.
	 */
	public class Voicemail implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("phone.jpg", "A) Listen to voicemail", "B) Delete "
					+ "messages");
			Listen listen = new Listen();
			Start.a.setOnAction(listen);
			Delete delete = new Delete();
			Start.b.setOnAction(delete);
		}
	}
	
	/*
	 * Event handler for deleting voicemails scene. Leads to death.
	 */
	public class Delete implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("iphone.jpg", "Next", "");
			Start.removeSecondButton();
			MessageDeath death = new MessageDeath();
			Start.a.setOnAction(death);
		}
	}
	
	/*
	 * Event handler for heart attack scene. Ghost pops up and user dies.
	 */
	public class MessageDeath implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("heartattack.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for listening to voicemails scene.
	 */
	public class Listen implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("voicemail.jpg", "Next", "");
			Start.removeSecondButton();
			Listen2 next = new Listen2();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for choosing whether or not to call back scene.
	 */
	public class Listen2 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("voicemail2.jpg", "A) Call back","B) Don't call back");
			Callback callback = new Callback();
			Start.a.setOnAction(callback);
			NoCall nocall = new NoCall();
			Start.b.setOnAction(nocall);
		}
	}
	
	/*
	 * Event handler for not calling back scene. Leads to death.
	 */
	public class NoCall implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("nocall.jpg", "Next", "");
			Start.removeSecondButton();
			WindowDeath death = new WindowDeath();
			Start.a.setOnAction(death);
		}
	}
	
	/*
	 * Event handler for falling out window scene. Ghost pops up and user dies.
	 */
	public class WindowDeath implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("windowdeath.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for calling back scene.
	 */
	public class Callback implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("callback.jpg", "Next", "");
			Start.removeSecondButton();
			Callback2 next = new Callback2();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for choosing to read message scene. User must decide whether
	 * or not to read the message.
	 */
	public class Callback2 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("callback2.jpg", "A) Read", "B) Don't read");
			Message read = new Message();
			Start.a.setOnAction(read);
			NoCall noread = new NoCall();
			Start.b.setOnAction(noread);
		}
	}
	
	/*
	 * Event handler for reading message scene. Leads to death.
	 */
	public class Message implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("iphone2.jpg", "Next", "");
			Start.removeSecondButton();
			WindowDeath death = new WindowDeath();
			Start.a.setOnAction(death);
		}
	}
	
}
