package litmus.unit;

import org.junit.Before;

import static play.test.Fixtures.deleteAllModels;

public abstract class IntegrationTest extends UnitTest {


    @Before
    public void cleanDb() {
        deleteAllModels();
    }


}

