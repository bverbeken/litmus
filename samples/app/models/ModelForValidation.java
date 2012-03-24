package models;

import play.data.validation.*;

public class ModelForValidation {

//	EQUALS("equals"),


	// MAX_SIZE("maxSize"),

	@Min(10)
	public int minInt;

	// MIN_SIZE("minSize"),

	// PASSWORD --> what is this used for? Not for validation, I guess..?

	@Phone
	public String phone;

	@Range(min = 10, max = 20)
	public int between10And20;


	@Required
	public String requiredString;

	//	TODO @Unique
	//	public String uniqueString;

	@URL
	public String url;

	@Valid
	public Person validObject;


}
