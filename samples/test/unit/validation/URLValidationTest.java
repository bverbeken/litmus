package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.URLModel;
import org.junit.Test;

public class URLValidationTest extends ValidationTest<URLModel> {

	@Override
	protected URLModel valid() {
		URLModel model = new URLModel();
		model.url = "http://www.playframework.org";
		return model;
	}

	@Test
	public void url() {
		assertThat("url").withValue(null).isValid();
		assertThat("url").withValue("not a url!!").isInvalid(); 
		assertThat("url").shouldBeAValidUrl();
		
	}
}
