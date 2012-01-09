package bowling.scenarios;

import org.jbehave.scenario.Scenario;

public class BowlingStory extends Scenario {
	
	public BowlingStory() {
		super(new GameSteps());
	}
}
