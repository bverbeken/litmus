package unit.validation;

import litmus.unit.validation.ValidationTest;
import models.IpAddressModel;
import org.junit.Test;

public class IpAddressValidationTest extends ValidationTest<IpAddressModel> {

	@Override
	protected IpAddressModel valid() {
		IpAddressModel model = new IpAddressModel();
		model.ipV4Address = "10.11.12.13";
		model.ipV6Address = "0:0:0:0:0:0:10.11.12.13";
		return model;
	}

	@Test
	public void ipv4Address() {
		assertThat("ipV4Address").shouldNotBe("invalid ip v4 address");
		assertThat("ipV4Address").shouldBeAValidIPv4Address();
	}

	@Test
	public void ipv6Address(){
		assertThat("ipV6Address").shouldNotBe("invalid ip v6 address");
		assertThat("ipV6Address").shouldBeAValidIPv6Address();
	}

}
