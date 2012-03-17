package functional.response;

import org.junit.Test;
import litmus.functional.FunctionalTest;

public class ContentTypeExample extends FunctionalTest {

	@Test
	public void html() {
		assertThat(get("/contentTypes/html")).isHtml();
		assertThat(get("/contentTypes/html")).hasContentType("text/html");
	}
	
	@Test
	public void xml(){
		assertThat(get("/contentTypes/xml")).isXml();
		assertThat(get("/contentTypes/xml")).hasContentType("text/xml");
	}
	
	@Test
	public void json(){
		assertThat(get("/contentTypes/json")).isJson();
		assertThat(get("/contentTypes/json")).hasContentType("application/json");
	}
	
	@Test
	public void text(){
		assertThat(get("/contentTypes/text")).isText();
		assertThat(get("/contentTypes/text")).hasContentType("text/plain");
	}

}
