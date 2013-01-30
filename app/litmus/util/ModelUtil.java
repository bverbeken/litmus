package litmus.util;

import play.db.jpa.JPA;
import play.db.jpa.Model;

public class ModelUtil {

    public static <T extends Model> T findSingle(Class<T> clazz) {
        return JPA.em().createQuery("from " + clazz.getSimpleName(), clazz).getSingleResult();
    }

}
