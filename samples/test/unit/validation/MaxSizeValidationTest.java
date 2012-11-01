package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.MaxSizeModel;
import org.fest.assertions.Assertions;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;

public class MaxSizeValidationTest extends ValidationTest<MaxSizeModel> {

    @Override
    protected Builder<MaxSizeModel> valid() {
        return new MaxSizeModelBuilder();

    }

    @Test
    public void ifStringIsNullItPassesValidation() {
        assertThat("maxString").withValue(null).isValid();
        assertThat("maxString").withValue("").isValid();
        assertThat("maxString").mustNotHaveSizeGreaterThan(4);
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

    private class MaxSizeModelBuilder extends Builder<MaxSizeModel> {
        @Override
        public MaxSizeModel build() {
            MaxSizeModel model = new MaxSizeModel();
            model.maxString = "ABC";
            return model;
        }
    }
}
