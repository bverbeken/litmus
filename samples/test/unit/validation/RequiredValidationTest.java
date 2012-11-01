package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.RequiredModel;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;

public class RequiredValidationTest extends ValidationTest<RequiredModel> {

    @Override
    protected Builder<RequiredModel> valid() {
        return new RequiredModelBuilder();
    }

    @Test
    public void requiredString() {
        assertThat("requiredString").isRequired();
    }

    @Test
    public void requiredCollection() {
        assertThat("requiredCollection").withValue(newArrayList()).isInvalid();
        assertThat("requiredCollection").isRequired();
    }

    private class RequiredModelBuilder extends Builder<RequiredModel> {
        @Override
        public RequiredModel build() {
            RequiredModel model = new RequiredModel();
            model.requiredString = "aString";
            model.requiredCollection = newArrayList("a", "b");
            return model;
        }
    }
}
