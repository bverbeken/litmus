package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.URLModel;
import org.junit.Test;

public class URLValidationTest extends ValidationTest<URLModel> {

    @Override
    protected URLModelBuilder valid() {
        return new URLModelBuilder();
    }

    @Test
    public void url() {
        assertThat("url").withValue(null).isValid();
        assertThat("url").withValue("not a url!!").isInvalid();
        assertThat("url").mustBeAURL();

    }

    private class URLModelBuilder extends Builder<URLModel> {
        @Override
        public URLModel build() {
            URLModel model = new URLModel();
            model.url = "http://www.playframework.org";
            return model;
        }
    }
}
