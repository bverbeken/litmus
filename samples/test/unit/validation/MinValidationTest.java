package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.MinModel;
import org.junit.Test;

public class MinValidationTest extends ValidationTest<MinModel> {

    @Override
    protected MinModelBuilder valid() {
        return new MinModelBuilder();
    }

    @Test
    public void minDouble() {
        assertThat("minDouble").withValue(10.000000000001).isValid();
        assertThat("minDouble").isInvalidWhenEqualTo(9.99999999999999);
        assertThat("minDouble").mustNotBeLessThan(10D);
        assertThat("minDouble").mustNotBeLessThan(10);
    }

    @Test
    public void minLong() {
        assertThat("minLong").withValue(11L).isValid();
        assertThat("minLong").isInvalidWhenEqualTo(9L);
        assertThat("minLong").mustNotBeLessThan(10L);
        assertThat("minLong").mustNotBeLessThan(10);

    }

    @Test
    public void minInt() {
        assertThat("minInt").withValue(10).isValid();
        assertThat("minInt").isInvalidWhenEqualTo(9);
        assertThat("minInt").mustNotBeLessThan(10);
    }

    @Test
    public void minString() {
        assertThat("minString").withValue("10").isValid();
        assertThat("minString").isInvalidWhenEqualTo("9");
        assertThat("minString").isInvalidWhenEqualTo("aaa");
        assertThat("minString").mustNotBeLessThan(10);
    }

    public static class MinModelBuilder extends Builder<MinModel> {
        @Override
        public MinModel build() {
            MinModel model = new MinModel();
            model.minInt = 11;
            model.minDouble = 11D;
            model.minLong = 11L;
            model.minString = "11";
            return model;
        }
    }
}
