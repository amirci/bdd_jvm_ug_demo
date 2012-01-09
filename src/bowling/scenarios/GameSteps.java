package bowling.scenarios;

import static org.hamcrest.CoreMatchers.*;
import static org.jbehave.Ensure.ensureThat;

import java.util.ArrayList;
import java.util.Collection;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Named;
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
		this.registerRolls(repeat(20, 0));
	}
	
	@When("I do a strike on every frame") 
	public void scoreEveryFrame() {
		this.registerRolls(repeat(12, 10));
	}
	
	@When("I roll a game of \"$rolls\"")
	public void rollGame(String rolls) {
		Collection<Integer> actual = new ArrayList<Integer>();
		
		for(String s: rolls.split(",")) {
			actual.add(Integer.parseInt(s.trim()));
		}
		
		this.registerRolls(actual);
	}
	
	private void registerRolls(Iterable<Integer> rolls) {
		for(int roll: rolls) {
			this.game.roll(roll);
		}
	}
	
	@Then("the score should be the lowest")
	public void checkLowestScore() {
		checkScore(0);
	}

	@Then("the score should be the highest")
	public void checkPerfectScore() {
		checkScore(300);
	}
	
	@Then("the score is $result")
	public void checkScore(int result) {
		ensureThat(this.game.getScore(), is(result));
	}
	
	private static <T> Iterable<T> repeat(int times, T j) {
		Collection<T> result = new ArrayList<T>();
		
		while(times-- > 0) {
			result.add(j);
		}
		
		return result;
	}

}