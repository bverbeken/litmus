package models;

import play.data.validation.Match;

public class MatchModel {

	@Match("[0-9]*")
	public String matchingString;


}
