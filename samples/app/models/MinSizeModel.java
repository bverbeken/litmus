package models;

import play.data.validation.MinSize;

public class MinSizeModel {

	@MinSize(4)
	public String minString;

}
