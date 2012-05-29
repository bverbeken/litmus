package other;

import litmus.Category;
import litmus.unit.UnitTest;
import org.junit.Test;

@Category(value = "Very Important (custom category)", priority = 1)
public class AVeryVeryImportantTest extends UnitTest {

    @Test
    public void ifThisDoesntWorkTheWorldWillExplode() {
        assertTrue(true);
    }
}
