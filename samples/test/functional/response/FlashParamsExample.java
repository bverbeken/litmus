package functional.response;

import org.junit.Test;
import litmus.functional.FunctionalTest;
import litmus.functional.Response;

public class FlashParamsExample extends FunctionalTest {

	@Test
	public void somethingPutInFlashScope() {
		assertThat(get("/flash/oneFlashParam")).hasFlashParam("foo");
		assertThat(get("/flash/oneFlashParam")).hasFlashParam("foo", "bar");
		assertThat(get("/flash/oneFlashParam").getFlashParam("foo")).isEqualTo("bar");
	}

	@Test
	public void multipleFlashScopeVars() {
		Response response = get("/flash/twoFlashParams");
		assertThat(response).hasFlashParam("foo", "message1");
		assertThat(response).hasFlashParam("bar", "message2");
	}

	@Test
	public void doesntHaveFlashParam() {
		assertThat(get("/flash/oneFlashParam")).hasNoFlashParam("unknownFlashParam");
	}

}
