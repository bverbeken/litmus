package testutil.functional.response;

import org.fest.assertions.Assertions;
import testutil.functional.AbstractFunctionalAssert;
import testutil.functional.Response;


@SuppressWarnings("unchecked")
public class ResponseAssert extends AbstractFunctionalAssert<ResponseAssert, Response> {

	public ResponseAssert(Response actual) {
		super(ResponseAssert.class, actual, actual);
	}

	public ResponseAssert hasRenderArg(String argName) {
		Assertions.assertThat(actual.getRenderArgs().keySet()).contains(argName);
		return this;
	}
}
