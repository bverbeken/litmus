package testutil.functional.response;

import org.apache.commons.lang.NotImplementedException;
import testutil.functional.AbstractFunctionalAssert;
import testutil.functional.Response;


@SuppressWarnings("unchecked")
public class ResponseAssert extends AbstractFunctionalAssert<ResponseAssert, Response> {

	public ResponseAssert(Response actual) {
		super(ResponseAssert.class, actual, actual);
	}

	public ResponseAssert hasRenderArg(String arg1) {
		throw new NotImplementedException();
	}
}
