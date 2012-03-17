package functional.response;

import litmus.functional.FunctionalTest;
import models.Person;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class RenderArgsTest extends FunctionalTest {

	@Test
	public void simpleExample() {
		assertThat(get("/renderargs/arg1")).hasRenderArg("arg1");
	}

	@Test
	public void worksWithTwoRequestsToo() {
		assertThat(get("/renderargs/arg1")).hasRenderArg("arg1");
		assertThat(get("/renderargs/arg2")).hasRenderArg("arg2");
	}

	@Test
	public void hasNoRenderArg() {
		assertThat(get("/renderargs/people")).hasNoRenderArg("unexisting");
	}

	@Test
	public void collectionAsContent() {
		List<Person> peopleRenderArg = get("/renderargs/people").getRenderArg("people");
		assertThat(peopleRenderArg).hasSize(3);
		assertThat(peopleRenderArg).containsExactly(new Person("Alex"), new Person("Ben"), new Person("Caroline"));
	}

	@Test
	public void hasRenderArgValue() {
		List<Person> expected = newArrayList(new Person("Alex"), new Person("Ben"), new Person("Caroline"));
		assertThat(get("/renderargs/people")).hasRenderArgValue("people", expected);
	}


}
