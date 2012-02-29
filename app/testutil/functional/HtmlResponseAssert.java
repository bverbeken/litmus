package testutil.functional;

public class HtmlResponseAssert extends FunctionalAssert<HtmlResponseAssert, Response> {

	protected HtmlResponseAssert(Response actual, Response response) {
		super(HtmlResponseAssert.class, actual, response);
	}
}
