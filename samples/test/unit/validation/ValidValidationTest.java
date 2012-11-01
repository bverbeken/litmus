package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.Person;
import models.ValidModel;
import org.junit.Test;

import static litmus.unit.validation.BuiltInValidation.VALID;

public class ValidValidationTest extends ValidationTest<ValidModel> {

    @Override
    protected ValidModelBuilder valid() {
        return new ValidModelBuilder();
    }


    @Test
    public void validShouldBeValid() {
        Object invalidPerson = new Person(null, null);
        assertThat("validPerson").withValue(invalidPerson).hasValidationError(VALID);
        assertThat("validPerson").withValue(invalidPerson).hasValidationError("validation.object");
    }

    private class ValidModelBuilder extends Builder<ValidModel> {
        @Override
        public ValidModel build() {
            ValidModel model = new ValidModel();
            model.validPerson = new Person("Ben");
            return model;
        }
    }
}
