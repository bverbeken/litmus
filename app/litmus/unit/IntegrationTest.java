package litmus.unit;

import org.junit.Before;
import play.db.jpa.JPA;

import static play.test.Fixtures.deleteAllModels;

public abstract class IntegrationTest extends UnitTest {


    @Before
    public void cleanDb() {
        deleteAllModels();
    }

    protected <T> T findUnique(Class<T> clazz) {
        return JPA.em().createQuery("from " + clazz.getSimpleName(), clazz).getSingleResult();
    }

}

