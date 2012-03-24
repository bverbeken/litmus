package models;

import play.data.validation.Max;

public class MaxModel {


	@Max(10)
	public int maxInt;

	@Max(10)
	public double maxDouble;


	@Max(10)
	public String maxString;
}
