package litmus.unit;

import org.junit.Before;

import static com.google.common.collect.Iterables.getOnlyElement;
import static play.db.jpa.JPA.em;
import static play.test.Fixtures.deleteAllModels;

public abstract class IntegrationTest extends UnitTest {

    protected <T> T findOnly(Class<T> clazz) {
        return (T) getOnlyElement(em().createQuery("FROM " + clazz.getSimpleName()).getResultList());
    }

    @Before
    public void cleanDb() {
        deleteAllModels();
    }

}

