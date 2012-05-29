package litmus.engine;

import litmus.Category;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.reflect.Modifier.isAbstract;
import static java.util.Collections.sort;
import static litmus.engine.CategoryInstance.NONE;
import static play.Play.classloader;

public class Tests {

    private HashMap<CategoryInstance, List<TestClass>> map = new HashMap<CategoryInstance, List<TestClass>>();


    public Tests() {
        for (Class testClass : getAllTests()) {
            if (!isAbstract(testClass.getModifiers())) {
                addTest(testClass);
            }
        }
    }

    private List<Class> getAllTests() {
        return classloader.getAssignableClasses(Assert.class);
    }


    private void addTest(Class<?> testClass) {
        Category annotation = findCategoryAnnotation(testClass);
        if (annotation != null) {
            addToCategory(testClass, new CategoryInstance(annotation));
        } else {
            addToCategory(testClass, NONE);
        }
    }

    private boolean addToCategory(Class<?> testClass, CategoryInstance category) {
        return getOrCreateCategoryList(category).add(new TestClass(testClass));
    }

    private Category findCategoryAnnotation(Class<?> testClass) {
        if (testClass.equals(Object.class)) {
            return null;
        } else {
            Category annotation = testClass.getAnnotation(Category.class);
            return annotation == null ? findCategoryAnnotation(testClass.getSuperclass()) : annotation;
        }
    }

    private List<TestClass> getOrCreateCategoryList(CategoryInstance category) {
        if (map.get(category) == null) {
            map.put(category, new ArrayList<TestClass>());
        }
        return map.get(category);
    }

    public List<CategoryInstance> getCategories() {
        ArrayList<CategoryInstance> categories = newArrayList(map.keySet());
        Collections.sort(categories, new CategoryInstanceComparator());
        return categories;
    }


    public List<TestClass> get(CategoryInstance o) {
        List<TestClass> classes = map.get(o);
        sort(classes, new TestClassComparator());
        return classes;
    }


}
