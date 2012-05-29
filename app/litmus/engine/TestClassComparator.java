package litmus.engine;

import java.util.Comparator;

public final class TestClassComparator implements Comparator<TestClass> {

    public int compare(TestClass class1, TestClass class2) {
        return class1.getName().compareTo(class2.getName());
    }
}
