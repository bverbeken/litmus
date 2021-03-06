package unit.validation;

import litmus.Builder;
import litmus.unit.validation.ValidationTest;
import models.IpAddressModel;
import org.junit.Test;

public class IpAddressValidationTest extends ValidationTest<IpAddressModel> {

    @Override
    protected Builder<IpAddressModel> valid() {
        return new IpAddressModelBuilder();
    }

    @Test
    public void ipv4Address() {
        assertThat("ipV4Address").isInvalidWhenEqualTo("invalid ip v4 address");
        assertThat("ipV4Address").mustBeAnIPv4Address();
    }

    @Test
    public void ipv6Address() {
        assertThat("ipV6Address").isInvalidWhenEqualTo("invalid ip v6 address");
        assertThat("ipV6Address").mustBeAnIPv6Address();
    }


    private class IpAddressModelBuilder extends Builder<IpAddressModel> {


        @Override
        public IpAddressModel build() {
            IpAddressModel model = new IpAddressModel();
            model.ipV4Address = "10.11.12.13";
            model.ipV6Address = "0:0:0:0:0:0:10.11.12.13";
            return model;
        }
    }
}
