package bowling.scenarios;

import static org.hamcrest.CoreMatchers.*;
import static org.jbehave.Ensure.ensureThat;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;

import bowling.BowlingGame;

public class GameSteps extends Steps {

	private BowlingGame game;

	public GameSteps() {
        super();
	}
	
	@Given("I have a new game")
	public void setupNewGame() {
		game = new BowlingGame();
	}
	
	@When("I miss all the pins in every single frame") 
	public void missEveryFrame() {
		
	}
	
	@When("I do a strike on every frame") 
	public void scoreEveryFrame() {
		this.game.roll(10);
	}
	
	@Then("the score should be the lowest")
	public void checkLowestScore() {
		checkScore(0);
	}

	@Then("the result should be $result")
	public void checkScore(int result) {
		ensureThat(this.game.getScore(), is(result));
	}
	
	@Then("the score should be perfect")
	public void checkPerfectScore() {
		checkScore(300);
	}
}