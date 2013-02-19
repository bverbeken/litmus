package litmus.util;

import play.db.jpa.GenericModel;
import play.db.jpa.JPA;

public class ModelUtil {

    public static <T extends GenericModel> T findSingle(Class<T> clazz) {
        return JPA.em().createQuery("from " + clazz.getSimpleName(), clazz).getSingleResult();
    }

}
