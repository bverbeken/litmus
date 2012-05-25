package litmus.engine;

import org.junit.Assert;
import play.Play;

public class TestEngine {

    public static TestMap getAllTests(){
        return new TestMap(Play.classloader.getAssignableClasses(Assert.class));
    }

}
