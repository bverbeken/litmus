package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.MinSizeModel;
import org.junit.Test;

public class MinSizeValidationTest extends ValidationTest<MinSizeModel> {

    @Override
    protected Builder<MinSizeModel> valid() {
        return new MinSizeModelBuilder();

    }

    @Test
    public void minString() {
        assertThat("minString").withValue(null).isValid();
        assertThat("minString").withValue("").isValid();
        assertThat("minString").mustNotHaveSizeSmallerThan(4);
    }

    private class MinSizeModelBuilder extends Builder<MinSizeModel> {
        @Override
        public MinSizeModel build() {
            MinSizeModel model = new MinSizeModel();
            model.minString = "String longer than 4 characters";
            return model;
        }
    }
}
