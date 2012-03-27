package models;

import play.data.validation.Range;

public class ModelForValidation {

	//	EQUALS("equals"),

	// PASSWORD --> what is this used for? Not for validation, I guess..?

	@Range(min = 10, max = 20)
	public int between10And20 = 12;

	//	TODO @Unique
	//	public String uniqueString;


}
