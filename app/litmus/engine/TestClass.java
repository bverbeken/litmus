package litmus.engine;

public class TestClass {

    private final Class clazz;

    public TestClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return clazz.getName();
    }
}
