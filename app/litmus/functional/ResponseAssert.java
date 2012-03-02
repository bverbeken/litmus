package litmus.functional;


@SuppressWarnings("unchecked")
public class ResponseAssert extends FunctionalAssert<ResponseAssert, Response> {

	protected ResponseAssert(Response actual) {
		super(ResponseAssert.class, actual, actual);
	}


}
