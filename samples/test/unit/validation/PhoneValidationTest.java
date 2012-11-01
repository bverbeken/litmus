package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.PhoneModel;
import org.junit.Test;

public class PhoneValidationTest extends ValidationTest<PhoneModel> {

    @Override
    protected Builder<PhoneModel> valid() {
        return new PhoneModelBuilder();

    }

    @Test
    public void validPhone() {
        assertThat("phone").withValue(null).isValid();
        assertThat("phone").withValue("not a phone").isInvalid();
        assertThat("phone").mustBeAPhoneNumber();
    }

    private class PhoneModelBuilder extends Builder<PhoneModel> {
        @Override
        public PhoneModel build() {
            PhoneModel model = new PhoneModel();
            model.phone = "+32 123 44 55 66";
            return model;
        }
    }
}
