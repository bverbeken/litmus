package functional.response;

import org.junit.Test;
import litmus.functional.FunctionalTest;

public class EncodingExample extends FunctionalTest {


	@Test
	public void isUtf8() {
		assertThat(get("/response/ok")).isUtf8();
		assertThat(get("/response/ok")).isEncoded("utf-8");
		assertThat(get("/response/ok")).isEncoded("UTF-8");
	}


}
