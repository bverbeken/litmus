package models;

import play.data.validation.Required;

import java.util.List;

public class RequiredModel {

	@Required
	public String requiredString;
	
	@Required
	public List<?> requiredCollection;
}
