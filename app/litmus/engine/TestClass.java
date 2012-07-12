package litmus.engine;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.sort;

public class TestClass implements Comparable<TestClass>{

    private final Class clazz;

    public TestClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return clazz.getName();
    }

    public List<String> getTestMethodNames() {
        List<String> list = newArrayList(transform(getTestMethods(), new Function<Method, String>() {
            public String apply(Method method) {
                return method.getName();
            }
        }));
        sort(list);
        return list;
    }

    private Collection<Method> getTestMethods() {
        return filter(newArrayList(clazz.getMethods()), new Predicate<Method>() {
            public boolean apply(Method method) {
                return method.getAnnotation(Test.class) != null;
            }
        });
    }

    @Override
    public int compareTo(TestClass o) {
        return getName().compareTo(o.getName());
    }
}
