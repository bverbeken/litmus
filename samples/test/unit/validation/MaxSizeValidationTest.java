package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.MaxSizeModel;
import org.fest.assertions.Assertions;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;

public class MaxSizeValidationTest extends ValidationTest<MaxSizeModel> {

	@Override
	protected MaxSizeModel valid() {
		MaxSizeModel model = new MaxSizeModel();
		model.maxString = "ABC";
		return model;
	}

	@Test
	public void ifStringIsNullItPassesValidation() {
		assertThat("maxString").withValue(null).isValid();
		assertThat("maxString").withValue("").isValid();
		assertThat("maxString").shouldHaveMaxSize(4);
	}


	@Test
	public void headsUpMaxSizeOnCollections() {
		try {
			assertThat("maxList").withValue(newArrayList("aSingleStringThatHasMoreThanThreeCharacters")).isValid();
			fail("expected exception since @MaxSize works on the length of field.toString(), not the size of the collection");
		} catch (Error e) {
			Assertions.assertThat(e).isInstanceOf(AssertionError.class);
		}
	}

}
