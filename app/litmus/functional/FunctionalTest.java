package litmus.functional;

public abstract class FunctionalTest extends FestAssertFunctionalTest {

	protected static Response get(Object url) {
		return new Request(url).get();

	}

	protected static Html getHtml(Object url) {
		return get(url).getHtml();
	}

	// TODO: add post, put, head and delete methods

}
