package models;

import play.data.validation.Range;
import play.data.validation.Required;
import play.data.validation.Valid;

public class ModelForValidation {

//	EQUALS("equals"),

	// PASSWORD --> what is this used for? Not for validation, I guess..?


	@Range(min = 10, max = 20)
	public int between10And20 = 12;


	@Required
	public String requiredString = null;

	//	TODO @Unique
	//	public String uniqueString;


	@Valid
	public Person validObject =  new Person(null, null);


}
