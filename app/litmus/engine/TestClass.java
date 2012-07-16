package litmus.engine;

public class TestClass implements Comparable<TestClass> {

    private final Class clazz;

    public TestClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return clazz.getName();
    }

    @Override
    public int compareTo(TestClass o) {
        return getName().compareTo(o.getName());
    }
}
