package litmus.engine;

import java.util.Comparator;

public final class ClassNameComparator implements Comparator<Class> {
    public int compare(Class class1, Class class2) {
        return class1.getName().compareTo(class2.getName());
    }
}
