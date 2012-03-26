package unit;

import litmus.unit.UnitTest;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;

public class SampleUnitTest extends UnitTest {
	
	@Test
	public void festStyleAssertsAreAvailable(){
		assertThat(1+1).isEqualTo(2);
		assertThat("a string").isNotEmpty();
		assertThat(newArrayList("a", "b", "c")).hasSize(3);
	}
	
}
