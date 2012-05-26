package other;


import org.fest.assertions.Assertions;
import org.junit.Test;

public class AnUncategorizedTest extends play.test.UnitTest{

    @Test
    public void test(){
        Assertions.assertThat(true).isTrue();
    }

}
