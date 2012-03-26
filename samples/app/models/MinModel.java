package models;

import play.data.validation.Min;

public class MinModel {


	@Min(10)
	public int minInt;

	@Min(10)
	public double minDouble;


	@Min(10)
	public Long minLong;
	
	@Min(10)
	public String minString;
}
