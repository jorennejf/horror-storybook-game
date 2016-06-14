import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
* @author: Jorenne Flores & Jomar Batac
* @email: cs8bba & cs8bae
* @pid: A11974170 & A11964157
* @about: Brings to user to the mom's scenario and changes the nodes according 
* 				to the user's choices.
* 
*/

public class MomScenario {
	static int clicks = 0;

	/*
	 * Begins the first scene for the mom character.
	 */
	public void play(){
		Start.changeNodes("bed.jpg", "A) Shower and get dressed", "B) Get dressed"
				+ " and go directly downstairs");
		Coffee yum = new Coffee();
		Start.a.setOnAction(yum);
		Start.b.setOnAction(yum);
	}
	
	/*
	 * Event handler for kitchen scene after playyer gets dressed.
	 */
	public class Coffee implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("kitchen.jpg", "A) Make coffee", "B) Have the maid"
					+ " make coffee");
			MomCoffee momCof = new MomCoffee();
			Start.a.setOnAction(momCof);
			MaidCoffee maidCof = new MaidCoffee();
			Start.b.setOnAction(maidCof);
		}
	}
	
	/*
	 * Event handler for mom making coffee scene. Leads directly to after making 
	 * coffee.
	 */
	public class MomCoffee implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Coffee();
		}
	}
	
	/*
	 * Event handler for maid making coffee scene. Dialogue before next scene.
	 */
	public class MaidCoffee implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("kitchenMaid.jpg", "Next", "");
			Start.removeSecondButton();
			MaidCoffee2 next = new MaidCoffee2();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for dialogue. Leads to after making coffee.
	 */
	public class MaidCoffee2 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Coffee();
		}
	}
	
	/*
	 * Method after drinking coffee. User chooses what to do next.
	 */
	public void Coffee(){
		Start.changeNodes("kitchenCoffee.jpg", "A) Swim", "B) Go out");
		Swim swim = new Swim();
		Start.a.setOnAction(swim);
		Out out = new Out();
		Start.b.setOnAction(out);
	}
	
	/*
	 * Event handler for swim scene. Leads to death.
	 */
	public class Swim implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("pool.jpg", "Next", "");
			Start.removeSecondButton();
			SwimDeath death = new SwimDeath();
			Start.a.setOnAction(death);
		}
	}
	
	/*
	 * Event handler for swim death scene. Ghost pops up and user dies.
	 */
	public class SwimDeath implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("poolCleaner.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for choosing transportation scene after user decides to go
	 * out.
	 */
	public class Out implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("cars.jpg", "A) Drive your Porsche", "B) Have the "
					+ "limo driver take you");
			Porsche porsche = new Porsche();
			Start.a.setOnAction(porsche);
			Limo limo = new Limo();
			Start.b.setOnAction(limo);
		}
	}
	
	/*
	 * Event handler for driving Porsche scene. Leads to death.
	 */
	public static class Porsche implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("porsche.jpg", "Next", "");
			Start.removeSecondButton();
			PorscheDeath death = new PorscheDeath();
			Start.a.setOnAction(death);
		}
	}
	
	/*
	 * Event handler for Porsche death scene. Ghost pops up and user dies.
	 */
	public static class PorscheDeath implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("crash.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for limo scene. User decides to shop or go to the spa.
	 */
	public class Limo implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("limo.jpg", "A) Shopping", "B) Spa");
			Shopping shop = new Shopping();
			Start.a.setOnAction(shop);
			Spa spa = new Spa();
			Start.b.setOnAction(spa);
		}
	}
	
	/*
	 * Event handler for spa scene. User must decide to get acupuncture or tan.
	 */
	public class Spa implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("spa.jpg", "A) Acupuncture", "B) Tanning Bed");
			Acupuncture acupuncture = new Acupuncture();
			Start.a.setOnAction(acupuncture);
			Tan tan = new Tan();
			Start.b.setOnAction(tan);
		}
	}
	
	/*
	 * Event handler for acupuncture scene. Ghost pops up and user dies.
	 */
	public class Acupuncture implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("acupuncture.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for tanning scene. Ghost pops up and user dies.
	 */
	public class Tan implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("tanningbed.jpg", "Quit", "");
			Start.removeSecondButton();
			Start.Quit quit = new Start.Quit();
			Start.a.setOnAction(quit);
		}
	}
	
	/*
	 * Event handler for shopping scene. 
	 */
	public class Shopping implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("clothes.jpg", "Next", "");
			Start.removeSecondButton();
			DressingRoom next = new DressingRoom();
			Start.a.setOnAction(next);			
		}
	}
	
	/*
	 * Event handler for dressing room scene. 
	 */
	public class DressingRoom implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("dressingroom.jpg", "Next", "");
			Start.removeSecondButton();
			Hallucinate next = new Hallucinate();
			Start.a.setOnAction(next);			
		}
	}
	
	/*
	 * Event handler for hallucination scene. Ghost pops up due to hallucination.
	 */
	public class Hallucinate implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.Ghost();
			Start.changeNodes("dressingroom2.jpg", "Next", "");
			Start.removeSecondButton();
			GoHome next = new GoHome();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for going home scene.
	 */
	public class GoHome implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("hallucinate.jpg", "Next", "");
			Start.removeSecondButton();
			Pill next = new Pill();
			Start.a.setOnAction(next);
		}
	}
	
	/*
	 * Event handler for taking pill scene. User must decide how many pills to 
	 * take.
	 */
	public class Pill implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("dietpills.jpg", "A) 1 pill", "B) 2 pills");
			SaveMe save = new SaveMe();
			Start.a.setOnAction(save);
			Start.b.setOnAction(save);
		}
	}
	
	/*
	 * Event handler for falling asleep in bathroom scene. Leads to death.
	 */
	public class SaveMe implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			Start.changeNodes("bathtub.jpg", "Wake up", "");
			Start.removeSecondButton();
			FinalDeath death = new FinalDeath();
			Start.a.setOnAction(death);			
		}
	}
	
	/*
	 * Event handler for dying in bathroom scene. User must click the button 4 
	 * times for ghost to pop up. Ghost pops up and user dies.
	 */
	public class FinalDeath implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			clicks++;
			if(clicks == 4){
				Start.Ghost();
				Start.changeNodes("pilldeath.jpg", "Quit", "");
				Start.removeSecondButton();
				Start.Quit quit = new Start.Quit();
				Start.a.setOnAction(quit);
			}
		}
	}
	
	
}
